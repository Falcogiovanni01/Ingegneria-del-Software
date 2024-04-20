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
-- Table structure for table `appuntamenti`
--

DROP TABLE IF EXISTS `appuntamenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appuntamenti` (
  `IdAppuntamento` varchar(5) NOT NULL,
  `Data` date DEFAULT NULL,
  `Ora` time DEFAULT NULL,
  `Note` varchar(100) DEFAULT NULL,
  `CodiceFiscale` char(16) DEFAULT NULL,
  `IdTelefonata` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`IdAppuntamento`),
  KEY `CodiceFiscale_idx` (`CodiceFiscale`),
  KEY `IdTelefonata_idx` (`IdTelefonata`),
  CONSTRAINT `CodiceFiscale` FOREIGN KEY (`CodiceFiscale`) REFERENCES `agentivendita` (`IdCodiceFiscale`),
  CONSTRAINT `IdTelefonata` FOREIGN KEY (`IdTelefonata`) REFERENCES `telefonate` (`IdTelefonate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuntamenti`
--

LOCK TABLES `appuntamenti` WRITE;
/*!40000 ALTER TABLE `appuntamenti` DISABLE KEYS */;
INSERT INTO `appuntamenti` VALUES ('0808','2023-06-29','11:11:11','or è finita','FLFLFFFFF1233FSA','0909'),('1','2023-04-07','09:15:00','sono riuscito a modificarlo dal controller ','FLFLFFFFF1233FSA','1234'),('10','2023-06-13','12:11:10','è andata','FLFLFZZZF1233FAA','11'),('1441','2023-06-11','16:22:22','modifico note ','FLFLFFFFF1233FSA','4114'),('2','2023-06-13','14:00:00','ora funziona anche la grafica','FLFLFZZZF1233FAA','3'),('2023','2023-06-11','16:30:00','in centralinista funziona','FLFLFFFFF1233FSA','7777'),('2024','2023-06-11','16:30:00','voila','FLFLFFFFF1233FSA','10'),('2025','2023-06-11','16:30:00','voila','FLFLFFFFF1233FSA','10'),('2026','2023-06-11','13:22:00','forse va','FLFLFZZZF1233FAA','7777'),('2027','2023-06-06','13:22:00','forse va','FLFLFZZZF1233FAA','7777'),('2028','2023-06-10','12:12:00','va bene','FLFLFZZZF1233FAA','7777'),('2112','2023-06-11','16:22:22','sssss','FLFLFFFFF1233FSA','1221'),('3232','2023-10-23','16:22:22','sssss','FLFLFFFFF1233FSA','2332'),('4','2023-07-11','16:53:20','hola','FLFLFFFFF1233FSA','30'),('5','2023-06-14','14:20:20','hshshs','FLFLFFFFF1233FSA','6'),('6','2024-01-10','16:53:30','jjj','FLFLFFFFF1233FSA','20'),('6767','2023-06-12','11:11:11','jddjdjdj','FLFLFFFFF1233FSA','7777'),('8','2023-06-11','16:30:00','anche la grafica funziona urra!!','FLFLFFFFF1233FSA','7777'),('8811','2023-06-11','16:30:00','voila','FLFLFFFFF1233FSA','10'),('8881','2023-06-11','16:30:00','voila','FLFLFFFFF1233FSA','7777');
/*!40000 ALTER TABLE `appuntamenti` ENABLE KEYS */;
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
