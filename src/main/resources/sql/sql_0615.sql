drop table if exists member_tbl;

create table member_tbl(
   id int primary key auto_increment ,
   username varchar(50),
   email varchar(200),
   `password` varchar (300)
);

insert into member_tbl(username,email,`password`) values
('권도현','도현@example.com','1234'),
('임현진','현진@example.com','1233'),
('박정은','정은@example.com','1222'),
('박현정','현정@example.com','1432');
