drop table if exists `user`;
drop table if exists `authority`;
drop table if exists `client`;
drop table if exists `grant_type`;
drop table if exists `oauth_client_details`;

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
CREATE TABLE `client`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `secret` VARCHAR(45) NOT NULL,
    `scope` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `grant_type`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `client` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);

create table oauth_client_details (
                                      client_id VARCHAR(256) PRIMARY KEY,
                                      resource_ids VARCHAR(256),
                                      client_secret VARCHAR(256),
                                      scope VARCHAR(256),
                                      authorized_grant_types VARCHAR(256),
                                      web_server_redirect_uri VARCHAR(256),
                                      authorities VARCHAR(256),
                                      access_token_validity INTEGER,
                                      refresh_token_validity INTEGER,
                                      additional_information VARCHAR(4096),
                                      autoapprove VARCHAR(256)
);