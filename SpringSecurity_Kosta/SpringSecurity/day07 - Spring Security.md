# Spring Security

* 인증과 보안 담당
* spring security를 사용하면 접근에 제한을 둘 수 있다
* 크리덴셜(Credential :자격) 기반 인증
* 아이디를 프린시플(principle) , 비밀번호를 크리덴셜(credential)이라고 부름
* DB에 부여된 권한에 관련된 것을 저장해야함 (role 테이블이 하나 더 생긴다)
  
* Spring Securuty 사용 위해
  1. 4개의 LIB 추가 필요
    ```xml
    <!-- spring security 라이브러리 -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>5.2.2.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>5.2.2.RELEASE</version>
		</dependency>


		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-config</artifactId>
			<version>5.2.2.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-taglibs</artifactId>
			<version>5.2.2.RELEASE</version>
		</dependency>
    ```
  2. web.xml에 filter 추가 필요
    ```xml
        <!-- spring Security 적용하기 -->
        <filter>
        <filter-name>springSecurityFilterChain</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        </filter>
        
        <filter-mapping>
        <filter-name>springSecurityFilterChain</filter-name>
        <url-pattern>/*</url-pattern>
        </filter-mapping>
    ```
   3. security-context.xml 생성 -> 후에 web.xml의 <param-value>에 등록해야함
   
    ```xml
        <!-- 클라이언트 요청을 가로챌 정보를 설정 
            auto-config="true" spring security의 기본 설정을 그대로 따라가겠다 
            use-expression="true" 는 spring의 SpEL을 사용함
        -->
        <security:http auto-config="true" use-expressions="true"> 
            <security:intercept-url pattern="/user.kosta" access="hasRole('ROLE_USER')"/>
            <security:intercept-url pattern="/admin.kosta" access="hasRole('ROLE_ADMIN')"/>
        </security:http>

        <!-- spring security가 제공하는 in-memory 기능 설정 -->
        <security:authentication-manager>
            <security:authentication-provider>
                <security:user-service>
                    <security:user name="user" password="1234" authorities="ROLE_USER" />
                    <security:user name="admin" password="1234" authorities="ROLE_ADMIN" /> <!-- authorities는 권한을 부여하는 것  -->
                </security:user-service>
            </security:authentication-provider>
        </security:authentication-manager>
    ```

    4. spring security 등록은 root-context.xml에 해야한다 
        -> security가 적용되면서 service, dao 등 back단 친구들을 root-context에. controller는 servlet-context에 
    

