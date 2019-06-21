-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: msosle
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

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
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `classes_id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_name` varchar(255) DEFAULT NULL,
  `classes_classes_id` int(11) DEFAULT NULL,
  `colleges_colleges_id` int(11) DEFAULT NULL,
  `classes_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`classes_id`),
  KEY `FK32E138261BC7F9FE` (`classes_classes_id`),
  KEY `FK32E1382669C4ED72` (`colleges_colleges_id`),
  CONSTRAINT `FK32E138261BC7F9FE` FOREIGN KEY (`classes_classes_id`) REFERENCES `classes` (`classes_id`),
  CONSTRAINT `FK32E1382669C4ED72` FOREIGN KEY (`colleges_colleges_id`) REFERENCES `colleges` (`colleges_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`classes_id`, `classes_name`, `classes_classes_id`, `colleges_colleges_id`, `classes_code`) VALUES (1,'软件一班',NULL,NULL,'C001'),(2,'软件二班',NULL,NULL,'C002');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colleges`
--

DROP TABLE IF EXISTS `colleges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colleges` (
  `colleges_id` int(11) NOT NULL AUTO_INCREMENT,
  `colleges_name` varchar(255) DEFAULT NULL,
  `colleges_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`colleges_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colleges`
--

LOCK TABLES `colleges` WRITE;
/*!40000 ALTER TABLE `colleges` DISABLE KEYS */;
INSERT INTO `colleges` (`colleges_id`, `colleges_name`, `colleges_code`) VALUES (1,'大数据与软件工程学院','CO001');
/*!40000 ALTER TABLE `colleges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dorm`
--

DROP TABLE IF EXISTS `dorm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dorm` (
  `dorm_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_name` varchar(255) DEFAULT NULL,
  `dormitory_dormitory_id` int(11) DEFAULT NULL,
  `dorm_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dorm_id`),
  KEY `FK2F2406101D7EFF` (`dormitory_dormitory_id`),
  CONSTRAINT `FK2F2406101D7EFF` FOREIGN KEY (`dormitory_dormitory_id`) REFERENCES `dormitory` (`dormitory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dorm`
--

LOCK TABLES `dorm` WRITE;
/*!40000 ALTER TABLE `dorm` DISABLE KEYS */;
INSERT INTO `dorm` (`dorm_id`, `dorm_name`, `dormitory_dormitory_id`, `dorm_code`) VALUES (1,'DORM002',NULL,'DORM002'),(2,'DORM003',NULL,'DORM003'),(3,'DORM004',NULL,'DORM004');
/*!40000 ALTER TABLE `dorm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dormitory`
--

DROP TABLE IF EXISTS `dormitory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dormitory` (
  `dormitory_id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitory_name` varchar(255) DEFAULT NULL,
  `dormitory_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dormitory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dormitory`
--

LOCK TABLES `dormitory` WRITE;
/*!40000 ALTER TABLE `dormitory` DISABLE KEYS */;
INSERT INTO `dormitory` (`dormitory_id`, `dormitory_name`, `dormitory_code`) VALUES (1,'DORM001','DORM001');
/*!40000 ALTER TABLE `dormitory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `houseparent`
--

DROP TABLE IF EXISTS `houseparent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `houseparent` (
  `houseparent_id` int(11) NOT NULL AUTO_INCREMENT,
  `houseparent_name` varchar(255) DEFAULT NULL,
  `dormitory_dormitory_id` int(11) DEFAULT NULL,
  `houseparent_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`houseparent_id`),
  KEY `FK79AEF7CA101D7EFF` (`dormitory_dormitory_id`),
  CONSTRAINT `FK79AEF7CA101D7EFF` FOREIGN KEY (`dormitory_dormitory_id`) REFERENCES `dormitory` (`dormitory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `houseparent`
--

LOCK TABLES `houseparent` WRITE;
/*!40000 ALTER TABLE `houseparent` DISABLE KEYS */;
INSERT INTO `houseparent` (`houseparent_id`, `houseparent_name`, `dormitory_dormitory_id`, `houseparent_code`) VALUES (1,'HP001',NULL,'HP001'),(2,'HP002',NULL,'HP002');
/*!40000 ALTER TABLE `houseparent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructor` (
  `instructor_id` int(11) NOT NULL AUTO_INCREMENT,
  `instructor_name` varchar(255) DEFAULT NULL,
  `instructor_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`instructor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` (`instructor_id`, `instructor_name`, `instructor_code`) VALUES (1,'蔡敏仪','I001'),(2,'INS002','INS002');
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `late_return`
--

DROP TABLE IF EXISTS `late_return`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `late_return` (
  `late_return_id` int(11) NOT NULL AUTO_INCREMENT,
  `dorm_name` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `late_return_case` varchar(255) DEFAULT NULL,
  `late_return_time` datetime DEFAULT NULL,
  `student_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`late_return_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `late_return`
--

LOCK TABLES `late_return` WRITE;
/*!40000 ALTER TABLE `late_return` DISABLE KEYS */;
INSERT INTO `late_return` (`late_return_id`, `dorm_name`, `student_name`, `late_return_case`, `late_return_time`, `student_no`) VALUES (1,'A512','麦奇','Test','2019-06-18 00:00:00','201700208524'),(5,'A512','阿姆斯特朗','不知道','2019-06-20 00:00:00','201700208524');
/*!40000 ALTER TABLE `late_return` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(255) DEFAULT NULL,
  `student_no` varchar(255) DEFAULT NULL,
  `student_sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`student_id`, `student_name`, `student_no`, `student_sex`) VALUES (1,'麦奇','201700208524',0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin`
--

DROP TABLE IF EXISTS `sys_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_code` varchar(255) DEFAULT NULL COMMENT '编号',
  `admin_email` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_phone` varchar(255) DEFAULT NULL,
  `admin_sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin`
--

LOCK TABLES `sys_admin` WRITE;
/*!40000 ALTER TABLE `sys_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `href` varchar(255) NOT NULL,
  `spread` tinyint(1) DEFAULT '0',
  `roleType` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`id`, `title`, `icon`, `href`, `spread`, `roleType`) VALUES (1,'学生管理','&#xe630;',' ',0,'1'),(2,'班级管理','&#xe630;',' ',0,'1'),(3,'学院管理','&#xe630;',' ',0,'1'),(4,'宿舍楼管理','&#xe630;',' ',0,'1'),(5,'宿舍管理','&#xe630;',' ',0,'1'),(6,'宿管员管理','&#xe630;',' ',0,'1'),(7,'辅导员管理','&#xe630;',' ',0,'1'),(8,'晚归记录管理','&#xe630;',' ',0,'1'),(9,'晚归记录管理','&#xe630;',' ',0,'2'),(10,'晚归记录管理','&#xe630;',' ',0,'3'),(11,'学生管理','&#xe630;',' ',0,'2');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu_children`
--

DROP TABLE IF EXISTS `sys_menu_children`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu_children` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `href` varchar(255) NOT NULL,
  `spread` tinyint(1) DEFAULT '0',
  `fatherMenu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA8243AED1D1BC4B6` (`fatherMenu_id`),
  CONSTRAINT `FKA8243AED1D1BC4B6` FOREIGN KEY (`fatherMenu_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu_children`
--

LOCK TABLES `sys_menu_children` WRITE;
/*!40000 ALTER TABLE `sys_menu_children` DISABLE KEYS */;
INSERT INTO `sys_menu_children` (`id`, `title`, `icon`, `href`, `spread`, `fatherMenu_id`) VALUES (1,'学生列表','&#xe61c;','/MSOSLE_war/page/system/student/studentList.html',0,1),(2,'班级列表','&#xe61c;','/MSOSLE_war/page/system/class/classList.html',0,2),(3,'学院列表','&#xe61c;','/MSOSLE_war/page/system/colleges/collegesList.html',0,3),(4,'宿舍列表','&#xe61c;','/MSOSLE_war/page/system/dorm/dormList.html',0,4),(5,'宿舍楼管理','&#xe61c;','/MSOSLE_war/page/system/dormitory/dormitoryList.html',0,5),(6,'宿管员列表','&#xe61c;','/MSOSLE_war/page/system/houseparent/houseparentList.html',0,6),(7,'辅导员列表','&#xe61c;','/MSOSLE_war/page/system/instructor/instructorList.html',0,7),(8,'记录列表','&#xe61c;','/MSOSLE_war/page/system/latereturn/latereturnList.html',0,8),(9,'记录列表','&#xe61c;','/MSOSLE_war/page/system/latereturn/latereturnList.html',0,9),(10,'记录列表','&#xe61c;','/MSOSLE_war/page/system/latereturn/latereturnList.html',0,10),(11,'学生列表','&#xe61c;','/MSOSLE_war/page/system/student/studentList.html',0,11);
/*!40000 ALTER TABLE `sys_menu_children` ENABLE KEYS */;
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
  `houseparent_houseparent_id` int(11) DEFAULT NULL,
  `instructor_instructor_id` int(11) DEFAULT NULL,
  `sys_admin_admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK74A81DFD589E37DA` (`houseparent_houseparent_id`),
  KEY `FK74A81DFD5BA70F3` (`instructor_instructor_id`),
  KEY `FK74A81DFDB2D999EA` (`sys_admin_admin_id`),
  CONSTRAINT `FK74A81DFD589E37DA` FOREIGN KEY (`houseparent_houseparent_id`) REFERENCES `houseparent` (`houseparent_id`),
  CONSTRAINT `FK74A81DFD5BA70F3` FOREIGN KEY (`instructor_instructor_id`) REFERENCES `instructor` (`instructor_id`),
  CONSTRAINT `FK74A81DFDB2D999EA` FOREIGN KEY (`sys_admin_admin_id`) REFERENCES `sys_admin` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`user_id`, `login_account`, `login_password`, `user_name`, `role_type`, `user_available`, `houseparent_houseparent_id`, `instructor_instructor_id`, `sys_admin_admin_id`) VALUES (1,'admin','admin','admin',1,1,NULL,NULL,NULL),(2,'HP001','123456','HP001',3,0,NULL,NULL,NULL),(3,'HP002','123456','HP002',3,0,NULL,NULL,NULL),(4,'INS002','123456','INS002',2,0,NULL,NULL,NULL);
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

-- Dump completed on 2019-06-18 14:57:23
