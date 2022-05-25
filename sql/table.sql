CREATE TABLE `contract` (  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    `name` varchar(32) NOT NULL DEFAULT '' COMMENT '姓名',
    `telephone` varchar(32) NOT NULL DEFAULT '' COMMENT '电话',
    `company` varchar(100) NOT NULL DEFAULT '' COMMENT '公司',
    `building_type` varchar(200) NOT NULL DEFAULT '' COMMENT '建筑类型',
    `description` varchar(250) NOT NULL DEFAULT '' COMMENT '需求描述'
) DEFAULT CHARSET utf8mb4 COMMENT '联系信息';
