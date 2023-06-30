-- 主键使用

-- id   name   email
CREATE TABLE t17 (
				id INT PRIMARY KEY, -- 表示id列是主键
				`name` VARCHAR(32),
				email VARCHAR(32)
);

-- 主键列的值是不可以重复的
INSERT INTO t17
				VALUES(1, 'jack', 'jack@souhu.com');

INSERT INTO t17
				VALUES(2, 'tom', 'tom@souhu.com');

INSERT INTO t17
				VALUES(1, 'jsx', 'jsx@souhu.com'); -- 报错 

-- 主键使用的细节讨论
-- primary key 不能重复而且不能为null
INSERT INTO t17
				VALUES(null, 'jack', 'jack@souhu.com'); --报错
-- 一张表最多只能有一个主键，但可以是复合主键
CREATE TABLE t18 (
				id INT,
				`name` VARCHAR(32),
				email varchar(32),
				PRIMARY KEY (id, `name`) -- 这里就是复合主键
);
INSERT INTO t18 
					VALUES(1, 'tom', 'tom@souhu.com');
INSERT INTO t18
					VALUES(1, 'jack', 'jack@souhu.com');
SELECT * FROM t18;					
-- 主键的指定方式有两种
-- 直接在字段名后指定: 字段名 primakry key
-- 在表定义最后写 primary key (列名)
CREATE TABLE t19 (
			id INT,
			`name` VARCHAR(32) PRIMARY KEY,
			email VARCHAR(32)
);

CREATE TABLE t20 (
			id INT,
			`name` VARCHAR(32),
			email VARCHAR(32),
			PRIMARY KEY(`name`)
);
-- 使用desc 表名，可以看到primary key的情况
DESC t18;												