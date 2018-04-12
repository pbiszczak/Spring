GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root12345' WITH GRANT OPTION;
FLUSH PRIVILEGES;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50),
	`description` VARCHAR(255),
	`image_url` VARCHAR(50),
	`active` BOOLEAN,
	CONSTRAINT `pk_category_id` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50),
	`last_name` VARCHAR(50),
	`role` VARCHAR(50),
	`enabled` BOOLEAN,
	`password` VARCHAR(60),
	`email` VARCHAR(100),
	`contact_number` VARCHAR(15),
	CONSTRAINT `pk_user_id` PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`code` VARCHAR(20),
	`name` VARCHAR(50),
	`brand` VARCHAR(50),
	`description` VARCHAR(255),
	`price` DECIMAL(10,2),
	`quantity` INT,
	`active` BOOLEAN,
	`category_id` INT,
	`supplier_id` INT,
	`purchases` INT DEFAULT 0,
	`views` INT DEFAULT 0,
	CONSTRAINT `pk_product_id` PRIMARY KEY (id),
 	CONSTRAINT `fk_product_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
	CONSTRAINT `fk_product_supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `address`;


CREATE TABLE `address` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int,
	`address_line_one` VARCHAR(100),
	`address_line_two` VARCHAR(100),
	`city` VARCHAR(20),
	`state` VARCHAR(20),
	`country` VARCHAR(20),
	`postal_code` VARCHAR(10),
	`billing` BOOLEAN,
	`shipping` BOOLEAN,
	CONSTRAINT `fk_address_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
	CONSTRAINT `pk_address_id` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `basket`;


CREATE TABLE `basket` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int,
	`total_payment` DECIMAL(10,2),
	`number_of_items` int,
	CONSTRAINT `fk_basket_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
	CONSTRAINT pk_basket_id PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `basket_item`;

CREATE TABLE `basket_item` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`basket_id` int,
	`total_payment` DECIMAL(10,2),
	`product_id` int,
	`product_count` int,
	`price` DECIMAL(10,2),
	`available` boolean,
	CONSTRAINT `fk_basket_item_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
	CONSTRAINT pk_basket_item_id PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- the order detail table to store the order
DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int,
	`total_payment` DECIMAL(10,2),
	`item_count` int,
	`shipping_address_id` int,
	`billing_address_id` int,
	`order_date` date,
	CONSTRAINT `fk_order_detail_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
	CONSTRAINT `fk_order_detail_shipping_id` FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`id`),
	CONSTRAINT `fk_order_detail_illing_id` FOREIGN KEY (`billing_address_id`) REFERENCES `address` (`id`),
	CONSTRAINT `pk_order_detail_id` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`order_detail_id` int,
	`total_payment` DECIMAL(10,2),
	`product_id` int,
	`product_count` int,
	`price` DECIMAL(10,2),
	CONSTRAINT `fk_order_item_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
	CONSTRAINT `fk_order_item_order_detail_id` FOREIGN KEY (`order_detail_id`) REFERENCES `order_detail` (`id`),
	CONSTRAINT `pk_order_item_id` PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



-- adding three categories
LOCK TABLES `category` WRITE;

INSERT INTO `category` (name, description, image_url, active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO `category` (name, description, image_url, active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO `category` (name, description, image_url, active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);



-- adding two users
LOCK TABLES `user` WRITE;

INSERT INTO user (first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Pawel', 'B', 'ADMIN', true, '$2a$04$M4Z78qI0U59DI2NeTprbTe..lcX8Tv4ifKTsOGLErrjEyHA.EAgmW', 'pawel', '123');

INSERT INTO `user`(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Adam', 'Z', 'SUPPLIER', true, '$2a$04$M4Z78qI0U59DI2NeTprbTe..lcX8Tv4ifKTsOGLErrjEyHA.EAgmW', 'adam', '12345');

INSERT INTO `user`(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Michal', 'Z', 'USER', true, '$2a$04$M4Z78qI0U59DI2NeTprbTe..lcX8Tv4ifKTsOGLErrjEyHA.EAgmW', 'michal', '123457');


-- adding five products
LOCK TABLES `product` WRITE;




INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PHONEx1', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 3000, 5, true, 3, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PHONEx2', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 1000, 2, true, 3, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PHONEx2', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 1200, 5, true, 3, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('LAPTOPx1', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 3000, 3, true, 1, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('LAPTOPx2', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 2000, 5, true, 1, 2, 0, 0 );



UNLOCK TABLES;
