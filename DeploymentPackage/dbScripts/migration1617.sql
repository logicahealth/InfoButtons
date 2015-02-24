ALTER TABLE `profilesdbprod`.`resource_profiles` ADD COLUMN `image_url` VARCHAR(255) NULL AFTER `content`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `profilesdbprod`.`resource_profiles_utf8` AS select `profilesdbprod`.`resource_profiles`.`id` AS `id`,`profilesdbprod`.`resource_profiles`.`name` AS `name`,`profilesdbprod`.`resource_profiles`.`version` AS `version`,`profilesdbprod`.`resource_profiles`.`published` AS `published`,`profilesdbprod`.`resource_profiles`.`image_url` AS `image_url`,`profilesdbprod`.`resource_profiles`.`status` AS `status`,if((`profilesdbprod`.`resource_profiles`.`status` = 1),'Active',if((`profilesdbprod`.`resource_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`profilesdbprod`.`resource_profiles`.`content` using utf8) AS `content_utf8` from `profilesdbprod`.`resource_profiles`;

alter table profilesdbprod.resource_profiles change version version varchar(45);

CREATE TABLE resource_profiles_cloud
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  version VARCHAR(45) DEFAULT '' NOT NULL,
  published TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  status INT NOT NULL,
  content LONGBLOB NOT NULL,
  image_url VARCHAR(255),
  PRIMARY KEY (id, version)
);

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `profilesdbprod`.`resource_profiles_utf8_cloud` AS select `profilesdbprod`.`resource_profiles_cloud`.`id` AS `id`,`profilesdbprod`.`resource_profiles_cloud`.`name` AS `name`,`profilesdbprod`.`resource_profiles_cloud`.`version` AS `version`,`profilesdbprod`.`resource_profiles_cloud`.`published` AS `published`,`profilesdbprod`.`resource_profiles_cloud`.`image_url` AS `image_url`,`profilesdbprod`.`resource_profiles_cloud`.`status` AS `status`,if((`profilesdbprod`.`resource_profiles_cloud`.`status` = 1),'Active',if((`profilesdbprod`.`resource_profiles_cloud`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`profilesdbprod`.`resource_profiles_cloud`.`content` using utf8) AS `content_utf8` from `profilesdbprod`.`resource_profiles_cloud`;

create view profilesdbprod.resource_profiles_all as
  select * from profilesdbprod.resource_profiles
  UNION ALL
  select * from profilesdbprod.resource_profiles_cloud;