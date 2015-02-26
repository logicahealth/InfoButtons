RENAME TABLE profilesdbprod.resource_profiles TO profilesdbprod.custom_profiles;

ALTER TABLE `profilesdbprod`.`custom_profiles` ADD COLUMN `image_url` VARCHAR(255) NULL AFTER `content`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `profilesdbprod`.`v_custom_profiles` AS select `profilesdbprod`.`custom_profiles`.`id` AS `id`,`profilesdbprod`.`custom_profiles`.`name` AS `name`,`profilesdbprod`.`custom_profiles`.`version` AS `version`,`profilesdbprod`.`custom_profiles`.`published` AS `published`,`profilesdbprod`.`custom_profiles`.`image_url` AS `image_url`,`profilesdbprod`.`custom_profiles`.`status` AS `status`,if((`profilesdbprod`.`custom_profiles`.`status` = 1),'Active',if((`profilesdbprod`.`custom_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`profilesdbprod`.`custom_profiles`.`content` using utf8) AS `content_utf8` from `profilesdbprod`.`custom_profiles`;

alter table profilesdbprod.custom_profiles change version varchar(45);

CREATE TABLE installed_store_profiles
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

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `profilesdbprod`.`v_installed_store_profiles` AS select `profilesdbprod`.`installed_store_profiles`.`id` AS `id`,`profilesdbprod`.`installed_store_profiles`.`name` AS `name`,`profilesdbprod`.`installed_store_profiles`.`version` AS `version`,`profilesdbprod`.`installed_store_profiles`.`published` AS `published`,`profilesdbprod`.`installed_store_profiles`.`image_url` AS `image_url`,`profilesdbprod`.`installed_store_profiles`.`status` AS `status`,if((`profilesdbprod`.`installed_store_profiles`.`status` = 1),'Active',if((`profilesdbprod`.`installed_store_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`profilesdbprod`.`installed_store_profiles`.`content` using utf8) AS `content_utf8` from `profilesdbprod`.`installed_store_profiles`;

create view profilesdbprod.resource_profiles_all as
  select * from profilesdbprod.custom_profiles
  UNION ALL
  select * from profilesdbprod.installed_store_profiles