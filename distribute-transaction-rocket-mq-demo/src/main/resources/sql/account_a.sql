CREATE TABLE `account_a` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

# INSERT INTO `xa_1`.`account_a`(`id`, `name`, `balance`) VALUES (1, '用户A', 800.00);
