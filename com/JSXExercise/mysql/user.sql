-- mysql用户的管理
-- 当我们做项目的开发时，可以根据不同的开发人员，赋给它相应的mysql操作权限
-- 所以，mysql数据库管理人员(root), 根据需要创建不同的用户，赋给相应的权限，供人员使用

-- 1.创建新的用户
-- 'jxs_user'@'localhost' 表示用户的完整信息 'jxs_user' 用户名 'localhost' 登录的ip
-- INENTIFIED BY 123456 密码，需要注意存放到mysql.user表时，是password('123456') 加密后的密码
CREATE USER 'jxs_user'@'localhost' IDENTIFIED BY '123456';

SELECT `host`, 'user', authentication_string
			FROM mysql.user;
			
-- 2. 删除用户
DROP USER 'jxs_user'@'localhost';	