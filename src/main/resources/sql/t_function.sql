CREATE TABLE t_function(
	id varchar(32) not null COMMENT '主键',
	modelType int(2) not null COMMENT '模块类型',
	modelName varchar(60) not null COMMENT '模块名称',
	functionType int(2) not null COMMENT '操作类型',
	functionName varchar(60) not null COMMENT '操作名称',
	statu int(1) not null COMMENT '使用状态：0删除，1使用',
	remarks varchar(200) COMMENT '备注',
	lastUpdateName varchar(100) NOT NULL COMMENT '最后修改人',
  	lastUpdateTime varchar(19) NOT NULL COMMENT '最后修改时间',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_function ( id, modelType, modelName, functionType, functionName, statu, remarks, lastUpdateName, lastUpdateTime )
VALUES ( replace(uuid(),'-',''), "1", "通讯录", "1", "新增", "1", "测试", "管理员", "2022-03-26 22:40:35" )
