CREATE DATABASE IF NOT EXISTS `library`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)     NOT NULL AUTO_INCREMENT,
    `username` char(30)    NOT NULL,
    `password` varchar(30) NOT NULL,
    `name`     varchar(30) NOT NULL,
    `phone`    varchar(30) NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`
(

    `id`     int(11)      NOT NULL AUTO_INCREMENT,
    `cover`  varchar(255) NOT NULL DEFAULT '',
    `title`  varchar(30)  NOT NULL,
    `author` varchar(30)  not null,
    `press`  varchar(30)  NOT NULL DEFAULT '',
    `total`  int(11)      NOT NULL,
    `lent`   int(11)      NOT NULL default 0,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`
(
    `id`      int(11)    NOT NULL AUTO_INCREMENT,
    `book_id` int(11)    NOT NULL,
    `user_id` int(11)    NOT NULL,
    `date`    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `status`  varchar(8) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `book`
VALUES (3,'https://i.loli.net/2020/09/03/aIKikS6ABV3Yfjp.jpg','随手写了两本书','本人','无',4,0);
INSERT INTO `book`
VALUES (2, 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', '重庆出版社', 2, 2);
INSERT INTO `book`
VALUES (1, 'https://i.loli.net/2020/09/02/kVQ61w9WcbTpmOY.jpg', '随手写了一本书', '狗狗', '无', 1, 1);
insert into `user`
VALUES (1, 20191113008, '192639', '周开乐', '19121700520');
insert into `user`
VALUES (2, 20191113009, '123456', '谁呢', '19121700520');
INSERT INTO `log`
VALUES (1,2, 3, current_timestamp,'借书');
INSERT INTO `log`
VALUES (2,3, 3, current_timestamp,'还书');
