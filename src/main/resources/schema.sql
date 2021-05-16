drop table if exists `user`;
drop table if exists `authority`;
CREATE TABLE `user`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `authority`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `name`  VARCHAR(45) NOT NULL,
    `user` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);