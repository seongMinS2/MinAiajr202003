                    select * 
					from phoneinfo_basic b
					left outer join phoneinfo_univ y 
					on b.idx = y.fr_ref 
					left outer join phoneinfo_com c 
					on b.idx = c.fr_ref 
					left outer join phoneinfo_cafe ca 
					on b.idx = ca.fr_ref;


select * from phoneinfo_basic b inner join phoneinfo_cafe ca on b.idx = ca.fr_ref;
select * from phoneinfo_com  where f like '%?%';

insert into phoneinfo_basic values (PB_BASIC_IDX_SEQ.nextval, ?, ?, ?, ?, ?);

insert into phoneinfo_cafe values (PB_UNIV_IDX_SEQ.nextval, ?, ?, PB_BASIC_IDX_SEQ.currval);

ALTER TABLE phoneinfo_univ
ADD CONSTRAINT PB_UNIV_IDX_FK
  FOREIGN KEY (FR_REF)
  REFERENCES phoneinfo_basic(idx)
  ON DELETE CASCADE;
  
  ALTER TABLE phoneinfo_univ DROP CONSTRAINT PHONEINFO_univ_IDX_FK;


  
  SELECT * FROM all_constraints WHERE table_name = 'phoneinfo_cafe';
 
 
