**_1. 核心配置文件：spring.factories_**

**2. yaml**  
 标记语言 数据为核心 可存对象数据 对空格要求高 

语法
```yaml
server:
  port: 8099

# 对象
student： 
  name: sty
  age: 23

# 行内写法
student： {name: sty,
  age: 23}

# 数组
pets：
  - cat
  - dog
  - pig

pets： [cat,dog,pig]
```

切换端口（测试版和线上版）
```yaml
# ---分割两个模式
---
server:
  port: 8081
spring:
  profiles: test


---
server:
  port: 8082
spring:
  profiles: dev
```

传参
```java
@Data
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
```
```yaml
# 对象赋值
person:
  name: CRIOWN
  age: 23
  happy: false
  birth: 2000/10/27
  maps: {key1: value1,k2: v2}
  lists:
    - code
    - music
    - read
  dog:
    name: 修狗
    age: ${random.int}
```

**3. @Component**


**4. 测试类**
```java
import org.springframework.beans.factory.annotation.Qualifier;

@SpringBootTest
class SpringBootStudyApplicationTests {

    @Autowired // 在测试类中直接引用并自动装配
    @Qualifier("xxDog") //声明具体的实例
    private Dog dog;
}
```


**5. thymeleaf**
templates目录下所有页面只能通过Controller跳转