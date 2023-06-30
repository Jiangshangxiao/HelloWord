-- 查看当前会话隔离级别
SELECT @@tx_isolation;
-- 查看系统当前的隔离级别
SELECT @@global.tx_isolation;
-- 设置当前会话隔离级别
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
-- 设置当前系统隔离级别
SET GLOBAL TRANSACTION ISOLATION LEVEL [你设置的隔离级别];