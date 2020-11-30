# Spring Security

* 인증과 보안 담당
* spring security를 사용하면 접근에 제한을 둘 수 있다
* 크리덴셜(Credential :자격) 기반 인증
* 아이디를 프린시플(principle) , 비밀번호를 크리덴셜(credential)이라고 부름
* DB에 부여된 권한에 관련된 것을 저장해야함 (role 테이블이 하나 더 생긴다)
  
* Spring Securuty 사용 위해
  1. 4개의 LIB 추가 필요
  2. spring security 등록은 root-context.xml에 해야한다 
        -> security가 적용되면서 service, dao 등 back단 친구들을 root-context에. controller는 servlet-context에 

