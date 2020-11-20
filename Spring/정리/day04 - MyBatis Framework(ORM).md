# MyBatis FrameWork =>  (ORM : Object Relation Mapping)

* 기존 방법 
    view --> controller --> service --> DAO --(JDBC API)--> DB

    DB 활용시에 로드, 연결, 닫기는 DBUtil에서 함
                실행은 CRUD 작업


ㄴ
* MyBatis 이용시
    view --> controller --> service --> DAO --> MyBatis --(JDBC API)--> DB

    ~.xml 설정문서를 기반으로 로드, 연결, 실행, 닫기 함

    - MyBatis 내 SqlMapConfig.xml가 하는 일 
        1. 로드, 연결 설정 
        2. MyBatis의 관련 환경 설정 세팅
        3. mapper 등록해야함 -> 쿼리 관리 역할 
    => 이후 DbUtil.java의 static {} 영역에서 문서 로딩

    ```java DbUtil
        static{
            //SqlMapConfig.xml 문서 로딩 
            //SqlSessionFactoryBuilder 생성 

            return SqlSession;
        }
    ```
    ``` java DAO
        SqlSession s = DbUtil.getConnection();
        BoardDTO b = s.selectOne("id");
    ```

    - MyBatis 내 ~.xml (mapper라고 부름)
        1. CRUD 작업을 한다 
        ex) <select id="a"> => java에서 id 참조(여기서는 a)하여 사용함


* 알아야 할 
  1. SqlSessionFactoryBuilder => 3을 생성
  2. SqlSessionFactory
  3. SqlSession => 기존의 connection과 동일함
     1. CRUD 작업 호출 관련 method
     2. commit, rollback
