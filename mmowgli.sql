CREATE DATABASE  IF NOT EXISTS `mmowgli` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mmowgli`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mmowgli
-- ------------------------------------------------------
-- Server version	5.7.5-m15-log

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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `CardID` int(11) NOT NULL,
  `PlayerID` int(11) DEFAULT NULL,
  `TextUser` varchar(150) DEFAULT NULL,
  `CardType` varchar(20) DEFAULT NULL,
  `Parent` int(11) DEFAULT NULL,
  `Votes` int(11) DEFAULT NULL,
  `Time` datetime DEFAULT NULL,
  PRIMARY KEY (`CardID`),
  UNIQUE KEY `CardID` (`CardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (1,1,'This is some test text0.','Root',0,2,'2015-03-24 18:15:11'),(2,1,'This is some test text1.','Expand',1,5,'2015-03-24 18:15:12'),(3,2,'This is some test text2.','Adapt',1,8,'2015-03-24 18:15:12'),(4,7,'This is some test text3.','Explore',3,22,'2015-03-24 18:15:12'),(5,3,'This is some test text4.','Counter',3,12,'2015-03-24 18:15:12'),(6,2,'This is some test text5.','Adapt',1,10,'2015-03-24 18:15:12'),(25,350,'This card was added!','Adapt',3,0,'2015-04-03 22:32:54');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorites`
--

DROP TABLE IF EXISTS `favorites`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorites` (
  `CardID` int(11) NOT NULL,
  `PlayerID` int(11) NOT NULL,
  `Time` datetime DEFAULT NULL,
  PRIMARY KEY (`CardID`,`PlayerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorites`
--

LOCK TABLES `favorites` WRITE;
/*!40000 ALTER TABLE `favorites` DISABLE KEYS */;
INSERT INTO `favorites` VALUES (1,25,'2015-04-04 12:43:18'),(2,25,'2015-04-04 12:43:18'),(3,25,'2015-04-04 12:43:18');
/*!40000 ALTER TABLE `favorites` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `PlayerID` int(11) NOT NULL,
  `PlayerName` varchar(45) DEFAULT NULL,
  `Points` int(11) DEFAULT NULL,
  `History1` int(11) DEFAULT NULL,
  `History2` int(11) DEFAULT NULL,
  `History3` int(11) DEFAULT NULL,
  `History4` int(11) DEFAULT NULL,
  `History5` int(11) DEFAULT NULL,
  `Hindex` int(11) DEFAULT NULL,
  PRIMARY KEY (`PlayerID`),
  UNIQUE KEY `PlayerID` (`PlayerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (25,'Cool Guy',35,3,2,1,5,6,5);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `Tag` varchar(45) NOT NULL,
  `CardID` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`Tag`,`CardID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES ('Attack',1,'2015-03-28 17:44:18'),('Attack',2,'2015-03-28 17:44:18'),('Game',1,'2015-03-28 17:44:18'),('Game',2,'2015-03-28 17:44:18'),('Game',3,'2015-03-28 17:44:18'),('Game',5,'2015-03-28 17:44:18'),('Game',6,'2015-03-28 17:44:18'),('Plan',3,'2015-03-28 17:44:18'),('Plan',4,'2015-03-28 17:44:18'),('tag1',25,'2015-04-03 22:32:54'),('tag2',25,'2015-04-03 22:32:54'),('tag3',25,'2015-04-03 22:32:54'),('tag4',25,'2015-04-03 22:32:54');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voting`
--

DROP TABLE IF EXISTS `voting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voting` (
  `CardID` int(11) NOT NULL,
  `PlayerID` int(11) NOT NULL,
  `Vote` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`CardID`,`PlayerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voting`
--

LOCK TABLES `voting` WRITE;
/*!40000 ALTER TABLE `voting` DISABLE KEYS */;
INSERT INTO `voting` VALUES (1,25,1,'2015-04-04 16:29:49'),(3,25,1,'2015-04-03 22:50:34');
/*!40000 ALTER TABLE `voting` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-05 21:38:59
