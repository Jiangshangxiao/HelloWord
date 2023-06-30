-- 多表查询的自连接
-- 显示公司员工和他的上级的名字
-- 员工和上级时通过emp表的mgr列关联

SELECT worker.ename AS '职员名', boss.ename AS '上级名'  
								FROM emp worker, emp boss
								WHERE worker.mgr = boss.empno;