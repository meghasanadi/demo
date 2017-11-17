CREATE DATABASE  IF NOT EXISTS `db3` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db3`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
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

DROP TABLE IF EXISTS `new_autogene`;
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

--
-- Dumping data for table `new_autogene`
--

LOCK TABLES `new_autogene` WRITE;
/*!40000 ALTER TABLE `new_autogene` DISABLE KEYS */;
INSERT INTO `new_autogene` VALUES ('DIGYWOOD01','1@BRU@0001',1,1,1,'1','',1,29,0,1,1,':',0,0,0,'','BRU',3,0,0,1,1,'@',0,'','','',5,1,'1','',4,32,9999,0,0,0,0,0,1,1),('DIGYWOOD01','0001@BRU@0001',2,5,1,'1','',1,31,0,1,1,'@',0,0,0,'','BRRA',4,0,0,1,1,'/',0,'','','',10,1,'1','',4,31,9999,0,1,1,0,0,1,1),('DIGYWOOD01','0001@0001@0001',3,1,1,'1','',1,21,0,1,1,'@',0,1,1,'1','',4,21,0,1,1,'@',0,'','','',1,1,'1','',4,21,9999,0,1,1,1,1,1,1),('DIGYWOOD01','1@0001@BRU',4,1,1,'1','',1,25,0,1,1,'@',0,1,1,'1','',4,25,9999,1,1,'_',0,'','','',0,0,'0','BRU',3,0,9999,0,0,0,1,3,0,0),('DIGYWOOD01','CUSTLS#1',5,0,0,'','CUST',4,0,0,1,1,'#',0,0,0,'0','LS',2,0,0,0,0,'',0,'','','',1,1,'1','',1,45,0,0,0,0,0,0,0,0),('DIGYWOOD01','0001_ABC',6,1,1,'1','',4,13,0,1,1,'-',0,0,0,'0','ABC',3,0,0,0,0,'',0,'','','',0,0,'0','',0,0,0,0,1,3,0,0,0,0),('DIGYWOOD01','SAM',7,0,0,'0','SAMCOMM',3,0,0,0,0,'',0,0,0,'','',0,0,0,0,0,'',0,'','','',0,0,'','',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','1',8,1,1,'1','',0,41,0,0,0,'0',0,0,0,'0','0',0,0,0,0,0,'',0,'','','',0,0,'','',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','CUAT#0001@LS',9,0,0,'0','CUAT',0,0,0,1,1,'#',0,1,1,'1','',4,16,0,1,1,'@',0,'','','',0,0,'0','LS',2,0,0,0,0,0,1,3,0,0),('DIGYWOOD01','1#0001LS',10,1,1,'1','',1,9,0,1,1,'#',0,1,1,'1','',4,11,0,0,0,'0',0,'','','',0,0,'0','LS',2,0,0,0,0,0,1,3,0,0),('DIGYWOOD01','A1',11,0,0,'0','AAA',1,0,0,0,0,'',0,1,1,'1','',1,8,0,0,0,'',0,'','','',0,0,'0','',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','A@1',12,0,0,'0','A',1,0,0,1,1,'@',0,1,1,'1','',1,5,0,0,0,'',0,'','','',0,0,'0','',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','0001ABC',13,1,1,'1','',4,19,0,0,0,'-',0,0,0,'0','ABC',3,0,0,0,0,'',0,'','','',0,0,'0','',0,0,0,0,1,3,0,0,0,0),('DIGYWOOD01','1ABC',14,1,1,'1','',4,20,0,0,0,'-',0,0,0,'0','ANBBN',3,0,0,0,0,'',0,'','','',0,0,'0','',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','0001@ABCD',15,1,1,'1','1',1,7,1,1,1,'#',0,0,0,'0','ABCD',0,0,0,0,0,'',0,'','','',0,0,'','',0,0,0,0,1,1,0,0,0,0),('DIGYWOOD01','A1B',16,0,0,'0','A',1,0,0,0,0,'',0,1,1,'1','',1,4,0,0,0,'',0,'','','',1,0,'0','B',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','CUST012017',17,0,0,'','CUST',4,0,0,0,0,'#',0,1,1,'1','LS',2,10,31,0,0,'',0,'','','',0,1,'2017','',4,2017,0,0,0,0,1,1,0,0),('DIGYWOOD01','1ABC',18,1,1,'1','',4,23,0,0,0,'-',0,0,0,'0','ANBBN',3,0,0,0,0,'',0,'','','',0,0,'0','',0,0,0,0,1,1,0,0,0,0),('DIGYWOOD01','1',19,1,1,'1','',1,35,0,0,0,'',0,0,0,'','',0,0,0,0,0,'',0,'','','',0,0,'','',0,0,0,0,0,0,0,0,0,0),('DIGYWOOD01','CUST0001',20,0,0,'0','CUST',4,0,0,0,0,'',0,1,1,'1','',4,14,0,0,0,'0',0,'','','',0,0,'','',0,0,0,0,0,0,1,3,0,0),('DIGYWOOD01','ROLE_01_0001',21,0,0,'0','ROLE',4,0,0,1,1,'_',0,0,1,'1',NULL,1,1,NULL,1,1,'_',0,NULL,NULL,NULL,1,1,'1',NULL,4,16,NULL,NULL,0,0,0,0,1,0),('DIGYWOOD01','SR01_0001',22,0,0,'0','SR0',1,0,0,0,0,NULL,0,0,1,'1',NULL,2,1,NULL,1,1,'_',0,NULL,NULL,NULL,1,1,'1',NULL,4,16,NULL,NULL,0,0,0,0,1,0),('DIGYWOOD01','ACT01_0001',24,0,0,'0','ACT',1,0,0,0,0,NULL,0,0,1,'1',NULL,2,1,NULL,1,1,'_',0,NULL,NULL,NULL,1,1,'1',NULL,4,41,NULL,NULL,NULL,0,0,0,1,0),('DIGYWOOD01','PADAA0446',25,0,0,'0','PADAA',5,0,0,0,0,'',0,0,0,'1',NULL,1,0,NULL,0,0,NULL,0,NULL,NULL,NULL,1,1,'1',NULL,3,818,NULL,NULL,NULL,0,0,0,1,0),('DIGYWOOD01','S-ORD0071',26,0,0,'0','S-ORD',5,0,0,0,0,NULL,0,0,1,'1',NULL,1,0,NULL,0,0,NULL,0,NULL,NULL,NULL,1,1,'1',NULL,3,123,NULL,NULL,NULL,0,0,0,1,0),('DIGYWOOD01','ADVT0019',27,0,0,'0','ADVT',4,0,0,0,0,NULL,0,0,0,'1',NULL,1,0,0,0,0,NULL,0,NULL,NULL,NULL,1,1,'1',NULL,3,401,NULL,NULL,NULL,0,0,0,1,0),('DIGYWOOD01','S-ORD0076',28,0,0,'0','S',1,0,0,1,1,'-',0,0,0,'0','ORD',3,0,0,0,0,NULL,0,NULL,NULL,NULL,1,1,'1',NULL,4,324,NULL,NULL,NULL,0,0,0,1,2);
/*!40000 ALTER TABLE `new_autogene` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-27 12:29:53
