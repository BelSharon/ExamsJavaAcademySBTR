CREATE DATABASE  IF NOT EXISTS `viveros_yecapixtla_neza` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `viveros_yecapixtla_neza`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: web_customer_tracker
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `arboles_viveros`
--

DROP TABLE IF EXISTS `arboles_viveros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arboles_viveros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_comun` varchar(45) DEFAULT NULL,
  `nombre_cientifico` varchar(45) DEFAULT NULL,
  `familia` varchar(45) DEFAULT NULL,
  `estatus_nom` enum('P', 'A', 'R', 'Pr') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fauna_viveros`
--

LOCK TABLES `arboles_viveros` WRITE;
/*!40000 ALTER TABLE `arboles_viveros` DISABLE KEYS */;

INSERT INTO `arboles_viveros` VALUES 
	(1,'Negundo','Acer negundo','Aceraceae', 'Pr'),
	(2,'Aile', 'Alnus acuminata','Betulaceae', null),
	(3,'Madroño negro', 'Arbutus tessellata', 'Ericaceae', null),
	(4,'Madroño','Arbutus xalapensis','Ericaceae', null),
	(5,'Tepozán','Buddleja cordata', 'Loganiaceae', null),
    (6,'Copal','Bursera cuneata' ,'Burseraceae' , 'Pr'),
	(7,'Cuajiote', 'Bursera fagaroides','Burseraceae', null),
	(8,'Jaboncillo', 'Clethra mexicana', 'Clethraceae', null),
	(9,'Tejocote','Crataegus mexicana','Rosaceae', null),
	(10,'Árbol de manita','Chiranthodendron pentadactylon', 'Malvaceae', 'A');

/*!40000 ALTER TABLE `arboles_viveros` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;