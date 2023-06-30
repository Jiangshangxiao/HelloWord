# 演示流程控制语句

# IF(expr1,expr2,expr3) 如果expr1 为 true ，则返回expr2 否则返回expr3
SELECT IF(TRUE,'北京','上海') FROM DUAL;
# IFNULL(expr1,expr2) 如果expr1不为空null，则返回expr1，否则返回expr2
SELECT IFNULL(NULL,'姜上晓') FROM DUAL;
# SELECT CASE WHEN expr1 THEN expr2 WHEN expr3 THEN expr4 ELSE expr5 END; [类似多重分支.]
# 如果expr1 为TRUE,则返回expr2,如果expr2 为t, 返回 expr4, 否则返回 expr5

SELECT case 
				WHEN TRUE THEN 'jack' --jack
				WHEN FALSE THEN 'tom'
				ELSE 'mary' END;

-- 1.查询emp表，如果comm时null，则显示0.0
-- 判断是否为null要使用is null ，判断不为空 使用is not
SELECT ename, IF(comm IS NULL, 0.0, comm) FROM emp;

-- 2.如果emp表的job时clerk则显示职员，如果时manager则显示经理
-- 如果时salesman 则显示销售人员，其他正常显示
SELECT ename, (SELECT case 
								WHEN job = 'CLERK' THEN '职员' 
								WHEN job = 'MANAGER' THEN '经理'
								WHEN job = 'SALESMAN' THEN '销售人员'
								ELSE job END) AS 'job'
FROM emp;

				