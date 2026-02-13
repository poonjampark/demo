CREATE TABLE t_role(
	id varchar(32) not null COMMENT '主键',
	roleName varchar(60) not null COMMENT '权限名称',
	roleLevel int(2) not null COMMENT '权限等级',
	remarks varchar(60) COMMENT '备注',
	lastUpdateName varchar(100) NOT NULL COMMENT '最后修改人',
	lastUpdateTime varchar(19) NOT NULL COMMENT '最后修改时间',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_role ( id, roleName, roleLevel, remarks, lastUpdateName, lastUpdateTime ) 
VALUES ( replace(uuid(),'-',''), "超级管理员权限", "3", "测试", "超级管理员", "2022-03-26 22:40:35" )

