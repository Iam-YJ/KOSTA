# MyBatis + Spring 연동

* 연동하기 위해 필요한 lib
1. myBatis
2. myBatis-Spring
3. Oracle
4. DBCP
5. Spring-jdbc

* LIB들
```xml
 <!-- myBatis 마이바티스-->
            <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis</artifactId>
                <version>3.5.3</version>
            </dependency>

            <!-- oracle 오라클 -->
            <dependency>
                <groupId>com.oracle.database.jdbc</groupId>
                <artifactId>ojdbc6</artifactId>
                <version>11.2.0.4</version>
                <scope>compile</scope>
            </dependency>

            <!-- myBatis Spring 마이바티스 스프링 -->
            <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis-spring</artifactId>
                <version>2.0.3</version>
            </dependency>

            <!-- spring - jdbc  제이디비씨 -->
            <!-- 이것은 내 spring이랑 버전을 맞춰야한다 -->
            <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jdbc</artifactId>
                <version>5.2.2.RELEASE</version>
            </dependency>

            <!-- commons - dbcp 디비씨피 -->
            <!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
            <dependency>
                <groupId>commons-dbcp</groupId>
                <artifactId>ons-dbcp</artifactId>
                <version>1.4</version>
            </dependency>

```

* 연동을 하면
* 