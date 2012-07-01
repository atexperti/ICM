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
  `adminUserName` varchar(100) NOT NULL,
  `adminPassword` varchar(100) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`adminUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_master` */

/*Table structure for table `article_master` */

DROP TABLE IF EXISTS `article_master`;

CREATE TABLE `article_master` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `article` varchar(5000) NOT NULL,
  `userId` int(11) NOT NULL,
  `languageId` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  `dateadded` datetime NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`articleId`),
  KEY `article_language` (`languageId`),
  KEY `article_user` (`userId`),
  CONSTRAINT `article_language` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `article_user` FOREIGN KEY (`userId`) REFERENCES `user_master` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `article_master` */

/*Table structure for table `audio_master` */

DROP TABLE IF EXISTS `audio_master`;

CREATE TABLE `audio_master` (
  `id` int(11) NOT NULL,
  `provider_unique_id` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `thumbnail` varchar(100) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `purchaseInfo` varchar(500) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `audioid_languageid` (`languageId`),
  CONSTRAINT `audioid_languageid` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `audio_master` */

/*Table structure for table `category_master` */

DROP TABLE IF EXISTS `category_master`;

CREATE TABLE `category_master` (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) NOT NULL,
  `parentCategoryName` varchar(50) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category_master` */

/*Table structure for table `christian_needs_master` */

DROP TABLE IF EXISTS `christian_needs_master`;

CREATE TABLE `christian_needs_master` (
  `id` int(11) NOT NULL,
  `provider_unique_id` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `thumbnail` varchar(100) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `purchaseInfo` varchar(500) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cnid_languageid` (`languageId`),
  CONSTRAINT `cnid_languageid` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `christian_needs_master` */

/*Table structure for table `event_master` */

DROP TABLE IF EXISTS `event_master`;

CREATE TABLE `event_master` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `eventName` varchar(50) NOT NULL,
  `eventDescription` varchar(100) NOT NULL,
  `place` varchar(100) NOT NULL,
  `datetime` datetime NOT NULL,
  `eventAddress` varchar(100) NOT NULL,
  `eventStatus` tinyint(1) NOT NULL,
  `contactPerson` varchar(50) NOT NULL,
  `languageId` int(11) NOT NULL,
  `contactNumber` varchar(12) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`eventId`),
  KEY `event_language` (`languageId`),
  CONSTRAINT `event_language` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `event_master` */

/*Table structure for table `item_analytics` */

DROP TABLE IF EXISTS `item_analytics`;

CREATE TABLE `item_analytics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `itemId` int(11) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `downloads` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_analytics` */

/*Table structure for table `language_master` */

DROP TABLE IF EXISTS `language_master`;

CREATE TABLE `language_master` (
  `languageId` int(11) NOT NULL AUTO_INCREMENT,
  `languageName` varchar(50) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`languageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `language_master` */

/*Table structure for table `lyrics_master` */

DROP TABLE IF EXISTS `lyrics_master`;

CREATE TABLE `lyrics_master` (
  `lyricsId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `lyrics` varchar(5000) NOT NULL,
  `albumName` varchar(50) DEFAULT NULL,
  `artists` varchar(50) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`lyricsId`),
  KEY `lyrics_langague` (`languageId`),
  CONSTRAINT `lyrics_langague` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lyrics_master` */

/*Table structure for table `ppt_master` */

DROP TABLE IF EXISTS `ppt_master`;

CREATE TABLE `ppt_master` (
  `id` int(11) NOT NULL,
  `provider_unique_id` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `thumbnail` varchar(100) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `purchaseInfo` varchar(500) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pptid_languageid` (`languageId`),
  CONSTRAINT `pptid_languageid` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ppt_master` */

/*Table structure for table `user_master` */

DROP TABLE IF EXISTS `user_master`;

CREATE TABLE `user_master` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `chruchName` varchar(200) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `address1` varchar(300) NOT NULL,
  `address2` varchar(300) DEFAULT NULL,
  `favorites` varchar(500) DEFAULT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_master` */

/*Table structure for table `video_master` */

DROP TABLE IF EXISTS `video_master`;

CREATE TABLE `video_master` (
  `id` int(11) NOT NULL,
  `provider_unique_id` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `thumbnail` varchar(100) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `purchaseInfo` varchar(500) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `videoid_languageid` (`languageId`),
  CONSTRAINT `videoid_languageid` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `video_master` */

/*Table structure for table `wallpapers_master` */

DROP TABLE IF EXISTS `wallpapers_master`;

CREATE TABLE `wallpapers_master` (
  `id` int(11) NOT NULL,
  `provider_unique_id` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `thumbnail` varchar(100) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `purchaseInfo` varchar(500) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `wallpapersid_languageid` (`languageId`),
  CONSTRAINT `wallpapersid_languageid` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wallpapers_master` */

/*Table structure for table `website_template_master` */

DROP TABLE IF EXISTS `website_template_master`;

CREATE TABLE `website_template_master` (
  `id` int(11) NOT NULL,
  `provider_unique_id` varchar(100) DEFAULT NULL,
  `provider_name` varchar(100) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `title` varchar(100) NOT NULL,
  `thumbnail` varchar(100) DEFAULT NULL,
  `preview` varchar(100) DEFAULT NULL,
  `ocassion` varchar(50) DEFAULT NULL,
  `genre` varchar(50) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `purchaseInfo` varchar(500) DEFAULT NULL,
  `languageId` int(11) NOT NULL,
  `lastModifiedDate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `webaiteid_languageid` (`languageId`),
  CONSTRAINT `websiteid_languageid` FOREIGN KEY (`languageId`) REFERENCES `language_master` (`languageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `website_template_master` */

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
