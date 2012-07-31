/*
SQLyog - Free MySQL GUI v5.19
Host - 5.5.23 : Database - icm
*********************************************************************
Server version : 5.5.23
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `icm`;

USE `icm`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `admin_master` */

DROP TABLE IF EXISTS `admin_master`;

CREATE TABLE `admin_master` (
  `adminUserId` int(11) NOT NULL AUTO_INCREMENT,
  `adminPassword` varchar(100) NOT NULL,
  `adminUserName` varchar(100) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`adminUserId`),
  UNIQUE KEY `adminUserId` (`adminUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_master` */

/*Table structure for table `article_master` */

DROP TABLE IF EXISTS `article_master`;

CREATE TABLE `article_master` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `article` longtext NOT NULL,
  `dateadded` datetime NOT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `languageId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`articleId`),
  UNIQUE KEY `articleId` (`articleId`),
  KEY `FKBBC7F9CB60096417` (`languageId`),
  KEY `FKBBC7F9CB5B2CD6FD` (`userId`),
  CONSTRAINT `FKBBC7F9CB5B2CD6FD` FOREIGN KEY (`userId`) REFERENCES `user_master` (`userId`),
  CONSTRAINT `FKBBC7F9CB60096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_master` */

/*Table structure for table `audio_master` */

DROP TABLE IF EXISTS `audio_master`;

CREATE TABLE `audio_master` (
  `id` int(11) NOT NULL,
  `album` varchar(100) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `purchaseInfo` longtext,
  `thumbnail` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK9F36AEEB60096417` (`languageId`),
  CONSTRAINT `FK9F36AEEB60096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `audio_master` */

insert into `audio_master` (`id`,`album`,`artist`,`description`,`genre`,`keywords`,`lastModifiedDate`,`ocassion`,`preview`,`provider_name`,`purchaseInfo`,`thumbnail`,`title`,`languageId`) values (1,'One','One','One',NULL,NULL,'2012-07-06 00:00:00',NULL,'audio/1.mp3',NULL,NULL,'images/images/1.jpg','One',1),(2,'Come','Come','Come',NULL,NULL,'2012-07-06 00:00:00',NULL,'audio/Come.mp3',NULL,NULL,'images/images/2.jpg','Come',1),(3,'FirstLove','FirstLove','FirstLove',NULL,NULL,'2012-07-06 00:00:00',NULL,'audio/FirstLove.mp3',NULL,NULL,'images/images/1.jpg','FirstLove',1),(4,NULL,NULL,'Description Four',NULL,NULL,'2012-07-07 00:00:00',NULL,NULL,NULL,NULL,'images/images/1.jpg','Audio Title Four',2);

/*Table structure for table `category_master` */

DROP TABLE IF EXISTS `category_master`;

CREATE TABLE `category_master` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `parentCategoryName` varchar(50) NOT NULL,
  PRIMARY KEY (`categoryId`),
  UNIQUE KEY `categoryId` (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category_master` */

/*Table structure for table `christian_needs_master` */

DROP TABLE IF EXISTS `christian_needs_master`;

CREATE TABLE `christian_needs_master` (
  `id` int(11) NOT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `purchaseInfo` longtext,
  `thumbnail` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK39BD44A60096417` (`languageId`),
  CONSTRAINT `FK39BD44A60096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `christian_needs_master` */

/*Table structure for table `event_master` */

DROP TABLE IF EXISTS `event_master`;

CREATE TABLE `event_master` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) DEFAULT NULL,
  `contactNumber` varchar(12) NOT NULL,
  `contactPerson` varchar(50) NOT NULL,
  `datetime` datetime NOT NULL,
  `eventAddress` longtext NOT NULL,
  `eventDescription` varchar(100) NOT NULL,
  `eventName` varchar(50) NOT NULL,
  `eventStatus` bit(1) NOT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `place` varchar(100) NOT NULL,
  `spectatorLanguage` varchar(100) DEFAULT NULL,
  `subLanguages` varchar(200) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eventId`),
  UNIQUE KEY `eventId` (`eventId`),
  KEY `FK33E773A760096417` (`languageId`),
  CONSTRAINT `FK33E773A760096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `event_master` */

insert into `event_master` (`eventId`,`category`,`contactNumber`,`contactPerson`,`datetime`,`eventAddress`,`eventDescription`,`eventName`,`eventStatus`,`keywords`,`lastModifiedDate`,`place`,`spectatorLanguage`,`subLanguages`,`languageId`,`region`) values (1,'category1','1234567899','personOne','2012-07-14 00:00:00','event address','event descriptio','event name','\0','keywors','2012-07-14 00:00:00','placeone','Telugu',NULL,1,NULL),(2,'category2','5678991234','personTwo','2012-07-14 00:00:00','event address One','event descriptio One','event name one','\0','keywors one','2012-07-14 00:00:00','plactwo','English',NULL,1,NULL),(3,'category3','2345678991','personThree','2012-07-14 00:00:00','event address Three','event descriptio Three','event name Three','\0','keywors Three','2012-07-14 00:00:00','placThree','English',NULL,1,NULL),(4,'category4','2345678991','personFour','2012-07-14 00:00:00','event address Four','event descriptio Four','event name Four','\0','keywors Four','2012-07-14 00:00:00','placFour',NULL,NULL,2,NULL);

/*Table structure for table `item_analytics` */

DROP TABLE IF EXISTS `item_analytics`;

CREATE TABLE `item_analytics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) DEFAULT NULL,
  `downloads` int(11) DEFAULT NULL,
  `itemId` int(11) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_analytics` */

/*Table structure for table `language_master` */

DROP TABLE IF EXISTS `language_master`;

CREATE TABLE `language_master` (
  `languageId` int(11) NOT NULL AUTO_INCREMENT,
  `languageName` varchar(50) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`languageId`),
  UNIQUE KEY `languageId` (`languageId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `language_master` */

insert into `language_master` (`languageId`,`languageName`,`lastModifiedDate`) values (1,'English','2012-07-06 00:00:00'),(2,'Telugu','2012-07-07 00:00:00'),(3,'Tamil','2012-07-17 00:00:00');

/*Table structure for table `lyrics_master` */

DROP TABLE IF EXISTS `lyrics_master`;

CREATE TABLE `lyrics_master` (
  `lyricsId` int(11) NOT NULL AUTO_INCREMENT,
  `albumName` varchar(50) DEFAULT NULL,
  `artists` varchar(50) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `lyrics` longtext NOT NULL,
  `title` varchar(50) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`lyricsId`),
  UNIQUE KEY `lyricsId` (`lyricsId`),
  KEY `FK23D0250D60096417` (`languageId`),
  CONSTRAINT `FK23D0250D60096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `lyrics_master` */

insert into `lyrics_master` (`lyricsId`,`albumName`,`artists`,`keywords`,`lastModifiedDate`,`lyrics`,`title`,`languageId`) values (1,'Album Name One','Artists One','KeyWords One','2012-07-15 00:00:00','The Lordâs my Shepherd, <br />Iâll not want;<br />He makes me down to lie<br />In pastures green; He leadeth me<br />The quiet waters by.<br /><br />  My soul He doth restore again,<br /> And me to walk doth make<br /> Within the paths of righteousness,<br /> Eâen for His own nameâs sake.<br /><br /> Yea, though I walk in deathâs dark vale,<br />\n                        Yet will I fear no ill;<br />\n                        For Thou art with me, and Thy rod<br />\n                        And staff my comfort still.<br /><br />\n                        My table Thou hast furnished me<br />\n                        In presence of my foes;<br />\n                        My head Thou dost with oil anoint,<br />\n                        And my cup overflows.<br /><br />\n                        Goodness and mercy all my life<br />\n                        Shall surely follow me;<br />\n                        And in Godâs house forevermore,<br />\n                        My dwelling place shall be.','Title One',1),(2,'Album Name Two','Artists Two','KeyWords Two','2012-07-15 00:00:00','Two Two Two Two The Lordâs my Shepherd, <br />Iâll not want;<br />He makes me down to lie<br />In pastures green; He leadeth me<br />The quiet waters by.<br /><br />  My soul He doth restore again,<br /> And me to walk doth make<br /> Within the paths of righteousness,<br /> Eâen for His own nameâs sake.<br /><br /> Yea, though I walk in deathâs dark vale,<br />\n                        Yet will I fear no ill;<br />\n                        For Thou art with me, and Thy rod<br />\n                        And staff my comfort still.<br /><br />\n                        My table Thou hast furnished me<br />\n                        In presence of my foes;<br />\n                        My head Thou dost with oil anoint,<br />\n                        And my cup overflows.<br /><br />\n                        Goodness and mercy all my life<br />\n                        Shall surely follow me;<br />\n                        And in Godâs house forevermore,<br />\n                        My dwelling place shall be.','Title Two',1),(3,'Album Name Three','Artists Three','KeyWords Three','2012-07-15 00:00:00','Three Three Three The Lordâs my Shepherd, <br />Iâll not want;<br />He makes me down to lie<br />In pastures green; He leadeth me<br />The quiet waters by.<br /><br />  My soul He doth restore again,<br /> And me to walk doth make<br /> Within the paths of righteousness,<br /> Eâen for His own nameâs sake.<br /><br /> Yea, though I walk in deathâs dark vale,<br />\n                        Yet will I fear no ill;<br />\n                        For Thou art with me, and Thy rod<br />\n                        And staff my comfort still.<br /><br />\n                        My table Thou hast furnished me<br />\n                        In presence of my foes;<br />\n                        My head Thou dost with oil anoint,<br />\n                        And my cup overflows.<br /><br />\n                        Goodness and mercy all my life<br />\n                        Shall surely follow me;<br />\n                        And in Godâs house forevermore,<br />\n                        My dwelling place shall be.','Title Three',2),(4,'Album Name Four','Artists Four','KeyWords Four','2012-07-15 00:00:00','Four Four Four The Lordâs my Shepherd, <br />Iâll not want;<br />He makes me down to lie<br />In pastures green; He leadeth me<br />The quiet waters by.<br /><br />  My soul He doth restore again,<br /> And me to walk doth make<br /> Within the paths of righteousness,<br /> Eâen for His own nameâs sake.<br /><br /> Yea, though I walk in deathâs dark vale,<br />\n                        Yet will I fear no ill;<br />\n                        For Thou art with me, and Thy rod<br />\n                        And staff my comfort still.<br /><br />\n                        My table Thou hast furnished me<br />\n                        In presence of my foes;<br />\n                        My head Thou dost with oil anoint,<br />\n                        And my cup overflows.<br /><br />\n                        Goodness and mercy all my life<br />\n                        Shall surely follow me;<br />\n                        And in Godâs house forevermore,<br />\n                        My dwelling place shall be.','Title Four',1);

/*Table structure for table `ppt_master` */

DROP TABLE IF EXISTS `ppt_master`;

CREATE TABLE `ppt_master` (
  `id` int(11) NOT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `groups` varchar(100) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `purchaseInfo` longtext,
  `thumbnail` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK31178A8D60096417` (`languageId`),
  CONSTRAINT `FK31178A8D60096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ppt_master` */

/*Table structure for table `user_master` */

DROP TABLE IF EXISTS `user_master`;

CREATE TABLE `user_master` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `address1` longtext NOT NULL,
  `address2` longtext,
  `chruchName` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `favorites` longtext,
  `lastModifiedDate` datetime NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` bit(1) NOT NULL,
  `userName` varchar(100) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_master` */

insert into `user_master` (`userId`,`address1`,`address2`,`chruchName`,`email`,`favorites`,`lastModifiedDate`,`password`,`status`,`userName`) values (1,'Hyderabad','Andhra Pradesh','Hyderabad','nagesh_vejju@yahoo.com',NULL,'2012-07-31 10:44:12','nagesh','','nagesh');

/*Table structure for table `video_master` */

DROP TABLE IF EXISTS `video_master`;

CREATE TABLE `video_master` (
  `id` int(11) NOT NULL,
  `album` varchar(100) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `purchaseInfo` longtext,
  `thumbnail` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKF4FF22A660096417` (`languageId`),
  CONSTRAINT `FKF4FF22A660096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `video_master` */

insert into `video_master` (`id`,`album`,`artist`,`description`,`genre`,`keywords`,`lastModifiedDate`,`ocassion`,`preview`,`provider_name`,`purchaseInfo`,`thumbnail`,`title`,`languageId`) values (1,'nagesh','nagesh','nagesh','fun','fun','2012-07-06 00:00:00',NULL,'audio/1.avi',NULL,NULL,'images/images/2.jpg','Video Title One',1),(2,'nagesh','nagesh','nagesh','fn','fun','2012-07-06 00:00:00',NULL,'audio/1.avi',NULL,NULL,'images/images/2.jpg','Video Title Two',1),(3,'nagesh','nagesh','Description Three','fun','fun','2012-07-06 00:00:00',NULL,'audio/1.avi',NULL,NULL,'images/images/2.jpg','Video Title Three',1);

/*Table structure for table `wallpapers_master` */

DROP TABLE IF EXISTS `wallpapers_master`;

CREATE TABLE `wallpapers_master` (
  `id` int(11) NOT NULL,
  `album` varchar(100) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `purchaseInfo` longtext,
  `thumbnail` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK3A53BB060096417` (`languageId`),
  CONSTRAINT `FK3A53BB060096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wallpapers_master` */

insert into `wallpapers_master` (`id`,`album`,`artist`,`description`,`genre`,`keywords`,`lastModifiedDate`,`ocassion`,`preview`,`provider_name`,`purchaseInfo`,`thumbnail`,`title`,`languageId`) values (1,NULL,NULL,'Description One',NULL,NULL,'2012-07-06 00:00:00',NULL,'http://www.indianchristianmedia.org',NULL,NULL,'images/images/3.jpg','images/images/1.jpg',1),(2,NULL,NULL,'Description One',NULL,NULL,'2012-07-06 00:00:00',NULL,'http://www.indianchristianmedia.org',NULL,NULL,'images/images/3.jpg','images/images/2.jpg',1),(3,NULL,NULL,'Description One',NULL,NULL,'2012-07-06 00:00:00',NULL,'http://www.indianchristianmedia.org',NULL,NULL,'images/images/3.jpg','images/images/3.jpg',1);

/*Table structure for table `website_template_master` */

DROP TABLE IF EXISTS `website_template_master`;

CREATE TABLE `website_template_master` (
  `id` int(11) NOT NULL,
  `album` varchar(100) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `purchaseInfo` longtext,
  `thumbnail` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `languageId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK10C8DE2360096417` (`languageId`),
  CONSTRAINT `FK10C8DE2360096417` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `website_template_master` */

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
