package com.criown.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;

@RequestMapping
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;


}
