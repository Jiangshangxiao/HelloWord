-- 演示时间相关的类型
-- 创建一张表，data,datatime,timestamp
CREATE TABLE t14 (
				birthday DATE, -- 生日
				job_time DATETIME, -- 记录年月日 时分秒
				login_time TIMESTAMP 
									NOT NULL DEFAULT CURRENT_TIMESTAMP
									ON UPDATE CURRENT_TIMESTAMP
									-- 登陆时间，如果希望login_time列自动更新,需要配置
);
INSERT INTO t14(birthday , job_time)
			VALUES('2022-11-11', '2022-11-11 10:10:10');
SELECT * FROM t14;
