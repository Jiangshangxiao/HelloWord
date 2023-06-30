-- 演示字符串相关函数的使用,使用emp表来演示
-- charset(str) 返回字符串的字符集
SELECT CHARSET(ename) FROM emp;
-- concat (string2 [....]) 连接字符串,将多个列拼接成一列
SELECT CONCAT(ename,' job is',job) FROM emp;

-- instr (string, substring) 返回substring在string中出现的位置，没有返回0
-- dual 亚元表,系统表可以作为测试表来使用
SELECT INSTR('jiangshangxiao','xiao') FROM DUAL;

-- ucase(string2) 转换成大写
SELECT UCASE(ename) FROM emp;

-- lcase(string2) 转换成小写
SELECT LCASE(ename) FROM emp;

-- left(string2, length) 从string2中的左边起取length个字符
SELECT LEFT(ename, 2) FROM emp;
-- right(string2, length) 从string2中的左边起取length个字符
select RIGHT(ename, 2) FROM 

-- length(string)  string长度[按照字节]
SELECT LENGTH(ename) FROM emp;

-- replace(str, search_str, replace_str) 在str中用replace_str 替换 search_str
SELECT ename, REPLACE(job, 'MANAGER','经理') FROM emp;

-- strcmp(string1, string2) 逐字符比较两字符串大小
SELECT STRCMP('jsx','jsx') FROM DUAL;

-- substring (str, position, length) 从str的position开始[从1开始计算]，取length长度
SELECT SUBSTRING(ename, 1, 2) FROM emp;

-- ltrim (string2) rtrim (string2) trim 去除前端空格或者后端空格
SELECT LTRIM(' 姜上晓 ') FROM DUAL;
SELECT RTRIM(' 姜上晓 ') FROM dual;
SELECT TRIM(' 姜上晓 ') FROM DUAL;

-- 练习: 以首字母小写的方式显示所有员工emp表的姓名
-- 方法1
SELECT CONCAT(LCASE(SUBSTRING(ename, 1, 1)), SUBSTRING(ename, 2)) AS new_name FROM emp;