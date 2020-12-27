CREATE TABLE `t_order` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `order_status` tinyint(1) DEFAULT NULL,
                           `order_amount` decimal(10,2) DEFAULT NULL,
                           `receive_user` varchar(255) DEFAULT NULL,
                           `receive_mobile` varchar(11) DEFAULT NULL,
                           `create_user` varchar(255) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_user` varchar(255) DEFAULT NULL,
                           `update_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8mb4;


# INSERT INTO `xa_2`.`t_order`(`id`, `order_status`, `order_amount`, `receive_user`, `receive_mobile`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (10010, 0, 200.00, '111', '11', '111', NULL, NULL, '2020-12-26 07:49:40');
