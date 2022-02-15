# MyBatis dynamic SQL

* 예시
``` java
    <select id="ifSelect" parameterType="emp" resultMap="empSelectMap">
        <include refid="empSelectSql"/>
            <where> <!--where절 안에 and나 or가 나오면 그것을(and나 or) 없앰 -->
            <if test="empName != null"> <!-- test는 자바 안에서 물어보는 것이기 때문에 empName으로(자바 명)-->
                ename=#{empName}
            </if>
                <if test="job != null ">
                and job=#{job}
                </if>
            </where>
    </select>
```
와 

select empno, ename, job, sal, hiredate from emp where ename=? and job=? ;
는 같다

empSelectSql 구문은  select empno, ename, job, sal, hiredate from emp ; 이다
여기서 <where>로 조건을 추가한 것인데
<if test="empName != null">을 만족하면
select empno, ename, job, sal, hiredate from emp where ename=? 이고
<if test="job != null ">을 만족하면
select empno, ename, job, sal, hiredate from emp where ename=? and job=? 이다.


* forEach

<foreach item="item" index="index" collection="list" open="(" separator="," close=")">
 #{item}
 </foreach>

는 JSTL의 forEach와 비슷한듯 다르다


*  
<!-- 글자 표기법 설정 -->
<settings>
<setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>

<!-- 자바에 값이 null이 들어올 경우에 null로 대체하기 위해-->
<settings>
<setting name="jdbcTypeForNull" value="NULL"/>
</settings>


* interface 설정
  ```java
    interface TestMapper{
        @Select("select * from..")
        Emp selectByJob(String str);
        리턴타입 / id      / 인수
    }
  ```