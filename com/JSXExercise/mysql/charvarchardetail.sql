-- 演示字符串使用的细节
-- char(4) 和 varchar(4) 这个4表示的是字符，而不是字节，不区分是字符还是汉字
CREATE TABLE t11 (
					`name` char(4)
);
INSERT INTO t11 VALUES('姜上晓好');
SELECT * FROM t11;

CREATE TABLE t12 (
					`name` VARCHAR(4)
);
INSERT INTO t12 VALUES('姜上晓');
INSERT INTO t12 VALUES('ab北京');
SELECT * FROM t12;

-- 如果varchar 不够用，可以考虑使用mediumtext 或者 longtext
-- 如果想简单点，可以使用text
CREATE TABLE t13( content TEXT, content2 MEDIUMTEXT, content3 LONGTEXT);
INSERT INTO t13 VALUES('姜上晓', '姜上晓100', '姜上晓1000');
SELECT * FROM t13;