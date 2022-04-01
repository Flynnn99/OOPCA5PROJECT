DROP DATABASE IF EXISTS bar_database;

CREATE DATABASE bar_database;

USE bar_database;

CREATE TABLE products
(PRODUCT_ID INT NOT NULL,
PRODUCT_NAME VARCHAR(25),
PRODUCT_TYPE VARCHAR (25),
DRINK_PERCENTAGE FLOAT,
PRICE Float
PRIMARY KEY (PRODUCT_ID));

INSERT INTO products(product_id, product_name,product_type,drink_percentage,price)values
(1, "Carlsberg", "Beer  ", 4.5, 5),
(2, "Peroni", "Beer  ", 4.5, 5),
(3, "Moretti", "Beer  ", 4.5, 5),
(4, "Guinness", "Stout ", 5, 5.50),
(5, "Smthwcks", "RedAle", 5, 5),
(6, "Magners", "Cider ", 4, 4.50),
(7, "Jameson", "Whisky", 45, 3.80),
(8, "Powers", "Whisky", 45, 4.00),
(9, "Jack D", "Bourbon", 45, 3.60),
(10, "Jhny W", "Scotch", 35, 5),
(11, "Macallan", "Scotch", 50, 45),
(12, "SoComfort", "Bourbon", 4, 4.50),
(13, "Smirnoff", "Vodka ", 45, 4.00),
(14, "GreyGoose", "Vodka ", 45, 5.50);

CREATE TABLE patrons(
PATRON_ID INT NOT NULL,
PATRON_NAME VARCHAR(30),
PATRON_AGE INT
PRIMARY KEY (PATRON_ID));

INSERT INTO patrons(patron_id, patron_name, patron_age) values
(1, "Claire", 25),
(2, "Grimes", 32),
(3, "Sammy", 54),
(4, "Domhnall", 50),
(5, "Aine", 31),
(6, "Bernie", 29),
(7, "James", 80),
(8, "Emma", 30),
(9, "Jack", 22),
(10, "Freydis", 23);






