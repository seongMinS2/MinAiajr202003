-- 함수

-- 1_ 숫자 함수
select mod(10,3)
from dual;

select abs(-10)
from dual;
select abs(sal)
from emp;

select trunc(1282.238273,2) -- 소수점 둘째자리까지만 표현 
from dual;

select trunc(1282.238273,-2) 
from dual;

select trunc(sal,-2)
from  emp;

select round(3.141592,3) -- 소수점 셋째자리 반올림되어 출력
from dual;

select round(315.1592172,-1)
from dual;



--2_ 날짜 함수
select sysdate
from dual;

--TO_CHAR(): date -> varchar2로 형 변환 
select sysdate,to_char(sysdate,'YYYY.MM.DD')
from dual;

select ename,to_char(hiredate,'YYYY.MM.DD') as hiredate
from emp;

--2020.05.20. 11:26
SELECT to_char(sysdate, 'YYYY.MM.DD. HH24:MI')
FROM dual;

--to_char
--number -> varchar2
SELECT to_char(12500, '000,000')
FROM dual;

SELECT to_char(12500, '0,000,000')
FROM dual;

SELECT to_char(12500, '99,999,999')
FROM dual;

SELECT to_char(12500, 'L99,999,999')
FROM dual;

SELECT to_char(3.14, '000,000.000')
FROM dual;

SELECT to_char(3.141592, '999,999.99')
FROM dual;

SELECT sal, to_char(sal*1220, 'L999,999,999,999'), 
to_char(sal*1000*12+nvl(comm, 0), 'L999,999,999,999') as income
FROM emp
order by income desc;

--TO_DATE
--TO_DATE(원본, 패턴)
--str - date

SELECT to_date('19810220', 'YYYYMMDD')
FROM dual;

SELECT to_date('19810220', 'YYYY/MM/DD')
FROM dual;

SELECT ename, hiredate
FROM emp
where hiredate = TO_DATE('1981/02/20', 'YYYY/MM/DD');

select sysdate, to_date('20201225', 'YYYY-MM-DD'),
trunc(to_date('20201225', 'YYYYMMDD')-sysdate)
from dual;

select sysdate, 
trunc(sysdate - to_date('19920202', 'YYYYMMDD'))
from dual;

--TO_NUMBER
--TO_NUMBER(원본, '패턴')
--str -> number : 산술, 관계 연산을 목적으로 변환

SELECT TO_NUMBER('20,000', '999,999') - TO_NUMBER('9,000', '999,999')
FROM dual;
SELECT TO_NUMBER('20,000', '999,999') - TO_NUMBER('9,000', '999,999')
FROM DUAL; 

-- DECODE 함수 : if switch 구문과 유사
select ename, deptno, 
decode(deptno,
        10, 'ACCOUNTING',
        20, 'RESEARCH',
        30, 'SALES',
        40, 'OPERATING'
        ) as deptNAME
from emp;

--직급에 따라 급여를 인상하도록 하자.
--직급이 'ANALIYST'인 사원은 5%,
-- 'SALESMAN'인 사원은 10%,
-- 'MANAGER'인 사원은 15%,
-- 'CLERK'인 사원은 20% 인상한다.

select ename, sal,
decode(job,
        'ANALIYST', sal + sal * 0.05,  --- sal*1.05
        'SALESMAN', sal + sal * 0.1,
        'MANAGER', sal + sal * 0.15,
        'CLERK', sal + sal * 0.2
) as UPSAL
from emp;

select ename, deptno,
case
    when deptno=10 then 'ACCOUNTING'
    when deptno=20 then 'RESARCH'
    when deptno=30 then 'SALSE'
    when deptno=40 then 'OPERATING'
    else 'no name'
end as deptName
from emp;


select sum(comm)
from emp;

select avg(sal)
from emp;

select 29025/14
from dual;

select sum(comm) from emp;

select avg(comm)
from emp;

select * from emp order by comm;

--MAX,MIN: 해당 컬럼의 데이터중에서 최대값, 최소값을 반환
select max(sal), min(sal), max(comm), min(comm)
from emp;

select comm
from emp;

select count(comm)
from emp;

select count(*)
from emp;

select count (job)
from emp;

select distinct job
from emp
order by job;

select count(distinct job)
from emp
order by job;

--groub by 절: 특정 컬럼으로 그룹핑을 해준다.

select deptno
from emp
group by deptno;

select job
from emp
group by job;

--소속 부서별 평균 급여를 구하는 예제입니다
select deptno, round(avg(sal),0)
from emp
group by deptno;

--부서별로
-- 사원 수와 커미션을 받는 사원들의 수를 계산하자
select deptno, count(*), count(comm)

from emp
--where comm <> 0
group by deptno;

--부서별 평균 급여가 2000이상인(HAVING)
--부서번호와 부서별 평균 급여를 출력

select deptno, avg(sal), count(*), count(comm), sum(comm)
from emp
group by deptno
having avg(sal)<=2000;

--직급별, 지표 출력

select job, count(*) as "직급별 인원",
            to_char(sum(sal), '999,999') as "직급별 월 총 급여",
            trunc(avg(sal)) as "직급별 월 평균 급여",
            sum(comm) as "부서별 수령 커미션 총 합",
            nvl(sum(comm), 0) as "부서별 수령 커미션의 총 합",
            max(sal) as "부서별 최고 급여 금액"
from emp
group by job
--having count(*)>1  -- 직급의 인원이 2명 이상인 직급
having avg(sal) >= 2000 and count(*)>1
;

select deptno--, job
from emp
group by deptno--, job
order by deptno;
