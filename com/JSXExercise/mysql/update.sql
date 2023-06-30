#演示update语句
-- 要求: 在上面创建的employee表中修改表中的记录
-- 1.将所有员工薪水修改为5000元.如果没有带where，将会修改所有记录
UPDATE employee SET salary = 5000;
-- 2.将姓名为小妖怪的员工的薪水改为3000元
UPDATE employee SET salary = 3000 WHERE user_name = '小妖怪';
-- 3.将老妖怪的薪水在原有基础上增加1000元
INSERT INTO employee 
						VALUES (200, '老妖怪', '1900-11-11', '2011-11-11', '管小妖怪的', 4000, '大王叫我来管小妖怪', 'D:\\');
UPDATE employee SET salary = salary + 1000 WHERE user_name = '老妖怪';	
-- 可以修改多个列
UPDATE employee SET salary = salary + 1000, job = '出主意的' WHERE user_name = '老妖怪';					
SELECT * FROM employee;