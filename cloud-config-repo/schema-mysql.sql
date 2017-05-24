DROP DATABASE cloud;

CREATE DATABASE cloud
    COLLATE = 'utf8_general_ci'
    DEFAULT CHARACTER SET = 'utf8';

USE cloud;
CREATE TABLE customer (
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(32)      DEFAULT '',
    last_name  VARCHAR(32)      DEFAULT ''
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;
