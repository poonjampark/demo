CREATE TABLE `pzp_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(300) NOT NULL COMMENT '用户名',
  `account` varchar(15) NOT NULL COMMENT '账号',
  `password` varchar(300) NOT NULL COMMENT '密码',
  `ip` varchar(1000) DEFAULT NULL COMMENT '登录ip地址',
  `credits` int(11) NOT NULL COMMENT '积分',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE_ACCOUNT` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;