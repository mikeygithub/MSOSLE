-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: 134.175.16.4    Database: ped_moni
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Table structure for table `ped_area`
--

DROP TABLE IF EXISTS `ped_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(255) DEFAULT NULL COMMENT '编号',
  `area_lal` varchar(255) DEFAULT NULL COMMENT '经纬度',
  `area_name` varchar(255) DEFAULT NULL COMMENT '地域名称',
  PRIMARY KEY (`area_id`) USING BTREE,
  KEY `area_code` (`area_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_area`
--

LOCK TABLES `ped_area` WRITE;
/*!40000 ALTER TABLE `ped_area` DISABLE KEYS */;
INSERT INTO `ped_area` (`area_id`, `area_code`, `area_lal`, `area_name`) VALUES (5,'A01','111.323746,23.499508','梧州学院南门门口'),(6,'A02','111.322139,23.502646','梧州学院A4宿舍楼路口'),(7,'A03','111.323918,23.5027','梧州学院实验楼路口');
/*!40000 ALTER TABLE `ped_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ped_area_of_staff`
--

DROP TABLE IF EXISTS `ped_area_of_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_area_of_staff` (
  `area_of_staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(255) DEFAULT NULL,
  `staff_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`area_of_staff_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_area_of_staff`
--

LOCK TABLES `ped_area_of_staff` WRITE;
/*!40000 ALTER TABLE `ped_area_of_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `ped_area_of_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ped_area_of_video`
--

DROP TABLE IF EXISTS `ped_area_of_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_area_of_video` (
  `area_of_video_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(255) DEFAULT NULL,
  `video_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`area_of_video_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_area_of_video`
--

LOCK TABLES `ped_area_of_video` WRITE;
/*!40000 ALTER TABLE `ped_area_of_video` DISABLE KEYS */;
INSERT INTO `ped_area_of_video` (`area_of_video_id`, `area_code`, `video_code`) VALUES (1,'122','V1');
/*!40000 ALTER TABLE `ped_area_of_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ped_sec_message`
--

DROP TABLE IF EXISTS `ped_sec_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_sec_message` (
  `sec_message_id` int(11) NOT NULL AUTO_INCREMENT,
  `sec_message_code` varchar(255) DEFAULT NULL,
  `sec_message_content` longtext,
  `sec_message_phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`sec_message_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_sec_message`
--

LOCK TABLES `ped_sec_message` WRITE;
/*!40000 ALTER TABLE `ped_sec_message` DISABLE KEYS */;
INSERT INTO `ped_sec_message` (`sec_message_id`, `sec_message_code`, `sec_message_content`, `sec_message_phone`) VALUES (1,'2','2','18276297824'),(2,'002','ffff','18276297824');
/*!40000 ALTER TABLE `ped_sec_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ped_sec_staff`
--

DROP TABLE IF EXISTS `ped_sec_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_sec_staff` (
  `sec_staff_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '保安id',
  `sec_staff_code` varchar(255) DEFAULT NULL COMMENT '保安编号',
  `sec_staff_name` varchar(255) DEFAULT NULL COMMENT '保安姓名',
  `sec_staff_phone` varchar(11) DEFAULT NULL COMMENT '保安电话',
  `area_area_id` int(11) DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL,
  `sec_staff_sex` int(11) DEFAULT NULL,
  `sec_staff_desc` longtext,
  `sec_staff_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`sec_staff_id`) USING BTREE,
  KEY `FKkvfsaal2hh3fictnk43iddy7x` (`area_area_id`),
  KEY `FKgbikac9gs9kqcyissf8ftwc3n` (`user_user_id`),
  CONSTRAINT `FKgbikac9gs9kqcyissf8ftwc3n` FOREIGN KEY (`user_user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FKkvfsaal2hh3fictnk43iddy7x` FOREIGN KEY (`area_area_id`) REFERENCES `ped_area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_sec_staff`
--

LOCK TABLES `ped_sec_staff` WRITE;
/*!40000 ALTER TABLE `ped_sec_staff` DISABLE KEYS */;
INSERT INTO `ped_sec_staff` (`sec_staff_id`, `sec_staff_code`, `sec_staff_name`, `sec_staff_phone`, `area_area_id`, `user_user_id`, `sec_staff_sex`, `sec_staff_desc`, `sec_staff_status`) VALUES (33,'18276297824','杨彪','18276297824',5,13,0,'',0),(34,'13471402595','许传本','13471402595',6,14,0,'',0),(37,'15777447891','黎士杰','15777447891',6,17,0,'',0),(38,'3319246990','易苏阳','18276255465',6,18,0,'',0),(39,'18376031350','黄结','18376031350',6,19,0,'',0);
/*!40000 ALTER TABLE `ped_sec_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ped_video`
--

DROP TABLE IF EXISTS `ped_video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_lal` varchar(255) DEFAULT NULL COMMENT '摄像头经纬度',
  `position_name` varchar(255) DEFAULT NULL COMMENT '位置名称',
  `video_code` varchar(255) DEFAULT NULL COMMENT '摄像头编号',
  `video_ip` varchar(255) DEFAULT NULL COMMENT '摄像头ip',
  `area_area_id` int(11) DEFAULT NULL,
  `threshoud` int(11) DEFAULT NULL,
  PRIMARY KEY (`video_id`) USING BTREE,
  KEY `FKpkafr772s9f1jq8emfggw3mle` (`area_area_id`),
  CONSTRAINT `FKpkafr772s9f1jq8emfggw3mle` FOREIGN KEY (`area_area_id`) REFERENCES `ped_area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_video`
--

LOCK TABLES `ped_video` WRITE;
/*!40000 ALTER TABLE `ped_video` DISABLE KEYS */;
INSERT INTO `ped_video` (`video_id`, `video_lal`, `position_name`, `video_code`, `video_ip`, `area_area_id`, `threshoud`) VALUES (5,'111.322139,23.502646','梧州学院A4宿舍楼路口','E003','192.168.1.12',6,15),(6,'111.323918,23.5027','梧州学院实验楼路口','E002','192.168.1.13',6,10),(7,'111.323746,23.499508','梧州学院南门门口','E001','192.168.2.11',6,20),(8,'111.324417,23.504054','梧州学院明理楼','E004','192.168.2.14',6,20);
/*!40000 ALTER TABLE `ped_video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ped_warn_message`
--

DROP TABLE IF EXISTS `ped_warn_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ped_warn_message` (
  `warn_message_id` varchar(255) NOT NULL,
  `lal` varchar(255) DEFAULT NULL,
  `people_num` int(11) DEFAULT NULL,
  `position_name` varchar(255) DEFAULT NULL,
  `video_code` varchar(255) DEFAULT NULL,
  `video_ip` varchar(255) DEFAULT NULL,
  `msg_time` datetime DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `msg_grade` int(11) DEFAULT NULL,
  `msg_status` int(11) DEFAULT NULL,
  `msg_content` longtext,
  `area_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`warn_message_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ped_warn_message`
--

LOCK TABLES `ped_warn_message` WRITE;
/*!40000 ALTER TABLE `ped_warn_message` DISABLE KEYS */;
INSERT INTO `ped_warn_message` (`warn_message_id`, `lal`, `people_num`, `position_name`, `video_code`, `video_ip`, `msg_time`, `video_url`, `msg_grade`, `msg_status`, `msg_content`, `area_code`) VALUES ('20190611172558749','111.322139,23.502646',6,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:25:58','group1/M00/00/00/rBAABlz_c6WASuITAAeBLDemB3k284.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611172622841','111.322139,23.502646',6,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:26:23','group1/M00/00/00/rBAABlz_c76AUySfAAdLVW5WepY001.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061117265328','111.322139,23.502646',6,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:26:54','group1/M00/00/00/rBAABlz_c92AUT8qAAeNPkiZVRU159.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611172726479','111.322139,23.502646',7,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:27:26','group1/M00/00/00/rBAABlz_c_2ARcjiAAb7JXqfLE4814.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611172803305','111.322139,23.502646',7,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:28:03','group1/M00/00/00/rBAABlz_dCOAIB4SAAcGcJwpaiE632.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611172833873','111.322139,23.502646',9,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:28:33','group1/M00/00/00/rBAABlz_dEGAYbCrAAhG9-haGM8278.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611172904573','111.322139,23.502646',7,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:29:05','group1/M00/00/00/rBAABlz_dGCARjKhAAfn5JuwvTw009.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611173657317','111.322139,23.502646',9,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:36:58','group1/M00/00/00/rBAABlz_djmAUc-oAAguVuPY_Jc097.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061117372778','111.322139,23.502646',12,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:37:28','group1/M00/00/00/rBAABlz_dleAD3n4AAd-AJo8Duw373.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611173758561','111.322139,23.502646',7,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:37:58','group1/M00/00/00/rBAABlz_dnWAcrJwAAgtizUtHLQ615.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611173831852','111.322139,23.502646',7,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 17:38:32','group1/M00/00/00/rBAABlz_dpaAIRpmAAlDfECozXE968.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('201906111956575','111.322139,23.502646',12,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 19:56:57','group1/M00/00/00/rBAABlz_lwmABACnAAj3TDdb3zg640.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190611195724506','111.322139,23.502646',7,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-11 19:57:25','group1/M00/00/00/rBAABlz_lySAJchtAAefgSYatls859.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612173141454','111.322139,23.502646',13,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:31:41','group1/M00/00/00/rBAABl0AxnyAUHuwAAiUiHsb2Xg896.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612173208283','111.322139,23.502646',13,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:32:08','group1/M00/00/00/rBAABl0AxpeAUt4UAAezP8STGrI423.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612173237375','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:32:38','group1/M00/00/00/rBAABl0AxrWATJUCAAeJI3zbmM4004.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612173308755','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:33:08','group1/M00/00/00/rBAABl0AxtOADFvHAAgbzf4OGgE852.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612173338142','111.322139,23.502646',9,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:33:38','group1/M00/00/00/rBAABl0AxvGAdGJpAAf4I8kJXcw804.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061217382052','111.322139,23.502646',20,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:38:21','group1/M00/00/00/rBAABl0AyAyAWkYUAAdR_JzO11w669.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612175522826','111.322139,23.502646',22,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:55:22','group1/M00/00/00/rBAABl0AzAmAQF40AAcBLTue1dQ438.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061217565987','111.322139,23.502646',22,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:56:59','group1/M00/00/00/rBAABl0AzGqAImmmAAbOp_gaIow630.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612175730414','111.322139,23.502646',21,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:57:31','group1/M00/00/00/rBAABl0AzIqAUDFXAAb_rxsMe34914.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190612175807475','111.322139,23.502646',20,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-12 17:58:08','group1/M00/00/00/rBAABl0AzK-AAETZAAcRqRjz5zQ106.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115405724','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:54:06','group1/M00/00/00/rBAABl0ByN2AZffEAAfTjS9agME640.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115428116','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:54:28','group1/M00/00/00/rBAABl0ByPOAcgBxAAcsHNAbktc112.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115506452','111.322139,23.502646',18,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:55:06','group1/M00/00/00/rBAABl0ByRmALbiJAAgAaDndkvs068.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115539375','111.322139,23.502646',17,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:55:40','group1/M00/00/00/rBAABl0ByTuACy90AAeoomFGA10073.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115609391','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:56:10','group1/M00/00/00/rBAABl0ByVmANDNdAAen1S2-w7E114.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115659854','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:56:59','group1/M00/00/00/rBAABl0ByYqAfkv_AAegrYdvdMs146.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115732484','111.322139,23.502646',19,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:57:33','group1/M00/00/00/rBAABl0ByayAI99xAAerljZn_gc015.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115810289','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:58:11','group1/M00/00/00/rBAABl0BydKAeEvlAAetfDG6jn8822.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061311583555','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:58:36','group1/M00/00/00/rBAABl0ByeuAN62kAAdPdLE4Cec857.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061311590616','111.322139,23.502646',17,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:59:07','group1/M00/00/01/rBAABl0BygqAGHn8AAb_HyBDJxU519.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613115940862','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 11:59:41','group1/M00/00/01/rBAABl0ByiyAPvYeAAbw4QjebS8201.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613120015688','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 12:00:16','group1/M00/00/01/rBAABl0Byk-Ad1Q2AAa4RjCny4c332.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613120047835','111.322139,23.502646',15,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 12:00:47','group1/M00/00/01/rBAABl0Bym6AGHO3AAckO12HHP4447.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613120124783','111.322139,23.502646',17,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 12:01:25','group1/M00/00/01/rBAABl0BypSAUzuXAAcZlGJ6WCY687.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613120201737','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 12:02:02','group1/M00/00/01/rBAABl0ByrmAE9nPAAcd7A1BI-U259.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613120320474','111.322139,23.502646',17,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 12:03:21','group1/M00/00/01/rBAABl0BywiATh3OAAbIsOOSN50989.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613141920140','111.322139,23.502646',9,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:19:21','group1/M00/00/01/rBAABl0B6uiAddnaAAhC6S05Ar8115.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142020110','111.322139,23.502646',13,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:20:21','group1/M00/00/01/rBAABl0B6yKAdbKSAAf1vOjwAKo845.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142101106','111.322139,23.502646',6,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:21:01','group1/M00/00/01/rBAABl0B60qAZRZ0AAhpDM58xpw875.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142153129','111.322139,23.502646',21,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:21:54','group1/M00/00/01/rBAABl0B63-AZpP0AAghyVKlWD8341.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142206554','111.322139,23.502646',11,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:22:06','group1/M00/00/01/rBAABl0B642Ab4aXAAhEW0kTLMI156.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142324856','111.322139,23.502646',8,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:23:25','group1/M00/00/01/rBAABl0B69yALpjAAAgEjc3OjPA266.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142414801','111.322139,23.502646',12,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:24:14','group1/M00/00/01/rBAABl0B7AqASn0nAAgpELkDV80980.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613142720757','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 14:27:20','group1/M00/00/01/rBAABl0B7MeAKU8SAAf03oqFscE239.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173134233','111.322139,23.502646',10,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:31:34','group1/M00/00/01/rBAABl0CF_WAFhPrAAhTBLH6jRI425.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173211785','111.322139,23.502646',12,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:32:11','group1/M00/00/01/rBAABl0CGBqAB2VOAAhXSbS_YlQ467.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173557852','111.322139,23.502646',19,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:35:58','group1/M00/00/01/rBAABl0CGP2AAkH_AAhd5KvmY60698.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173624582','111.322139,23.502646',19,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:36:25','group1/M00/00/01/rBAABl0CGRiAEO22AAhDuf31FlU877.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173654486','111.322139,23.502646',19,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:36:54','group1/M00/00/01/rBAABl0CGTWAVzDQAAhlpAz2s3I155.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173725684','111.322139,23.502646',18,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:37:25','group1/M00/00/01/rBAABl0CGVSASYmfAAfYAwI7phk186.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061317375754','111.322139,23.502646',22,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:37:58','group1/M00/00/01/rBAABl0CGXWABc8JAAfw4oh6gFY897.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173834587','111.322139,23.502646',17,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:38:35','group1/M00/00/01/rBAABl0CGZqAbl9HAAfKEXb9NfE863.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190613173905304','111.322139,23.502646',18,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-13 17:39:05','group1/M00/00/01/rBAABl0CGbiAVJGIAAfgyl6Upro689.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614115340660','111.322139,23.502646',21,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 11:53:41','group1/M00/00/01/rBAABl0DGkSAFAF3AAhPFSXW_Ho688.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614115417766','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 11:54:17','group1/M00/00/01/rBAABl0DGmiAAcpqAAe1OeWjY8A601.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614115448511','111.322139,23.502646',16,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 11:54:49','group1/M00/00/01/rBAABl0DGoiAA8RiAAfqAo7SUQE467.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614115518336','111.322139,23.502646',18,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 11:55:18','group1/M00/00/01/rBAABl0DGqaAAorQAAb56oPspzg704.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614115549740','111.322139,23.502646',18,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 11:55:50','group1/M00/00/01/rBAABl0DGsWAGJ7TAAebyVfT1I0232.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614121914384','111.322139,23.502646',2,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 12:19:15','group1/M00/00/01/rBAABl0DIEKAWmy_AAd2ibFqs9I438.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614122011337','111.322139,23.502646',1,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 12:20:11','group1/M00/00/01/rBAABl0DIHqADHb0AAm3XOva3cU518.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('2019061412204196','111.322139,23.502646',1,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 12:20:42','group1/M00/00/01/rBAABl0DIJmAHk0aAAog8oZIIqc592.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614122120250','111.322139,23.502646',1,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 12:21:21','group1/M00/00/01/rBAABl0DIMCAJ2z9AAnUk5eUx2g093.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614122150736','111.322139,23.502646',6,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 12:21:50','group1/M00/00/01/rBAABl0DIN6AO4FuAAjKPZ_t0DU934.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614122222481','111.322139,23.502646',1,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 12:22:22','group1/M00/00/01/rBAABl0DIP6AXRRpAAnsw3PhcZU196.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614200106528','111.322139,23.502646',2,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 20:01:07','group1/M00/00/01/rBAABl0DjIGADGHWAAkQDZuLzI0883.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614224743637','111.322139,23.502646',3,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 22:47:44','group1/M00/00/01/rBAABl0Ds42ARN7iAA-YNa0ZjEo218.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02'),('20190614231357182','111.322139,23.502646',1,'梧州学院A4宿舍楼路口','E003','192.168.1.12','2019-06-14 23:13:57','group1/M00/00/01/rBAABl0DubOACpbSAAmea3ucvFc849.mp4',1,2,'您所在的区域人流量已超出预警线,请及时维持次序\r\n','A02');
/*!40000 ALTER TABLE `ped_warn_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin`
--

DROP TABLE IF EXISTS `sys_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) NOT NULL,
  `admin_code` varchar(255) DEFAULT NULL COMMENT '编号',
  `admin_email` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_phone` varchar(255) DEFAULT NULL,
  `admin_sex` int(11) DEFAULT NULL,
  `login_password` varchar(255) DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE,
  KEY `FK25tl0pfope4w9g5ofei7stf4t` (`user_user_id`),
  CONSTRAINT `FK25tl0pfope4w9g5ofei7stf4t` FOREIGN KEY (`user_user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin`
--

LOCK TABLES `sys_admin` WRITE;
/*!40000 ALTER TABLE `sys_admin` DISABLE KEYS */;
INSERT INTO `sys_admin` (`admin_id`, `login_name`, `admin_code`, `admin_email`, `admin_name`, `admin_phone`, `admin_sex`, `login_password`, `user_user_id`) VALUES (1,'admin','admin','admin','admin','110',1,'admins',NULL);
/*!40000 ALTER TABLE `sys_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_account` varchar(255) DEFAULT NULL,
  `login_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `role_type` int(11) DEFAULT NULL,
  `user_available` int(2) NOT NULL DEFAULT '1' COMMENT '1:可用 2：封号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `login_account`, `login_password`, `user_name`, `role_type`, `user_available`) VALUES (2,'admin','admin','admin',1,1),(13,'18276297824','123456','杨彪',2,0),(14,'13471402595','123456','许传本',2,0),(15,'18276427587','123456','黎士杰',2,0),(16,'18276297822','123456','易苏阳',2,0),(17,'15777447891','123456','黎士杰',2,0),(18,'3319246990','123456','易苏阳',2,0),(19,'18376031350','123456','黄结',2,0);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-15 12:31:57
