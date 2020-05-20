--2020.05.19

--특정 데이터를 cnrcnfgkrl :졷ㄱㄷ wjfdmf dldyd
-- select 컬럼명 from 테이블 이름 where 조건(truue/false)

--전체 사원중의 월 급여가 3000 이상인 사원의 이름 리스트

SELECT ename
    
FROM emp

where sal >= 3000;

-- 전체 사원중 10번 부서의 소속 사원의 이름과 직급을 출력

select ename, job
from emp
where deptno=10;

-- 컬럼의 값과 일치 여부 확인 : =

SELECT
    *
FROM emp
where deptno=10;

-- 문자열 표현: '작은 따옴표로 묶는다.
SELECT
    *
FROM emp
where job = 'MANAGER';

SELECT
    *
FROM EMP
where ename='SCOTT';

SELECT
    *
FROM emp
where hiredate = '80-12-17'; -- 날짜를 비교할 때 -> ' 작은 따옴표를 이용


-- 논리 연산자 : and
-- 10번 부서 소속인 사원들 중에서
-- 직급이 MANAGER인 사람을 검색하여
-- 사원명, 부서번호, 직급을 출력하려고 한다면
-- 조건1 : 10번 부서 소속 -> deptno=10
-- 조건2 : job='MANAGER'

SELECT ename, deptno, job
    
FROM emp
where deptno=10 and job='MANAGER';

-- 논리연산자 : or
-- 10번 부서에 소속된 사원이거나 
--직급이 MANAGER인 사람을 검색하여 
--사원명, 부서번호, 직급을 출력합시다.

select ename, deptno, job
from emp
where deptno=10 or job='MANAGER';

-- 논리연산자 : NOT
-- 부서번호가 10번이 아닌 사원의
-- 사원이름, 부서번호, 직급을 출력

SELECT ename, deptno, job
FROM emp
where NOT deptno=10 AND NOT job='MANAGER';

--범위 연산: 논리연산의 사용 and
-- 2000에서 300 사이의 급여를 받는 사원의 정보를 출력
SELECT
    *
FROM emp
where sal >= 2000 AND sal <= 3000;

--범위 연산자: between A and B -> A이상 B이하
-- 2000에서 3000 사이의 급여를 받는 사원의 정보를 출력
SELECT
    *
FROM emp
where sal BETWEEN 2000 and 3000;

--2000을 초과하고 3000 미만의 급여를 받는 사원
-- sal>2000 and sal<3000
-- sal between 2001 and 2999

select *
from emp
--where sal>2000 and sal<3000;
where sal BETWEEN 2001 and 2999;

-- 1987년 입사자 리스트를 출력
SELECT
    *
FROM emp
where hiredate > '1987-1-1'; -- 1987년 이후

SELECT
    *
FROM emp
--where hiredate >= '1987-01-01' AND hiredate =< '1987-12-31'; -- 1987년 이후
--where hiredate >= '1981-01-01' AND hiredate <= '1981-12-31';
where hiredate BETWEEN '1982-01-01' AND '1982-12-31';

-- or 연산을 간소화 시키는 IN 연산자
-- 컬럼 이름 IN(데이터1, 데이터2, 데이터3, ...)
-- 컬럼=데이터1 or 컬럼=데이터2 or 컬럼=데이터3 or..

-- 커미션이 300 이거나 500 이거나 1400 인 사원을
-- 검색하기 위해서 IN 연산자를 이용해
SELECT
    *
FROM emp
where comm=300 or comm=500 or comm=1400;

SELECT
    *
FROM emp
where comm IN(300, 500, 1400);

-- 패턴검색:// like 연산자
-- 컬럼이름 like 패턴
--패턴: %, _
-- % -> 0개이상의 문자열이 가능하다.
--'S%' : s로 시작하는 문자열
--'%S' : s로 끝나는 문자열
--'%S%' : s를 포함하는 문자열
--'%노트북%' : 노트북을 포함하는 문자열

--이름이 s로 시작하는 사원의 리스트
SELECT
    *
FROM emp
--where ename like 'A%';
--where ename like '%IN';
--where ename like '%AR%';
where ename NOT like '%A%';

-- _ -> 1개의 자리수에 어떠한 문자가 와도 가능하다.
SELECT
    *
FROM emp
--where ename like '_A%'; -- 2번째문자열이 A인
--where ename like '__A%'; -- 3번째 문자열이 A인
--where ename like '%E_'; -- 끝에서 두번째 문자열이 E인
where ename like '%L__'; -- 끝에서 세번째 문자열이 L인


-- null 값 확인을 위한 연산자 : is null, is not null
-- 컬럼명 is null : 해당 컬럼의 값이 null인 경우 true
-- 컬럼명 is not null : 해당 컬럼의 값이 null이 아닌경우 true
SELECT ename, comm

FROM emp
--where comm is null;
where comm is not null;

-- row의 정렬
-- 오름차순: 작은쪽에서 -> 큰쪽 , asc(생략 가능, 기본 값)
-- 내림차순: 큰쪽에서 -> 작은쪽 , desc (명시적 사용)
SELECT ename, sal, hiredate, comm
    
FROM emp
--where empno>0
--order by ename asc; --문자의 오름차순
--order by ename; --문자의 오름차순
--order by ename desc; --문자의 내림차순
--order by sal desc; -- 숫자의 내림차순
--order by sal asc; -- 숫자의 오름차순
--order by hiredate asc; --날짜의 오름차순
order by hiredate desc; -- 날짜의 내림차순
--order by comm asc-- null의 오름차순
--order by comm desc -- null의 내림차순

SELECT ename, sal
    
FROM emp
order by sal desc, ename  desc; 

SELECT ename, deptno
FROM emp
order by deptno, ename;