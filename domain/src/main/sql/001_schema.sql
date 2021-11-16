--create schema if not exists PUBLIC;

create table if not exists LOCATION
(
    ID        BIGINT auto_increment ,
    LATITUDE  DOUBLE,
    LONGITUDE DOUBLE,
    PRIMARY KEY (`ID`)
);

create table if not exists USER
(
    ID       BIGINT auto_increment ,
    USERNAME VARCHAR(255),
    PRIMARY KEY (`ID`)
);

create table if not exists TWEET
(
    ID          BIGINT auto_increment ,
    CONTENT     VARCHAR(255),
    LOCATION_ID BIGINT,
    POSTER_ID   BIGINT not null,
    PRIMARY KEY (`ID`)
);

create table if not exists TWEET_USER
(
    ID          BIGINT auto_increment ,
    TWEET_ID    BIGINT not null,
    MENTIONS_ID BIGINT not null,
    PRIMARY KEY (`ID`)
);

-- additional

CREATE TABLE if not exists `activity_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `activity_name` varchar(200) DEFAULT NULL COMMENT '活动名称',
  `activity_type` varchar(10) DEFAULT NULL COMMENT '活动类型（1：满减，2：折扣）',
  `activity_desc` varchar(2000) DEFAULT NULL COMMENT '活动描述',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
);
