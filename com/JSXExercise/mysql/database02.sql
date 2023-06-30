#备份jsx_db02 和 jsx_db03 库中的数据,并恢复
#备份,要在Dos下执行mysqldump指令
mysqldump -u root -p -B jsx_db02 jsx_db03 > D:\\bak.sql

DROP DATABASE jsx_db03;

#恢复数据库(需要进入mysql命令行在执行)
source D:\\bak.sql
#第二个恢复方法,直接将bak.sql的内容放到查询编辑器中执行