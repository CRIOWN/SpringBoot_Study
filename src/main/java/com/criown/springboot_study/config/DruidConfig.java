package com.criown.springboot_study.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean a(){
        //进入后台监控
        ServletRegistrationBean<StatViewServlet> bean =  new ServletRegistrationBean<>(new StatViewServlet(), "/druid/**");
        //配置账号密码
        HashMap<String, String> initParameters = new HashMap<>();
        //可访问用户
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        //允许谁可以访问
        initParameters.put("allow","");
        bean.setInitParameters(initParameters);  //初始化参数

        return bean;
    }

    //filter
    public FilterRegistrationBean webFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> init = new HashMap<>();
        //排除 不统计以下内容
        init.put("exclusions","*.js,*.css,/druid/*");

        //配置生效
        bean.setInitParameters(init);
        return bean;
    }

}
