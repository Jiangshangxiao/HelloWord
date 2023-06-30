-- all 和 any的使用
	
-- 显示工资比部门对30的所有员工的工资高的员工的姓名、工资和部门号

SELECT ename, sal, deptno
					FROM emp
					WHERE sal > ALL (
									SELECT sal
											FROM emp
											WHERE deptno = 30
								);

-- 也可以这样写
SELECT ename, sal, deptno
					FROM emp
					WHERE sal > (
									SELECT MAX(sal)
											FROM emp
											WHERE deptno = 30
								);

-- 如果显示工资比部门 30 的其中一个员工的工资高的员工的姓名、工资和部门号

SELECT ename, sal, deptno
					FROM emp
					WHERE sal > ANY (
									SELECT sal
											FROM emp
											WHERE deptno = 30
								);														