#演示整型
#使用tinyint 演示范围
#表的字符即,校验规则，存储引擎，使用默认
#1. 如果没有指定 unsinged，则TINYINT就是无符号
CREATE TABLE t3 (
			id TINYINT UNSIGNED
);
INSERT INTO t3 VALUES (-128);
SELECT * FROM t3
