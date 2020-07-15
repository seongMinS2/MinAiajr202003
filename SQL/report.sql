-- report

create table report(
  idx number(4) PRIMARY KEY,
  sname varchar2(20) not null,
  sno varchar(10) not null,
  reportfile varchar2(100) not null
);

create SEQUENCE report_seq;

insert into report values (report_seq.nextval, '홍길동', '1234', 'file/12312412343_report.ppt');



SELECT
    *
FROM report;

ROLLBACK;

COMMIT;