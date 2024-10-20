CREATE TABLE USERS(
ID INTEGER PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
EMAIL VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255) NOT NULL,
CPF_CNPJ VARCHAR(255) NOT NULL,
IS_ACTIVE BOOLEAN DEFAULT TRUE
);

create table produtos(
    id integer primary key auto_increment,
    name VARCHAR(255) NOT NULL,
    preco FLOAT,
    quantidade integer,
    USER_ID INTEGER REFERENCES USERS (id)
);

create table venda(
    id integer primary key auto_increment,
    preco FLOAT,
    quantidade integer,
    product_id INTEGER REFERENCES produtos (id),
    USER_ID INTEGER REFERENCES USERS (id)
);