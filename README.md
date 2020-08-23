# dev-ent-java-microserv-spring-final-proj-template
Spring Final Project 
  A small restaurant wants to offer its menu (lunch and dinner only) and let the customers place order (pick up, pay at counter) on the web or through mobile app. 

Main purpose of the project: 
  Users should be able to place an order from Desktop or Mobile and pick up in about 30 minutes from the restaurant. No delivery service to customer.
  
Payment: 
  Will be at the counter before pick-up, can be cheque, cash or credit card.
  
FrontEnd (not covered in this project, tools like curl and postman can be used to simulate this): 
  Web or Mobile App (gets the menu from the web server, connecting to the backend database on the cloud)

Middle layer: 
  Java Spring Framework based interface so that the FrontEnd (Web and Mobile App) requests can be streamlined.

Backend, database: 
  Any in the cloud, for now SQL based database.

Time of food delivery after order is complete: Standard, 30 minutes after order.

Limitations of this project:
  Only part of Middle layer (Java Spring Framework), is shown to demo a viable option to cater to needs of Small Restaurants.
Backend used: MySQL, tables are two, one for Restaurant Menu, other for all Customers

Microservices:

  Add Customer
  
  Add Menu Item

  Get all customers
  
  Get all menu items
  
  Get Lunch items from menu items
  
  Get Drink items from menu items
  
  Get Dessert items from menu items
  
  Get Apitizer items from menu items
  
  Get both Apitizer and Drink items from menu items
  

<code>
CREATE DATABASE restaurant_menu_db;

USE restaurant_menu_db;

CREATE TABLE IF NOT EXISTS menu_list (

    menu_id INT AUTO_INCREMENT PRIMARY KEY,

    dish_name VARCHAR(255) UNIQUE NOT NULL,
    
    dish_type VARCHAR(255) NOT NULL,
    
    description VARCHAR(255),
    
    dish_price DECIMAL(5,2) NOT NULL
    
);

CREATE TABLE IF NOT EXISTS customer_list (

    cust_id INT AUTO_INCREMENT PRIMARY KEY,
    
    first_name VARCHAR(255) NOT NULL,
    
    last_name VARCHAR(255) NOT NULL,
    
    email_id VARCHAR(128) UNIQUE NOT NULL,
    
    user_name VARCHAR(32) UNIQUE NOT NULL,
    
    phone_no VARCHAR(32) NOT NULL,
    
    addr VARCHAR(255)
    
);


mysql> DESCRIBE customer_list;

+------------+--------------+------+-----+---------+----------------+

| Field      | Type         | Null | Key | Default | Extra          |

+------------+--------------+------+-----+---------+----------------+

| cust_id    | int(11)      | NO   | PRI | NULL    | auto_increment |

| first_name | varchar(255) | NO   |     | NULL    |                |

| last_name  | varchar(255) | NO   |     | NULL    |                |

| email_id   | varchar(128) | NO   | UNI | NULL    |                |

| user_name  | varchar(32)  | NO   | UNI | NULL    |                |

| phone_no   | varchar(32)  | NO   |     | NULL    |                |

| addr       | varchar(255) | YES  |     | NULL    |                |

+------------+--------------+------+-----+---------+----------------+

7 rows in set (0.00 sec)



mysql> DESCRIBE menu_list;                                                      

+-------------+--------------+------+-----+---------+----------------+

| Field       | Type         | Null | Key | Default | Extra          |

+-------------+--------------+------+-----+---------+----------------+

| menu_id     | int(11)      | NO   | PRI | NULL    | auto_increment |

| dish_name   | varchar(255) | NO   | UNI | NULL    |                |

| dish_type   | varchar(255) | NO   |     | NULL    |                |

| description | varchar(255) | YES  |     | NULL    |                |

| dish_price  | decimal(5,2) | NO   |     | NULL    |                |

+-------------+--------------+------+-----+---------+----------------+

5 rows in set (0.01 sec)

</code>
