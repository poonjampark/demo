CREATE TABLE t_user (
	id int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(60) NOT NULL COMMENT '用户名',
	account varchar(11) NOT NULL COMMENT '账号',
	password varchar(100) NOT NULL COMMENT '密码',
	lastUpdateName varchar(100) NOT NULL COMMENT '最后修改人',
	lastUpdateTime varchar(19) NOT NULL COMMENT '最后修改时间',
	PRIMARY KEY (id),
	UNIQUE KEY `UNIQUE_ACCOUNT` (account)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX INDEX_NAME ON t_user(name)

INSERT INTO t_user (name, account, password, lastUpdateName, lastUpdateTime ) 
VALUES ("超级管理员", "13189190858", "e10adc3949ba59abbe56e057f20f883e", "超级管理员", "2022-03-26 22:40:35" )
