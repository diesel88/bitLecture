create table tb_account (
	id varchar2(3),
	money number(6)
);

insert into tb_account values ('a', 10000);
insert into tb_account values ('b', 10000);

commit;

select * from TB_ACCOUNT;