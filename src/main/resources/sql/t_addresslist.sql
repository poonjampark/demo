CREATE TABLE t_addresslist(
	id varchar(32) not null COMMENT '主键',
	companyName varchar(300) not null COMMENT '单位名称',
	typeName varchar(100) not null COMMENT '人员类型',
	post varchar(100) COMMENT '职位',
	userName varchar(60) COMMENT '姓名',
	telephone varchar(60) COMMENT '联系电话',
	mobile varchar(60) COMMENT '手机',
	email varchar(60) COMMENT '邮箱',
	belongTo varchar(300) COMMENT '所属分会',
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX INDEX_COMPANYNAME ON t_addresslist(companyName)
CREATE INDEX INDEX_USERNAME ON t_addresslist(userName)
CREATE INDEX INDEX_MOBILE ON t_addresslist(mobile)

