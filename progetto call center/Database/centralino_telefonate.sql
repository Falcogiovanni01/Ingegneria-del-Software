-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: centralino
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `telefonate`
--

DROP TABLE IF EXISTS `telefonate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonate` (
  `IdTelefonate` varchar(5) NOT NULL,
  `Data` date DEFAULT NULL,
  `Ora` time DEFAULT NULL,
  `Note` varchar(100) DEFAULT NULL,
  `Esito` varchar(45) DEFAULT NULL,
  `id_centralinista` varchar(5) DEFAULT NULL,
  `id_numero` char(10) DEFAULT NULL,
  PRIMARY KEY (`IdTelefonate`),
  KEY `id_numero_idx` (`id_numero`),
  KEY `id_centralinista_idx` (`id_centralinista`),
  CONSTRAINT `id_centralinista` FOREIGN KEY (`id_centralinista`) REFERENCES `centralinisti` (`IdCentralinista`),
  CONSTRAINT `id_numero` FOREIGN KEY (`id_numero`) REFERENCES `utenti` (`IdNumeroTelefonico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonate`
--

LOCK TABLES `telefonate` WRITE;
/*!40000 ALTER TABLE `telefonate` DISABLE KEYS */;
INSERT INTO `telefonate` VALUES ('',NULL,NULL,NULL,'',NULL,NULL),('002',NULL,NULL,'anche questa è andata','appuntamento fissato',NULL,NULL),('01',NULL,NULL,'forza non mollare','appuntamento fissato',NULL,NULL),('0909',NULL,NULL,'funziona anche dal boundary','fatto questo dal boundary . siamo forti',NULL,NULL),('10',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('11',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('1221',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('1234','2023-04-04','12:59:11','speriamo che me la cavo','appuntamento fissato','001','3207111839'),('20',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('2332',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('3',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('30',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('4',NULL,NULL,NULL,'occupato',NULL,NULL),('4114',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('5',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('5432',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('6',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('60',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL),('7777',NULL,NULL,NULL,'appuntamento fissato',NULL,NULL);
/*!40000 ALTER TABLE `telefonate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-15 18:15:19
