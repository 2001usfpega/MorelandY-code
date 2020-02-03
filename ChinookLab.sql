--2.0 SQL QUERIES

--2.1 SELECT EMPLOYEE (DONE)
DESC employee;
SELECT * FROM employee;
--SELECT Emploee with last nanme King
SELECT * FROM employee where lastname = 'King';
--SELECT Employee where first name is Andrew and reportsto is null
SELECT * FROM employee WHERE firstname = 'Andrew' and reportsto IS NULL;

--2.2 SQL Order By (DONE)
SELECT * FROM album;
SELECT * FROM album ORDER BY title DESC; 
--SELECT first name from customer and sort result set in ascending order by city
SELECT *FROM customer;
SELECT * FROM customer ORDER BY firstname, city;

--2.3 INSERT INTO (DONE)
SELECT * FROM genre; 
INSERT INTO genre VALUES('26', 'Movies');
INSERT INTO genre VALUES('27', 'Counrty');

SELECT * FROM employee; 
INSERT INTO employee values('9', 'Moreland', 'Yzairyen', 'IT Staff',' 6', '27-AUG-92', '29 -JAN-20', '923 7 ST NW', 'Lethbridge', 'AB', 'Canada',' 75165','1+ 469-285-3019', '1+ 123-345-67890', 'yrmoreland@gmail.com');
INSERT INTO employee values('10', 'Mon', 'Poke', 'IT Staff',' 6', '1-APR-97', '29 -JAN-20', 'Japan', 'Somewhere In Japan', 'JAP', 'Japan',' 1200000','+011 815671234', '+011 816676543', 'satoshi@tajiri.com');


SELECT * FROM customer;
INSERT INTO customer values('60','Poke', 'Mon', 'VM', 'Rue Jouvence', 'Waxahachie', 'TJ', 'Spain', '20200', '+864-556-576-8543','+97-245-6865','hi@bye.com', '3'); 
INSERT INTO customer values('61','Hi', 'Ya', 'Google', 'Ple ase', 'Dallas', 'Tx', 'Sweeden', '20201', '+98-758-567-37488','+97-234-6775','bye@you.com', '5'); 

--2.4 UPDATE (DONE)
SELECT * FROM customer; 
UPDATE customer SET firstname = 'Robert' where firstname = 'Aaron';
UPDATE customer SET lastname = 'Walter' where lastname = 'Mitchell';

SELECT * FROM artist;
SELECT * FROM artist order by name;
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';--LINE 67 TO LINE 50

--2.5 LIKE (DONE)
SELECT * FROM invoice;
SELECT * FROM invoice where billingaddress like 'T%';

--2.6 BETWEEN (DONE)
SELECT * FROM invoice;
SELECT * FROM invoice where total between 15 and 50;
SELECT * FROM employee;
SELECT * FROM employee where hiredate between '01-JUN-03' and '01-MAR-04';

--2.7 DELETE (DONE)
SELECT * FROM customer;
ALTER TABLE INVOICE
DISABLE CONSTRAINT fk_invoicecustomerid; 
DELETE customer where firstname= 'Robert' and lastname = 'Walter';

--3.0 SQL FUNCTIONS

--3.1 SYSTEM DEFINED FUNCTIONS (DONE)
SELECT current_timestamp FROM DUAL;
SELECT * FROM mediatype;
SELECT length ('mediatype') from dual;

--3.2 SYSTEM DEFINDED AGGREGATE FUNCTIONS (DONE)
SELECT * FROM invoice;
SELECT AVG (TOTAL) FROM invoice;
SELECT MAX (TOTAL) FROM invoice;

--3.3 USER DEFINED SCALAR FUNCTIONS (DONE)
SELECT * FROM invoiceline;
--SELECT unitprice from invoiceline;
SELECT avg (unitprice) from invoiceline;

--3.4 USER DEFINED TABLE VALUE FUNCTIONS (DONE)
SELECT * FROM employee;
--SELECT * FROM employee where birthdate > '31-DEC-68';
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE
                        WHERE birthdate > '31-DEC-68';
  RETURN EMPLOYEE_C;
END;
/  

SELECT AFTER_1968 FROM DUAL;
    
--4.0 PROCEDURES

--4.1 BASIC STORED PROCEDURE(need to fill in blanks)
SELECT * FROM employee;
CREATE PROCEDURE employee_names(employeea out sys_refcursor)
IS
BEGIN
    open employeea FOR SELECT firstname, lastname FROM EMPLOYEE;
end;
/
DECLARE 
    employeea SYS_REFCURSOR; 
    firstname varchar2(50);
    lastname varchar2(50);
BEGIN
    employee_names(employeea);

LOOP
FETCH employeea
INTO 
    firstname;
    lastname;
EXIT WHEN employeea%notfound;

DBMS_OUTPUT.PUT_LINE(firstname || '' || lastname);
END LOOP;

END;
/
--4.2.1 STORED PROCEDURES INPUT PARAMETERS (DONE)
SELECT * FROM EMPLOYEE;
CREATE OR REPLACE PROCEDURE update_EMPLOYEE--(firstname in varchar2, lastname in varchar2,
   -- phone in number)
is
begin
    UPDATE employee SET firstname= 'Edwardz' where firstname = 'Nancy';
    UPDATE employee SET lastname= 'Nancee' where lastname ='Edwards';
    UPDATE employee SET phone = '+1 (972) 867-5309' where phone = '+1 (403) 262-3443';

END;
/

BEGIN 
    
    update_employee;
END;
/


--4.2.2 STORED PROCEDURES INPUT PARAMETERS (DONE)
CREATE OR REPLACE PROCEDURE getManager(ID IN NUMBER, MANAGER OUT VARCHAR2)
IS
    m_Id Number(10);
Begin 
    SELECT reportsto INTO m_id FROM employee WHERE employeeid = ID;
    SELECT firstname || ' ' || lastname INTO MANAGER FROM employee WHERE employeeid = m_id;
    END;
    /
DECLARE 
MANAGER VARCHAR(50);
BEGIN
    getManager(6, MANAGER);
    DBMS_OUTPUT.PUT_LINE(MANAGER);
END;
/

--4.3 STORED PROCEDURE THAT STORES THE NAME AND COMPANY OF A CUSTOMER (DONE)
SELECT * FROM CUSTOMER;
CREATE OR REPLACE PROCEDURE customerSS(custo_id in number, custo_name out varchar2, custo_company out varchar2)
IS
BEGIN
     SELECT firstname || ' ' || lastname, company INTO custo_name, custo_company FROM customer WHERE customerid = custo_id;
     END;
     /
     
DECLARE 
    custo_name VARCHAR2(75);
    company VARCHAR2(75);

BEGIN
    customerSS(5, custo_name, company);
     DBMS_OUTPUT.PUT_LINE(custo_name || ' with ' || company);

END;
/


--5.0 TRANSACTIONS

--5.1 DELETE INVOICE FROM INVOICEID (DONE)
SELECT * FROM invoice;
DELETE FROM invoiceline WHERE invoiceid IN
    (SELECT invoiceid FROM invoice WHERE INVOICEid IN
        (SELECT INVOICEid FROM INVOICE WHERE INVOICEID = 2)
    );
COMMIT;
DELETE FROM INVOICE WHERE INVOICEID = 2;

--5.2 NESTED STORED PROCEDURE (DONE)
SELECT * FROM CUSTOMER;
CREATE OR REPLACE PROCEDURE insert_customer--(c_customer_id IN number, firstname in varchar2, lastname in varchar2, company in varchar2, address in varchar2
  -- , city in varchar2, state in varchar2, country in varchar2, postalcode in varchar2, phone in number, email in varchar2, supportrepid in number)
IS
BEGIN
    INSERT INTO customer VALUES
    ('62', 'Amanda', 'Please', 'null', '4567 heelo', 'Los Angeles', 'CA', 'United States'
    , '63856','+97 4839 585949', 'null', 'amandaplease@amandabarnes.com', '5');
COMMIT;
END;
/
DECLARE
BEGIN 
        insert_customer;
END;
/


--6.0 TRIGGERS (DONE)
--Trigger Syntax
--CREATE [OR REPLACE] TRIGGER trigger_name
--BEFORE | AFTER           INSERT | UPDATE | DELETE
--ON TABLE_NAME 
--FOR EACH ROW       <--- REQUIRED IF YOU WANT TO SEE/MANIPULATE ROWS OR DATE
--DECLARE
--BEGIN
--EXCEPTION
--END;
--/ <--SLASH

--6.1 AFTER TRIGGER(DONE)
--DELETE from employee where employeeid = '8';
INSERT INTO EMPLOYEE values('15', 'Hello', 'Magnolia', 'IT Staff', '6', '09-JAN-62', '04-MAR-12','1234 IDK ST'
        ,'Somewhere', 'Over', 'The', 'Rainbow', '+1 (403) 657-7536', '+ 1 (403) 277-8378', 'magic@karp.com');


CREATE or replace TRIGGER insert_employee
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
   
   DBMS_OUTPUT.PUT_LINE('New Employee');
                  
END;
/

SELECT * FROM EMPLOYEE;
    
   

--6.2 UPDATE TRIGGER (DONE)
UPDATE album SET title= 'For Whom The Bell Tolls' WHERE albumid=1;

CREATE OR REPLACE TRIGGER album_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN 

    DBMS_OUTPUT.PUT_LINE('Update album');

END;
/
SELECT * FROM album;

--6.3 DELETE TRIGGER (DONE)
 
DELETE from customer WHERE firstname = 'Helena';
--INSERT INTOcustomer values('66', 'Day', 'Mon', 'Weekend', 'Weekday'
  -- ,'Tuesday', 'MWF', 'TTHSS', '1234567','+012 345678910', '+098 76543210', 'happy@feet.com', '5');


CREATE or replace TRIGGER delete_after_customer
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
     DBMS_OUTPUT.PUT_LINE('New customer');

END;
/


SELECT * FROM customer;

--DELETE from customer WHERE firstname = 'Helena';

--BEGIN
--INSERT INTO customer values('63', 'Mon', 'Poke', 'AshCatchem', 'Somewhere In Japan'
  --   ,'Japan', 'JAP', 'Japan',' 1200000','+011 815671234', '+011 816676543', 'satoshi@tajiri.com', '3');


--END;

--7.0 JOINS (DONE)

--7.1 INNER JOIN
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT * FROM customer a inner join invoice b on a.customerid= b.invoiceid;

--7.2 OUTER JOIN
SELECT*FROM customer;
SELECT*FROM invoice;
select * from customer a full outer join invoice b on a.customerid= b.invoiceid;

--7.3 RIGHT
SELECT * FROM album;
SELECT *FROM artist;
SELECT * FROM artist a right outer join album b on a.name= b.title;--better way of using right outer join

--7.4 Cross
SELECT * FROM album;
SELECT *FROM artist;
SELECT * FROM album cross join artist order by artist.name desc;

--7.5 Self Join
SELECT * FROM employee;
SELECT* FROM employee a inner join employee b on a.employeeid=b.reportsto;

--THE ENNNNDDDDAAAHHHHHHH--


ROLLBACK;

--SELECT * FROM EMPLOYEE;

--INSERT INTO EMPLOYEE --(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city
   -- , state, country, postalcode, phone, fax, email)
--values('8', 'Callahan', 'Laura', 'IT Staff', '6', '09-JAN-69', '04-MAR-04','923 7 ST'
      --  ,'NW Lethbridge', 'AB', 'Canada', 'T1H1Y8', '+1 (403) 467-3351', '+ 1 (403) 467-8772', 'laura@chinookcorp.com');
     


