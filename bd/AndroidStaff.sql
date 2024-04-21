create database StaffAndroid
go
use StaffAndroid

create table Staff(
dni char(10) primary key not null,
FirstName varchar(20) not null,
Surname varchar(20) not null,
Address varchar(30)not null,
Phone char(10) not null,
Salary money not null
)
select* from Staff
insert into Staff values('76670123','Marco Ant','Rath Chipani','s/n','900778011',1000)

insert into Staff values('76670312','Jesus Andres','Sideral','av.Las palmeras','900778010',950)

