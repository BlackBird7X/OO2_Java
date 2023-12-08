CREATE DATABASE  IF NOT EXISTS `bd_vacunas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_vacunas`;
-- MySQL dump 10.13  Distrib 8.0.24, for Linux (x86_64)
--
-- Host: localhost    Database: bd_vacunas
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `Dosis`
--

DROP TABLE IF EXISTS `Dosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Dosis` (
  `idDosis` int NOT NULL AUTO_INCREMENT,
  `vacunatorio` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `idVacuna` int DEFAULT NULL,
  `idPersona` int DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`idDosis`),
  KEY `fk_Dosis_1_idx` (`idVacuna`),
  KEY `fk_Dosis_2_idx` (`idPersona`),
  CONSTRAINT `fk_Dosis_1` FOREIGN KEY (`idVacuna`) REFERENCES `Vacuna` (`idVacuna`),
  CONSTRAINT `fk_Dosis_2` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dosis`
--

LOCK TABLES `Dosis` WRITE;
/*!40000 ALTER TABLE `Dosis` DISABLE KEYS */;
INSERT INTO `Dosis` VALUES (1,'UNLa','2020-05-01',1,1,'15:00:00'),(2,'UNLa','2020-06-01',2,1,'16:00:00'),(3,'UNLa','2020-06-15',1,2,'11:00:00'),(4,'UNLa','2020-06-15',4,3,'11:15:00'),(5,'UNLa','2020-06-15',5,4,'11:30:00'),(6,'UNLa','2020-06-15',6,5,'11:45:00'),(7,'UNLa','2020-05-01',2,2,'15:30:00');
/*!40000 ALTER TABLE `Dosis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Persona` (
  `idPersona` int NOT NULL,
  `documento` int DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `tieneComorbilidad` tinyint DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,11111111,'2000-01-01 00:00:00',1),(2,22222222,'1990-01-10 00:00:00',0),(3,33333333,'1995-03-30 00:00:00',0),(4,44444444,'1985-05-20 00:00:00',1),(5,55555555,'1989-06-10 00:00:00',0);
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vacuna`
--

DROP TABLE IF EXISTS `Vacuna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vacuna` (
  `idVacuna` int NOT NULL,
  `codigo` int DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `fechaElaboracion` datetime DEFAULT NULL,
  PRIMARY KEY (`idVacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vacuna`
--

LOCK TABLES `Vacuna` WRITE;
/*!40000 ALTER TABLE `Vacuna` DISABLE KEYS */;
INSERT INTO `Vacuna` VALUES (1,800009,'Sputnik V','2020-03-01 00:00:00'),(2,800011,'Sputnik V','2020-03-10 00:00:00'),(3,800013,'Sputnik V','2020-03-20 00:00:00'),(4,901001,'AstraZeneca','2020-05-01 00:00:00'),(5,901003,'AstraZeneca','2020-05-11 00:00:00'),(6,901005,'AstraZeneca','2020-05-21 00:00:00');
/*!40000 ALTER TABLE `Vacuna` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-09 17:23:48
