# Spring AoP(Aspect Oreiented Programming)

* 스프링 삼각형(Pojo)
1. DI & Ioc
2. AoP
3. Abstract - 기반코드 제공


- 예전에 했던 필터와 비슷하다. 
- 최대한 수정이 덜 되도록 하고, 확장에는 열려있게 하라(SOLID의 OCP 개념)
- spring AoP는 관점지향프로그래밍 이라고 한다. 
  관점이라는 것은 핵심 기능이 있고, 공통 기능이 있다. 
  
  핵심 기능은 반드시 거기에만 존재해야 하는 것. 
  공통은 여러 곳에서 공통적으로 사용되는 것. 
  이 공통 기능을 분리한다(횡단 관심사항 분리.  Cross Cutting Conser)

## Spring AoP 과정

클래스 ---->  Spring Aop Proxy Server ----> 공통기능(Advice)

* 클래스들..
  - target : 
  - joinPoint : 하나의 객체 안에서 여러 메소드 중 공통 기능을 적절하게 삽입시켜줄 지점 
  - PointCut : joinpoint를 여러개를 묶어서 칭하는 말 

* Spring Aop Proxy Server
  - weaving(위빙) : Aop Proxy Server가 Advice(공통기능)를 joinPoint가 호출될 때 적절하게 삽입해주는 과정 
  
  * proxyServer 생성 방법
    1. J2SE 방식 (기본)
    2. CGLIB 방식 

* point cut + Advice = Advisor 
* point cut + Advice + target = Aspect(관심사항) 

* 공통기능(Advice)
  - around : 사전, 사후
  - before : 
  - after : 
  - after-returning : 기능 실행 후 문제 없을 때
  - after-throwing : 기능 실행 후 문제 있을 때


### 코딩 방식
1. xml 설정 기반 방식
2. @Annotation 기반 방식