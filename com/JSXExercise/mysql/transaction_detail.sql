-- 事务细节
-- 1.如果不开始事务，默认情况下，dml操作是自动提交的，不能回滚
INSERT INTO t27 VALUES(300, 'milan'); 

SELECT * FROM t27;

ROLLBACK;

-- 2.如果开始一个事务，你没有创建保存点，可以执行rollback
-- 默认就是回退到是事务开始的状态
START TRANSACTION;
INSERT INTO t27 VALUES(400, 'king');
INSERT INTO t27 VALUES(500, 'scott');
ROLLBACK; -- 表示直接回退到事务开始的状态
COMMIT;

-- 3. 你可以在这个事务中(还没有提交时), 创建多个保存点. 

-- 4. 你可以在事务没有提交前，选择回退到那个保存点
-- 5. innoDB存储引擎支持事务， MyISAM不支持

