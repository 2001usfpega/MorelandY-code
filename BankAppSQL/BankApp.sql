create table customer(
        customer_id number(25)
        ,customer_firstname varchar2(50)
        ,customer_lastname varchar2(50)
        ,customer_username varchar2(25)unique
        , customer_password varchar2(25) not null
         , customer_accountnumber number(25)
         , checking_balance number (25)
         , saving_balance number (25)
        ,primary key (customer_id)
);

insert into customer values (001, 'Billie', 'McGruder', 'BD', 'Dumpling', 043037, '', '');
insert into customer values (072, 'M', 'Gruder', 'ac', 'McN', 134, '700', '800');
SELECT checking_balance, saving_balance FROM customer where customer_firstname='Magnolia';
SELECT * FROM customer;

DELETE FROM CUSTOMER WHERE CUSTOMER_ID = 546372;
UPDATE customer SET checking_balance= 0, saving_balance= 0; -- saving_balance = ?
UPDATE customer SET checking_balance= 400000 , saving_balance= 500000 where customer_firstname= 'Billie';
select * from customer;
select * from customer order by customer_id;

--drop table customer;


create table admin(
        admin_id number(15)
        ,admin_firstname varchar2(50)unique
        ,admin_lastname varchar2(50)
        ,admin_username varchar2 (50)
        ,admin_password varchar2(50)
        ,primary key (admin_id)
);

insert into admin values (082792, 'Yzairyen', 'Moreland', 'YMORE', '*****');

DROP TABLE admin;
select * from admin;

