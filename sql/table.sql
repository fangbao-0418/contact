CREATE TABLE `contact` (  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    `name` varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
    `telephone` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
    `company` varchar(100) NOT NULL DEFAULT '' COMMENT '公司',
    `building_type` varchar(200) NOT NULL DEFAULT '' COMMENT '建筑类型',
    `description` varchar(250) NOT NULL DEFAULT '' COMMENT '需求描述',
    `ip` varchar(20) NOT NULL DEFAULT '' COMMENT 'ip',
    `gmt_create` int(13) NOT NULL COMMENT '创建日期'
) DEFAULT CHARSET utf8mb4 COMMENT '联系信息';

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) DEFAULT CHARSET=utf8mb4 COMMENT 'hibernate';

INSERT INTO  `hibernate_sequence` (next_val) VALUES (1);