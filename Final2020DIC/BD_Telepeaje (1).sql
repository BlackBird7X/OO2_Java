CREATE DATABASE  IF NOT EXISTS `BD_Telepeaje` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BD_Telepeaje`;
-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: BD_Telepeaje
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `Abonado`
--

DROP TABLE IF EXISTS `Abonado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Abonado` (
  `idAbonado` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(25) NOT NULL,
  `nombres` varchar(25) NOT NULL,
  `dni` int NOT NULL,
  PRIMARY KEY (`idAbonado`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Abonado`
--

LOCK TABLES `Abonado` WRITE;
/*!40000 ALTER TABLE `Abonado` DISABLE KEYS */;
INSERT INTO `Abonado` VALUES (1,'Lopez','Juan',11111111),(2,'Rodriguez','Lara',22222222);
/*!40000 ALTER TABLE `Abonado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manual`
--

DROP TABLE IF EXISTS `Manual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Manual` (
  `idManual` int NOT NULL,
  `codCabina` varchar(5) NOT NULL,
  PRIMARY KEY (`idManual`),
  CONSTRAINT `fk_Manual_1` FOREIGN KEY (`idManual`) REFERENCES `Peaje` (`idPeaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manual`
--

LOCK TABLES `Manual` WRITE;
/*!40000 ALTER TABLE `Manual` DISABLE KEYS */;
INSERT INTO `Manual` VALUES (2,'A1B1C'),(5,'T2J7A'),(8,'A1B1C'),(11,'T2J7A');
/*!40000 ALTER TABLE `Manual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Peaje`
--

DROP TABLE IF EXISTS `Peaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Peaje` (
  `idPeaje` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `hora` varchar(45) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`idPeaje`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Peaje`
--

LOCK TABLES `Peaje` WRITE;
/*!40000 ALTER TABLE `Peaje` DISABLE KEYS */;
INSERT INTO `Peaje` VALUES (1,'2020-11-01','10:20:10',120),(2,'2020-11-01','10:20:15',80),(3,'2020-11-01','10:20:15',180),(4,'2020-11-01','19:20:18',120),(5,'2020-11-01','20:40:12',80),(6,'2020-11-01','21:20:15',180),(7,'2020-11-03','07:30:10',120),(8,'2020-11-03','11:25:15',80),(9,'2020-11-03','06:31:12',180),(10,'2020-11-03','20:32:15',120),(11,'2020-11-03','19:21:17',80),(12,'2020-11-03','22:32:11',180);
/*!40000 ALTER TABLE `Peaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rodado`
--

DROP TABLE IF EXISTS `Rodado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Rodado` (
  `idRodado` int NOT NULL AUTO_INCREMENT,
  `dominio` varchar(6) NOT NULL,
  `categoria` int NOT NULL,
  `idAbonado` int NOT NULL,
  PRIMARY KEY (`idRodado`),
  KEY `fk_Rodado_1_idx` (`idAbonado`),
  CONSTRAINT `fk_Rodado_1` FOREIGN KEY (`idAbonado`) REFERENCES `Abonado` (`idAbonado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rodado`
--

LOCK TABLES `Rodado` WRITE;
/*!40000 ALTER TABLE `Rodado` DISABLE KEYS */;
INSERT INTO `Rodado` VALUES (1,'AAA111',2,1),(2,'BBB222',3,2);
/*!40000 ALTER TABLE `Rodado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Telepeaje`
--

DROP TABLE IF EXISTS `Telepeaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Telepeaje` (
  `idTelepeaje` int NOT NULL,
  `lector` varchar(5) NOT NULL,
  `idRodado` int NOT NULL,
  PRIMARY KEY (`idTelepeaje`),
  KEY `fk_Manual_10_idx` (`idRodado`),
  CONSTRAINT `fk_Manual_10` FOREIGN KEY (`idRodado`) REFERENCES `Rodado` (`idRodado`),
  CONSTRAINT `fk_Telepeaje_1` FOREIGN KEY (`idTelepeaje`) REFERENCES `Peaje` (`idPeaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Telepeaje`
--

LOCK TABLES `Telepeaje` WRITE;
/*!40000 ALTER TABLE `Telepeaje` DISABLE KEYS */;
INSERT INTO `Telepeaje` VALUES (1,'43871',1),(3,'75881',2),(4,'43871',1),(6,'75881',2),(9,'75881',1),(10,'75881',2),(12,'43871',1);
/*!40000 ALTER TABLE `Telepeaje` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-28 18:02:42
