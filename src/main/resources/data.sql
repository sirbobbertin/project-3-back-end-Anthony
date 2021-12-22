# -------- Missing columns & cause error on insert---------

INSERT INTO user_details(user_email, user_password, user_first_name, user_last_name, user_address, user_contact, user_type, user_removed)
VALUES('manager@email.com', 123456, 'Jane', 'Doe', 'California', '555-555-5555', 'Manager', FALSE);

INSERT INTO user_details(user_email, user_password, user_first_name, user_last_name, user_address, user_contact, user_type, user_removed) 
VALUES('employee@email.com', 123456, 'John', 'Doe', 'California', '555-555-5555', 'Employee', FALSE);

INSERT INTO user_details(user_email, user_password, user_first_name, user_last_name, user_address, user_contact, user_type, user_removed) 
VALUES('customer1@email.com', 123456, 'Test', 'Doe', 'California', '555-555-5555', 'Customer', FALSE);

INSERT INTO user_details(user_email, user_password, user_first_name, user_last_name, user_address, user_contact, user_type, user_removed) 
VALUES('customer2@email.com', 123456, 'Test', 'Doe', 'California', '555-555-5555', 'Customer', FALSE);


INSERT INTO user_details(user_email, user_password, user_first_name, user_last_name, user_address, user_contact, user_type, user_removed) 
VALUES('customer3@email.com', 123456, 'Test', 'Doe', 'California', '555-555-5555', 'Customer', FALSE);

#--------- Fixed the missing columns User Tables
INSERT INTO user_details(user_id, user_email, user_name, user_password, user_first_name,
user_last_name, user_address, user_contact, user_type, user_removed)
VALUES(1,'manager@email.com',' testu', 'password', 'Jane', 'Doe',
'123 main St Los Angeles, CA', '555-555-5555', 'Customer', FALSE);

INSERT INTO user_details(user_id, user_email, user_name, user_password, user_first_name,
user_last_name, user_address, user_contact, user_type, user_removed)
VALUES(2,'keu@gemail.com',' newg1', 'pass1', 'Kiera', 'Eupnary',
'66 Elm St Manchester, NH', '321-115-6500', 'Customer', FALSE);

#-------For adding Products --------

insert into product_details(product_id, image_url, product_category, product_cost,
product_description, product_name, product_qty, product_removed, product_sku)
values (1, 'http://pexels.com/img23', 'Gaming Chairs', 234.89,
'Best gaming chair ever. You can play all daylong & will never get body ache. Its for the real gamer',
'XBlaster Chair', 10, false, 'A0XB34GCHAIR00234');

 insert into product_details(product_id, image_url, product_category, product_cost,
  product_description, product_name, product_qty, product_removed, product_sku)
 values (2, 'http://pexels.com/img12', 'Gaming Chairs', 134.79,
 'New gaming chair ever. You can play all day long & will never get body ache. Its for the real gamer',
 'New XBlaster Chair', 5, false, 'A0XB34GNEWC00234');
