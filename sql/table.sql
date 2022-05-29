CREATE TABLE `contact` (  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    `name` varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
    `telephone` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
    `company` varchar(100) NOT NULL DEFAULT '' COMMENT '公司',
    `building_type` varchar(200) NOT NULL DEFAULT '' COMMENT '建筑类型',
    `description` varchar(250) NOT NULL DEFAULT '' COMMENT '需求描述',
    `ip` varchar(20) NOT NULL DEFAULT '' COMMENT 'ip',
    `gmt_create` BIGINT(13) NOT NULL COMMENT '创建日期'
) DEFAULT CHARSET utf8mb4 COMMENT '联系信息';

ALTER TABLE contact ADD COLUMN ip VARCHAR(20) NOT NULL DEFAULT '' COMMENT 'ip'
ALTER TABLE contact ADD COLUMN gmt_create BIGINT(13) NOT NULL COMMENT 'gmt_create'

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) DEFAULT CHARSET=utf8mb4 COMMENT 'hibernate';

INSERT INTO  `hibernate_sequence` (next_val) VALUES (1);

CREATE TABLE `meta` (  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    `code` varchar(32) NOT NULL DEFAULT '' COMMENT 'code',
    `text` varchar(255) NOT NULL DEFAULT '' COMMENT '文本',
    `lang` varchar(100) NOT NULL DEFAULT '' COMMENT '语言',
    `gmt_create` BIGINT(13) NOT NULL COMMENT '创建日期',
		`gmt_modify` BIGINT(13) NOT NULL COMMENT '修改日期'
) DEFAULT CHARSET utf8mb4