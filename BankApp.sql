CREATE TABLE customer(
        customer_id NUMBER(25)
        ,customer_firstname VARCHAR2(50)
        ,customer_lastname VARCHAR2(50)
        ,customer_username VARCHAR2(25)UNIQUE
        , customer_password VARCHAR2(25) NOT NULL
         , customer_accountnumber NUMBER(25)
         , checking_balance NUMBER (25)
         , saving_balance NUMBER (25)
        ,PRIMARY KEY (customer_id)
);
CREATE SEQUENCE cus
    START WITH 8
    INCREMENT BY 1;

DROP SEQUENCE cus;
DROP TRIGGER custom;

CREATE OR REPLACE TRIGGER cus
    BEFORE INSERT ON customer
    FOR EACH ROW
    BEGIN
        IF : NEW.customer_id IS NULL THEN
            SELECT cus.NEXTVAL INTO : NEW.customer_id FROM dual;
        END IF;
    END;
/

CREATE SEQUENCE custoa
    START WITH 27
    INCREMENT BY 1;

DROP SEQUENCE custoa;
DROP TRIGGER customs;

CREATE OR REPLACE TRIGGER customs
    BEFORE INSERT ON customer
    FOR EACH ROW
    BEGIN
        IF : NEW.customer_accountnumber IS NULL THEN
            SELECT custoa.NEXTVAL INTO : NEW.customer_accountnumber FROM dual;
        END IF;
    END;
/

INSERT INTO customer(customer_firstname, customer_lastname, customer_username, customer_password, checking_balance, saving_balance)
    VALUES ( 'Billie', 'McGruder', 'BD', 'Dumpling', '700', '4000');
INSERT INTO customer(customer_firstname, customer_lastname, customer_username, customer_password, checking_balance, saving_balance)
VALUES( 'Magnolia', 'McGruder', 'Mac', 'McNasty', '500', '8000');

SELECT * FROM customer;

UPDATE customer SET checking_balance = 0  WHERE customer_firstname = 'Magnolia';
SELECT * FROM customer ORDER BY customer_id;
COMMIT;
--drop table customer;


CREATE TABLE ADMIN(
        admin_id NUMBER(15)
        ,admin_firstname VARCHAR2(50)UNIQUE
        ,admin_lastname VARCHAR2(50)
        ,admin_username VARCHAR2 (50)
        ,admin_password VARCHAR2(50)
        ,PRIMARY KEY (admin_id)
);

INSERT INTO ADMIN VALUES (082792, 'Yzairyen', 'Moreland', 'YMORE', '*****');

--DROP TABLE admin;
SELECT * FROM ADMIN;

COMMIT;