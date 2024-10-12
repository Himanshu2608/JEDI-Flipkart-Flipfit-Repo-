-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (arm64)
--
-- Host: localhost    Database: FlipFitSchema
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Booking`
--

DROP TABLE IF EXISTS `Booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Booking` (
  `bookingID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `slotTime` int NOT NULL,
  `slotID` int NOT NULL,
  `isDeleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`bookingID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Booking`
--

LOCK TABLES `Booking` WRITE;
/*!40000 ALTER TABLE `Booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `Booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customer` (
  `customerID` int NOT NULL,
  `city` varchar(255) NOT NULL,
  `pincode` varchar(45) NOT NULL,
  PRIMARY KEY (`customerID`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GymAdmin`
--

DROP TABLE IF EXISTS `GymAdmin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GymAdmin` (
  `adminID` int NOT NULL AUTO_INCREMENT,
  `emailID` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GymAdmin`
--

LOCK TABLES `GymAdmin` WRITE;
/*!40000 ALTER TABLE `GymAdmin` DISABLE KEYS */;
INSERT INTO `GymAdmin` VALUES (1,'admin1@flipfit.com','12345678');
/*!40000 ALTER TABLE `GymAdmin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GymCentre`
--

DROP TABLE IF EXISTS `GymCentre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GymCentre` (
  `centreID` int NOT NULL AUTO_INCREMENT,
  `ownerID` int NOT NULL,
  `capacity` int NOT NULL,
  `approved` tinyint(1) NOT NULL,
  `city` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  `pincode` varchar(45) NOT NULL,
  PRIMARY KEY (`centreID`),
  KEY `ownerID` (`ownerID`),
  CONSTRAINT `gymcentre_ibfk_1` FOREIGN KEY (`ownerID`) REFERENCES `GymOwner` (`ownerID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GymCentre`
--

LOCK TABLES `GymCentre` WRITE;
/*!40000 ALTER TABLE `GymCentre` DISABLE KEYS */;
INSERT INTO `GymCentre` VALUES (1,103,3,1,'Warangal','Telangana','506001');
/*!40000 ALTER TABLE `GymCentre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GymOwner`
--

DROP TABLE IF EXISTS `GymOwner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `GymOwner` (
  `ownerID` int NOT NULL,
  `PAN` varchar(255) NOT NULL,
  `Aadhar` varchar(255) NOT NULL,
  `GSTIN` varchar(255) NOT NULL,
  `approved` tinyint(1) NOT NULL,
  PRIMARY KEY (`ownerID`),
  CONSTRAINT `gymowner_ibfk_1` FOREIGN KEY (`ownerID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GymOwner`
--

LOCK TABLES `GymOwner` WRITE;
/*!40000 ALTER TABLE `GymOwner` DISABLE KEYS */;
INSERT INTO `GymOwner` VALUES (103,'QWE!@#$%QW','123456781234','1234512345',0);
/*!40000 ALTER TABLE `GymOwner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payments`
--

DROP TABLE IF EXISTS `Payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payments` (
  `paymentID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `paymentType` int NOT NULL,
  `paymentInfo` varchar(255) NOT NULL,
  PRIMARY KEY (`paymentID`),
  KEY `userID` (`userID`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `Customer` (`customerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payments`
--

LOCK TABLES `Payments` WRITE;
/*!40000 ALTER TABLE `Payments` DISABLE KEYS */;
/*!40000 ALTER TABLE `Payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `roleID` int NOT NULL,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (0,'Customer'),(1,'GymOwner'),(2,'Admin');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Slots`
--

DROP TABLE IF EXISTS `Slots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Slots` (
  `slotID` int NOT NULL AUTO_INCREMENT,
  `centreID` int NOT NULL,
  `seatsAvailable` int NOT NULL,
  `slotTime` int NOT NULL,
  PRIMARY KEY (`slotID`),
  KEY `centreID` (`centreID`),
  CONSTRAINT `slots_ibfk_1` FOREIGN KEY (`centreID`) REFERENCES `GymCentre` (`centreID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Slots`
--

LOCK TABLES `Slots` WRITE;
/*!40000 ALTER TABLE `Slots` DISABLE KEYS */;
/*!40000 ALTER TABLE `Slots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `roleID` int DEFAULT NULL,
  `emailID` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `user_ibfk_1_idx` (`roleID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleID`) REFERENCES `Role` (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (101,'Praneeth',1,'xyz@gmail.com','9876543210','Qwerty123456'),(102,'xyz',0,'xyz@gmail.com','9876543210','Qwerty123456'),(103,'qwe',1,'qwe@gmail.com','1234567890','Qwery123456');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-13  0:53:33
