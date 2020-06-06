
-----------------------
-- JOIN
-----------------------

select * from emp;
select * from dept;

-- 1_cross JOIN
select *
from emp,dept
;

--2_ equi join
select * -- e.ename, d.dname,e.deptno,d.deptno
from emp e,dept d
where e.deptno=d.deptno
;
--예제))
--book,customer, orders
select * from orders;
select * from book;
select * from custoemr;
--cross JOIN
select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
;

-- 박지성의 총구매액(박지성의 고객번호는 1번으로 놓고 작성)
select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid
and name='박지성'
;

select * from emp;

select * from salgrade;

select * --ename, sal, s.grade
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between losal and hisal
;

select ename, sal, grade
from emp,salgrade
where sal between losal and hisal
;

select * -- ename, sal,grade
from emp e,salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
;

-- 관리자의 이름을 알아보자
select * from emp;

select * -- e.ename || '의 상사는' || m.ename || '입니다.'
from emp e, emp m
where e.mgr = m.empno(+)
;  

select e.ename , e.empno, e.sal, e.comm, nvl(m.ename, '관리자 없음')
from emp e, emp m
where e.mgr = m.empno(+)
;  

select ename, dname
from emp em inner join dept de
on emp.deptno=dept.deptno
;

select ename, dname
from emp inner join dept
using(deptno)
;

select *
from emp natural join dept
;

select *
from emp e left outer join emp m
on  e.mgr = m.empno
order by m.ename
;

SELECT EMP.ENAME, DEPT.DNAME  FROM EMP INNER JOIN DEPT USING (DEPTNO); 

select e.ename , e.empno, e.sal, e.comm, nvl(m.ename, '관리자 없음')
from emp e, emp m
where e.mgr = m.empno(+)
;  
