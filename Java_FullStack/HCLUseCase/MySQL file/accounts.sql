use accounts;
CREATE TABLE transactions (
    cus_id int NOT NULL,
    username int NOT NULL,
    password varchar(45) not null,
    email varchar(45) not null,
    balance int,
    PRIMARY KEY(cus_id)
)ENGINE=INNODB;

CREATE TABLE transactions (
	tranc_id int NOT NULL,
    cus_id int,
    tranc_amt int NOT NULL,
    tranc_type varchar(45) not null,
    tranc_date datetime,
    PRIMARY KEY(tranc_id),
    FOREIGN KEY (cus_id) references customers(cus_id)
)ENGINE=INNODB;

SELECT * FROM  customers;

SELECT * FROM  transactions;


