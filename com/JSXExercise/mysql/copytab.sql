-- 表的复制
-- 为了对某个sql语句进行效率测试，我们需要海量数据时，可以使用此方法为表创建海量数据

CREATE TABLE my_tab01 (
					id INT,
					`name` VARCHAR(32),
					sal DOUBLE,
					job VARCHAR(32),
					deptno INT
);
DESC my_tab01;
SELECT * FROM my_tab01;

--演示如何自我复制
-- 1. 先把emp表的记录复制到my_tab01
INSERT INTO my_tab01 
				(id, `name`, sal, job, deptno)
				SELECT empno, ename, sal, job, deptno FROM emp;
				
-- 2. 自我复制
INSERT INTO my_tab01
				SELECT * FROM my_tab01;	
SELECT COUNT(*) FROM my_tab01;

-- 如果删除一张表的重复记录
-- 1. 先创建一张表 my_tab02,
-- 2. 让 my_tab02 有重复的记录

CREATE TABLE my_tab02 LIKE emp; -- 这个语句把emp表的结构(列), 复制到my_tab02

DESC my_tab02;

INSERT INTO my_tab02 SELECT * FROM emp;

SELECT * FROM my_tab02;
-- 3.考虑去重 my_tab02的记录
/*
					思路
					1. 先创建一张临时表 my_tmp, 该表的结构和my_tab02 一样
					2. 把my_tmp 的记录通过distinct 关键字 处理后 把记录复制到my_tmp
					3. 清除掉my_tab02 记录
					4. 把my_tmp 表的记录复制到 my_tab02
					5. drop 掉临时表 my_tmp
*/
-- 1. 先创建一张临时表 my_tmp, 该表的结构和my_tab02 一样
CREATE TABLE my_tmp LIKE my_tab02;

-- 2. 把my_tmp 的记录通过distinct 关键字 处理后 把记录复制到my_tmp
INSERT INTO my_tmp SELECT DISTINCT * FROM my_tab02;

-- 3. 清除掉my_tab02 记录
DELETE FROM my_tab02;

-- 4. 把my_tmp 表的记录复制到 my_tab02
INSERT INTO my_tab02 SELECT * FROM my_tmp; 

-- 5. drop 掉临时表 my_tmp
SELECT * FROM my_tmp;

SELECT * FROM my_tab02;				