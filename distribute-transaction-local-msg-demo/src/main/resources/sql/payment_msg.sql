CREATE TABLE `payment_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0' COMMENT '0-未发送，1-发送成功，2-超过最大发送次数',
  `failure_cnt` int(1) DEFAULT NULL COMMENT '失败次数，最大5次',
  `create_time` datetime DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
