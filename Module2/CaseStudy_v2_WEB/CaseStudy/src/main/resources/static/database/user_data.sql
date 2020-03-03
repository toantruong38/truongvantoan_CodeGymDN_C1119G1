insert into `user` (user_name,pass_word)
values ('admin','$2a$10$4CtFu4wYvc1Tdb./VOaQmOu1v/pIociYr5CvTMSLxEwMZTrPFUEN.');

insert into `authority` (role)
values ('ROLE_ADMIN');
insert into `authority` (role)
values ('ROLE_USER');
insert into `authority` (role)
values ('ROLE_GOD');

insert into `user_authority` (user_id, authority_id)
values (1,1);
