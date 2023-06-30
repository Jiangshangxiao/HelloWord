-- 外键演示

-- 创建 主表 my_class
CREATE TABLE my_class (
			id INT PRIMARY KEY,
			`name` VARCHAR(32) NOT NULL DEFAULT ''
);

-- 创建 从表 my_stu
CREATE TABLE my_stu (
			id INT PRIMARY KEY, -- 学生编号
			`name` VARCHAR(32) NOT NULL DEFAULT '',
			class_id INT,
			-- 下面指定外键关系
			FOREIGN KEY (class_id) REFERENCES my_class(id)
);

-- 测试数据
INSERT INTO my_class VALUES(100, 'java'), (200, 'web');

SELECT * FROM my_class;

INSERT INTO my_stu VALUES (1, 'tom', 100), (2, 'jack', 200);
INSERT INTO my_stu VALUES (3, 'jsx', 300); -- 报错

SELECT * FROM my_stu;