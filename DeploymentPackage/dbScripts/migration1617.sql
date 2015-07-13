USE profilesdbprod;

RENAME TABLE resource_profiles TO custom_profiles;

ALTER TABLE `custom_profiles` ADD COLUMN `image_url` VARCHAR(255) NULL AFTER `content`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_custom_profiles` AS select `custom_profiles`.`id` AS `id`,`custom_profiles`.`name` AS `name`,`custom_profiles`.`version` AS `version`,`custom_profiles`.`published` AS `published`,`custom_profiles`.`image_url` AS `image_url`,`custom_profiles`.`status` AS `status`,if((`custom_profiles`.`status` = 1),'Active',if((`custom_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`custom_profiles`.`content` using utf8) AS `content_utf8` from `custom_profiles`;

alter table custom_profiles change version varchar(45);

CREATE TABLE installed_store_profiles
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  version VARCHAR(45) DEFAULT '' NOT NULL,
  published TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  status INT NOT NULL,
  content LONGBLOB NOT NULL,
  image_url VARCHAR(255),
  PRIMARY KEY (id, version)
);

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_installed_store_profiles` AS select `installed_store_profiles`.`id` AS `id`,`installed_store_profiles`.`name` AS `name`,`installed_store_profiles`.`version` AS `version`,`installed_store_profiles`.`published` AS `published`,`installed_store_profiles`.`image_url` AS `image_url`,`installed_store_profiles`.`status` AS `status`,if((`installed_store_profiles`.`status` = 1),'Active',if((`installed_store_profiles`.`status` = 2),'Testing','Inactive')) AS `status_dsc`,convert(`installed_store_profiles`.`content` using utf8) AS `content_utf8` from `installed_store_profiles`;

create view resource_profiles_all as
  select * from custom_profiles
  UNION ALL
  select * from installed_store_profiles