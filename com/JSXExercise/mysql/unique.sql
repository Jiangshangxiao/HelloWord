-- unique的使用

CREATE TABLE t21 (
				id INT UNIQUE NOT NULL, -- 表示id列是不可以重复的
				`name` VARCHAR(32),
				email VARCHAR(32),
				PRIMARY KEY(`name`)
);

INSERT INTO t21 VALUES(1, 'jack', 'jack@souhu.com');
INSERT INTO t21 VALUES(1, 'tom', 'tom@souhu.com'); -- 报错

-- unqiue 使用细节
-- 如果没有指定not null ， 则unique字段可以有多个null
-- 如果有一个列(字段), 是unique not null 使用效果类似primary key
INSERT INTO t21 VALUES (null, 'jiang', 'tom@souhu.com');
SELECT * FROM t21;
-- 一张表可以有多个unique字段

CREATE TABLE t22 (
				id INT UNIQUE NOT NULL, -- 表示id列是不可以重复的
				`name` VARCHAR(32) UNIQUE, -- 表示name不可以重复
				email VARCHAR(32),
				PRIMARY KEY(`name`)
);
DESC t22;