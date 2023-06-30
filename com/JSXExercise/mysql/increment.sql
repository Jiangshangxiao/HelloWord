-- 演示自增长的使用
-- 创建表
CREATE TABLE t24 (
				id INT PRIMARY KEY AUTO_INCREMENT,
				email VARCHAR(32) NOT NULL DEFAULT '',
				`name` VARCHAR(32) NOT NULL DEFAULT ''
);
DESC t24;

-- 测试自增长的使用
INSERT INTO t24 VALUES (null, 'jack@qq.com', 'jack'), (null, 'tom@qq.com', 'tom');

INSERT INTO t24 (email, `name`) VALUES ('jsx@qq.com', 'jsx');

SELECT * from t24;

-- 修改默认的自增长的开始值
ALTER TABLE t25 AUTO_INCREMENT = 100;
CREATE TABLE t25(
			id INT PRIMARY KEY AUTO_INCREMENT,
			email VARCHAR(32) NOT NULL DEFAULT '',
			`name` VARCHAR(32) NOT NULL DEFAULT ''
);
INSERT INTO t25 VALUES(NULL,'jsx@qq.com', 'jsx');
SELECT * FROM t25;

INSERT INTO t25 VALUES(666, 'jsx@qq.com', 'jsx');