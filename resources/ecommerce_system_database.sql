-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 20, 2023 at 10:32 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce_system`
--
DROP DATABASE IF EXISTS `ecommerce_system`;
CREATE DATABASE IF NOT EXISTS `ecommerce_system` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ecommerce_system`;

-- --------------------------------------------------------

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE IF NOT EXISTS `cart_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` decimal(10,0) DEFAULT NULL,
  `shopping_session_id` int(10) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `modify_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cart_item_and_product` (`product_id`),
  KEY `fk_cart_item_and_shopping_session` (`shopping_session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `discount`
--

DROP TABLE IF EXISTS `discount`;
CREATE TABLE IF NOT EXISTS `discount` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `discount_percent` int(11) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `modify_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `discount`
--

INSERT INTO `discount` (`id`, `name`, `description`, `discount_percent`, `active`, `create_at`, `modify_at`) VALUES
(1, 'sale', NULL, 0, b'0', '2023-09-19 21:27:50.000000', NULL),
(2, NULL, NULL, 10, b'0', '2023-09-19 21:28:38.000000', NULL),
(3, NULL, NULL, 5, b'0', '2023-09-19 21:28:54.000000', NULL),
(4, NULL, NULL, 5, b'0', '2023-09-19 21:29:23.000000', NULL),
(5, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL),
(6, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL),
(7, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL),
(8, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL),
(9, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL),
(10, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL),
(11, NULL, NULL, 5, b'0', '2023-09-19 21:29:38.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
CREATE TABLE IF NOT EXISTS `order_details` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `total` decimal(10,0) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `modify_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_details_and_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE IF NOT EXISTS `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` decimal(10,0) DEFAULT NULL,
  `order_id` int(10) DEFAULT NULL,
  `product_id` int(10) DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `modify_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_item_and_order_details` (`order_id`),
  KEY `fk_order_item_and_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `outstanding`
--

DROP TABLE IF EXISTS `outstanding`;
CREATE TABLE IF NOT EXISTS `outstanding` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `meta` varchar(100) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `hide` bit(2) DEFAULT b'0',
  `product_category_id` int(10) DEFAULT NULL,
  `product_inventory_id` int(5) DEFAULT NULL,
  `discount_id` int(5) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `modify_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_and_discount_id` (`discount_id`),
  KEY `fk_product_and_product_categoy_id` (`product_category_id`),
  KEY `fk_product_and_product_inventory_id` (`product_inventory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `price`, `image`, `hide`, `product_category_id`, `product_inventory_id`, `discount_id`, `create_at`, `modify_at`) VALUES
(1, 'iPhone X', NULL, 1000, '1.png', b'00', 2, 1, 1, '2023-09-20 15:02:04.000000', NULL),
(2, 'iPhone 12 (64GB)', NULL, 15000000, '2.png', b'00', 2, 2, 2, '2023-09-20 15:02:04.000000', NULL),
(3, 'Điện thoại Tecno POVA 5', NULL, 3900000, '3.png', b'00', 2, 6, 3, '2023-09-20 15:02:04.000000', NULL),
(4, 'TPCN NattoEnzym Red Rice hỗ trợ giảm cholesterol, giảm nguy cơ tắc mạnh đột quỵ 1 chai x 60 viên - C', NULL, 485000, '4.png', b'00', 11, 7, 4, '2023-09-20 15:02:04.000000', NULL),
(5, 'TPCN NattoEnzym Red Rice hỗ trợ giảm cholesterol, giảm nguy cơ tắc mạnh đột quỵ 1 chai x 60 viên - Chính hãng DHG Pharma', NULL, 485000, '7.png', b'00', 11, 7, 5, '2023-09-20 15:02:04.000000', NULL),
(6, 'TPCN NattoEnzym Red Rice hỗ trợ giảm cholesterol, giảm nguy cơ tắc mạnh đột quỵ 1 chai x 60 viên - Chính hãng DHG Pharma', NULL, 228000, '5.png', b'00', 14, 8, 6, '2023-09-20 15:02:04.000000', NULL),
(7, 'Collagen uống ALFE Beauty Conc hỗ trợ tăng đàn hồi da, giúp da sáng đẹp mịn màng Hộp 10 chai x 50ml - Chính hãng DHG Pharma', NULL, 659000, '6.png', b'00', 14, 9, 7, '2023-09-20 15:02:04.000000', NULL),
(8, 'Cà phê G7 3in1 - Bịch 100 sticks 16gr ( gói dài)', NULL, 249000, '10.png', b'00', 11, 10, 8, '2023-09-20 15:02:04.000000', NULL),
(9, 'Cà phê hòa tan G7 3in1 - Bịch 50 sachets 16gr', NULL, 134000, '11.png', b'00', 11, 11, 9, '2023-09-20 15:02:04.000000', NULL),
(10, 'Bình Giữ Nhiệt Lock&Lock Energetic One-Touch Tumbler LHC3249 - 550ML', NULL, 256000, '12.png', b'00', 11, 12, 10, '2023-09-20 15:02:04.000000', NULL),
(11, 'Máy Xay Sinh Tố Đa Năng Sunhouse HappyTime HTD5113G (Xanh) 350W - Hàng chính hãng', NULL, 386000, '13.png', b'00', 11, 13, 11, '2023-09-20 15:02:04.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

DROP TABLE IF EXISTS `product_category`;
CREATE TABLE IF NOT EXISTS `product_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `modify_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`id`, `name`, `description`, `create_at`, `modify_at`) VALUES
(1, 'Đồ chơi - Mẹ và bé', NULL, '2023-09-19 14:49:41.000000', NULL),
(2, 'Điện thoại - Máy tính bảng', NULL, '2023-09-19 14:50:48.000000', NULL),
(3, 'Làm đẹp - Sức khỏe', NULL, '2023-09-19 14:50:48.000000', NULL),
(4, 'Thời trang nam', NULL, '2023-09-19 14:50:48.000000', NULL),
(5, 'Thời trang nũ', NULL, '2023-09-19 14:50:48.000000', NULL),
(6, 'Giày dép nữ', NULL, '2023-09-19 14:51:38.000000', NULL),
(7, 'Giày dép nam', NULL, '2023-09-19 14:51:38.000000', NULL),
(8, 'Túi thời trang nam', NULL, '2023-09-19 14:51:38.000000', NULL),
(9, 'Túi thời trang nữ', NULL, '2023-09-19 14:51:38.000000', NULL),
(10, 'Sách', NULL, '2023-09-19 14:52:49.000000', NULL),
(11, 'Bách hóa', NULL, '2023-09-19 14:52:49.000000', NULL),
(12, 'Điện tử - Điênh lạnh', NULL, '2023-09-19 14:52:49.000000', NULL),
(13, 'Thể thao', NULL, '2023-09-19 14:52:49.000000', NULL),
(14, 'Thực phẩm chức năng', NULL, '2023-09-19 21:10:31.000000', NULL),
(15, 'Thực phẩm', NULL, '2023-09-19 21:14:39.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product_images`
--

DROP TABLE IF EXISTS `product_images`;
CREATE TABLE IF NOT EXISTS `product_images` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `modify_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_images_id_and_product_id` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_inventory`
--

DROP TABLE IF EXISTS `product_inventory`;
CREATE TABLE IF NOT EXISTS `product_inventory` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `quantity` int(10) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `modify_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product_inventory`
--

INSERT INTO `product_inventory` (`id`, `quantity`, `color`, `details`, `description`, `create_at`, `modify_at`) VALUES
(1, 10, 'Black', NULL, NULL, '2023-09-19 21:00:46.000000', NULL),
(2, 10, 'White', NULL, NULL, '2023-09-19 21:01:13.000000', NULL),
(3, 10, 'Red', NULL, NULL, '2023-09-19 21:02:00.000000', NULL),
(4, 5, 'Black', NULL, NULL, '2023-09-19 21:02:00.000000', NULL),
(5, 20, 'Pink', NULL, NULL, '2023-09-19 21:02:00.000000', NULL),
(6, 10, 'Blue', NULL, NULL, '2023-09-19 21:02:00.000000', NULL),
(7, 50, NULL, NULL, NULL, '2023-09-19 21:07:10.000000', NULL),
(8, 16, NULL, NULL, NULL, '2023-09-19 21:11:54.000000', NULL),
(9, 20, NULL, NULL, NULL, '2023-09-19 21:13:20.000000', NULL),
(10, 20, NULL, NULL, NULL, '2023-09-19 21:16:45.000000', NULL),
(11, 30, NULL, NULL, NULL, '2023-09-19 21:23:26.000000', NULL),
(12, 5, NULL, NULL, NULL, '2023-09-19 21:25:19.000000', NULL),
(13, 20, NULL, NULL, NULL, '2023-09-19 21:26:06.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'USER'),
(2, 'CREATOR'),
(3, 'EDITOR'),
(4, 'ADMIN'),
(5, 'MANAGER');

-- --------------------------------------------------------

--
-- Table structure for table `shopping_session`
--

DROP TABLE IF EXISTS `shopping_session`;
CREATE TABLE IF NOT EXISTS `shopping_session` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `total` decimal(10,0) DEFAULT NULL,
  `create_at` datetime DEFAULT current_timestamp(),
  `modify_at` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shopping_session_and_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT 1,
  `create_at` datetime(6) DEFAULT NULL,
  `modify_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=517 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`, `telephone`, `avatar`, `enabled`, `create_at`, `modify_at`) VALUES
(1, 'tanhung@gmail.com', 'Hung', 'Tran', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', '0707206345', NULL, 1, '2023-09-19 14:46:04.000000', '2023-09-19 14:46:04.000000'),
(3, 'user1@gmail.com', 'Anh', 'Nguyen Hoang', '$2a$10$xiJ/ws6isCmukEPr9zPqke0XooKfaHYFccT0iPRmUIoSMim1nSnPC', '0707123666', NULL, 1, '2023-09-20 09:21:55.000000', NULL),
(52, 'user2@gmail.com', NULL, NULL, '$2a$10$HL6GRQY0y5CECSjmc45Gqe4dkPKWSaps1YURfyEVIXD/rFFcahcgS', NULL, NULL, 1, '2023-09-19 17:41:38.000000', NULL),
(252, 'admin@gmail.com', NULL, NULL, '$2a$10$der98aK88tdxYkNDKHLAhuKJ0lVJZt4GMFPzxKV/QJOY9mysiBrPO', NULL, NULL, 1, '2023-09-20 09:50:21.000000', NULL),
(515, 'user7@gmail.com', NULL, NULL, '$2a$10$aiXS8CGb73VYmBcYMNIAJ./Ri6CDxZmtZBcAhPuMhK9UdioErmtdS', NULL, NULL, 1, '2023-09-20 11:12:29.000000', NULL),
(516, 'user3@gmail.com', NULL, NULL, '$2a$10$FUeUvNEyiNtMphXA4jx.U.4J0L4CPzsql0MFz0C6qp5Kpp4iXv8ia', NULL, NULL, 1, '2023-09-20 11:16:14.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE IF NOT EXISTS `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `role_fk` (`role_id`),
  KEY `user_fk` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`, `id`) VALUES
(1, 1, 1),
(1, 4, 2),
(515, 1, 3),
(516, 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
CREATE TABLE IF NOT EXISTS `user_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_line` varchar(30) DEFAULT NULL,
  `district` varchar(20) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `country` varchar(30) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_and_user_address` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_payment`
--

DROP TABLE IF EXISTS `user_payment`;
CREATE TABLE IF NOT EXISTS `user_payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(20) DEFAULT NULL,
  `provider` varchar(20) DEFAULT NULL,
  `account_number` varchar(20) DEFAULT NULL,
  `expiry` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_payment_and_users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart_item`
--
ALTER TABLE `cart_item`
  ADD CONSTRAINT `fk_cart_item_and_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `fk_cart_item_and_shopping_session` FOREIGN KEY (`shopping_session_id`) REFERENCES `shopping_session` (`id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `fk_order_details_and_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `fk_order_item_and_order_details` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`id`),
  ADD CONSTRAINT `fk_order_item_and_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `fk_product_and_discount_id` FOREIGN KEY (`discount_id`) REFERENCES `discount` (`id`),
  ADD CONSTRAINT `fk_product_and_product_categoy_id` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`),
  ADD CONSTRAINT `fk_product_and_product_inventory_id` FOREIGN KEY (`product_inventory_id`) REFERENCES `product_inventory` (`id`);

--
-- Constraints for table `product_images`
--
ALTER TABLE `product_images`
  ADD CONSTRAINT `fk_product_images_id_and_product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `shopping_session`
--
ALTER TABLE `shopping_session`
  ADD CONSTRAINT `fk_shopping_session_and_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_address`
--
ALTER TABLE `user_address`
  ADD CONSTRAINT `fk_user_id_and_user_address` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `user_payment`
--
ALTER TABLE `user_payment`
  ADD CONSTRAINT `fk_user_payment_and_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
