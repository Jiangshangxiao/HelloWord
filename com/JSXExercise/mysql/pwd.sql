-- 演示加密函数和系统函数

-- USER() 查询用户
-- 可以查看登录到mysql的有哪些用户，以及登录的ip
SELECT USER() FROM DUAL;
-- DATABASE() 查询当前使用数据库的名字
SELECT DATABASE() FROM DUAL;
-- MD5(str) 为字符串算出一个MD5 32的字符串, 常用于(用户密码) 加密
-- root 密码是jsx -> 加密md5 -> 在数据库中存放的是加密后的密码
SELECT MD5('jsx') FROM DUAL;

--演示用户表，存放密码时，时MD5
CREATE TABLE jsx_user (
            id INT,
						`name` VARCHAR(32) NOT NULL DEFAULT '',
						pwd CHAR(32) NOT NULL DEFAULT ''
);
INSERT INTO jsx_user VALUES(100, '姜上晓', MD5('jsx'));
SELECT * FROM jsx_user;

SELECT * FROM jsx_user WHERE `name` = '姜上晓' AND pwd = md5('jsx');

-- PASSWORD(str) 加密函数，mysql数据库的用户密码就是password函数加密
SELECT PASSWORD('jsx') from DUAL;

-- select * from mysql.user \G 从原文密码str 计算并返回密码字符串
-- 通常用于对mysql数据库的用户密码加密
-- mysql.user 表示 数据库.表
SELECT * FROM mysql.user; 