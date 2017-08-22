create table oib_app_property
(
	app_property_id int not null
		primary key,
	prop_name varchar(50) not null,
	prop_description varchar(50) null,
	prop_value varchar(50) not null
)
;

