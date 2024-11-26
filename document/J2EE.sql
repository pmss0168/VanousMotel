CREATE DATABASE  IF NOT EXISTS `project_j2ee` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `project_j2ee`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: project_j2ee
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id_booking` int NOT NULL AUTO_INCREMENT,
  `user_booking` varchar(20) NOT NULL,
  `room` int NOT NULL,
  `check_in` date NOT NULL,
  `check_out` date NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `isCancel` tinyint NOT NULL DEFAULT '0',
  `isSuccess` tinyint NOT NULL DEFAULT '0',
  `isConfirm` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_booking`),
  KEY `fk_user_idx` (`user_booking`),
  KEY `fk_room_idx` (`room`),
  CONSTRAINT `fk_room` FOREIGN KEY (`room`) REFERENCES `room` (`room_number`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_booking`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (2,'pmss0168',104,'2024-03-19','2024-03-20',200000.00,0,1,0),(6,'tinnguyen',101,'2024-03-18','2024-03-19',200000.00,0,1,0),(7,'pmss0168',103,'2024-03-20','2024-03-21',200000.00,1,0,0),(8,'pmss0168',102,'2024-03-18','2024-03-21',600000.00,1,0,0),(9,'pmss0168',101,'2024-03-20','2024-03-22',400000.00,1,0,0),(10,'pmss0168',101,'2024-03-20','2024-03-21',200000.00,1,0,0),(12,'pmss0168',104,'2024-03-21','2024-03-21',200000.00,0,1,0),(13,'pmss0168',113,'2024-03-21','2024-03-24',800000.00,0,1,0),(14,'pmss0168',113,'2024-03-22','2024-03-22',200000.00,1,0,0),(15,'pmss0168',113,'2024-03-22','2024-03-22',200000.00,1,0,0),(16,'vinhnguyen',109,'2024-03-22','2024-03-24',1500000.00,0,1,0),(17,'tinnguyen',108,'2024-03-22','2024-03-22',500000.00,0,1,0),(18,'pmss0168',201,'2024-03-23','2024-03-26',2400000.00,1,0,0),(19,'pmss0168',204,'2024-03-25','2024-03-28',2400000.00,1,0,0),(20,'staff',101,'2024-03-25','2024-03-25',200000.00,1,0,0),(21,'staff',102,'2024-03-27','2024-03-28',400000.00,1,0,0),(22,'vinhnguyen',109,'2024-03-26','2024-03-31',3000000.00,0,1,0),(23,'tinnguyen',108,'2024-03-26','2024-03-27',1000000.00,0,1,0),(24,'teohandsome',106,'2024-03-26','2024-03-27',700000.00,1,0,0),(25,'teohandsome',101,'2024-03-25','2024-03-25',200000.00,0,1,0),(35,'teohandsome',101,'2024-03-28','2024-03-28',200000.00,1,0,0),(36,'teohandsome',105,'2024-03-26','2024-03-30',1750000.00,0,1,0),(37,'pmss0168',101,'2024-03-27','2024-03-29',600000.00,1,0,0),(38,'pmss0168',101,'2024-03-31','2024-04-03',800000.00,0,1,0),(39,'staff',102,'2024-03-31','2024-03-31',200000.00,1,0,0),(40,'staff',102,'2024-03-30','2024-03-31',400000.00,1,0,0),(41,'pmss0168',101,'2024-04-14','2024-04-14',200000.00,1,0,0),(42,'pmss0168',101,'2024-04-24','2024-04-26',600000.00,0,1,0),(43,'pmss0168',108,'2024-04-29','2024-05-01',1500000.00,0,1,0),(44,'tinnguyen',108,'2024-05-04','2024-05-04',500000.00,1,0,0),(45,'thienho',104,'2024-05-04','2024-05-04',200000.00,0,1,0);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_room`
--

DROP TABLE IF EXISTS `category_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_room` (
  `id_category` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) NOT NULL,
  `price_per_day` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_room`
--

LOCK TABLES `category_room` WRITE;
/*!40000 ALTER TABLE `category_room` DISABLE KEYS */;
INSERT INTO `category_room` VALUES (1,'Phòng Đơn',200000.00),(2,'Phòng Đôi',350000.00),(3,'Phòng VIP',500000.00),(4,'Phòng Chill',600000.00),(6,'Phòng View Biển',1000000.00);
/*!40000 ALTER TABLE `category_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `room_number` int NOT NULL,
  `status` tinyint NOT NULL DEFAULT '0',
  `category` int NOT NULL,
  PRIMARY KEY (`room_number`),
  KEY `fk_category_idx` (`category`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category`) REFERENCES `category_room` (`id_category`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (101,0,1),(102,0,1),(103,0,1),(104,0,1),(105,0,2),(106,0,2),(107,0,2),(108,0,3),(109,0,3),(110,0,2),(111,0,2),(112,0,2),(113,0,1),(114,0,1),(115,0,1),(116,0,1),(201,0,4),(202,0,4),(203,0,4),(204,0,4),(301,0,6);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `isAdmin` tinyint NOT NULL DEFAULT '0',
  `isStaff` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','administrator','Nguyễn Văn Admin','0942668888',1,0),('pmss0168','sang12345','Phạm Minh Sáng','0912016800',0,0),('staff','staff1234','Phạm Minh Staff','0883883888',0,1),('teohandsome','teohandsome','Nguyễn Anh Tèo','0902030464',0,0),('thienho','thien12345','Hồ Hoàng Thiện','0999999999',0,0),('tinnguyen','tinnguyen1234','Nguyễn Trung Tín','0912112333',0,0),('vinhnguyen','vinh1234','Nguyễn Quang Vinh','0803012345',0,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02 22:02:54
