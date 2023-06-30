#删除数据库指令
#DROP DATABASE jsx_db01;
#使用指令创建数据库
#CREATE DATABASE jsx_db01;
#创建一个使用utf8字符集的jsx_db02数据库
#CREATE DATABASE jsx_db02 CHARACTER SET utf8; 
#创建一个使用utf8字符集,并带校对规则的jsx_db03
#CREATE DATABASE jsx_db03 CHARACTER set utf8 COLLATE utf8_bin;
#下面是一条查询的sql,select查询 * 表示所有字段
SELECT * FROM t1 WHERE name = 'tom';