CREATE DATABASE  IF NOT EXISTS `db3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db3`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: db3
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `new_autogene`
--

DROP TABLE IF EXISTS `new_autogene1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `new_autogene` (
  `orgid` varchar(20) DEFAULT NULL,
  `patternid` varchar(45) DEFAULT NULL,
  `patternkey` int(10) NOT NULL,
  `startIncValue` int(10) DEFAULT NULL,
  `startIncYesorNo` tinyint(5) DEFAULT NULL,
  `startTypeInt` varchar(45) DEFAULT NULL,
  `startTypeString` varchar(45) DEFAULT NULL,
  `startlength` int(10) DEFAULT NULL,
  `startCurrentValue` int(10) DEFAULT NULL,
  `startThreshold` int(20) DEFAULT NULL,
  `startSeparator_applicable` tinyint(10) DEFAULT NULL,
  `startSeparator_length` int(10) DEFAULT NULL,
  `startSeparator_value` varchar(45) DEFAULT NULL,
  `startDependency_applicable` tinyint(10) DEFAULT NULL,
  `midIncValue` int(10) DEFAULT NULL,
  `midIncYesorNo` tinyint(5) DEFAULT NULL,
  `midTypeInt` varchar(45) DEFAULT NULL,
  `midTypeString` varchar(45) DEFAULT NULL,
  `midlength` int(10) DEFAULT NULL,
  `midCurrentValue` int(10) DEFAULT NULL,
  `midThreshold` int(20) DEFAULT NULL,
  `midSeparator_applicable` tinyint(10) DEFAULT NULL,
  `midSeparator_length` int(10) DEFAULT NULL,
  `midSeparator_value` varchar(45) DEFAULT NULL,
  `midDependency_applicable` tinyint(10) DEFAULT NULL,
  `startValue` varchar(45) DEFAULT NULL,
  `midValue` varchar(45) DEFAULT NULL,
  `endValue` varchar(45) DEFAULT NULL,
  `endIncValue` int(10) DEFAULT NULL,
  `endIncYesorNo` tinyint(5) DEFAULT NULL,
  `endTypeInt` varchar(45) DEFAULT NULL,
  `endTypeString` varchar(45) DEFAULT NULL,
  `endlength` int(10) DEFAULT NULL,
  `endCurrentValue` int(10) DEFAULT NULL,
  `endThreshold` int(20) DEFAULT NULL,
  `endDependency_applicable` tinyint(10) DEFAULT NULL,
  `start_zero_fill_yesorno` tinyint(10) DEFAULT NULL,
  `start_zero_fill_length` int(10) DEFAULT NULL,
  `mid_zero_fill_yesorno` tinyint(10) DEFAULT NULL,
  `mid_zero_fill_length` int(10) DEFAULT NULL,
  `end_zero_fill_yesorno` tinyint(10) DEFAULT NULL,
  `end_zero_fill_length` int(10) DEFAULT NULL,
  PRIMARY KEY (`patternkey`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-05 11:50:01
