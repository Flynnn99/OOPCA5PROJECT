DROP DATABASE IF EXISTS bar_database;

CREATE DATABASE bar_database;

USE bar_database;

CREATE TABLE products
(PRODUCT_ID INT NOT NULL AUTO_INCREMENT,
PRODUCT_NAME VARCHAR(25),
PRODUCT_TYPE VARCHAR (25),
DRINK_PERCENTAGE FLOAT,
PRICE Float
PRIMARY KEY (PRODUCT_ID));

INSERT INTO products(product_name,product_type,drink_percentage,price)values
("Carlsberg", "Beer  ", 4.5, 5),
("Peroni", "Beer  ", 4.5, 5),
("Moretti", "Beer  ", 4.5, 5),
("Guinness", "Stout ", 5, 5.50),
("Smthwcks", "RedAle", 5, 5),
("Magners", "Cider ", 4, 4.50),
("Jameson", "Whisky", 45, 3.80),
("Powers", "Whisky", 45, 4.00),
("Jack D", "Bourbon", 45, 3.60),
("Jhny W", "Scotch", 35, 5),
("Macallan", "Scotch", 50, 45),
("SoComfort", "Bourbon", 4, 4.50),
("Smirnoff", "Vodka ", 45, 4.00),
("GreyGoose", "Vodka ", 45, 5.50);

CREATE TABLE patrons(
PATRON_ID INT NOT NULL AUTO_INCREMENT,
PATRON_NAME VARCHAR(30),
PATRON_AGE INT
PRIMARY KEY (PATRON_ID));

INSERT INTO patrons(patron_name, patron_age) values
("Claire", 25),
("Grimes", 32),
("Sammy", 54),
("Domhnall", 50),
("Aine", 31),
("Bernie", 29),
("James", 80),
("Emma", 30),
("Jack", 22),
("Freydis", 23);






