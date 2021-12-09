DROP DATABASE IF EXISTS cardealershipdbTest;
CREATE DATABASE cardealershipdbTest;
USE cardealershipdbTest;

CREATE TABLE Contact (
	contactId INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(50),
    email varchar(50),
    phone varchar(10),
    message TINYTEXT
    );
    

CREATE TABLE User (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(50),
    last_name varchar(50),
    password varchar(50),
    email varchar(50),
    role varchar(50)
);
INSERT INTO `cardealershipdbTest`.`user` (`user_id`, `first_name`, `last_name`, `password`, `email`, `role`) VALUES ('1', 'X', 'man', 'xman', 'xman@hotmail.com', 'Admin');
INSERT INTO `cardealershipdbTest`.`user` (`user_id`, `first_name`, `last_name`, `password`, `email`, `role`) VALUES ('2', 'Stran', 'ger', 'Stranger', 'Stranger@hotmail.com', 'Buyer');
INSERT INTO `cardealershipdbTest`.`user` (`user_id`, `first_name`, `last_name`, `password`, `email`, `role`) VALUES ('3', 'Sal', 'er', 'Saler', 'Saler@hotmail.com', 'Sales');




CREATE TABLE MakeModel (
    make varchar(50),
    model varchar(50),
    date Date,
    email varchar(50)
);
SELECT * FROM makemodel;

INSERT INTO `cardealershipdbTest`.`MakeModel` (`make`, `model`, `date`,`email`) VALUES ('Audi', 'A4', '2016-01-01', 'ewise@guildcars.com');
    
CREATE TABLE Vehicle (
	vehicleId INT PRIMARY KEY AUTO_INCREMENT,
	year INT NOT NULL,
    bodyStyle varchar(50),
    color varchar(20),
    transmission varchar(50),
    interior varchar(50),
    mileage varchar(10),
    vin varchar(20),
    price double,
    MSRP double,
    type varchar(10),
    description TINYTEXT,
	make varchar(10),
	model varchar(10),
	user_id Int,
    CONSTRAINT FOREIGN KEY (user_id)     REFERENCES User (user_id)
    
    );
    
INSERT INTO `cardealershipdbTest`.`vehicle` (`year`, `bodyStyle`, `color`, `transmission`, `interior`, `mileage`, `vin`, `price`, `MSRP`, `type`, `description`, `make`,`model`,`user_id`) VALUES ('2013', 'SUV', 'Silver', 'Automatic', 'Black', '15000', '2DS820192D78S123', '12875', '14875', 'Used', 'Bad Car', 'Audi', 'A4', '3');
INSERT INTO `cardealershipdbTest`.`vehicle`  (`year`, `bodyStyle`, `color`, `transmission`, `interior`, `mileage`, `vin`, `price`, `MSRP`, `type`, `description`, `make`,`model`,`user_id`) VALUES ('2013', 'SUV', 'Silver', 'Automatic', 'Black', '15000', '2DS820192D78S123', '13877', '14875', 'New', 'Bad Car', 'Audi', 'A4', '3');

CREATE TABLE purchase (
	purchase_id INT PRIMARY KEY AUTO_INCREMENT,
	customer_name varchar(50),
    customer_phone varchar(50),
    customer_email varchar(50),
    customer_street1 varchar(50),
    customer_street2 varchar(50),
    customer_city varchar(50),
    customer_state varchar(50),
    customer_zip varchar(50),
    purchase_type varchar(50),
    purchase_time datetime,
    car_id int,
    CONSTRAINT FOREIGN KEY (car_id) REFERENCES Vehicle (vehicleId)
    );