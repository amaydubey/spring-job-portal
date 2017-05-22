-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: jobportal
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) NOT NULL,
  `headquarters` varchar(255) NOT NULL,
  `companyUser` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `description` blob,
  `verificationCode` int(11) DEFAULT NULL,
  `verified` bit(1) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'l','San Jose','linkedin','1234','We are LinkedIn',1234,''),(3,'surendra yadav','head','amaydubey@gmail.com','1234',NULL,9632,'');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobapplication`
--

DROP TABLE IF EXISTS `jobapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobapplication` (
  `appId` int(11) NOT NULL AUTO_INCREMENT,
  `jobId` int(11) NOT NULL,
  `jobSeekerId` int(11) NOT NULL,
  `resume` tinyint(4) DEFAULT '0',
  `resumePath` blob,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`appId`),
  KEY `FKjxcwb2fekoduom5q146d6sllh` (`jobId`),
  KEY `FK1urhfyvocp1ryhb1c18dcbh5m` (`jobSeekerId`),
  CONSTRAINT `FK1urhfyvocp1ryhb1c18dcbh5m` FOREIGN KEY (`jobSeekerId`) REFERENCES `jobseeker` (`jobSeekerId`),
  CONSTRAINT `FKjxcwb2fekoduom5q146d6sllh` FOREIGN KEY (`jobId`) REFERENCES `jobposting` (`jobId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobapplication`
--

LOCK TABLES `jobapplication` WRITE;
/*!40000 ALTER TABLE `jobapplication` DISABLE KEYS */;
INSERT INTO `jobapplication` VALUES (1,1,1,1,'qwe',0);
/*!40000 ALTER TABLE `jobapplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jobposting`
--

DROP TABLE IF EXISTS `jobposting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobposting` (
  `jobId` int(11) NOT NULL AUTO_INCREMENT,
  `companyId` int(11) NOT NULL,
  `state` int(11) NOT NULL DEFAULT '0',
  `title` varchar(255) NOT NULL,
  `description` blob,
  `responsibilities` blob,
  `location` varchar(255) NOT NULL,
  `salary` float DEFAULT '0',
  `keywords` blob,
  PRIMARY KEY (`jobId`),
  KEY `FK9s2a13di3vurgeiw7iwp1kwl` (`companyId`),
  CONSTRAINT `FK9s2a13di3vurgeiw7iwp1kwl` FOREIGN KEY (`companyId`) REFERENCES `company` (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobposting`
--

LOCK TABLES `jobposting` WRITE;
/*!40000 ALTER TABLE `jobposting` DISABLE KEYS */;
INSERT INTO `jobposting` VALUES (1,1,1,'new','Updated','Do yourwork','Pune',1212140,'SE SE SE san Jose'),(2,1,0,'Test','66','234','San Jose',242,'Test 66 243 adfd'),(3,1,0,'Test','66','234','adfd',242,'Test 66 243 adfd');
/*!40000 ALTER TABLE `jobposting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `jobpostingsview`
--

DROP TABLE IF EXISTS `jobpostingsview`;
/*!50001 DROP VIEW IF EXISTS `jobpostingsview`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `jobpostingsview` AS SELECT 
 1 AS `jobId`,
 1 AS `title`,
 1 AS `description`,
 1 AS `responsibilities`,
 1 AS `location`,
 1 AS `salary`,
 1 AS `keywords`,
 1 AS `state`,
 1 AS `companyId`,
 1 AS `companyName`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `jobseeker`
--

DROP TABLE IF EXISTS `jobseeker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jobseeker` (
  `jobSeekerId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `emailId` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `workEx` int(11) DEFAULT '0',
  `highestEducation` int(11) DEFAULT '0',
  `skills` blob,
  `verified` tinyint(4) DEFAULT '0',
  `verificationCode` int(11) NOT NULL,
  PRIMARY KEY (`jobSeekerId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobseeker`
--

LOCK TABLES `jobseeker` WRITE;
/*!40000 ALTER TABLE `jobseeker` DISABLE KEYS */;
INSERT INTO `jobseeker` VALUES (1,'John','Doe','john.doe@jd.com','1234',1,2,'Java, C, C#, C++, MySQL',1,1234),(3,'surendra','yadav','amaydubey@gmail.com','1234',0,0,NULL,0,5959);
/*!40000 ALTER TABLE `jobseeker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `jobpostingsview`
--

/*!50001 DROP VIEW IF EXISTS `jobpostingsview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `jobpostingsview` AS select `jp`.`jobId` AS `jobId`,`jp`.`title` AS `title`,`jp`.`description` AS `description`,`jp`.`responsibilities` AS `responsibilities`,`jp`.`location` AS `location`,`jp`.`salary` AS `salary`,`jp`.`keywords` AS `keywords`,`jp`.`state` AS `state`,`c`.`companyId` AS `companyId`,`c`.`companyName` AS `companyName` from (`jobposting` `jp` join `company` `c`) where (`c`.`companyId` = `jp`.`companyId`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-21 17:42:43
