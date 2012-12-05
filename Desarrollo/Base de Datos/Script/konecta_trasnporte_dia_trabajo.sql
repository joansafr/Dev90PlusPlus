CREATE DATABASE  IF NOT EXISTS `konecta` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `konecta`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: konecta
-- ------------------------------------------------------
-- Server version	5.5.19

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
-- Table structure for table `trasnporte_dia_trabajo`
--

DROP TABLE IF EXISTS `trasnporte_dia_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trasnporte_dia_trabajo` (
  `id_tipo_vehiculo` varchar(50) DEFAULT NULL,
  `id_causa_demora` int(11) DEFAULT NULL,
  `transporte_dia_trabajo_cantidad_personas` int(11) DEFAULT NULL,
  `transporte_dia_trabajo_nro_vale` varchar(20) DEFAULT NULL,
  `transporte_dia_trabajo_placa` varchar(7) DEFAULT NULL,
  `id_transporte_dia_trabajo` bigint(20) NOT NULL AUTO_INCREMENT,
  `transporte_dia_trabajo_observaciones` varchar(500) DEFAULT NULL,
  `transporte_dia_trabajo_fecha` date DEFAULT NULL,
  `transporte_dia_trabajo_tardanza` time DEFAULT NULL,
  `transporte_dia_trabajo_costo_total` decimal(7,3) DEFAULT NULL,
  `transporte_dia_trabajo_costo_por_persona` decimal(7,3) DEFAULT NULL,
  `padron` varchar(500) DEFAULT NULL,
  `id_sector` varchar(50) DEFAULT NULL,
  `id_hora_ingreso` time DEFAULT NULL,
  `id_proveedor` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_transporte_dia_trabajo`),
  KEY `R_14` (`id_tipo_vehiculo`),
  KEY `R_15` (`id_causa_demora`),
  KEY `R_40` (`padron`),
  KEY `R_42` (`id_sector`),
  KEY `R_44` (`id_hora_ingreso`),
  KEY `R_45` (`id_proveedor`),
  CONSTRAINT `trasnporte_dia_trabajo_ibfk_1` FOREIGN KEY (`id_tipo_vehiculo`) REFERENCES `tipo_vehiculo` (`id_tipo_vehiculo`),
  CONSTRAINT `trasnporte_dia_trabajo_ibfk_2` FOREIGN KEY (`id_causa_demora`) REFERENCES `causa_demora` (`id_causa_demora`),
  CONSTRAINT `trasnporte_dia_trabajo_ibfk_3` FOREIGN KEY (`padron`) REFERENCES `padron` (`padron`),
  CONSTRAINT `trasnporte_dia_trabajo_ibfk_4` FOREIGN KEY (`id_sector`) REFERENCES `sector` (`id_sector`),
  CONSTRAINT `trasnporte_dia_trabajo_ibfk_5` FOREIGN KEY (`id_hora_ingreso`) REFERENCES `hora_ingreso` (`id_hora_ingreso`),
  CONSTRAINT `trasnporte_dia_trabajo_ibfk_6` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trasnporte_dia_trabajo`
--

LOCK TABLES `trasnporte_dia_trabajo` WRITE;
/*!40000 ALTER TABLE `trasnporte_dia_trabajo` DISABLE KEYS */;
INSERT INTO `trasnporte_dia_trabajo` VALUES (NULL,NULL,4,NULL,NULL,2,NULL,'2012-05-16',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,3,NULL,'2012-05-16',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,4,NULL,'2012-05-17',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,5,NULL,'2012-05-18',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,6,NULL,'2012-05-21',NULL,29.250,7.313,NULL,'RI_0','02:00:00',NULL),(NULL,NULL,4,NULL,NULL,7,NULL,'2012-05-22',NULL,29.250,7.313,NULL,'RI_0','02:00:00',NULL),(NULL,NULL,4,NULL,NULL,8,NULL,'2012-05-23',NULL,29.250,7.313,NULL,'RI_0','02:00:00',NULL),(NULL,NULL,4,NULL,NULL,9,NULL,'2012-05-24',NULL,29.250,7.313,NULL,'RI_0','02:00:00',NULL),(NULL,NULL,4,NULL,NULL,10,NULL,'2012-05-25',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,11,NULL,'2012-05-25',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,12,NULL,'2012-05-26',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,13,NULL,'2012-05-26',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,14,NULL,'2012-05-26',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,15,NULL,'2012-05-26',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,16,NULL,'2012-05-26',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,17,NULL,'2012-05-26',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Urbanito'),(NULL,NULL,4,NULL,NULL,18,NULL,'2012-05-27',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,19,NULL,'2012-05-27',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,20,NULL,'2012-05-25',NULL,29.250,7.313,NULL,'RI_0','01:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,21,NULL,'2012-05-25',NULL,29.250,7.313,NULL,'RI_0','02:00:00','Kapital'),(NULL,NULL,4,NULL,NULL,22,NULL,'2012-06-11',NULL,29.250,7.313,NULL,'RI_0','01:00:00',NULL),(NULL,NULL,5,NULL,NULL,23,NULL,'2012-06-11',NULL,33.250,6.650,NULL,'RI_0','02:00:00',NULL);
/*!40000 ALTER TABLE `trasnporte_dia_trabajo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-06-12  2:37:34
