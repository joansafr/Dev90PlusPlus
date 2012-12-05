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
-- Table structure for table `personal`
--

DROP TABLE IF EXISTS `personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal` (
  `id_personal` varchar(9) NOT NULL,
  `id_sector` varchar(50) NOT NULL,
  `personal_codigo_planilla` varchar(20) DEFAULT NULL,
  `personal_codigo_fotocheck` varchar(20) DEFAULT NULL,
  `personal_nombre` varchar(50) DEFAULT NULL,
  `personal_apellido_paterno` varchar(50) DEFAULT NULL,
  `personal_apellido_materno` varchar(50) DEFAULT NULL,
  `personal_usuario` varchar(8) DEFAULT NULL,
  `personal_contrasena` varchar(16) DEFAULT NULL,
  `personal_cantidad_horas_semanal` time DEFAULT NULL,
  `id_cargo` varchar(50) DEFAULT NULL,
  `id_area` varchar(50) DEFAULT NULL,
  `personal_confianza` tinyint(1) DEFAULT NULL,
  `personal_fecha_incorporacion` date DEFAULT NULL,
  `personal_actividad` tinyint(1) DEFAULT NULL,
  `personal_tipo_baja` tinyint(1) DEFAULT NULL,
  `id_motivo_baja` varchar(50) DEFAULT NULL,
  `id_turno` varchar(20) DEFAULT NULL,
  `personal_fecha_baja` date DEFAULT NULL,
  `id_grupo_formacion` varchar(20) DEFAULT NULL,
  `personal_fecha_formacion` date DEFAULT NULL,
  `personal_fecha_ingreso_gestion` date DEFAULT NULL,
  `personal_fecha_nacimiento` date DEFAULT NULL,
  `personal_sexo` tinyint(1) DEFAULT NULL,
  `id_estado_civil` varchar(20) DEFAULT NULL,
  `personal_cantidad_hijos` int(11) DEFAULT NULL,
  `id_nivel_educativo` varchar(50) DEFAULT NULL,
  `id_carrera` varchar(100) DEFAULT NULL,
  `personal_direccion` varchar(300) DEFAULT NULL,
  `id_centro_estudios` varchar(100) DEFAULT NULL,
  `personal_direccion_referencia` varchar(200) DEFAULT NULL,
  `personal_telefono_fijo` varchar(15) DEFAULT NULL,
  `personal_telefono_movil` varchar(15) DEFAULT NULL,
  `personal_email` varchar(100) DEFAULT NULL,
  `personal_hora_refrigerio_inicio` time DEFAULT NULL,
  `personal_hora_refrigerio_duracion` time DEFAULT NULL,
  `personal_latitude` float(10,6) DEFAULT NULL,
  `personal_longitude` float(10,6) DEFAULT NULL,
  `id_responsable_nombre_apellido` varchar(100) DEFAULT NULL,
  `id_hora_ingreso` time DEFAULT NULL,
  `personal_contrato` longblob,
  PRIMARY KEY (`id_personal`),
  KEY `R_19` (`id_sector`),
  KEY `R_22` (`id_cargo`),
  KEY `R_23` (`id_area`),
  KEY `R_25` (`id_motivo_baja`),
  KEY `R_26` (`id_turno`),
  KEY `R_27` (`id_grupo_formacion`),
  KEY `R_28` (`id_estado_civil`),
  KEY `R_29` (`id_nivel_educativo`),
  KEY `R_30` (`id_carrera`),
  KEY `R_31` (`id_centro_estudios`),
  KEY `R_37` (`id_responsable_nombre_apellido`),
  KEY `R_43` (`id_hora_ingreso`),
  CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`id_sector`) REFERENCES `sector` (`id_sector`),
  CONSTRAINT `personal_ibfk_10` FOREIGN KEY (`id_centro_estudios`) REFERENCES `centro_estudios` (`id_centro_estudios`),
  CONSTRAINT `personal_ibfk_11` FOREIGN KEY (`id_responsable_nombre_apellido`) REFERENCES `responsable` (`id_responsable_nombre_apellido`),
  CONSTRAINT `personal_ibfk_12` FOREIGN KEY (`id_hora_ingreso`) REFERENCES `hora_ingreso` (`id_hora_ingreso`),
  CONSTRAINT `personal_ibfk_2` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`),
  CONSTRAINT `personal_ibfk_3` FOREIGN KEY (`id_area`) REFERENCES `area` (`id_area`),
  CONSTRAINT `personal_ibfk_4` FOREIGN KEY (`id_motivo_baja`) REFERENCES `motivo_baja` (`id_motivo_baja`),
  CONSTRAINT `personal_ibfk_5` FOREIGN KEY (`id_turno`) REFERENCES `turno` (`id_turno`),
  CONSTRAINT `personal_ibfk_6` FOREIGN KEY (`id_grupo_formacion`) REFERENCES `grupo_formacion` (`id_grupo_formacion`),
  CONSTRAINT `personal_ibfk_7` FOREIGN KEY (`id_estado_civil`) REFERENCES `estado_civil` (`id_estado_civil`),
  CONSTRAINT `personal_ibfk_8` FOREIGN KEY (`id_nivel_educativo`) REFERENCES `nivel_educativo` (`id_nivel_educativo`),
  CONSTRAINT `personal_ibfk_9` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal`
--

LOCK TABLES `personal` WRITE;
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` VALUES ('45954055','RI_0','','','','','','','',NULL,NULL,'FI_123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'01:00:00',NULL),('46954046','RI_0','','','','','','','',NULL,NULL,'128',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'00:00:00',NULL),('46954047','SI_0','','','','','','','',NULL,NULL,'128',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'01:00:00',NULL),('46954048','RI_0','','','','','','','',NULL,NULL,'FI_123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'02:00:00',NULL),('46954049','RI_0','','','','','','','',NULL,NULL,'FI_123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'02:00:00',NULL),('46954050','RI_0','','','','','','','',NULL,NULL,'128',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'02:00:00',NULL),('46954051','RI_0','','','','','','','',NULL,NULL,'128',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'02:00:00',NULL),('46954052','RI_0','','','','','','','',NULL,NULL,'FI_123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'01:00:00',NULL),('46954053','RI_0','','','','','','','',NULL,NULL,'FI_123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'02:00:00',NULL),('46954054','RI_0','','','','','','','',NULL,NULL,'128',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'01:00:00',NULL),('46954056','RI_0','','','','','','','',NULL,NULL,'FI_123',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'','','','',NULL,NULL,NULL,NULL,NULL,'01:00:00',NULL);
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-06-12  2:37:33
