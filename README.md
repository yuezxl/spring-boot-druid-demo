# Spring Boot 集成 MyBatis, 分页插件 PageHelper, 通用 Mapper ，druid多数据源

- [Spring Boot 1.5.3.RELEASE](https://github.com/spring-projects/spring-boot)
-

## 项目依赖
```xml
<!--mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.1</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.4</version>
        </dependency>
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>4.0.3</version>
        </dependency>
        <!--通用Mapper -->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
            <version>1.1.1</version>
        </dependency>
        
        <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.0</version>
        </dependency>

