--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수

select count(distinct bookname)
from customer c cross join orders o cross join book b
where c.custid = o.custid
and c.name = '박지성'
and b.bookid = o.bookid
;


--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

select b.bookname, b.price, b.price - o.saleprice as "가격차이"
from customer c cross join orders o cross join book b
where c.custid = o.custid
and c.name = '박지성'
and b.bookid = o.bookid
;



--(7) 박지성이구매하지않은도서의이름

--박지성이 구매한 도서의 이름
select b.bookname
from customer c cross join orders o cross join book b
where c.custid = o.custid
and c.name = '박지성'
and b.bookid = o.bookid
;

--박지성이 구매하지 않은 도서의 이름
select bookname
from book
where bookname not in(select b.bookname
                    from customer c cross join orders o cross join book b
                    where c.custid = o.custid
                    and c.name = '박지성'
                    and b.bookid = o.bookid
                    );

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)



--주문한 고객의 이름
select distinct c.name
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid
;

--주문하지 않은 고객의 이름
select name
from customer
where name not in (select distinct c.name
                        from customer c cross join orders o cross join book b
                        where c.custid = o.custid
                        and b.bookid = o.bookid
                        );


--(9) 주문금액의총액과주문의평균금액

select sum(saleprice) as "총금액", avg(saleprice) as "평균 금액"
from orders;


--(10) 고객의이름과고객별구매액

select c.name, nvl(sum(o.saleprice), 0)
from customer c left outer join orders o
using(custid)
group by c.name;



--(11) 고객의이름과고객이구매한도서목록

select c.name, b.bookname
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid
;



--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

--가격의 차이 목록
select b.price - o.saleprice as "가격차이"
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid
;

--가격차이가 제일 큰 값
select max("가격차이가 큰 주문")
from (select b.price - o.saleprice as "가격차이가 큰 주문"
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid)
;

--가격의 차이가 가장 많은 주문(전체출력)
select *
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid
and b.price - o.saleprice in (select max("가격차이가 큰 주문")
                    from (select b.price - o.saleprice as "가격차이가 큰 주문"
                    from customer c cross join orders o cross join book b
                    where c.custid = o.custid
                    and b.bookid = o.bookid))
;


--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름

--도서의 판매액 평균
select avg(saleprice) from orders;

select c.name
from customer c left outer join orders o
using(custid)
group by name
having avg(o.saleprice) > (select avg(saleprice) from orders)
;


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름

--박지성이 구매한 책 이름
select b.publisher
from customer c cross join orders o cross join book b
where c.custid = o.custid
and c.name = '박지성'
and b.bookid = o.bookid
;

--박지성을 제외한 같은 출판사에서 도서를 구매한 고객의 이름
select c.name
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid
and c.name != '박지성'
and b.publisher in (select b.publisher
                        from customer c cross join orders o cross join book b
                        where c.custid = o.custid
                        and c.name = '박지성'
                        and b.bookid = o.bookid)
;


--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름

-- 2개이상의 서로다른 출판사에서 도서를 구매한 사람의 목록(이름기준으로 그룹바이해줘야함)
select c.name, b.publisher
from customer c cross join orders o cross join book b
where c.custid = o.custid
and b.bookid = o.bookid
group by c.name, b.publisher
having count(*) = 1
;



--이름

select distinct na
from (select c.name na, b.publisher pu
        from customer c cross join orders o cross join book b
        where c.custid = o.custid
        and b.bookid = o.bookid
        group by c.name, b.publisher
        having count(*) = 1)
;

select name
from orders o, customer c, book b 
where o.custid=c.custid 
and o.bookid = b.bookid
group by name
having count(distinct publisher)>=2;