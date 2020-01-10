CREATE SCHEMA AUTHORIZATION springmybatis;

create table mybatisdb.employee (
emp_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
fullname varchar(50) not null,
email varchar(50) not null,
gender varchar(50) not null,
hobbies varchar(50) not null,
country varchar(50) not null,
address varchar(50) not null
);

select * from mybatisdb.employee;
insert into MYBATISDB.EMPLOYEE(FULLNAME, EMAIL, GENDER, HOBBIES, COUNTRY, ADDRESS) values('Shibashis Manna', 'test@test.com', 'male', 'reading', 'India', 'L62 sp society');

