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

-- the address table to store the user billing and shipping addresses
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

-- the cart table to store the user cart top-level details
CREATE TABLE `basket` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user_id` int,
	`total_payment` DECIMAL(10,2),
	`number_of_items` int,
	CONSTRAINT `fk_basket_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
	CONSTRAINT pk_basket_id PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
-- the cart line table to store the cart details

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

-- the order item table to store order items
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



-- adding three users
LOCK TABLES user WRITE;

INSERT INTO `user`
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Virat', 'Kohli', 'ADMIN', true, '$2a$04$d.Yzx2DGEKSo48F6FMqNHeKzb88Z2h7ckYpoRvvsqhXY1zxuiAVZe', 'vk@gmail.com', '8888888888');
INSERT INTO `user`
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, '$2a$04$d.Yzx2DGEKSo48F6FMqNHeKzb88Z2h7ckYpoRvvsqhXY1zxuiAVZe', 'rj@gmail.com', '9999999999');
INSERT INTO `user`
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '$2a$06$i1dLNlXj2uY.UBIb9kUcAOxCigGHUZRKBtpRlmNtL5xtgD6bcVNOK', 'ra@gmail.com', '7777777777');
INSERT INTO `user`
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Khozema', 'Nullwala', 'USER', true, '$2a$04$d.Yzx2DGEKSo48F6FMqNHeKzb88Z2h7ckYpoRvvsqhXY1zxuiAVZe', 'kn@gmail.com', '7777777777');

-- adding five products
LOCK TABLES `product` WRITE;

INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO `product` (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );






-- adding a supplier correspondece address
LOCK TABLES `address` WRITE;

INSERT INTO `address` (user_id, address_line_one, address_line_two, city, state, country, postal_code, billing, shipping)
VALUES (4, '102 Sabarmati Society, Mahatma Gandhi Road', 'Near Salt Lake, Gandhi Nagar', 'Ahmedabad', 'Gujarat', 'India', '111111', true, false );



-- adding a cart for testing
LOCK TABLES `basket` WRITE;

INSERT INTO `basket` (user_id, total_payment, number_of_items) VALUES (4, 0, 0);

UNLOCK TABLES;
