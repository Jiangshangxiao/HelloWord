-- 多表查询
-- 显示雇员名，雇员工资以及所有部门的名字[笛卡尔集]
-- 如何显示部门好为10的部门名、员工名和工资
-- 当需要指定显示某个表的列时，需要 表.列表
SELECT ename, sal, dname, emp.deptno FROM emp, dept WHERE emp.deptno = dept.deptno AND emp.deptno = 10;

-- 显示各个员工的姓名，工资，及其工资的级别
SELECT ename, sal, grade FROM emp, salgrade WHERE sal BETWEEN losal AND hisal;