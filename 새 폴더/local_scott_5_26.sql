-- 2020.05.25


-----------------------------------------------
-- DDL 
-----------------------------------------------

-- 테이블 생성 
-- create table 테이블의 이름 () <- 괄호 안에 컬럼을 정의
-- ( 컬럼명1 타입(사이즈) , 컬럼명2 타입(사이즈), ... )

-- ddl_test 라는 이름의 테이블을 생성
-- 컬럼1 : no, 숫자타입,  사이즈는 3
-- 컬럼2 : name, 가변 문자열 저장, 사이즈 10
-- 컬럼3 : birth, 날짜 타입, 기본값은 현재 날짜 시간

create table ddl_test (
    no number(3),
    name varchar2(10),
    birth date default sysdate
);

desc ddl_test;
select * from tab;

select * from ddl_test;

insert into ddl_test (no, name) values (1, 'scott');


-- emp 테이블 참조
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 
-- EMP01 테이블을 생성해 봅시다.
desc emp;

create table emp01(
    empno number(4),
    ename varchar2(10),
    sal number(7,2)
);

select * from tab;
desc emp01;

-- 테이블의 복사 : 서브 쿼리 이용 
-- 스키마 복사, 행 복사, 제약조건의 복사는 되지 않는다.

create table emp02
as
select * from emp
;

select * from tab;

desc emp02;
select * from emp02;


-- emp 테이블의 empno와 ename 컬러만 복사해서 
-- 새로운 테이블 emp03 을 생성하자
create table emp03
as
select empno, ename from emp
;
select * from emp03;
desc emp03;

-- emp 테이블의 10번 부서의 데이터만 복사해서 새로운 테이블 
-- emp04 테이블을 생성하자
create table emp04
as
select * from emp where deptno=10
;
select * from emp04;

-- emp 테이블의 스키마 구조만 복사해서 새로운 테이블 emp05 생성하자
create table emp05
as
select * from emp where 1<0
;

select * from emp05;

-- 테이블에 컬럼 추가
-- alter table 테이블 이름 add (컬럼정의)

-- emp01 테이블에 직급(job) 컬럼을 추가하자
desc emp01;

alter table emp01 add(job varchar2(10));

-- 컬럼의 변경
-- alter table 테이블이름 modify (컬럼 정의)
-- 직급(JOB) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자.
alter table emp01 modify (job varchar(30) not null);
desc emp01;

-- 컬럼의 삭제
-- alter table 테이블이름 drop column 컬럼이름
alter table emp01 drop column sal;
desc emp01;


-- 테이블 객체 삭제
-- drop table 테이블 이름;
drop table emp01;
select * from tab;
desc emp01;

select * from emp02;

TRUNCATE table emp02;


-- 테이블 이름의 변경
-- rename 현재 테이블 이름 to 새로운 테이블 이름

rename emp02 to test_emp;
select * from tab;


desc dept;
insert into dept values(10, 'test', 'seoul');


-- 컬럼의 제약 정의는 컬럼 정의를 하면서 컬럼 옆에 정의 
-- 컬럼의 타입을 모두 정의하고, 아래에 제약을 정의하는 방법

-- create table emp01 (
--     empno number(4) not null
-- )

-- create table emp01 (
--    empno number(4) ,
--    primary key(empno)
--)

-- not null 제약 : 컬럼의 값에 null 값을 허용하지 않는다.
-- 컬럼 레벨에서만 정의가 가능

-- 사원 테이블(EMP02)을 
-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성하되 
-- 이번에는 사원번호와 사원명에 NOT NULL 조건을 지정하도록 합시다
drop table emp02;

create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);
desc emp02;

insert into emp02 values (null, null, 'MANAGER', 10);
insert into emp02 values (1111, null, 'MANAGER', 10);
insert into emp02 values (1111, 'SON', 'MANAGER', 10);
SELECT * FROM EMP02;

DROP TABLE EMP03;

CREATE TABLE EMP03(
    EMPNO NUMBER(4) UNIQUE,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);


CREATE TABLE EMP03(
    EMPNO NUMBER(4) UNIQUE NOT NULL,
    ENAME VARCHAR2(10) NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);


DESC EMP03;
INSERT INTO EMP03 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP03 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP03 VALUES(NULL, 'TEST123', 'MANAGER', 20);
SELECT * FROM EMP03;


-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- EMP04 테이블을 생성하되 
-- 사원번호에는 유일키로 사원명은 NOT NULL 제약조건을 설정해 봅시다.
DROP TABLE EMP04;
CREATE TABLE EMP04(
    EMPNO NUMBER(4) CONSTRAINT EMP04_EMPNO_UK UNIQUE CONSTRAINT EMP04_EMPNO_NN NOT NULL,
    ENAME VARCHAR2(10) CONSTRAINT EMP04_ENAME_NN NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);

DESC EMP04;
INSERT INTO EMP04 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP04 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP04 VALUES(NULL, 'TEST123', 'MANAGER', 20);
SELECT * FROM EMP04;

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- 테이블을 생성하되 사원번호에 기본 키 제약 조건을 설정해 봅시다.
DROP TABLE EMP05;
CREATE TABLE EMP05(
    EMPNO NUMBER(4) CONSTRAINT EMP05_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP05_ENAME_NN NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2)
);
DESC EMP05;
INSERT INTO EMP05 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP05 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP05 VALUES(NULL, 'TEST123', 'MANAGER', 20);
SELECT * FROM EMP05;

-- 사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
-- 테이블을 생성하되 사원번호에 기본 키 제약 조건을 설정해 봅시다.
-- DEPTNO 외래키로 제약조건을 설정
DROP TABLE EMP06;
CREATE TABLE EMP06(
    EMPNO NUMBER(4) CONSTRAINT EMP06_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP06_ENAME_NN NOT NULL,
    JOB VARCHAR2(10),
    DEPTNO NUMBER(2) CONSTRAINT EMP06_DEPTNO_FK REFERENCES DEPT(DEPTNO)
);
SELECT * FROM DEPT;
DESC EMP06;
INSERT INTO EMP06 VALUES(1111, 'TEST', 'MANAGER', 10);
INSERT INTO EMP06 VALUES(1111, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP06 VALUES(NULL, 'TEST123', 'MANAGER', 20);
INSERT INTO EMP06 VALUES(2222, 'TEST123', 'MANAGER', 50);
SELECT * FROM EMP06;


-- 사원번호, 사원명, 직급, 부서번호, 직급, 성별, 생일 7개의 칼럼으로 
-- 구성된 테이블을 생성하되 
-- 기본 키 제약 조건, 외래키 제약 조건은 물론 
-- CHECK 제약 조건도 설정해 봅시다.
-- DEFAULT 제약 조건으로 BIRTHDAY  SYSDATE로 입력되도록 처리
CREATE TABLE EMP07(
    EMPNO NUMBER(4) CONSTRAINT EMP07_EMPNO_PK PRIMARY KEY,
    ENAME VARCHAR2(10) CONSTRAINT EMP07_ENAME_NN NOT NULL,
    JOB VARCHAR2(10) DEFAULT 'MANAGER',
    DEPTNO NUMBER(2) CONSTRAINT EMP07_DEPTNO_FK REFERENCES DEPT(DEPTNO),
    GENDER CHAR(1) CONSTRAINT EMP07_GENDER_CK CHECK (GENDER='M' OR GENDER='F'),
    SAL NUMBER(7,2) CONSTRAINT EMP07_SAL_CK CHECK (SAL BETWEEN 500 AND 5000),
    BIRTHDAY DATE DEFAULT SYSDATE
);

INSERT INTO EMP07 VALUES (1111, 'TEST', NULL, 10, 'F', 600, NULL);
INSERT INTO EMP07 VALUES (1112, 'TEST', NULL, 10, 'M', 600, NULL);

INSERT INTO EMP07 (EMPNO, ENAME, DEPTNO, GENDER, SAL) 
           VALUES (1113, 'TEST', 10, 'F', 1600);

SELECT * FROM EMP07;

-----------------------------------------05.26

DROP TABLE EMP02;

CREATE TABLE EMP02(
    EMPNO NUMBER(4),
    ENAME VARCHAR2(10) CONSTRAINT EMP02_ENAME_NN NOT NULL,
    JOB VARCHAR2(10) NOT NULL,
    DEPTNO NUMBER(2),
    CONSTRAINT EMP02_EMPNO_PK PRIMARY KEY(EMPNO),
    CONSTRAINT EMP02_ENAME_UK UNIQUE(ENAME),
    CONSTRAINT EMP02_DEPTNO_FK FOREIGN KEY(DEPTNO) REFERENCES DEPT(DEPTNO)
);

--전화번호 관리 프로그램

-- 이름, 전화번호, 생일, EMAIL
-- 전공, 학년
-- 부서이름, 직급
-- 모임이름, 닉네임
-- 대리키 : 일련번호 -> pidx, memberIDX


-- 전화번호 부(Contact)

--===== 전화번호 부( Contact )
-- 대리키 : 일련번호 -> pIdx

-- 이름, 전화번호, 주소, 이메일 <- 기본정보 NOT NULL

-- 주소값과 이메일은 입력이 없을 때 기본값 입력

-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능 

------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임

DROP TABLE CONTACT01;
DESC CONTACT01;
CREATE TABLE CONTACT01(
    PIDX NUMBER(6) CONSTRAINT CONTACT01_PIDX_PK PRIMARY KEY,
    NAME VARCHAR2(20) CONSTRAINT CONTACT01_NAME_NN NOT NULL,
    PNUMBER NUMBER(20) CONSTRAINT CONTACT01_PNUMBER_NN NOT NULL,
    ADDRESS VARCHAR2(20) DEFAULT '입력안함' CONSTRAINT CONTACT01_ADDRESS_NN NOT NULL ,
    EMAIL VARCHAR2(20) DEFAULT '입력안함' CONSTRAINT CONTACT01_EMAIL_NN NOT NULL,
    CATEGORY VARCHAR(20) CONSTRAINT CONTACT01_CATEGORY_CK CHECK(CATEGORY IN ('UNIV', 'COM', 'CAFE')),
    
    MAJOR VARCHAR2(20),
    GRADE NUMBER(1),
    COMPANY VARCHAR2(20),
    DNAME VARCHAR2(20),
    JOB VARCHAR2(20),
    CNAME VARCHAR2(20),
    NICKNAME VARCHAR(20)     
);


--테이블레벨 작성

DESC CONTACT01;
DROP TABLE CONTACT01;
CREATE TABLE CONTACT01(
    PIDX NUMBER(6), 
    NAME VARCHAR2(20) CONSTRAINT CONTACT01_NAME_NN NOT NULL,
    PNUMBER NUMBER(20) NOT NULL,
    ADDRESS VARCHAR2(20) DEFAULT '입력안함' CONSTRAINT CONTACT01_ADDRESS_NN NOT NULL ,
    EMAIL VARCHAR2(20) DEFAULT '입력안함'  CONSTRAINT CONTACT01_EMAIL_NN NOT NULL,
    CATEGORY VARCHAR(20) ,
    
    MAJOR VARCHAR2(20),
    GRADE NUMBER(1),
    COMPANY VARCHAR2(20),
    DNAME VARCHAR2(20),
    JOB VARCHAR2(20),
    CNAME VARCHAR2(20),
    NICKNAME VARCHAR(20),
    
    CONSTRAINT CONTACT01_PIDX_PK PRIMARY KEY(PIDX),
    CONSTRAINT CONTACT01_PNUMBER_UK UNIQUE(PNUMBER),
    CONSTRAINT CONTACT01_CATEGORY_CK CHECK(CATEGORY IN ('UNIV', 'COM', 'CAFE')) 
);

--과제 2

CREATE TABLE PHONEINFO_BASIC(
IDX NUMBER(6) PRIMARY KEY,
FR_NAME VARCHAR2(20) NOT NULL,
FR_PHONENUMBER VARCHAR2(20) NOT NULL,
FR_EMAIL VARCHAR2(20),
FR_ADDRESS VARCHAR2(20),
FR_REGDATE DATE DEFAULT SYSDATE

);


CREATE TABLE PHONEINFO_UNIV(
IDX NUMBER(6) PRIMARY KEY,
FR_U_MAJOR VARCHAR2(20) DEFAULT 'N' NOT NULL,
FR_U_YEAR NUMBER(1) DEFAULT'1' CHECK(FR_U_YEAR BETWEEN 1 AND 4) NOT NULL,
FR_REF NUMBER(7), 
CONSTRAINT PHONEINFO_UNIV_IDX_FK  FOREIGN KEY(FR_REF) REFERENCES PHONEINFO_BASIC(IDX)
);


CREATE TABLE PHONEINFO_COM(
IDX NUMBER(6) PRIMARY KEY,
FR_C_COMPANY VARCHAR2(20) DEFAULT 'N' NOT NULL,
FR_REF NUMBER(6) NOT NULL,
CONSTRAINT PHONEINFO_COM_IDX_FK FOREIGN KEY(FR_REF) REFERENCES PHONEINFO_BASIC(IDX)
);

DROP TABLE PHONEINFO_UNIV;
DROP TABLE PHONEINFO_COM;
DROP TABLE PHONEINFO_BASIC;

DESC PHONEINFO_UNIV;
SELECT * FROM phoneinfo_basic;
SELECT * FROM phoneinfo_univ;
SELECT * FROM phoneinfo_com;
SELECT * FROM TAB;
------------------------------------------------------------------------------------
--1. 기본정보 입력
insert into PHONEINFO_BASIC
    (IDX, FR_NAME, FR_PHONENUMBER, FR_EMAIL, FR_ADDRESS)
    values  
    (pb_basic_idx_seq.nextval, '박지성', '010-1111-1111', 'SEOUL', 'scott@gmail.com');

insert into PHONEINFO_BASIC
    (IDX, FR_NAME, FR_PHONENUMBER, FR_EMAIL, FR_ADDRESS)
    values 
    (pb_basic_idx_seq.nextval, '손흥민', '010-2222-2222', 'DEAGU', 'tot@gmail.com');

insert into PHONEINFO_BASIC
    (IDX, FR_NAME, FR_PHONENUMBER, FR_EMAIL, FR_ADDRESS)
    values 
    (pb_basic_idx_seq.nextval, '김연아', '010-333-3333', 'BUSAN', 'kim@gmail.com');
    
--2. 회사 정보 입력
insert into PHONEINFO_COM
    (IDX, FR_C_COMPANY, FR_REF)
    values
    (pb_com_idx_seq.nextval ,'카카오', PB_BASIC_IDX_SEQ.currval)
    ;
    

    
insert into PHONEINFO_COM
    (IDX, FR_C_COMPANY, FR_REF)
    values
    (pb_com_idx_seq.nextval ,'삼성', PB_BASIC_IDX_SEQ.currval)
    ;    


--3. 학교 정보 입력
    
insert into PHONEINFO_UNIV
    (IDX, FR_U_MAJOR, FR_U_YEAR,FR_REF)
    values
    (PB_UNIV_IDX_SEQ.nextval, '데이터베이스', 2, PB_BASIC_IDX_SEQ.currval);
    

----------------------------------------------------
--1.전체 정보출력
select *
from PHONEINFO_BASIC b left outer join PHONEINFO_UNIV u
on b.idx = u.fr_ref
left outer join PHONEINFO_COM c
on b.idx = c.fr_ref
;

--학교 친구 출력

select *
from PHONEINFO_BASIC b join PHONEINFO_UNIV u
on b.idx = u.fr_ref;

--회사 친구 출력

select *
from PHONEINFO_BASIC b join PHONEINFO_COM c
on b.idx = c.fr_ref;


-- view : pb_com_view
create view pb_com_view
as
select b.IDX IDX,
b.FR_NAME FR_NAME,
b.FR_PHONENUMBER FR_PHONENUMBER,
b.FR_ADDRESS FR_ADDRESS,
b.FR_EMAIL FR_EMAIL,
b.FR_REGDATE FR_REGDATE,
c.IDX IDX_0,
c.FR_C_COMPANY FR_C_COMPANY,
c.FR_REF FR_REF
from PHONEINFO_BASIC b join PHONEINFO_COM c
on b.idx = c.fr_ref;

select * from pb_com_view;

   
 -- view : pb_univ_view
create view pb_univ_view
as
select b.IDX IDX,
b.FR_NAME FR_NAME,
b.FR_PHONENUMBER FR_PHONENUMBER,
b.FR_ADDRESS FR_ADDRESS,
b.FR_EMAIL FR_EMAIL,
b.FR_REGDATE FR_REGDATE,
u.IDX IDX_0,
u.FR_U_MAJOR FR_U_MAJOR,
u.FR_U_YEAR FR_U_YEAR,
u.FR_REF FR_REF 
from PHONEINFO_BASIC b join PHONEINFO_UNIV u
on b.idx = u.fr_ref;


---------------------------------------------------
-- 수정을 위한 SQL
---------------------------------------------------
-- 1. 회사친구의 정보 변경
select fr_c_company from PHONEINFO_COM;


update phoneinfo_basic set fr_phonenumber = '010-3242-2352' where fr_name= '손흥민';

update phoneinfo_com
set fr_c_company = '네이버'
where fr_ref= (select idx
                from phoneinfo_basic 
                where fr_name = '손흥민');


rollback;
-- 2. 학교친구의 정보 변경

select fr_u_major from phoneinfo_univ;

update phoneinfo_basic set fr_phonenumber = '010-8888-8888' where fr_name= '김연아';

update phoneinfo_univ
set fr_u_major = '웹개발'
where fr_ref=(select idx 
                from phoneinfo_basic 
                where fr_name = '김연아');

rollback;
---------------------------------------------------
-- 삭제를 위한 SQL
---------------------------------------------------
-- 1. 회사 친구 정보를 삭제



delete from phoneinfo_com
where fr_ref = (select idx 
                from phoneinfo_basic 
                where fr_name = '박지성');

delete from phoneinfo_basic
where fr_name = '박지성';                


-- 2. 학교 친구 정보를 삭제

delete from phoneinfo_univ
where fr_ref = (select idx
                from phoneinfo_basic
                where fr_name = '김연아');
                
delete from phoneinfo_basic
where fr_name = '김연아';

-- 주소와 이메일 컬럼명이 바뀌어야 하는걸 발견
-- 회사 컬럼명 변경
alter table phoneinfo_basic
rename column FR_ADDRESS
to FR_EMAIL;

alter table phoneinfo_basic
rename column FR_EMAIL1
to FR_EMAIL;

-- 학교 컬럼명 변경
alter table phoneinfo_univ
rename column FR_ADDRESS
to FR_EMAIL;

alter table phoneinfo_univ
rename column FR_EMAIL
to FR_ADDRESS;

------------------------------------------------------------------------------------
--- DML
------------------------------------------------------------------------------------

DROP TABLE DEPT01;

CREATE TABLE DEPT01
AS
SELECT * FROM DEPT WHERE 1<0
;

DESC DEPT01;
SELECT * FROM DEPT01;

-- 새로운 부서 정보를 입력: 행단위 입력
-- insert into 테이블 이름 (입력하고자 하는 컬럼들) values (데이터들)
-- 입력 컬럼의 순서와 입력데이터의 순서는 같아야 한다.

insert into dept01 (deptno, dname, loc) values (10, 'MARKETING', 'SEOUL');

insert into dept01 values (20, 'DESIGN', 'PUSAN');

insert into dept01 (loc, deptno, dname) values ('LONDON', 30, 'SALES');

insert into dept01 (deptno, dname) values (40, 'DEV');

create table dept02 (
    deptno number(2) not null,
    dname varchar2(20) not null,
    loc varchar2(20) default 'SEOUL'
);

select * from dept02;

insert into dept02 (deptno, dname, loc) values (10, 'MARKETING', 'SEOUL');

insert into dept02 (deptno, dname) values (40, 'DEV');

insert into dept02 (deptno, dname, loc) values (30, 'MARKETING', null);

desc dept02;

insert into dept02 (dname, loc) values ('test', 'locTest');


----------------------------------------------------------

-- 입력 SQL 작성

DESC CONTACT01;

-- 기본정보 입력
    INSERT INTO contact01
    (PIDX, NAME, PNUMBER, ADDRESS, EMAIL) VALUES (1, 'SCOTT', '010-1111-1111', 'SEOUL', 'SCOTT@GMAIL.COM');
-- 학교 친구 정보 입력
    INSERT INTO contact01
    (PIDX, NAME, PNUMBER, ADDRESS, EMAIL, CATEGORY, MAJOR, GRADE) VALUES (2, 'FORD', '010-2222-2222', 'FORD', 'FORD@GMAIL.COM', 'UNIV', 'DESIGN', 1);
-- 회사 친구 정보 입력
    INSERT INTO contact01
    (PIDX, NAME, PNUMBER, ADDRESS, EMAIL, CATEGORY, COMPANY, DNAME, JOB) VALUES (3, 'MILLER', '010-1111-1111', 'MILLER', 'SCOTT@GMAIL.COM','COM', 'KAKAO', 'SALES', 'ANALYST');
-- 모임 친구 정보 입력
    INSERT INTO contact01
    (PIDX, NAME, PNUMBER, ADDRESS, EMAIL, CATEGORY, CNAME, NICKNAME) VALUES (4, 'SCOTT', '010-1111-1111', 'SEOUL', 'SCOTT@GMAIL.COM','CAFE', 'STUDY', 'PARK');



-- phonebook DDL
-- ===== 전화번호 부( Contact )

-- 대리키 : 일련번호 -> pbIdx ==> PK 기본키로 만들기 위한 목적

-- 이름, 전화번호, 주소, 이메일 <- 기본정보
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임
drop table phonebook;

-- 테이블 레벨 제약 정의
create table phonebook(
    pbidx number(4),                -- 기본키, 대리키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null,   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50),    -- 닉네임
    
    constraint pb_pbidx_pk PRIMARY KEY (pbidx),
    CONSTRAINT pb_type_ck check (pbtype in ('univ', 'com', 'cafe') ),
    constraint pb_grade_ck check (pbgrade between 1 and 4)
);

-- 컬럼 레벨 제약 정의
create table phonebook(
    pbidx number(4) constraint pb_pbidx_pk PRIMARY KEY,                -- 기본키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null 
    CONSTRAINT pb_type_ck 
        check (pbtype in ('univ', 'com', 'cafe') ),   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1) 
    constraint pb_grade_ck 
    check (pbgrade between 1 and 4),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50)    -- 닉네임    
    
);

-----------------------------------------------------------------

-- 사용자 정의 제약조건을 저장하는 딕셔너리 테이블
desc user_constraints;
select * from user_constraints where table_name='PHONEBOOK';

-----------------------------------------------------------------


-----------------------------------------------------------------
-- 정보 입력 SQL 작성
-----------------------------------------------------------------

desc phonebook;

-- 기본정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype)
values 
(1, 'scott', '010-9999-1234', 'SEOUL', 'scott@gmail.com', 'univ')
;

-- default 입력 처리 pbaddr, pbemail
insert into phonebook 
(pbidx, pbname, pbnumber, pbtype)
values 
(2, 'king', '010-7777-3333', 'univ')
;

-- 학교 친구 정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbmajor, pbgrade)
values 
(3, 'son', '010-3333-1111', '서울', 'son@gmail.com', 'univ', 'computer', 1)
;

-- 회사 친구 정보 입력 
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcomname, pbcomdept, pbcomjob)
values 
(4, '박지성', '010-1234-0000', '런던', 'ji@gmail.com', 'com', 'NAVER', 'SEARCH', 'PROGRAMER')
;

-- 모임 친구 정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcafename, pbcafenickname)
values 
(5, 'Rain', '010-1111-2222', 'SEOUL', 'rain@gmail.com', 'cafe', 'Campping', 'FirstCamp')
;

desc phonebook;

select * from phonebook;



------------------------------------------------------------------------
-- 정보 출력 질의 
------------------------------------------------------------------------

-- 1. 기본 정보 출력 질의

select pbidx, pbname, pbnumber from phonebook;

-- 2. 대학 친구 정보 출력 질의

select * from phonebook where pbtype='univ';

select pbname, pbnumber, pbmajor, pbgrade from phonebook where pbtype='univ';
-- 3. 회사 친구 정보 출력 질의

select pbname, pbnumber, pbname, pbcomjob from phonebook where pbtype='com';

-- 4. 모임 친구 정보 출력 질의

select pbname, pbnumber, pbcafename, pbcafenickname from phonebook where pbtype='cafe';

---------------------------------------------------
-- 수정을 위한 SQL
---------------------------------------------------
-- 1. 회사친구의 정보 변경


-- 2. 학교친구의 정보 변경


---------------------------------------------------
-- 삭제를 위한 SQL
---------------------------------------------------
-- 1. 회사 친구 정보를 삭제

-- 2. 학교 친구 정보를 삭제




-- 서브쿼리를 이용해서 여러 테이블에 한번에 데이터 삽입
-- 테스트 테이블 emp_hir : empno, ename, hiredate
-- 테스트 테이블 emp_mgr : empno, ename, mgr

create table emp_hir
as
select empno, ename, hiredate from emp where 1<0;

create table emp_mgr
as
select empno, ename, mgr from emp where 1<0;

desc emp_hir;
desc emp_mgr;

-- 두개 테이블에 emp 테이블의 데이터를 기반으로 삽입

insert all
into emp_hir values (empno, ename, hiredate)
into emp_mgr values (empno, ename, mgr)
select empno, ename, hiredate, mgr
from emp;

select * from emp_hir;
select * from emp_mgr;

-- INSERT ALL 명령문에 WHEN 절을 추가해서 조건을 제시하여 조건에 맞는 행만 추출하여 테이블에 추가합니다.   
-- EMP_HIR02 테이블에는 1982 년 01 월01 일 이후에 입사한 사원들의 번호, 사원 명, 입사일을 추가합니다.   
-- EMP_SAL 테이블에는 급여가 2000 이상인 사원들의 번호, 사원 명, 급여를 추가합니다.  
 
create table emp_hir02
as
select empno, ename, hiredate from emp where 1<0;
 
create table emp_sal
as
select empno, ename, sal from emp where 1<0;
desc emp_hir02;
desc emp_sal;
 
insert all
when hiredate > '82/01/01' then 
    into emp_hir02 values (empno, ename, hiredate)
when sal >= 2000 then
    into emp_sal values (empno, ename, sal)
select empno, ename, hiredate, sal
from emp
;

select * from emp_hir02;
select * from emp_sal;

------------------------------------------------------
-- DML : 수정, 삭제
------------------------------------------------------

drop table emp01;

create table emp01
as
select * from emp
;

desc emp01;

-- 컬럼의 데이터 변경(수정)
-- update 테이블이름 set 컬럼이름 1=값, 컬럼이름 2=값, .... where 행을 찾는 조건식
-- where 절이 없는 경우 테이블의 모든 행이 영향을 받는다.

select * from emp01;

-- 1. 모든 사원의 부서를 30번으로 수정합시다.

update emp01
set deptno = 30;

-- 2. 이번엔 모든 사원의 급여를 10% 인상시키는 UPDATE 문을 보겠습니다.

update emp01
--set sal = sal + sal*0.1
set sal = sal*1.1
;

-- 3. 모든 사원의 입사일을 오늘 날짜로 수정
update emp01
set hiredate = sysdate;

drop table emp01;
rollback;

-- 1.부서번호가 10번인 사원의
-- 부서번호를 30번으로 수정합시다.
SELECT * FROM EMP01 WHERE DEPTNO=10;

update emp01
set deptno=30
where deptno=10
;

-- 2.급여가 3000 이상인 사원만
-- 급여를 10% 인상합시다.
update emp01
set sal=sal * 1.1
where sal >= 3000;

-- 3. 1987년에 입사한 사원이
--  입사일이 오늘로 수정
-- 사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.

select * from emp
--where hiredate between '1987/01/01' and '1987/12/31'
where substr(hiredate, 1, 2) = '87'
;

update emp01
set hiredate = sysdate
where substr(hiredate, 1, 2) = '87';



--1. SCOTT 사원의
-- 부서번호는 0번으로,  
-- 직급은 MANAGER로 한꺼번에 수정하도록 합시다

update emp01
 set deptno=10, job='MANAGER'
  where ename = 'SCOTT'
  ;
  
  select * from emp01 where ename ='SCOTT';
  
 
 
 update emp01
 set comm=4000
 where ename = 'SCOTT'
 ;
 
 
 --1. 20번 부서의 지역멱을
 --   40번 부서의 지역먹으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.
 
 update dept01
 set loc=(
    select loc from dept01 where deptno=40
    )
    where deptno = 20
    ;
 
 drop table dept01;
 create table dept01
 as
 select * from dept
 ;
 select * from dept01;
 
 rollback;
 
-- 서브 쿼리를 이용해서 부서번호가 20인 부서의 부서명과 지역명을 
-- 부서 번호가 40번인 부서와 동일하게 변경하도록 해 봅시다. 
-- 부서 번호가 40번인 부서와 동일하게 변경하도록 해 봅시다.
update dept01
set dname = (select dname from dept01 where deptno=40),
loc =(select loc from dept01 where deptno=40)
where deptno=20
;

update dept01
set (dname, loc) = (select dname, loc from dept01 where deptno=40)
where deptno=20
;

-------------------------------------------------------
-- DML : 삭제
-------------------------------------------------------

-- DELETE FROM 테이블 이름 WHERE 행을 찾을 조건식
-- WHERE 절이 없으면 모든 행에 영향을 준다.

--부서 테이블의 모든 행을 삭제합시다.
delete from dept01;
select * from dept01;

rollback;

delete from dept01 where deptno=30;

-- 사원 테이블에서 
-- 부서명이 SALES인 사원을 모두 삭제해봅시다.

select deptno from dept where dname='SALES';

delete from emp01 where deptno=(
        select deptno from dept where dname='SALES'
        );
        
select * from emp01;

