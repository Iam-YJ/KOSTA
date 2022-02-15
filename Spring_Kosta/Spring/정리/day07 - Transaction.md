# Transaction

* Transaction 이란?
    CRUD 작업을 한번에 rollback, commit 하는 작업

* Spring에서 transaction
  - DB가 바뀌더라도 transaction을 사용하는 방법은 모두 동일하다 => 편리
  - 설정기반 or annotation 기반
  - 스프링 트랜잭션은 기본적으로 RuntimException  및 Error에 대해서만 롤백 처리를 수행한다. 
    Throwable 이나 Exception타입의 예외가 발생하더라도 롤백되지 않고 Exception 발생 하기 전 까지의 작업이 커밋 된다.

  
  자동 프록시 생성기 <- 어드바이저 <- 포인트컷(조인포인트가 모인 것)
   (Aop server)
                                 <-  어드바이스

* transaction 동작원리
  - 메소드 호출 전에 transaction 시작 + 메소드가 끝난 후에 commit / rollback 해야함 => 사전처리, 사후처리 필요
  
* transaction을 mvc에서 pointcut잡기
   view --주문하기--> controller -> service -----> dao -> db
         1. insert    주문하기()    주문하기()     insert()
         2. update                  pointcut으로  update()
         3. delete                     묶음       delete()

  - dao는 하나하나의 method를 만들기 때문에 pointcut이 될 수 없다. 
    만약에 pointcut이 되면 메소드 하나하나가 transaction이 된다.
    따라서 service가 transaction의 대상이다.