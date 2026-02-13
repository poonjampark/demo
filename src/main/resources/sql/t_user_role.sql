CREATE TABLE t_user_role(
	id varchar(32) not null COMMENT '主键',
	userId varchar(32) not null COMMENT '用户id',
	roleId varchar(32) not null COMMENT '权限id',
	lastUpdateName varchar(100) NOT NULL COMMENT '最后修改人',
  	lastUpdateTime varchar(19) NOT NULL COMMENT '最后修改时间',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;