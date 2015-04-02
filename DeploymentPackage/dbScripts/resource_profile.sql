CREATE DATABASE  IF NOT EXISTS `resource_profile` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `resource_profile`;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `resource_profile`
--

-- --------------------------------------------------------

--
-- Table structure for table `custom_profiles`
--

DROP TABLE IF EXISTS `custom_profiles`;
CREATE TABLE IF NOT EXISTS `custom_profiles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `version` varchar(45) NOT NULL,
  `published` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(2) NOT NULL,
  `content` longblob NOT NULL,
  `image_url` VARCHAR(255),
  PRIMARY KEY (`id`,`version`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- UTF8 custom profiles view
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `resource_profile`.`v_custom_profiles` AS select `resource_profile`.`custom_profiles`.`id` AS `id`,`resource_profile`.`custom_profiles`.`name` AS `name`,`resource_profile`.`custom_profiles`.`version` AS `version`,`resource_profile`.`custom_profiles`.`published` AS `published`,`resource_profile`.`custom_profiles`.`image_url` AS `image_url`,`resource_profile`.`custom_profiles`.`status` AS `status`,if((`resource_profile`.`custom_profiles`.`status` = 1),'Active',if((`resource_profile`.`custom_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`resource_profile`.`custom_profiles`.`content` using utf8) AS `content_utf8` from `resource_profile`.`custom_profiles`;

--
-- Table structure for table `custom_profiles`
--

DROP TABLE IF EXISTS `installed_store_profiles`;
CREATE TABLE IF NOT EXISTS `installed_store_profiles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `version` varchar(45) NOT NULL,
  `published` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` int(2) NOT NULL,
  `content` longblob NOT NULL,
  `image_url` VARCHAR(255),
  PRIMARY KEY (`id`,`version`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- UTF8 store profiles view
--

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `resource_profile`.`v_installed_store_profiles` AS select `resource_profile`.`installed_store_profiles`.`id` AS `id`,`resource_profile`.`installed_store_profiles`.`name` AS `name`,`resource_profile`.`installed_store_profiles`.`version` AS `version`,`resource_profile`.`installed_store_profiles`.`published` AS `published`,`resource_profile`.`installed_store_profiles`.`image_url` AS `image_url`,`resource_profile`.`installed_store_profiles`.`status` AS `status`,if((`resource_profile`.`installed_store_profiles`.`status` = 1),'Active',if((`resource_profile`.`installed_store_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`resource_profile`.`installed_store_profiles`.`content` using utf8) AS `content_utf8` from `resource_profile`.`installed_store_profiles`;

--
-- Combined profile view
--

create view resource_profile.resource_profiles_all as
  select * from resource_profile.custom_profiles
  UNION ALL
  select * from resource_profile.installed_store_profiles


