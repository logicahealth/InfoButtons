create table `resource_profile`.`oib_app_property`
(
	app_property_id int not null auto_increment primary key,
	prop_name varchar(50) not null,
	prop_description varchar(50) null,
	prop_value varchar(50) not null
)
;

INSERT INTO `resource_profile`.`oib_app_property`(prop_name, prop_description, prop_value) VALUES ('umls.username', null, '');
INSERT INTO `resource_profile`.`oib_app_property`(prop_name, prop_description, prop_value) VALUES ('umls.password', null, '');
INSERT INTO `resource_profile`.`oib_app_property`(prop_name, prop_description, prop_value) VALUES ('github.username', null, '');
INSERT INTO `resource_profile`.`oib_app_property`(prop_name, prop_description, prop_value) VALUES ('github.password', null, '');