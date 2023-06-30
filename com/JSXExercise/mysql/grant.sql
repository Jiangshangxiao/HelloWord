-- 演示 用户权限的管理

-- 创建用户shangxiao 密码123 ，从本地登录
CREATE USER 'shangxiao'@'localhost' IDENTIFIED BY '123';

-- 使用root 用户创建 testdb, 表news
CREATE DATABASE testdb;
CREATE TABLE news (
				id INT,
				content VARCHAR(32)
);
-- 添加一条数据
INSERT INTO news VALUES(100, '北京新闻');

-- 给shangxiao分配查看 news 表和 添加news的权限
GRANT SELECT , INSERT ON testdb.news TO 'shangxiao'@'localhost';

-- 可以增加update权限
GRANT UPDATE ON testdb.news TO 'shangxiao'@'localhost';

-- 修改shangxiao的密码为abc
SET PASSWORD FOR 'shangxiao'@'localhost' = PASSWORD('123');

-- 回收shangxiao用户在testdb.news 表的所有权限
REVOKE SELECT, UPDATE, INSERT ON testdb.news FROM 'shangxiao'@'localhost';
REVOKE ALL ON testdb.news FROM 'shangxiao'@'localhost';

-- 删除shangxiao
DROP USER 'shangxiao'@'localhost';
