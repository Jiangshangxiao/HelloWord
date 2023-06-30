-- 日期时间相关函数

-- CURRENT_DATE() 当前日期
SELECT CURRENT_DATE from DUAL;
-- CURRENT_TIME() 当前时间
SELECT CURRENT_TIME FROM DUAL;
-- CURRENT_TIMESTAMP 当前时间戳
SELECT CURRENT_TIMESTAMP FROM DUAL;


-- 创建测试表 信息表
CREATE TABLE mes (
				id INT,
				content VARCHAR(30),
				send_time DATETIME
)

-- 添加一条记录
INSERT INTO mes VALUE(1, '北京新闻', CURRENT_TIMESTAMP);
INSERT INTO mes VALUES(2, '上海新闻', NOW());
INSERT INTO mes VALUES(3, '广州新闻', NOW());

SELECT * FROM mes;

-- 应用实例
-- 显示所有新闻信息, 发布日期值显示日期, 不用显示时间
SELECT id, content, DATE(send_time) FROM mes;
-- 请查询在10分钟内发布的新闻
SELECT * FROM mes WHERE DATE_ADD(send_time,INTERVAL 10 MINUTE) >= NOW();
-- 请在mysql的sql语句中求出2011-11-11和1990-1-1相差多少天
SELECT DATEDIFF('2011-11-11','1990-01-01') FROM DUAL;
-- 请用mysql的sql语句求出你活了多少天
SELECT DATEDIFF(NOW(), '1996-04-26') FROM DUAL;
-- 如果你能活80岁，求出你还能活多少天
SELECT DATEDIFF(DATE_ADD('1996-04-26',INTERVAL 80 YEAR), NOW()) FROM DUAL;

-- year|month|day date (datetime)
SELECT YEAR(NOW()) FROM DUAL;
SELECT MONTH(NOW()) FROM DUAL;
SELECT DAY(NOW()) FROM DUAL;

-- FROM_UNIXTIME(unix_timestamp) 返回的是1970-1-1 到现在的秒数
SELECT UNIX_TIMESTAMP() FROM DUAL;

-- FROM_UNIXTIME(unix_timestamp) 可以把一个unix_timestamp秒数，转成指定格式的日期
SELECT FROM_UNIXTIME(1686870817, '%Y-%m-%d %H:%i:%s') FROM DUAL;