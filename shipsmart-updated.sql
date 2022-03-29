-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1


DROP DATABASE IF EXISTS SHIPSMART;
DROP USER 'saginaathikkal'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'saginaathikkal'@'localhost' IDENTIFIED BY 'saginaathikkalpass';

CREATE DATABASE SHIPSMART;
USE SHIPSMART;

CREATE TABLE `customer_sign_up` (
  `first_name` varchar(15) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `customer_email` varchar(50) NOT NULL,
  `customer_pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_checkout`
--

CREATE TABLE `form_checkout` (
  `delivery_date` date NOT NULL,
  `delivery_price` float NOT NULL,
  `promo_code` varchar(30),
  `total_amount` float NOT NULL,
  `credit_card` tinyint(1) NOT NULL,
  `debit_card` tinyint(1) NOT NULL,
  `paypal` tinyint(1) NOT NULL,
  `name_on_the_card` varchar(100) NOT NULL,
  `card_number` varchar(100) NOT NULL,
  `exp_date` varchar(16) NOT NULL,
  `cvv` int(3) NOT NULL,
  `order_id` int(10) NOT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_delivery_option`
--

CREATE TABLE `form_delivery_option` (
  `express_delivery_days` int(10) NOT NULL,
  `express_price` float NOT NULL,
  `recommended_delivery_days` int(10) NOT NULL,
  `recommended_price` float NOT NULL,
  `standard_delivery_days` int(10) NOT NULL,
  `standard_price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
insert into form_delivery_option(express_delivery_days,express_price,recommended_delivery_days,recommended_price,standard_delivery_days,standard_price) values(
2,25.0,4,15.0,7,10.0);
-- --------------------------------------------------------

--
-- Table structure for table `form_package`
--

CREATE TABLE `form_package` (
  `package_type` varchar(50) NOT NULL,
  `weight` float NOT NULL,
  `length` float NOT NULL,
  `width` float NOT NULL,
  `height` float NOT NULL,
  `declared_value` varchar(50),
  `signature` tinyint(1) NOT NULL,
  `email_notifications` tinyint(1) NOT NULL,
  `phone_notifications` tinyint(1) NOT NULL,
  `order_id` int(10) NOT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_promo_code`
--

CREATE TABLE `form_promo_code` (
  `promo_code` varchar(50) NOT NULL,
  `discount` float NOT NULL,
  `price_limit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO form_promo_code(promo_code,discount,price_limit) values ('ROYAL5',5,25);

-- --------------------------------------------------------

--
-- Table structure for table `form_schedule_pickup`
--

CREATE TABLE `form_schedule_pickup` (
  `pickup_date` date ,
  `pickup_time` varchar(20) ,
  `phone_number` varchar(30) ,
  `driver_instruction` varchar(200),
  `order_id` int(10) NOT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_ship_from`
--

CREATE TABLE `form_ship_from` (
  `full_name` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `street_address` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `zip_code` varchar(10) NOT NULL,
  `additional_details` varchar(200) NOT NULL,
  `order_id` varchar(10) NOT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `form_ship_to`
--

CREATE TABLE `form_ship_to` (
  `full_name` varchar(100) NOT NULL,
  `country` varchar(100) NOT NULL,
  `street_address` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(80) NOT NULL,
  `zip_code` varchar(10) NOT NULL,
  `additional_details` varchar(200) NOT NULL,
  `order_id` int(10) NOT NULL,
  PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `email_id` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sign_up`
--

CREATE TABLE `sign_up` (
  `first_name` varchar(15) NOT NULL,
  `last_name` varchar(15) NOT NULL,
  `employee_id` int(15) NOT NULL,
  `employee_email` varchar(50) NOT NULL,
  `employee_pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE signed_users (
   user_id INT NOT NULL AUTO_INCREMENT,
   first_name varchar(15) NOT NULL,
   last_name varchar(15) NOT NULL,
   email varchar(50) NOT NULL UNIQUE,
   password varchar(20) NOT NULL,
   is_admin VARCHAR(2) NOT NULL,
   created_date  DATETIME DEFAULT CURRENT_TIMESTAMP,
   updated_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE admin_users_extn (
   user_id INT NOT NULL,
   employee_id int(15) NOT NULL,
   created_date  DATETIME DEFAULT CURRENT_TIMESTAMP,
   updated_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (user_id)
   
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_order (
   order_id int(15) NOT NULL  AUTO_INCREMENT,
   user_id INT ,
   tracking varchar(200) NOT NULL,
   created_date  DATETIME DEFAULT CURRENT_TIMESTAMP,
   updated_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (order_id)
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tracking_order (

   tracking_order_id int(15) NOT NULL  AUTO_INCREMENT,
   tracking varchar(200) NOT NULL,
   order_id int(15) NOT NULL,
   ship_date date ,
   from_city varchar(200),
   to_city  varchar(200),
   status varchar(200),
   delivery_date date,
   comments varchar(200),
   is_completed tinyint(1) DEFAULT 0,
   created_date  DATETIME DEFAULT CURRENT_TIMESTAMP,
   updated_date DATETIME ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (tracking_order_id)
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `rate_calculation` (
  `from_zipcode` int(5) NOT NULL,
  `to_zipcode` int(5) NOT NULL,
  `price_per_lb` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rate_calculation`
--

INSERT INTO `rate_calculation` (`from_zipcode`, `to_zipcode`, `price_per_lb`) VALUES
(7111, 5661, 7),
(11234, 11445, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer_sign_up`
--

ALTER TABLE `customer_sign_up`
  ADD PRIMARY KEY (`customer_email`),
  ADD UNIQUE KEY `customer_email` (`customer_email`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `email_id` (`email_id`);

--
-- Indexes for table `sign_up`
--
ALTER TABLE `sign_up`
  ADD PRIMARY KEY (`employee_id`);

GRANT SELECT, INSERT, UPDATE, DELETE
ON *
TO super@localhost
IDENTIFIED BY 'super';

