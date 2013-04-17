CREATE DATABASE  IF NOT EXISTS `prodoib` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `prodoib`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: mysql.chpc.utah.edu    Database: prodoib
-- ------------------------------------------------------
-- Server version	5.0.95

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `subset`
--

DROP TABLE IF EXISTS `subset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subset` (
  `subsetId` bigint(20) NOT NULL,
  `description` varchar(255) default NULL,
  `internalconceptid` int(11) default NULL,
  `methodologyconceptid` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`subsetId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subset`
--

LOCK TABLES `subset` WRITE;
/*!40000 ALTER TABLE `subset` DISABLE KEYS */;
INSERT INTO `subset` VALUES (1,'Diabetes mellitus type 2 codes',1,NULL,'DIABETES_MELLITUS'),(2,'Tamoxifen codes',6,NULL,'TAMOXIFEN'),(3,'Nilotinib codes',70,NULL,'NILOTINIB'),(4,'Carvedilol codes',88,NULL,'CARVEDILOL'),(5,'Metoprolol codes',145,NULL,'METOPROLOL'),(6,'Propafenone codes',218,NULL,'PROPAFENONE'),(7,'Capecitabine codes',253,NULL,'CAPECITABINE'),(8,'Irinotecan codes',264,NULL,'IRINOTECAN'),(9,'Mercaptopurine codes',269,NULL,'MERCAPTOPURINE'),(10,'Thioguanine codes',278,NULL,'THIOGUANINE'),(11,'Clopidogrel codes',285,NULL,'CLOPIDOGREL'),(12,'Warfarin codes',309,NULL,'WARFARIN'),(13,'Drugs with pharmacogenomic interaction',373,NULL,'PHARMACOGENOMIC_DRUGS'),(14,'VisualDx Problems',19478,NULL,'VISUALDX_PROBLEMS'),(15,'VisualDx Medications',19477,NULL,'VISUALDX_MEDICATIONS');
/*!40000 ALTER TABLE `subset` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-17 12:06:07
