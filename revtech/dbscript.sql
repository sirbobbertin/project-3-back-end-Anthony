CREATE TABLE user_details(
user_id INT GENERATED ALWAYS AS IDENTITY,
user_email VARCHAR,
user_password VARCHAR(128),
user_first_name VARCHAR(50),
user_last_name VARCHAR(50),
user_address VARCHAR,
user_contact VARCHAR(15),
user_type VARCHAR(10),
user_removed BOOLEAN,
PRIMARY KEY(user_id));

CREATE TABLE product_details(
product_id INT GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(100),
product_cost INT,
product_description VARCHAR,
product_sku VARCHAR,
product_qty INT,
product_removed BOOLEAN,
PRIMARY KEY(product_id));

CREATE TABLE image_details(
image_id VARCHAR,
image_name VARCHAR,
image_type VARCHAR,
product_id INT,
image_data OID,
FOREIGN KEY(product_id) 
REFERENCES product_details(product_id) ON DELETE CASCADE);

CREATE TABLE cart_details(
cart_id INT GENERATED ALWAYS AS IDENTITY,
user_id INT,
cart_total INT,
cart_paid BOOLEAN,
PRIMARY KEY(cart_id),
FOREIGN KEY(user_id) REFERENCES user_details(user_id));

CREATE TABLE cart_items(
cart_id INT,
product_id INT,
cart_qty INT,
FOREIGN KEY(cart_id) REFERENCES cart_details(cart_id),
FOREIGN KEY(product_id) REFERENCES product_details(product_id));

CREATE TABLE transaction_details(
transaction_id INT GENERATED ALWAYS AS IDENTITY,
transaction_date DATE,
cart_id INT,
PRIMARY KEY(transaction_id),
FOREIGN KEY(cart_id) REFERENCES cart_details(cart_id));

CREATE TABLE discount_details(
discount_id INT GENERATED ALWAYS AS IDENTITY,
product_id INT,
discount_description VARCHAR,
PRIMARY KEY(discount_id),
FOREIGN KEY(product_id) REFERENCES product_details(product_id) ON DELETE CASCADE);