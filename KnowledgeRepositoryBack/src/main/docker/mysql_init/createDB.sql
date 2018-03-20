CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)

);

CREATE TABLE user (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);


CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	price DECIMAL(10,2),
	quantity INT,
	active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user (id),
);

-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	billing BOOLEAN,
	shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id) REFERENCES user (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE basket (
	id IDENTITY,
	user_id int,
	total_payment DECIMAL(10,2),
	number_of_items int,
	CONSTRAINT fk_basket_user_id FOREIGN KEY (user_id ) REFERENCES user (id),
	CONSTRAINT pk_basket_id PRIMARY KEY (id)
);
-- the cart line table to store the cart details

CREATE TABLE basket_item (
	id IDENTITY,
	basket_id int,
	total_payment DECIMAL(10,2),
	product_id int,
	product_count int,
	price DECIMAL(10,2),
	available boolean,
	CONSTRAINT fk_basket_item_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_basket_item_id PRIMARY KEY (id)
);


-- the order detail table to store the order

CREATE TABLE order (
	id IDENTITY,
	user_id int,
	total_payment DECIMAL(10,2),
	item_count int,
	shipping_address_id int,
	billing_address_id int,
	order_date date,
	CONSTRAINT fk_order_user_id FOREIGN KEY (user_id) REFERENCES user (id),
	CONSTRAINT fk_order_shipping_id FOREIGN KEY (shipping_address_id) REFERENCES address (id),
	CONSTRAINT fk_order_billing_id FOREIGN KEY (billing_address_id) REFERENCES address (id),
	CONSTRAINT pk_order_id PRIMARY KEY (id)
);

-- the order item table to store order items

CREATE TABLE order_item (
	id IDENTITY,
	order_id int,
	total_payment DECIMAL(10,2),
	product_id int,
	product_count int,
	price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);


-- adding three categories
INSERT INTO category (name, description, image_url, active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO category (name, description, image_url, active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO category (name, description, image_url, active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);
-- adding three users
INSERT INTO user
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Virat', 'Kohli', 'ADMIN', true, '$2a$04$d.Yzx2DGEKSo48F6FMqNHeKzb88Z2h7ckYpoRvvsqhXY1zxuiAVZe', 'vk@gmail.com', '8888888888');
INSERT INTO user
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Ravindra', 'Jadeja', 'SUPPLIER', true, '$2a$04$d.Yzx2DGEKSo48F6FMqNHeKzb88Z2h7ckYpoRvvsqhXY1zxuiAVZe', 'rj@gmail.com', '9999999999');
INSERT INTO user
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Ravichandra', 'Ashwin', 'SUPPLIER', true, '$2a$06$i1dLNlXj2uY.UBIb9kUcAOxCigGHUZRKBtpRlmNtL5xtgD6bcVNOK', 'ra@gmail.com', '7777777777');
INSERT INTO user
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES ('Khozema', 'Nullwala', 'USER', true, '$2a$04$d.Yzx2DGEKSo48F6FMqNHeKzb88Z2h7ckYpoRvvsqhXY1zxuiAVZe', 'kn@gmail.com', '7777777777');

-- adding five products
INSERT INTO product (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, price, quantity, active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );
-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, billing, shipping)
VALUES (4, '102 Sabarmati Society, Mahatma Gandhi Road', 'Near Salt Lake, Gandhi Nagar', 'Ahmedabad', 'Gujarat', 'India', '111111', true, false );
-- adding a cart for testing
INSERT INTO basket (user_id, total_payment, number_of_items) VALUES (4, 0, 0);

