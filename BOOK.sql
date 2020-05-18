select * from tab;

--- emp : 사원정보
--- dept : 부서정보
--- bonus : 임시테이블
--- salgrade : 급여 테이블

-- 테이블의 구조 확인 : desc 테이블이름

desc emp;
desc dept;
desc salgrade;

--데이터 검색 질의
SELECT ename, sal, deptno, empno
    
FROM emp; -- 테이블 이름

select * from dept;

SELECT deptno
FROM dept;

--select의 결과는 새로운 테이블이다.
--컬럼의 산술 연산이 가능하다. +, -, *, /, mod함수 이용

SELECT
    *
FROM emp;

SELECT ename, sal, sal + comm
    
FROM emp;

select ename, sal, sal + 500
from emp;

select ename, sal, sal - 100
from emp;

select ename, sal, sal * 12
from emp;

select ename, sal, sal / 2
from emp;

-- null값의 확인
SELECT ename, job, sal, comm, SAL*12, SAL*12+COMM
FROM emp;

-- null 값 치환 함수: nvl(컬럼명, 기본값)
-- 기본값은 컬럼의 도메인의 자료명과 같아야 한다.

SELECT ename, job, sal, nvl(comm,0), sal*12, sal*12+nvl(comm,0) as total+
FROM emp;

-- 데이터베이스의 문자열 표현 -> 작은 따옴표를 이용
-- '문자열'
-- 문자열을 붙여서 출력하는 연산 -> ||

SELECT ename || ' is a ' || job as massage
    
FROM emp;

select ename, job from emp;

-- 출력 컬럼의 중복을 제거하고 하나씩만 출력: distinct
select distinct deptno
from emp;

SELECT distinct deptno, job
    
FROM emp order by deptno;