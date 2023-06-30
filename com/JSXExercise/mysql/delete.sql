-- delete 语句演示

-- 删除表中名称为'老妖怪'的记录
DELETE FROM employee WHERE user_name = '老妖怪';
-- 删除表中所有记录
DELETE FROM employee;

-- delete 语句不能删除某一列的值(可使用update设为null 获取 '')
UPDATE employee set job = '' WHERE user_name = '老妖怪';

SELECT * FROM employee;

--要删除一个表
DROP TABLE employee;