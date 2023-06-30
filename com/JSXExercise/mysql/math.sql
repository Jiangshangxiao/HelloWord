-- 演示数学相关函数
-- ABS(X) 绝对值
SELECT ABS(-10) FROM DUAL;
-- BIN(N) 十进制转二进制
select BIN(10) FROM DUAL;
-- CEILING(X) 向上取整, 得到比x打的最小整数
SELECT CEILING(1.1) FROM DUAL;
-- CONV(N,from_base,to_base) 进制转换
SELECT CONV(8,10,2) FROM DUAL;
-- FLOOR(X)   向下取整, 得到比x小的最大整数
SELECT FLOOR(1.1) FROM DUAL;
-- FORMAT(X,D) 保留小数位数
SELECT FORMAT(78.1232345234,2) FROM DUAL;
-- HEX(N_or_S) 转十六进制

-- LEAST(value1,value2,...) 求最小值
SELECT LEAST( 0,1,2, 4) FROM DUAL;
-- MOD(N,M) 求余
SELECT MOD(10, 3) FROM DUAL;
-- RAND() 返回0到1之间的一个随机数
-- RAND(seed) 返回0到1之间的一个随机数, 如果seed不变，该随机数不变 
SELECT RAND() FROM DUAL;