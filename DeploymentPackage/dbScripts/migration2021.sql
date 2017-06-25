USE `valueset_and_log`;

ALTER TABLE logs ADD response MEDIUMTEXT NULL;

DROP TABLE IF EXISTS `subset_json`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subset_json`
(
  `id` INT(11) PRIMARY KEY NOT NULL,
  `last_updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` VARCHAR(255) NOT NULL,
  `value_set` LONGBLOB
)ENGINE=MyISAM DEFAULT CHARSET=latin1
/*!40101 SET character_set_client = @saved_cs_client */;