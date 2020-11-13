# spring

## spring framework

* 규모가 큰 프로젝트 - 모놀리식..
* Framework - 설계도, 구조.. -> 어떻게 만들어야하는지에 대한 고민이 준다 
            - 디자인 패턴 + 라이브러리 
            - 다양한 라이브러리(maven이 라이브러리 관리 도와줌), 다양한 디자인 패턴의 집합체 
            - 유지보수가 쉬워진다 
* 호출을 유저 코드에서 하면 라이브러리 / 자동으로 하면 프레임워크


1. spring container 
- 객체를 관리하는 개념이라고 생각하기
- 서버가 시작될 때 관련된 객체를 생성하고 주입해줌 
- 전반적인 라이프사이클 관리 
- BeanFactory, ApplicationContext, WebApplicationContext .. 이들을 실제로 사용하기 위해서는 new ClassPath..나 new FileSystem..으로 불러와야한다

2. spring IOC(Inversion of Control) & DI(Dependency Injection)
- 제어의 역행  
    ```java
        class A{
            B b;
        }
    ```
흐름이 예전에는 소스 내부에서 이루어졌다면 흐름이 역행된 것은 흐름이 외부에서 들어옴 
이것을 IOC라고 하고 DI(의존관계에 있는 객체를 주입)가 이를 도와줌 
- DI를 생성자로 주입(value, ref)하는 방법, setter로 주입(value, ref)하는 방법이 있다.

```java 생성자로 주입하는 예시
    	<bean class="sample03.BookVo" id="book">
		<constructor-arg value="spring" />
		<constructor-arg value="장희정" />
		<constructor-arg value="25000" type="int" />
		<constructor-arg value="2016-11-01" />
        </bean>
        <bean class="sample03.BookDAOImpl" id="bookdao" />

        <bean class="sample03.BookController" id="controller">
            <constructor-arg ref="bookdao" />
            <constructor-arg>
                <ref bean="book" />
            </constructor-arg>

        </bean>
```

```java setter로 주입하는 예시
    <bean class="sample05.ProductBean" id="pbean">
		<property name="p_name" value="새우깡"></property>
		<property name="p_no" value="900"></property>
		<property name="p_price" value="4000"></property>
	</bean>

	<bean class="sample05.UserBean" id="ubean">
		<property name="name" value="장희정"></property>
		<property name="phone" value="010-1111-1111"></property>
		<property name="addr" value="판교"></property>
		<property name="id" value="10"></property>
	</bean>

	<bean class="sample05.OrderMessageImpl" id="dao">
		<property name="productbean" ref="pbean"></property>
		<property name="userbean" ref="ubean"></property>
		<property name="orderid" value="11"></property>
		<property name="message" value="주문완룡"></property>
	</bean>
```



1. spring AOP(Aspect Orlented Programming) -> 관점지향 프로그래밍 (filter랑 비슷)

2. spring web MVC 
- 스프링이 제공하는 모듈 중 하나가 spring web MVC..
- spring이 웹에서 중요하긴 하지만 java에서도 쓸 수 있다

5. spring JDBC
6.  spring ORM(Object Relation Mapping) -> MyBatis, Hibernate(JPA)  ((5번 spring JDBC와 목적 비슷))
- MyBatis framework, Hibernate framework 따로 있어서 스프링과 연결해서 쓰는 것

7. spring Ajax 

8. spring tiles -> 레이아웃 template
- jsp <include:> 와 비슷한 기능 

9. spring transcation -> ACID 유지 

10. spring Security -> 인증 + 권한 
- 인증 (로그인, 로그아웃..)
- 권한

11. spring boot
- 반 이상의 설정을 자기가 알아서 해줌 
- WAS 내장 
  
12. JPA 
    
13. MSA 개념 



