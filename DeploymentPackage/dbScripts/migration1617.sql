USE profilesdbprod;

RENAME TABLE resource_profiles TO custom_profiles;

ALTER TABLE `custom_profiles` ADD COLUMN `image_url` VARCHAR(255) NULL AFTER `content`;

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

create view resource_profiles_all as
  select * from custom_profiles
  UNION ALL
  select * from installed_store_profiles