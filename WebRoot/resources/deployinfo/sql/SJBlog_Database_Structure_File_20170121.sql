/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.16-0ubuntu0.16.04.1 : Database - sjblogdb
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sjblogdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sjblogdb`;

/*Table structure for table `sj_articles` */

DROP TABLE IF EXISTS `sj_articles`;

CREATE TABLE `sj_articles` (
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_NAME` varchar(50) NOT NULL,
  `A_T_ID` int(11) NOT NULL,
  `A_U_ID` int(11) NOT NULL,
  `A_CREATEDATE` datetime NOT NULL,
  `A_IPADDRESS` varchar(50) DEFAULT NULL,
  `A_MODIFYDATE` datetime DEFAULT NULL,
  `A_READCOUNT` bigint(20) NOT NULL DEFAULT '0',
  `A_HOLDTOP` tinyint(4) NOT NULL DEFAULT '0',
  `A_STATE` char(10) NOT NULL DEFAULT '正常',
  `A_TAGKEYWORD` varchar(100) NOT NULL,
  `A_BODYCONTENTS` longtext NOT NULL,
  `A_ATTACHFILESPATH` char(50) DEFAULT NULL,
  `A_BRIEFCONTENTS` varchar(300) NOT NULL,
  `A_BROWSERINFO` varchar(100) DEFAULT NULL COMMENT '博文发表时的浏览器信息',
  `A_SYSTEMINFO` varchar(100) DEFAULT NULL COMMENT '博文发表时的操作系统信息',
  PRIMARY KEY (`A_ID`),
  KEY `A_T_ID` (`A_T_ID`),
  KEY `A_U_ID` (`A_U_ID`),
  CONSTRAINT `sj_articles_ibfk_1` FOREIGN KEY (`A_T_ID`) REFERENCES `sj_articletypes` (`T_ID`),
  CONSTRAINT `sj_articles_ibfk_2` FOREIGN KEY (`A_U_ID`) REFERENCES `sj_users` (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_articletypes` */

DROP TABLE IF EXISTS `sj_articletypes`;

CREATE TABLE `sj_articletypes` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `T_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_file_attachments` */

DROP TABLE IF EXISTS `sj_file_attachments`;

CREATE TABLE `sj_file_attachments` (
  `FA_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件附件编号',
  `FA_A_ID` int(11) NOT NULL COMMENT '文件附件所属的文章编号外键',
  `FA_FILE_PATH` varchar(255) NOT NULL COMMENT '文件附件路径',
  `FA_FILE_FORMAT` varchar(50) NOT NULL COMMENT '文件附件格式',
  `FA_CREATE_DATE` datetime NOT NULL COMMENT '文件附件创建时间',
  `FA_MODIFY_DATE` datetime DEFAULT NULL COMMENT '文件附件修改时间',
  `FA_MD5_VAR` varchar(500) NOT NULL COMMENT '文件附件MD5值',
  `FA_DOWMLOAD_COUNT` int(11) DEFAULT '0' COMMENT '文件附件下载次数',
  `FA_ENABLE_DOWNLOAD` bit(1) DEFAULT b'1' COMMENT '是否启用对此文件的下载',
  PRIMARY KEY (`FA_ID`),
  KEY `FA_A_ID` (`FA_A_ID`),
  CONSTRAINT `sj_file_attachments_ibfk_1` FOREIGN KEY (`FA_A_ID`) REFERENCES `sj_articles` (`A_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_guestsdatehistorydetail` */

DROP TABLE IF EXISTS `sj_guestsdatehistorydetail`;

CREATE TABLE `sj_guestsdatehistorydetail` (
  `GD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GD_G_ID` int(11) NOT NULL,
  `GD_VISTEDDATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`GD_ID`),
  KEY `GD_G_ID` (`GD_G_ID`),
  CONSTRAINT `sj_guestsdatehistorydetail_ibfk_1` FOREIGN KEY (`GD_G_ID`) REFERENCES `sj_guestshistory` (`G_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=855 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_guestshistory` */

DROP TABLE IF EXISTS `sj_guestshistory`;

CREATE TABLE `sj_guestshistory` (
  `G_ID` int(11) NOT NULL AUTO_INCREMENT,
  `G_IPADDRESS` varchar(50) DEFAULT NULL,
  `G_PROVINCEANDCITY` varchar(50) DEFAULT NULL,
  `G_FIRSTVISITORDATE` datetime NOT NULL,
  `G_LASTVISITORDATE` datetime NOT NULL,
  PRIMARY KEY (`G_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_leavemessages` */

DROP TABLE IF EXISTS `sj_leavemessages`;

CREATE TABLE `sj_leavemessages` (
  `M_ID` int(11) NOT NULL AUTO_INCREMENT,
  `M_U_ID` int(11) NOT NULL,
  `M_REPLY_ID` int(11) DEFAULT NULL,
  `M_A_ID` int(11) NOT NULL,
  `M_COMMENTS` varchar(200) NOT NULL,
  `M_PUBLISHDATE` datetime NOT NULL,
  `M_MESSAGE_TYPE` smallint(6) NOT NULL,
  `M_VERIFYSTATE` smallint(6) NOT NULL,
  `M_IPADDRESS` varchar(100) DEFAULT NULL,
  `M_DEVICEINFO` varchar(100) DEFAULT NULL,
  `M_SYSTEMINFO` varchar(100) DEFAULT NULL,
  `M_PRAISE_COUNT` int(11) DEFAULT '0' COMMENT '点赞数',
  PRIMARY KEY (`M_ID`),
  KEY `M_U_ID` (`M_U_ID`),
  KEY `M_REPLY_ID` (`M_REPLY_ID`),
  KEY `M_A_ID` (`M_A_ID`),
  CONSTRAINT `sj_leavemessages_ibfk_1` FOREIGN KEY (`M_U_ID`) REFERENCES `sj_users` (`U_ID`),
  CONSTRAINT `sj_leavemessages_ibfk_2` FOREIGN KEY (`M_REPLY_ID`) REFERENCES `sj_users` (`U_ID`),
  CONSTRAINT `sj_leavemessages_ibfk_3` FOREIGN KEY (`M_A_ID`) REFERENCES `sj_articles` (`A_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_life` */

DROP TABLE IF EXISTS `sj_life`;

CREATE TABLE `sj_life` (
  `L_ID` int(11) NOT NULL AUTO_INCREMENT,
  `L_U_ID` int(11) NOT NULL,
  `L_CONTENTS` varchar(1000) NOT NULL,
  `L_PUBLISHDATE` datetime NOT NULL,
  `L_MODIFYDATE` datetime DEFAULT NULL,
  `L_IPADDRESS` varchar(50) DEFAULT NULL,
  `L_DEVICEINFO` varchar(100) DEFAULT NULL,
  `L_SYSTEMINFO` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`L_ID`),
  KEY `L_U_ID` (`L_U_ID`),
  CONSTRAINT `sj_life_ibfk_1` FOREIGN KEY (`L_U_ID`) REFERENCES `sj_users` (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Table structure for table `sj_users` */

DROP TABLE IF EXISTS `sj_users`;

CREATE TABLE `sj_users` (
  `U_ID` int(11) NOT NULL AUTO_INCREMENT,
  `U_NICKNAME` varchar(50) NOT NULL,
  `U_GENDER` char(2) DEFAULT NULL,
  `U_ROLE` char(10) NOT NULL DEFAULT '普通用户',
  `U_AGE` int(11) DEFAULT NULL,
  `U_PWD` varchar(500) NOT NULL,
  `U_SECURITYQUESTIONANSWER` varchar(50) NOT NULL,
  `U_HEADER` varchar(500) DEFAULT NULL COMMENT 'user header.',
  `U_STATE` char(10) NOT NULL DEFAULT '正常',
  `U_LEVEL` int(11) NOT NULL,
  `U_CREATETIME` datetime NOT NULL,
  `U_LASTLOGONTIME` datetime DEFAULT NULL,
  `U_EMAIL` varchar(50) NOT NULL,
  `U_QQNUM` int(11) DEFAULT NULL,
  `U_PROVINCEANDCITY` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
