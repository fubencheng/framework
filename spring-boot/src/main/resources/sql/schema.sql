-- CREATE SCHEMA `lnk_bankcard` CHARACTER SET utf8;

CREATE TABLE `lnk_bankcard`.`t_card_bin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `issuer_name` VARCHAR(64) NOT NULL COMMENT '发卡机构名称',
  `issuer_code` CHAR(16) NOT NULL COMMENT '发卡机构码',
  `card_name` VARCHAR(64) NULL COMMENT '卡名称',
  `for_atm` TINYINT NOT NULL COMMENT '是否适用于ATM',
  `for_pos` TINYINT NOT NULL COMMENT '是否适用于POS',
  `card_length` TINYINT NOT NULL COMMENT '卡号总长度',
  `primary_length` TINYINT NOT NULL COMMENT '发卡行标识长度',
  `primary_no` CHAR(16) NOT NULL COMMENT '发卡行标识',
  `card_type` TINYINT NOT NULL COMMENT '卡种',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  INDEX `idx_issuer_code` USING BTREE (`issuer_code` ASC),
  INDEX `idx_primary_no` USING BTREE (`primary_no` ASC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lnk_bankcard`.`t_id_card` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `id_no` char(18) NOT NULL,
  `gender` tinyint(2) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_no_UNIQUE` (`id_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;