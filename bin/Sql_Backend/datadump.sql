-- MySQL dump 10.13  Distrib 5.6.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bankofpune
-- ------------------------------------------------------
-- Server version       5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bankaccounts`
--

DROP TABLE IF EXISTS `bankaccounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bankaccounts` (
  `CustomerID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Address` text NOT NULL,
  `DOB` date DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `upi_id` varchar(50) DEFAULT NULL,
  `IFSC_code` varchar(50) DEFAULT NULL,
  `account_type` varchar(50) DEFAULT NULL,
  `account_balance` decimal(10,2) DEFAULT '0.00',
  `account_number` bigint(200) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankaccounts`
--

LOCK TABLES `bankaccounts` WRITE;
/*!40000 ALTER TABLE `bankaccounts` DISABLE KEYS */;
INSERT INTO `bankaccounts` VALUES (1,'ds','ad','a','a','2024-03-08','a','123','BPUN0123456.1234567891@example.com','BPUN0123456','Savings',4600.00,1234567891),(2,'d','d','dd','dd','2024-03-01','d','123','BPUN0123456.1234567892@example.com','BPUN0123456','Savings',30.00,1234567892),(3,'Chinmay','Ingale','9145097166','Chintamani Nagar','2003-12-04','chinmay','12345','BPUN0123456.1234567893@example.com','BPUN0123456','Savings',11500.00,1234567893);
/*!40000 ALTER TABLE `bankaccounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doorstep_banking`
--

DROP TABLE IF EXISTS `doorstep_banking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `doorstep_banking` (
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `address` text,
  `email_id` varchar(255) DEFAULT NULL,
  `DOB` varchar(60) DEFAULT NULL,
  `Phone_No` varchar(20) DEFAULT NULL,
  `Aadhar_no` varchar(20) DEFAULT NULL,
  `Pan_No` varchar(20) DEFAULT NULL,
  `date_for_appointment` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doorstep_banking`
--

LOCK TABLES `doorstep_banking` WRITE;
/*!40000 ALTER TABLE `doorstep_banking` DISABLE KEYS */;
INSERT INTO `doorstep_banking` VALUES ('Chinmay','Male','Chintamani Nagar','chinmay@gmail.com','2003-12-04','9145097166','123456789','123456789','2024-03-24'),('Chinmay','Male','Chintamani Nagar','chinmay@gmail.com','2003-12-04','9145097166','123456789','123456789','2024-03-24'),('a','Male','s','s','2024-03-01','s','s','s','2024-03-20');
/*!40000 ALTER TABLE `doorstep_banking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactions` (
  `serial_no` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `transaction_type` varchar(20) NOT NULL,
  `date` date DEFAULT NULL,
  `account_number` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,1000.00,'Deposit','2024-03-19',1234567891),(2,1000.00,'Withdrawal','2024-03-20',1234567893),(3,-1000.00,'Withdrawal','2024-03-20',1234567893),(4,1000.00,'Deposit','2024-03-20',1234567891),(5,500.00,'Money transfer','2024-03-20',1234567893),(6,500.00,'Money transfer','2024-03-20',1234567891),(7,10.00,'Deposit','2024-03-21',1234567891),(8,5.00,'Deposit','2024-03-21',1234567891),(9,2.00,'Deposit','2024-03-21',1234567891),(10,2.00,'Deposit','2024-03-21',1234567891),(11,11.00,'Deposit','2024-03-21',1234567891),(12,1000.00,'Money transfer','2024-03-21',1234567891),(13,1000.00,'Money transfer','2024-03-21',1234567893),(14,1000.00,'Money transfer','2024-03-21',1234567891),(15,1000.00,'Money transfer','2024-03-21',1234567893),(16,1000.00,'Deposit','2024-03-21',1234567891),(17,1000.00,'Deposit','2024-03-21',1234567891),(18,1000.00,'Deposit','2024-03-21',1234567891),(19,1000.00,'Money transfer','2024-03-21',1234567891),(20,1000.00,'Money transfer','2024-03-21',1234567893),(21,5.00,'Deposit','2024-03-22',1234567891),(22,1000.00,'Deposit','2024-03-22',1234567893);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `with_depo`
--

DROP TABLE IF EXISTS `with_depo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `with_depo` (
  `account_num` int(11) DEFAULT NULL,
  `transaction_amount` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `with_depo`
--

LOCK TABLES `with_depo` WRITE;
/*!40000 ALTER TABLE `with_depo` DISABLE KEYS */;
/*!40000 ALTER TABLE `with_depo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-23 20:14:54