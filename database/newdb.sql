/*
SQLyog Ultimate - MySQL GUI v8.21 
MySQL - 5.5.8-log : Database - xxnation_music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xxnation_music` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `xxnation_music`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `sex` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dob` varchar(30) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `admin` */

insert  into `admin`(`admin_id`,`username`,`password`,`fname`,`lname`,`sex`,`email`,`dob`) values (1,'admin','admin','Administrator','admin','Male','xxnations@gmail.com','1111-11-11');

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `Album_id` int(11) NOT NULL AUTO_INCREMENT,
  `Album_name` varchar(100) NOT NULL,
  `Genre_id` int(11) NOT NULL,
  `Release_date` date DEFAULT NULL,
  `Artist_name` varchar(50) NOT NULL,
  `Album_info` varchar(100) DEFAULT NULL,
  `img_url` varchar(1000) DEFAULT NULL,
  `Featuring_artists` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Album_id`),
  UNIQUE KEY `Album_name` (`Album_name`),
  KEY `genrealbum` (`Genre_id`),
  CONSTRAINT `genrealbum` FOREIGN KEY (`Genre_id`) REFERENCES `genre` (`Genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `album` */

insert  into `album`(`Album_id`,`Album_name`,`Genre_id`,`Release_date`,`Artist_name`,`Album_info`,`img_url`,`Featuring_artists`) values (2,'love ?',3,'2012-02-14','jenifer lopez',' papi,on the floor etc etc','../images/albums/love.jpg','null'),(3,'Femme Fatale',3,'2012-01-01','Briteny Spears',' Its awesome album then her previous..','../images/albums/femalfatale.jpg','null'),(4,'freedom',3,'2012-01-01','akon',' dont matter, right now','../images/albums/akonfreedom.jpg','null'),(5,'Loud',6,'2011-05-04','Rihanna','o na na whats my name ?','../images/albums/rihanna.jpg','null'),(6,'Insomniac',2,'2010-08-04','Enrique Iglesias',' Do you Know?','../images/albums/enrique.jpg','null'),(7,'Teenage Dream',5,'2011-04-07','Katty Pery',' Part of me..wide awake','../images/albums/katty.jpg','null'),(8,'V-Disc',7,'2008-04-02','Louis Jorden',' Is You Is or Is youAint My Baby','../images/albums/jorden.jpg','null'),(9,'Baby Bash',9,'2009-12-09','T-Pain',' Cyclon','../images/albums/tpain.jpg','null');

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `song_id` int(11) DEFAULT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `dat` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `album_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `album_comments` (`album_id`),
  KEY `song_comments` (`song_id`),
  KEY `customercomments` (`user_id`),
  CONSTRAINT `customercomments` FOREIGN KEY (`user_id`) REFERENCES `customer` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `song_comments` FOREIGN KEY (`song_id`) REFERENCES `song` (`song_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

/*Data for the table `comments` */

insert  into `comments`(`comment_id`,`user_id`,`song_id`,`comment`,`dat`,`album_id`) values (16,7,3,'Pop it ..','2012-02-17 10:46:26',2),(18,7,4,'hhhhhhhhhhhmmmmmmmmmmmm\r\n','2012-03-02 13:49:43',2),(20,7,4,'aaaaa','2012-03-09 00:47:00',2),(24,7,4,'KUldeep','2012-03-30 04:21:00',2),(27,7,6,'hgf','2012-04-23 15:24:05',3),(29,7,2,'ravi\r\n','2012-05-08 20:28:03',2),(30,7,8,'Hello','2012-05-22 10:59:27',4),(31,9,8,'This is Demo','2012-05-22 11:38:03',4),(32,9,2,'on the floor','2012-05-22 11:56:43',2);

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `counter_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `counter` int(11) DEFAULT '0',
  `valid_upto` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`counter_id`),
  KEY `FK_counter` (`user_id`),
  CONSTRAINT `FK_counter` FOREIGN KEY (`user_id`) REFERENCES `customer` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `counter` */

insert  into `counter`(`counter_id`,`user_id`,`counter`,`valid_upto`) values (1,7,13508,'2019-11-22 22:27:12'),(3,9,5444,'2013-10-19 05:17:01'),(4,10,4450,'2013-07-11 10:11:02'),(8,14,4448,'2013-09-13 21:41:17'),(9,15,3050,'2013-03-07 18:20:43');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`user_id`,`username`,`password`,`first_name`,`last_name`,`sex`,`dob`,`city`,`email`) values (7,'a','a','a','a','Female','1111-11-11','a','xxnations@gmail.com'),(9,'b','b','b','b','Male','1111-11-11','ahmedabad','vivek@gmail.com'),(10,'rutu','qwerty','RUTVI','sheth','Female','19991-04-29','ahmedabad','rutvis0@gmail.com'),(14,'miller','miller','roy','miller','Female','1990-12-28','ahmedabad','atulzalavadiya007@gmail.com'),(15,'f','f','f','f','Female','2012-12-12','f','patelshaishav@hotmail.com');

/*Table structure for table `customer_temp` */

DROP TABLE IF EXISTS `customer_temp`;

CREATE TABLE `customer_temp` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `kcode` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `customer_temp` */

/*Table structure for table `downloadhistory` */

DROP TABLE IF EXISTS `downloadhistory`;

CREATE TABLE `downloadhistory` (
  `download_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `dtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `song_name` varchar(100) DEFAULT NULL,
  `url` varchar(1000) NOT NULL,
  PRIMARY KEY (`download_id`),
  KEY `FK_downloadhistory` (`user_id`),
  CONSTRAINT `FK_downloadhistory` FOREIGN KEY (`user_id`) REFERENCES `customer` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=latin1;

/*Data for the table `downloadhistory` */

insert  into `downloadhistory`(`download_id`,`user_id`,`dtime`,`song_name`,`url`) values (1,7,'2012-02-05 04:27:31','zara','www.google.com'),(2,7,'2012-02-05 04:30:40','tara','www.google.com'),(3,7,'2012-02-07 23:33:51','mara','www.google.com'),(4,7,'2012-02-07 23:34:30','kara','www.google.com'),(5,7,'2012-02-09 02:44:30','Senorita','www.google.com'),(6,7,'2012-02-09 02:46:06','Senorita','www.google.com'),(7,7,'2012-02-09 02:46:27','Senorita','www.google.com'),(8,7,'2012-02-10 04:56:49','Senorita','www.google.com'),(9,7,'2012-02-10 19:06:54','Senorita','www.google.com'),(10,7,'2012-02-11 18:46:00','Senorita','www.google.com'),(11,7,'2012-02-11 19:46:49','Senorita','www.google.com'),(12,7,'2012-02-11 20:00:53','Senorita','www.google.com'),(13,7,'2012-02-12 04:31:58','Senorita','http://www.xxnations.com/downloadqueue.do?k=-8947091149323463566&sname=Senorita'),(14,7,'2012-02-12 04:58:13','Senorita','http://www.xxnations.com/downloadqueue.do?k=-664203933256349730&sname=Senorita'),(15,7,'2012-02-12 05:00:01','Senorita','http://www.xxnations.com/downloadqueue.do?k=-7442899261974405356&sname=Senorita'),(16,7,'2012-02-12 05:05:55','Senorita','http://www.xxnations.com/downloadqueue.do?k=-6153824204667541651&sname=Senorita'),(17,7,'2012-02-12 05:08:27','Senorita','http://www.xxnations.com/downloadqueue.do?k=-5599300099085532813&sname=Senorita'),(18,7,'2012-02-12 05:11:40','Senorita','http://www.xxnations.com/downloadqueue.do?k=-2649634477983891974&sname=Senorita'),(19,7,'2012-02-12 13:58:25','Senorita','http://www.xxnations.com/downloadqueue.do?k=4884494522410994326&sname=Senorita'),(20,7,'2012-02-13 21:04:41','Senorita','http://www.xxnations.com/downloadqueue.do?k=3908161379109334626&sname=Senorita'),(21,7,'2012-02-13 21:05:10','Senorita','http://www.xxnations.com/downloadqueue.do?k=7241944927986023533&sname=Senorita'),(22,7,'2012-02-13 21:05:48','Senorita','http://www.xxnations.com/downloadqueue.do?k=7322157705226154969&sname=Senorita'),(23,7,'2012-02-13 21:07:18','Senorita','http://www.xxnations.com/downloadqueue.do?k=2190455064531171140&sname=Senorita'),(24,7,'2012-02-13 22:09:25','Senorita','http://www.xxnations.com/downloadqueue.do?k=3033728303087468968&sname=Senorita'),(25,7,'2012-02-14 15:23:02','Senorita','http://www.xxnations.com/downloadqueue.do?k=-4077264651326899286&sname=Senorita'),(26,7,'2012-02-14 22:27:45','Senorita','http://www.xxnations.com/downloadqueue.do?k=-7491907167526105906&sname=Senorita'),(27,7,'2012-02-15 00:36:29','Senorita','http://www.xxnations.com/downloadqueue.do?k=-3154671684131827525&sname=Senorita'),(28,7,'2012-02-15 04:37:20','Senorita','http://www.xxnations.com/downloadqueue.do?k=5234467818874947609&sname=Senorita'),(29,7,'2012-02-16 00:32:18','Senorita','http://www.xxnations.com/downloadqueue.do?k=2577497258547601020&sname=Senorita'),(30,7,'2012-02-15 16:16:40','Senorita','http://www.xxnations.com/downloadqueue.do?k=-249597090992138755&sname=Senorita'),(31,7,'2012-02-15 16:41:26','Senorita','http://www.xxnations.com/downloadqueue.do?k=4904956380535382518&sname=Senorita'),(32,7,'2012-02-15 16:52:49','Senorita','http://www.xxnations.com/downloadqueue.do?k=-918010014733716869&sname=Senorita'),(33,7,'2012-02-15 16:58:39','Senorita','http://www.xxnations.com/downloadqueue.do?k=3745943980922668922&sname=Senorita'),(34,7,'2012-02-15 17:13:21','Senorita','http://www.xxnations.com/downloadqueue.do?k=2725061122076272950&sname=Senorita'),(35,7,'2012-02-16 00:31:42','Senorita','http://www.xxnations.com/downloadqueue.do?k=-3187260189646970828&sname=Senorita'),(36,7,'2012-02-16 02:04:20','Senorita','http://www.xxnations.com/downloadqueue.do?k=1273355801055550623&sname=Senorita'),(37,7,'2012-02-16 02:04:30','Senorita','http://www.xxnations.com/downloadqueue.do?k=-3736080706155303311&sname=Senorita'),(38,7,'2012-02-16 02:40:18','Senorita','http://www.xxnations.com/downloadqueue.do?k=7161143555251739956&sname=Senorita'),(39,7,'2012-02-16 05:00:34','Senorita','http://www.xxnations.com/downloadqueue.do?k=-7697188566025222412&sname=Senorita'),(40,7,'2012-02-16 06:43:15','Senorita','http://www.xxnations.com/downloadqueue.do?k=4440741541710197476&sname=Senorita'),(41,7,'2012-02-16 11:45:03','Senorita','http://www.xxnations.com/downloadqueue.do?k=5474675975824701191&sname=Senorita'),(42,7,'2012-02-16 16:51:56','Senorita','http://www.xxnations.com/downloadqueue.do?k=1313697948106148227&sname=Senorita'),(43,7,'2012-02-16 17:04:10','Senorita','http://www.xxnations.com/downloadqueue.do?k=4063442038941087719&sname=Senorita'),(44,7,'2012-02-17 03:41:07','Senorita','http://www.xxnations.com/downloadqueue.do?k=-4252995571578958853&sname=Senorita'),(45,7,'2012-02-17 09:03:51','Senorita','http://www.xxnations.com/downloadqueue.do?k=-8971527315806650126&sname=Senorita'),(46,7,'2012-02-17 09:24:58','Senorita','http://www.xxnations.com/downloadqueue.do?k=-1554293311640280802&sname=Senorita'),(47,7,'2012-02-17 10:13:36','on the floor','http://www.xxnations.com/downloadqueue.do?k=1301220879283763949&sname=on the floor'),(48,7,'2012-02-17 10:14:03','on the floor','http://www.xxnations.com/downloadqueue.do?k=-3520405931219361443&sname=on the floor'),(49,7,'2012-02-17 10:15:58','Criminal','http://www.xxnations.com/downloadqueue.do?k=1523636434531576571&sname=Criminal'),(50,7,'2012-02-17 10:38:39','Criminal','http://www.xxnations.com/downloadqueue.do?k=2589646574657663683&sname=Criminal'),(51,7,'2012-02-17 10:43:58','Papi','http://www.xxnations.com/downloadqueue.do?k=8625975411873971017&sname=Papi'),(52,7,'2012-02-17 11:11:09','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=-4466070053172333872&sname=Till The Worlds End'),(53,7,'2012-02-17 11:20:47','Senorita','http://www.xxnations.com/downloadqueue.do?k=4818211498882025444&sname=Senorita'),(54,7,'2012-02-29 07:18:04','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=2628711324915348395&sname=Till The Worlds End'),(55,7,'2012-02-29 11:41:06','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=-1152591152347610158&sname=Till The Worlds End'),(56,7,'2012-02-29 11:45:17','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=3758420552784268772&sname=Till The Worlds End'),(57,7,'2012-03-02 04:44:19','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=2470704485582190066&sname=Till The Worlds End'),(58,7,'2012-03-02 08:23:56','Papi','http://www.xxnations.com/downloadqueue.do?k=-3111853436476017452&sname=Papi'),(59,7,'2012-03-02 13:46:26','on the floor','http://www.xxnations.com/downloadqueue.do?k=93099959842100723&sname=on the floor'),(60,7,'2012-03-02 13:46:34','on the floor','http://www.xxnations.com/downloadqueue.do?k=-4272182336370152037&sname=on the floor'),(61,7,'2012-03-03 06:32:50','Senorita','http://www.xxnations.com/downloadqueue.do?k=8638469702254492183&sname=Senorita'),(62,7,'2012-03-03 07:45:26','on the floor','http://www.xxnations.com/downloadqueue.do?k=-3525969538241748386&sname=on the floor'),(63,7,'2012-03-03 07:46:10','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=-7460756100975535505&sname=Till The Worlds End'),(64,7,'2012-03-04 12:16:54','Senorita','http://www.xxnations.com/downloadqueue.do?k=-2177418835793542352&sname=Senorita'),(65,7,'2012-03-07 03:25:14','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=-235536745454134079&sname=Till The Worlds End'),(66,7,'2012-03-07 03:34:13','Senorita','http://www.xxnations.com/downloadqueue.do?k=-6494122880006654661&sname=Senorita'),(67,7,'2012-03-09 00:31:49','Senorita','http://www.xxnations.com/downloadqueue.do?k=-4510657068477977433&sname=Senorita'),(68,7,'2012-03-09 00:42:31','Senorita','http://www.xxnations.com/downloadqueue.do?k=-2746905558019639260&sname=Senorita'),(69,7,'2012-03-09 00:44:38','Senorita','http://www.xxnations.com/downloadqueue.do?k=-4313246612153722032&sname=Senorita'),(70,9,'2012-03-09 00:52:16','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=-8233860891620748764&sname=Till The Worlds End'),(71,9,'2012-03-09 00:57:34','Papi','http://www.xxnations.com/downloadqueue.do?k=-1889899022240950384&sname=Papi'),(72,7,'2012-03-30 05:40:09','Criminal','http://www.xxnations.com/downloadqueue.do?k=4514353568499619541&sname=Criminal'),(73,7,'2012-03-31 22:10:12','Till The Worlds End','http://www.xxnations.com/downloadqueue.do?k=-7963096587674207371&sname=Till The Worlds End'),(74,7,'2012-04-03 03:21:16','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=-1634745236868271292&sname=I Wanna Go'),(75,7,'2012-04-03 20:36:31','Criminal','/downloadqueue.do?k=-8661326754231399433&sname=Criminal'),(76,7,'2012-04-03 20:37:03','Criminal','/downloadqueue.do?k=-9036738902433363102&sname=Criminal'),(77,7,'2012-04-03 20:39:05','Till The Worlds End','http://localhost:8080/download_qr.do/downloadqueue.do?k=3169074818945075511&sname=Till The Worlds End'),(78,7,'2012-04-03 20:40:16','Till The Worlds End','http://localhost:8080/download_qr.do/downloadqueue.do?k=216099352983484152&sname=Till The Worlds End'),(79,7,'2012-04-03 20:40:45','Till The Worlds End','null/downloadqueue.do?k=215509672959390602&sname=Till The Worlds End'),(80,7,'2012-04-03 20:42:53','Till The Worlds End','127.0.0.1/downloadqueue.do?k=1350021854158714330&sname=Till The Worlds End'),(81,7,'2012-04-03 20:45:04','Till The Worlds End','localhost:8080/downloadqueue.do?k=4666531069919109836&sname=Till The Worlds End'),(82,7,'2012-04-03 20:46:30','Till The Worlds End','http://localhost:8080/downloadqueue.do?k=2166262022779179176&sname=Till The Worlds End'),(83,7,'2012-04-03 20:59:14','Senorita','http://localhost:8080http://www.xxnations.com/downloadqueue.do?k=-893474559735399282&sname=Senorita'),(84,7,'2012-04-03 21:01:02','Till The Worlds End','http://localhost:8080/downloadqueue.do?k=-6048580430295422968&sname=Till The Worlds End'),(85,7,'2012-04-07 23:12:19','Senorita','http://localhost:8080/downloadqueue.do?k=-3292342802276786855&sname=Senorita'),(86,7,'2012-04-11 01:54:18','on the floor','http://localhost:8080http://www.xxnations.com/downloadqueue.do?k=6675512426322245011&sname=on the floor'),(87,7,'2012-04-11 01:54:20','on the floor','http://localhost:8080http://www.xxnations.com/downloadqueue.do?k=7033108857179851113&sname=on the floor'),(88,7,'2012-04-11 01:57:19','Till The Worlds End','http://localhost:8080/downloadqueue.do?k=-6598752557969428043&sname=Till The Worlds End'),(89,7,'2012-04-11 02:01:34','on the floor','http://localhost:8080/downloadqueue.do?k=964655390366150718&sname=on the floor'),(90,7,'2012-04-11 23:11:27','Till The Worlds End','http://localhost:8080/downloadqueue.do?k=-3290866929720884100&sname=Till The Worlds End'),(91,14,'2012-04-21 21:47:07','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=4627825906756635984&sname=I Wanna Go'),(92,14,'2012-04-22 14:16:42','Senorita','http://www.xxnations.com/downloadqueue.do?k=8134847046794045549&sname=Senorita'),(93,7,'2012-04-23 15:28:06','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=2068196056877113951&sname=I Wanna Go'),(94,7,'2012-04-23 15:28:19','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=-3979741256150109634&sname=I Wanna Go'),(95,7,'2012-04-29 21:59:30','I Wanna Go','http://xxnations.com/downloadqueue.do?k=8161844218862254470&sname=I Wanna Go'),(96,7,'2012-05-01 17:21:03','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=-8668909051108317526&sname=I Wanna Go'),(97,9,'2012-05-05 20:45:09','Senorita','http://www.xxnations.com/downloadqueue.do?k=111372951533763778&sname=Senorita'),(98,9,'2012-05-05 20:47:09','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=-3192019243606503317&sname=I Wanna Go'),(99,7,'2012-05-08 20:26:42','on the floor','http://www.xxnations.com/downloadqueue.do?k=-5312872996690155341&sname=on the floor'),(100,7,'2012-05-22 10:59:43','Beautiful','http://www.xxnations.com/downloadqueue.do?k=1735617144101146850&sname=Beautiful'),(101,9,'2012-05-22 11:38:13','Beautiful','http://xxnations.com/downloadqueue.do?k=-4688019934270024422&sname=Beautiful'),(102,7,'2012-05-22 11:51:21','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=1381638509393480781&sname=I Wanna Go'),(103,7,'2012-05-22 11:52:27','I Wanna Go','http://www.xxnations.com/downloadqueue.do?k=-3713977383534335417&sname=I Wanna Go'),(104,9,'2012-05-22 11:56:53','on the floor','http://xxnations.com/downloadqueue.do?k=7101697352248552124&sname=on the floor'),(105,7,'2012-05-22 12:07:18','on the floor','http://xxnations.com/downloadqueue.do?k=-5376722462441903150&sname=on the floor');

/*Table structure for table `genre` */

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
  `Genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `Genre` varchar(50) NOT NULL,
  PRIMARY KEY (`Genre_id`),
  UNIQUE KEY `Genre` (`Genre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `genre` */

insert  into `genre`(`Genre_id`,`Genre`) values (7,'blues'),(9,'electromix'),(8,'folk'),(5,'hip-hop'),(2,'jazz'),(3,'pop'),(6,'rock'),(12,'vocal');

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `invoice_number` bigint(100) NOT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

/*Data for the table `invoice` */

insert  into `invoice`(`invoice_id`,`user_id`,`invoice_number`,`amount`) values (3,7,-6382978346062750670,20),(4,7,-468756011256142122,5),(5,7,-99608842986754335,20),(6,7,6350530823717718120,20),(7,7,-1124251438719505962,20),(8,7,2411055343358448488,20),(9,7,3369579759923027332,20),(10,7,-2342271675558606263,12),(11,7,-2751800711100349239,12),(12,7,-2907454889520332243,12),(13,7,-7563684369273514786,12),(14,7,5636801053398601571,12),(15,7,2489625309788441405,12),(16,7,5407062997993618880,12),(19,8,-3510751532366280249,10.99),(20,8,613987308060141963,10.99),(21,8,-340994681480896228,5),(22,7,-9054036544642341860,12),(24,7,-7975107180331371347,12),(27,7,291103306759528018,5),(28,7,1626590615376193276,5),(29,7,-217981354915376078,5),(30,7,2892786150006065414,5),(31,7,-1840409143469765877,10.99),(32,14,3508384265164883922,10.99),(33,14,-6483982147456962076,10.99),(34,14,-7086219579615627555,10.99),(35,14,1846456135281538732,12),(37,7,-316757517894617949,5),(41,7,-2631000057196008140,12);

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `status` varchar(50) NOT NULL DEFAULT 'false',
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`user_id`,`user_name`,`password`,`status`,`email`) values (7,'a','a','true','xxnations@gmail.com'),(9,'b','b','true','vivek@gmail.com'),(10,'rutu','qwerty','true','rutvis0@gmail.com'),(14,'miller','miller','true','atulzalavadiya007@gmail.com'),(15,'f','f','true','patelshaishav@hotmail.com');

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `paymentdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` float NOT NULL,
  `valid_upto` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `no_of_songs` int(11) NOT NULL,
  `plan_name` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `customerpayment` (`user_id`),
  CONSTRAINT `customerpayment` FOREIGN KEY (`user_id`) REFERENCES `customer` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `payment` */

insert  into `payment`(`payment_id`,`user_id`,`name`,`paymentdate`,`amount`,`valid_upto`,`no_of_songs`,`plan_name`,`city`,`email`) values (4,7,'Joe Bloggs','2012-02-07 22:24:46',10,'2012-02-07 22:25:03',10,'b','a','a'),(5,7,'Joe Bloggs','2012-02-07 22:26:46',10,'2012-05-17 20:26:46',400,'B','Made Up City','joe.bloggs@atsomewebsite.com'),(6,7,'Joe Bloggs','2012-02-07 22:30:35',10,'2012-05-17 20:30:35',400,'B','Made Up City','joe.bloggs@atsomewebsite.com'),(7,7,'Joe Bloggs','2012-02-07 22:55:31',10,'2012-05-17 20:55:31',400,'B','Made Up City','joe.bloggs@atsomewebsite.com'),(8,7,'Joe Bloggs','2012-02-09 21:56:45',5,'2012-02-19 21:56:45',50,'A','Made Up City','joe.bloggs@atsomewebsite.com'),(9,7,'Test User','2012-02-16 01:13:31',12,'2012-05-25 23:13:31',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(10,7,'Test User','2012-02-16 01:17:20',12,'2012-05-25 23:17:20',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(11,7,'Test User','2012-02-16 04:55:49',12,'2012-05-26 02:55:49',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(12,7,'Test User','2012-02-16 05:02:39',12,'2012-05-26 03:02:39',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(13,7,'Test User','2012-02-16 17:00:40',12,'2012-05-26 15:00:40',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(14,7,'Test User','2012-02-17 07:00:03',12,'2012-05-27 05:00:03',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(15,9,'Test User','2012-02-17 07:19:57',12,'2012-05-27 05:19:57',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(16,14,'Test User','2012-04-21 21:43:01',10.99,'2012-07-30 21:43:01',400,'B','San Jose','xxnati_1326017502_per@gmail.com'),(17,14,'Test User','2012-04-22 01:33:59',12,'2012-07-31 01:33:59',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(18,7,'Test User','2012-05-22 11:03:33',12,'2012-08-30 11:03:33',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(19,9,'Test User','2012-05-22 11:40:13',5,'2012-06-01 11:40:13',50,'A','San Jose','xxnati_1326017502_per@gmail.com'),(20,9,'Test User','2012-05-22 11:55:41',12,'2012-08-30 11:55:41',1000,'C','San Jose','xxnati_1326017502_per@gmail.com'),(21,7,'Test User','2012-05-22 12:12:03',12,'2012-08-30 12:12:03',1000,'C','San Jose','xxnati_1326017502_per@gmail.com');

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `planid` int(11) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(50) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `no_of_songs` int(11) DEFAULT NULL,
  PRIMARY KEY (`planid`),
  UNIQUE KEY `amount` (`amount`),
  UNIQUE KEY `plan_name` (`plan_name`),
  UNIQUE KEY `plan_name_2` (`plan_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `plan` */

insert  into `plan`(`planid`,`plan_name`,`amount`,`duration`,`no_of_songs`) values (2,'A','5.00',10,50),(3,'B','10.99',100,400),(4,'C','12.00',100,1000);

/*Table structure for table `rating` */

DROP TABLE IF EXISTS `rating`;

CREATE TABLE `rating` (
  `rating_id` int(11) NOT NULL AUTO_INCREMENT,
  `song_id` int(11) DEFAULT NULL,
  `rating` float DEFAULT '2.5',
  `album_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rating_id`),
  KEY `album_rating` (`album_id`),
  KEY `song_rating` (`song_id`),
  CONSTRAINT `song_rating` FOREIGN KEY (`song_id`) REFERENCES `song` (`song_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `rating` */

insert  into `rating`(`rating_id`,`song_id`,`rating`,`album_id`) values (2,2,4.6,2),(3,3,2,2),(4,4,1.8,2),(5,5,4.7,3),(6,6,4.3,3),(7,7,4.8,3),(8,8,3.8,4),(9,9,2.5,4),(10,10,2.5,5),(11,11,2.5,5),(12,12,2.5,5),(13,13,2.5,6),(14,14,2.5,6),(15,15,2.5,7),(16,16,2.5,7),(17,17,2.5,8),(18,18,2.5,8),(19,19,2.5,8),(20,20,2.5,9);

/*Table structure for table `request` */

DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (
  `request_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `album` varchar(50) DEFAULT NULL,
  `song` varchar(50) DEFAULT NULL,
  `rtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`),
  KEY `customerrequest` (`user_id`),
  CONSTRAINT `customerrequest` FOREIGN KEY (`user_id`) REFERENCES `customer` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

/*Data for the table `request` */

insert  into `request`(`request_id`,`user_id`,`username`,`album`,`song`,`rtime`) values (9,7,'a','femme fatal','till the world ends','2012-02-16 00:29:57'),(11,9,'b','ala carte','','2012-02-17 07:21:28'),(12,7,'a','papi','love','2012-05-08 20:28:34');

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `song_id` int(11) NOT NULL AUTO_INCREMENT,
  `Album_id` int(11) NOT NULL,
  `song_name` varchar(100) NOT NULL,
  `song_url` varchar(1000) NOT NULL,
  `Artist_name` varchar(50) NOT NULL,
  `bitrate` int(11) DEFAULT NULL,
  `frequency` int(11) DEFAULT NULL,
  `Genre_id` int(11) NOT NULL,
  `duration` varchar(50) DEFAULT NULL,
  `len` int(50) DEFAULT NULL,
  `demo_url` varchar(1000) NOT NULL,
  `release_year` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`song_id`),
  KEY `album_song` (`Album_id`),
  KEY `genresong` (`Genre_id`),
  CONSTRAINT `album_song` FOREIGN KEY (`Album_id`) REFERENCES `album` (`Album_id`) ON DELETE CASCADE,
  CONSTRAINT `genresong` FOREIGN KEY (`Genre_id`) REFERENCES `genre` (`Genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `song` */

insert  into `song`(`song_id`,`Album_id`,`song_name`,`song_url`,`Artist_name`,`bitrate`,`frequency`,`Genre_id`,`duration`,`len`,`demo_url`,`release_year`) values (2,2,'on the floor','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','Jenifer Lopez',120,44,3,'4:0',9,'http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','2011-02-17'),(3,2,'Papi','http://www.woo55.com/adata/7145/01%20Jennifer%20Lopez%20-%20Papi%20(www.SongsLover.com).mp3','Jenifer Lopez',180,44,3,'4:13',7,'http://www.woo55.com/adata/7145/01%20Jennifer%20Lopez%20-%20Papi%20(www.SongsLover.com).mp3','2011-02-17'),(4,2,'Good HIt','http://mp3.zing.vn/download/song/Good-Hit-Jennifer-Lopez/ZnJGyLnNVJdsNCJyZbcybGLm','Jenifer Lopez',120,44,3,'3.53',3,'http://mp3.zing.vn/download/song/Good-Hit-Jennifer-Lopez/ZnJGyLnNVJdsNCJyZbcybGLm','2011-02-17'),(5,3,'Till The Worlds End','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','Briteny',180,44,3,'4.12',9,'http://www.woo55.com/adata/6812/01%20Till%20The%20World%20Ends%20-%20(www.SongsLover.com).mp3','2011-02-17'),(6,3,'I Wanna Go','http://www.woo55.com/adata/6815/04%20I%20Wanna%20Go%20-%20(www.SongsLover.com).mp3','Briteny',180,44,3,'4.53',8,'http://www.woo55.com/adata/6815/04%20I%20Wanna%20Go%20-%20(www.SongsLover.com).mp3','2012-01-01'),(7,3,'Criminal','http://s1.radio.ge/Music/Britney%20Spears/2011_Femme_Fatale/12%20Criminal.mp3','Briteny',180,44,3,'4.43',10,'http://www.woo55.com/adata/6806/12%20Criminal%20-%20(www.SongsLover.com).mp3','2012-01-01'),(8,4,'Beautiful','http://postmusic.org/wordpress/wp-content/uploads/2009/06/akon-so-damn-beautiful-viking-remix.mp3','akon',128,44,3,'5;19',5,'http://postmusic.org/wordpress/wp-content/uploads/2009/06/akon-so-damn-beautiful-viking-remix.mp3','2012-01-01'),(9,4,'I Wanna Love You','http://m0.li.ru/b/1/mp3/8/25269/252698_akon__i_wanna_love_you_feat._snoop_dogg.mp3','akon',128,44,3,'5:29',5,'http://m0.li.ru/b/1/mp3/8/25269/252698_akon__i_wanna_love_you_feat._snoop_dogg.mp3','2012-01-01'),(10,5,'whats my name','http://mp3.wapos.ru/base/0/3/3/195/wapos84327.mp3','Rihanna',128,44,6,'4:17',4,'http://mp3.wapos.ru/base/0/3/3/195/wapos84327.mp3','2011-05-04'),(11,5,'only girl in the world','http://cdn3.mixcrate.com/files/music/35482-Bwd8tw7y.mp3','Rihanna',128,44,6,'5:13',12,'http://cdn3.mixcrate.com/files/music/35482-Bwd8tw7y.mp3','2011-05-04'),(12,5,'love the way you lie','http://3f.media.v4.skyrock.net/music/3f3/9f5/3f39f521ae320f325c9e89f0c403fa8c.mp3','Rihanna',128,44,6,'4:17',4,'http://3f.media.v4.skyrock.net/music/3f3/9f5/3f39f521ae320f325c9e89f0c403fa8c.mp3','2011-05-04'),(13,6,'Do You Know?','http://members.shaw.ca/cuong123/Enrique%20Iglesias%20-%20Do%20You%20Know.mp3','Enrique',128,44,2,'3:40',9,'http://members.shaw.ca/cuong123/Enrique%20Iglesias%20-%20Do%20You%20Know.mp3','2010-08-04'),(14,6,'Somebody\'s me','http://mytopclip.com/uploads/audio/yiaLD20AKpVFmIC3GQVl.mp3','Enrique',128,44,2,'4:00',6,'http://mytopclip.com/uploads/audio/yiaLD20AKpVFmIC3GQVl.mp3','2010-08-04'),(15,7,'Wide Awake','http://www.woo55.com/adata/10948/Katy%20Perry%20-%20Wide%20Awake%20%28www.SongsLover.com%29.mp3','Katty',128,44,5,'4:29',5,'http://www.woo55.com/adata/10948/Katy%20Perry%20-%20Wide%20Awake%20%28www.SongsLover.com%29.mp3','2011-04-07'),(16,7,'Part of Me','http://dl1.ka4ka.ru/d0/music/30/54/461993_64.mp3','Katty',128,44,5,'3:27',2,'http://dl1.ka4ka.ru/d0/music/30/54/461993_64.mp3','2011-04-07'),(17,8,' Is You Is Or Is You Ain\'t My Baby ','http://www.africanafrican.com/negroartist/mp3/louis%20jordan/V-D158B1.mp3','Louis',128,44,7,'2:32',6,'http://www.africanafrican.com/negroartist/mp3/louis%20jordan/V-D158B1.mp3','2008-04-02'),(18,8,'Trick Me','http://img.crazys.info/files/music/2007.9/kelis_trick_me.mp3','Louis',128,44,7,'3:26',5,'http://img.crazys.info/files/music/2007.9/kelis_trick_me.mp3','2008-04-02'),(19,8,'Bounce','http://www.theburningear.com/media/2011/06/Calvin-Harris-Feat.-Kelis-Bounce.mp3','Louis',128,44,7,'3:00',4,'http://www.theburningear.com/media/2011/06/Calvin-Harris-Feat.-Kelis-Bounce.mp3','2008-04-02'),(20,9,'Cyclone','http://hits.mpeg-search.com/Songs/361560/8b4850255ef25a6e420d497f955c62ee/Baby%20Bash%20Featuring%20T%20Pain-Cyclone.mp3','T-Pain',128,44,9,'3:42',5,'http://hits.mpeg-search.com/Songs/361560/8b4850255ef25a6e420d497f955c62ee/Baby%20Bash%20Featuring%20T%20Pain-Cyclone.mp3','2009-12-09');

/*Table structure for table `temp` */

DROP TABLE IF EXISTS `temp`;

CREATE TABLE `temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `k` varchar(50) DEFAULT NULL,
  `url` varchar(1000) NOT NULL,
  `size` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

/*Data for the table `temp` */

insert  into `temp`(`id`,`user_id`,`k`,`url`,`size`) values (1,7,'4729795030787531037','http://elarci.wen9.org/Mp3/1/AkonDont-Matter.mp3',NULL),(2,7,'-6853635729857813267','http://elarci.wen9.org/Mp3/1/AkonDont-Matter.mp3',NULL),(4,7,'-785725581007242844','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3',NULL),(5,7,'-6245400972462794879','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3',NULL),(6,7,'-3305563096259686693','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3',NULL),(7,7,'-8864314102011055268','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3',NULL),(8,7,'4344598233938208581','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3',NULL),(9,7,'-8947091149323463566','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3',NULL),(10,7,'3908161379109334626','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(11,7,'7241944927986023533','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(12,7,'7322157705226154969','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(13,7,'2190455064531171140','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(14,7,'3033728303087468968','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(15,7,'-4077264651326899286','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(16,7,'-7491907167526105906','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(17,7,'-3154671684131827525','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(18,7,'5234467818874947609','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(19,7,'2577497258547601020','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(20,7,'-249597090992138755','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(21,7,'4904956380535382518','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(26,7,'1273355801055550623','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(28,7,'4063442038941087719','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(29,7,'-4252995571578958853','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(30,7,'-8971527315806650126','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(31,7,'-1554293311640280802','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(33,7,'-3520405931219361443','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9'),(34,7,'1523636434531576571','http://www.woo55.com/adata/6806/12%20Criminal%20-%20(www.SongsLover.com).mp3','10'),(36,7,'-1152591152347610158','http://www.woo55.com/adata/6812/01%20Till%20The%20World%20Ends%20-%20(www.SongsLover.com).mp3','9'),(37,7,'2470704485582190066','http://www.woo55.com/adata/6812/01%20Till%20The%20World%20Ends%20-%20(www.SongsLover.com).mp3','9'),(38,7,'-3111853436476017452','http://www.woo55.com/adata/7145/01%20Jennifer%20Lopez%20-%20Papi%20(www.SongsLover.com).mp3','7'),(39,7,'93099959842100723','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9'),(40,7,'-4272182336370152037','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9'),(41,7,'8638469702254492183','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(42,7,'-235536745454134079','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(43,7,'-6494122880006654661','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(44,7,'-4510657068477977433','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(46,7,'-4313246612153722032','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(47,7,'4514353568499619541','http://s1.radio.ge/Music/Britney%20Spears/2011_Femme_Fatale/12%20Criminal.mp3','10'),(48,7,'-7963096587674207371','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(49,7,'-8661326754231399433','http://s1.radio.ge/Music/Britney%20Spears/2011_Femme_Fatale/12%20Criminal.mp3','10'),(50,7,'-9036738902433363102','http://s1.radio.ge/Music/Britney%20Spears/2011_Femme_Fatale/12%20Criminal.mp3','10'),(51,7,'3169074818945075511','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(52,7,'216099352983484152','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(53,7,'215509672959390602','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(54,7,'1350021854158714330','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(55,7,'4666531069919109836','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(56,7,'2166262022779179176','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(57,7,'-893474559735399282','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(58,7,'-3292342802276786855','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(59,7,'6675512426322245011','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9'),(62,7,'964655390366150718','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9'),(63,7,'-3290866929720884100','http://34.media.v4.skyrock.net/music/34f/654/34f6549b9d6f8acf9eb037a9636ccbfc.mp3','9'),(65,14,'8134847046794045549','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(67,7,'-3979741256150109634','http://www.woo55.com/adata/6815/04%20I%20Wanna%20Go%20-%20(www.SongsLover.com).mp3','8'),(68,7,'8161844218862254470','http://www.woo55.com/adata/6815/04%20I%20Wanna%20Go%20-%20(www.SongsLover.com).mp3','8'),(70,9,'111372951533763778','http://sound25.mp3pk.com/indian/zindaginamilegidobara/zindagi-na-milegi-dobara04%28www.songs.pk%29.mp3','10'),(72,7,'-5312872996690155341','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9'),(73,7,'1735617144101146850','http://postmusic.org/wordpress/wp-content/uploads/2009/06/akon-so-damn-beautiful-viking-remix.mp3','5'),(74,9,'-4688019934270024422','http://postmusic.org/wordpress/wp-content/uploads/2009/06/akon-so-damn-beautiful-viking-remix.mp3','5'),(75,7,'1381638509393480781','http://www.woo55.com/adata/6815/04%20I%20Wanna%20Go%20-%20(www.SongsLover.com).mp3','8'),(76,7,'-3713977383534335417','http://www.woo55.com/adata/6815/04%20I%20Wanna%20Go%20-%20(www.SongsLover.com).mp3','8'),(77,9,'7101697352248552124','http://www.woo55.com/adata/7281/01.%20On%20The%20Floor%20(Ft.%20Pitbull)%20(www.SongsLover.com).mp3','9');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
