--32. EQUI 조인을 이용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.

select e.ename, d.deptno, d.dname
from emp e,dept d
where e.deptno=d.deptno
and e.ename = 'SCOTT'
;

--33. INNER JOIN과 ON 연산자를 이용하여 사원의 이름과 함께 그 사원이 소속된 부서이름과 지역명 출력

select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno=d.deptno
;

--36. 조인과 wildCard를 사용하여 이름에 'A'가 포함된 모든 사원의 이름과 부서명을 출력하시오.

select e.ename, d.dname
from emp e, dept d
where e.deptno=d.deptno
and e.ename like '%A%'
;

--37. join을 이용하여 new york에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.

select e.ename, e.job, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno
and loc = 'NEW YORK'
;

--38. self join을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.

select e.ename, e.empno, m.ename
from emp e, emp m
where e.mgr = m.empno;

--39. outer join, self join을 이용하여 

select e.ename, e.empno, m.ename
from emp e, emp m
where e.mgr = m.empno(+)
order by e.empno;


select e.ename, e.empno, m.ename
from emp e left outer join emp m
on e.mgr = m.empno
order by e.empno
;

--40. SELF JOIN을 사용하여 지정한 사원과 동일한 부서에서 근무하는 사원 이름, 부서번호를 출력하시오

select ename from emp where deptno=20;

select e.ename, e.deptno, s.ename
from emp e, emp s
where e.ename='SCOTT'
and e.deptno=s.deptno
--SCOTT은 제외할 경우
and s.ename != 'SCOTT'
;

--41. SELF JOIN을 사용하여 WARD사원 보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.

select e.ename, e.hiredate, w.ename, w.hiredate
from emp e, emp w
where w.ename = 'WARD'
and e.hiredate > w.hiredate
;

--42. SELF JOIN을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일

select e.ename, e.hiredate , m.ename, m.hiredate
from emp e, emp m
where e.mgr = m.empno
and e.hiredate < m.hiredate
;