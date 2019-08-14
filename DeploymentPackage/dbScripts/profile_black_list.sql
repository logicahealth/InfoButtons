USE `resource_profile`;

CREATE TABLE `profile_black_list`
(
`id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`profileTitle` VARCHAR(100) NOT NULL,
`userId` VARCHAR(20) NOT NULL,
`profileID` INT(11)
);
CREATE UNIQUE INDEX profile_black_list_id_uindex ON resource_profile.profile_black_list (id);
