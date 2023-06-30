-- 增强group by的使用
-- 1.显示每种岗位的雇员总数、平均工资
SELECT COUNT(*), AVG(sal), job FROM emp GROUP BY job; 
-- 2.显示雇员总数，以及获得补助的雇员数
-- count(列), 如果该列的值为null，时不会统计
SELECT COUNT(*), COUNT(comm) FROM emp;
-- 拓展要求：统计没有获得补助的员工数
SELECT COUNT(*), COUNT(IF(comm IS NULL,1,null)) FROM emp;
-- 3.显示管理者的总人数
SELECT COUNT(DISTINCT mgr) FROM emp;
-- 4.显示雇员工资的最大差额
SELECT MAX(sal) - MIN(sal) FROM emp;

-- 应用案例：请统计各个部门group by的平均工资 avg，
-- 并且时大于1000的having，并且按照平均工资从高到低排序，order by
-- 取出前两行记录limit

SELECT deptno, avg(sal) AS avg_sal FROM emp
									GROUP BY deptno
									HAVING avg_sal > 1000
									ORDER BY avg_sal DESC
									LIMIT 0, 2;