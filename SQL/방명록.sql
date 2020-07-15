-- 방명록 테이블

create table guestbook_message (
    message_id number(4) primary key,
    guest_name varchar2(50) not null,
    password varchar2(10) not null,
    message varchar2(2000) not null
);

create SEQUENCE message_id_seq INCREMENT by 1 START WITH 1;


insert into guestbook_message 
values (message_id_seq.nextVal, '테스터10', '1111', '글쓰기 테스트');

SELECT
    *
FROM guestbook_message;

select ROWNUM, message_id, message
from guestbook_message;


delete from guestbook_message;

select * from guestbook_message order by message_id desc;
select rownum, message_id, guest_name, password, message 
from guestbook_message order by message_id desc;


select rownum, message_id, guest_name, password, message 
from (
    select * from guestbook_message order by guestbook_message.message_id desc
);

-- 2page : 4~6

select rownum, message_id, guest_name, password, message 
from (
    select * from guestbook_message order by guestbook_message.message_id desc
) where rownum <= 6;



select rnum,message_id,guest_name,password,message
from(
   select rownum rnum,message_id,guest_name,password,message  
   from (
      select * 
      from guestbook_message m
      order by m.MESSAGE_ID desc
   )
   where rownum <= 6
)
where rnum >= 4;


commit;

rollback;

