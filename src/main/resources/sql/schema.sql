CREATE TABLE IF NOT EXISTS `USER`
(
    id     BIGINT(20) NOT NULL ,
    name   VARCHAR(30) NULL DEFAULT NULL,
    age    INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (id)
);