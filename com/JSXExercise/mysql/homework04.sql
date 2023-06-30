-- 1. 列出至少有一个员工的所有部门
/*
				先查出各个部门有多少人
				使用having子句过滤
*/
SELECT COUNT(*) AS c, deptno
				FROM emp
				GROUP BY deptno
				HAVING c > 1;
-- 2. 列出薪金比'smith'多的所有员工
/*
				先查出smith的sal
				然后其他员工sal大于smith即可
*/
SELECT * FROM emp 
				WHERE sal > (
						SELECT sal
								FROM emp
								WHERE ename = 'SMITH'
				);
-- 3. 列出受雇日期晚与其直接上级的所有员工
/*
				先把emp表当作两张表worker, leader
*/
SELECT worker.ename AS '员工名', worker.hiredate AS '员工入职时间', 
				leader.ename AS '上级名', leader.hiredate AS '上级入职时间'
				FROM emp worker, emp leader
				WHERE worker.hiredate > leader.hiredate
				AND worker.mgr = leader.empno;
-- 4. 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门
/*
				这里因为需要显示所有部门，因此考虑使用外连接
*/
SELECT dname, emp.* FROM dept LEFT JOIN emp ON dept.deptno = emp.deptno;
-- 5. 列出所有'CLERK'的姓名及其部门名称
SELECT ename, dname FROM emp, dept
					WHERE job = 'CLERK' AND emp.deptno = dept.deptno;
-- 6. 列出最低薪金大于1500的各种工作
/*
				查询各个部门的最低工资
*/
SELECT MIN(sal) AS min_sal, job
				FROM emp
				GROUP BY job
				HAVING min_sal > 1500;
-- 7. 列出不部门'sales'工作的员工的姓名
SELECT ename, dname from emp, dept
				WHERE emp.deptno = dept.deptno AND dname = 'SALES';

-- 8. 列出薪金高于公司平均薪金的所有员工
SELECT * FROM emp
				WHERE sal > (
						SELECT AVG(sal) FROM emp
				);
-- 9. 列出与'scott'从事相同工作的左右员工
SELECT * FROM emp WHERE job = (
			SELECT job FROM emp WHERE ename = 'SCOTT'
) AND ename != 'SCOTT';
-- 10. 列出薪金高于在部门30工作的所有员工的薪金的员工姓名和薪金
-- 先查出30部门的最高工资
SELECT ename, sal FROM emp
			WHERE sal > (
					SELECT MAX(sal) FROM emp WHERE deptno = 30
			);
-- 11. 列出在每个部门工作的员工数量、平均工资和平均服务期限
SELECT COUNT(*) AS '部门员工数量', deptno, AVG(sal) AS '部门平均工资',
				FORMAT(AVG(DATEDIFF(NOW(),hiredate) / 365),2) AS '平均服务年限(年)'
				FROM emp
				GROUP BY deptno;
-- 12. 列出所有员工的姓名、部门名称和工资
-- 就是emp 和dept联合查询, 连接条件就是emp.depton = dept.deptno

-- 13. 列出所有部门的详细信息和部门人数
-- 1. 先得到各个部门的人数,把下面的结果看成临时表
SELECT COUNT(*) AS c, deptno
			FROM emp
			GROUP BY deptno;
-- 2. 
SELECT dept.*, tmp.c FROM dept, (
			SELECT COUNT(*) AS c, deptno
			FROM emp
			GROUP BY deptno
) tmp WHERE dept.deptno = tmp.deptno;
			
-- 14. 列出各种工作的最低工资
SELECT MIN(sal), job FROM emp GROUP BY job;
-- 15. 列出manager的最低薪金
SELECT MIN(sal), job FROM emp WHERE job = 'MANAGER';
-- 16. 列出所有员工的年工资，按年薪从低到高排序
-- 1.显得员工的年工资
SELECT ename, (sal + IFNULL(comm,0)) * 12 AS	year_sal
					FROM emp
					ORDER BY year_sal;
					