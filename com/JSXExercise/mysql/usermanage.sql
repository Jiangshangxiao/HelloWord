-- 修改自己的密码

SET PASSWORD = PASSWORD('asdfgh');

-- 修改其他人的密码，需要权限, 如果是root用户，则可以成功
SET PASSWORD FOR 'jsx_user'@'local' = PASSWORD('123456789');

SELECT `host`,`USER`, authentication_string FROM mysql.`user`;