CREATE TABLE t_role_function(
	id varchar(32) not null COMMENT '主键',
	roleId varchar(32) not null COMMENT '权限id',
	functionId varchar(32) not null COMMENT '功能id',
	lastUpdateName varchar(100) NOT NULL COMMENT '最后修改人',
	lastUpdateTime varchar(19) NOT NULL COMMENT '最后修改时间',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;