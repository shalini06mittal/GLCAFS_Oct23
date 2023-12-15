-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 15, 2023 at 03:01 PM
-- Server version: 5.7.34
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cat_id` int(11) NOT NULL,
  `cat_type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_type`) VALUES
(1, 'electronics'),
(2, 'books');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `cust_name` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `gst` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `cust_name`, `city`, `country`, `email`, `phone`, `gst`) VALUES
(1, 'Roy', 'Delhi', 'India', 'roya@test.com', '3636363636', NULL),
(2, 'Ronit', 'Delhi', 'India', 'ronit@techgatha.com', '1212121212', NULL),
(3, 'Sujoy', 'Pune', 'India', 'sujoy@test.com', '8787878787', NULL),
(4, 'Sam', 'Chicago', 'USA', 'sam@tehcl.com', '776765646465', NULL),
(5, 'Jack Ma', 'Singapore', 'Singapore', 'jack@test.com', '9898989898', NULL),
(6, 'Neil', 'San Francisco', 'USA', 'neil@techgatha.com', '9292929292', NULL),
(7, 'Prakash', 'London', 'UK', 'prakash@test.com', '9273645352', NULL),
(8, 'Ray', 'Mumbai', 'India', 'ray@gmail.com', '8585858585', NULL),
(9, 'Alexa', 'Mumbai', 'India', 'alexa@gmail.com', '9292929292', NULL),
(10, 'Chinki', 'Mumbai', 'China', 'chinki@gmail.com', '5454545454', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `item_id` char(10) NOT NULL,
  `item_name` varchar(50) DEFAULT NULL,
  `manufacturer` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `item_name`, `manufacturer`, `price`, `cat_id`) VALUES
('I001', 'Personal Computer', 'Apple', 35000, 1),
('I002', 'Personal Computer', 'Windows', 45000, 1),
('I003', 'Bluetooth', 'Bose', 15000, 1),
('I004', 'laptop', 'Apple', 55000, 1),
('I005', 'laptop', 'HP', 25000, 1),
('I006', 'Headphone', 'Sony', 20000, 1),
('I007', 'Wireless Mouse', 'Sony', 12000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `lineitem`
--

CREATE TABLE `lineitem` (
  `order_id` char(10) NOT NULL,
  `item_id` char(10) NOT NULL,
  `qty` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lineitem`
--

INSERT INTO `lineitem` (`order_id`, `item_id`, `qty`, `price`) VALUES
('O001', 'I001', 1, 35000),
('O001', 'I006', 1, 20000),
('O002', 'I003', 1, 15000),
('O002', 'I005', 1, 25000),
('O002', 'I006', 1, 20000),
('O003', 'I004', 1, 55000),
('O004', 'I002', 1, 45000),
('O004', 'I003', 2, 15000),
('O005', 'I003', 3, 15000),
('O005', 'I005', 2, 25000),
('O006', 'I001', 1, 35000),
('O006', 'I004', 1, 55000);

-- --------------------------------------------------------

--
-- Table structure for table `order_table`
--

CREATE TABLE `order_table` (
  `order_id` char(10) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `delivery_address` varchar(200) NOT NULL,
  `order_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `delivery_date` datetime DEFAULT NULL,
  `order_total` double NOT NULL DEFAULT '0',
  `order_tax` double DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_table`
--

INSERT INTO `order_table` (`order_id`, `customer_id`, `delivery_address`, `order_date`, `delivery_date`, `order_total`, `order_tax`, `STATUS`) VALUES
('O001', 1, 'street name charcoal, plot no 60, Nagpur-898989', '2021-03-07 21:42:38', '2021-03-09 00:00:00', 55000, NULL, 0),
('O002', 1, 'street no 1234, Saunflower APts, Delhi', '2021-03-07 21:53:50', '2021-03-14 19:30:00', 60000, NULL, 0),
('O003', 4, 'Islander Apartments, Chicago-898989', '2021-03-09 01:42:38', '2021-03-10 12:45:00', 55000, NULL, 0),
('O004', 4, 'Tousdale apts, NewYork, USA', '2021-04-09 21:42:38', '2021-05-10 09:00:00', 75000, NULL, 0),
('O005', 5, 'Indian Street, Singapore', '2021-03-12 05:10:10', '2021-03-15 05:00:00', 95000, NULL, 0),
('O006', 2, '93 neelkamal apartments, Mumbai-34333', '2021-03-08 12:12:38', '2021-03-10 09:00:00', 90000, NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `cat_id` (`cat_id`);

--
-- Indexes for table `lineitem`
--
ALTER TABLE `lineitem`
  ADD PRIMARY KEY (`order_id`,`item_id`);

--
-- Indexes for table `order_table`
--
ALTER TABLE `order_table`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`);

--
-- Constraints for table `lineitem`
--
ALTER TABLE `lineitem`
  ADD CONSTRAINT `lineitem_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_table` (`order_id`);

--
-- Constraints for table `order_table`
--
ALTER TABLE `order_table`
  ADD CONSTRAINT `order_table_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
