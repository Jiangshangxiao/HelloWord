#insert 语句的细节
-- 1.插入的数据应与字段的数据类型相同
-- 比如吧 'abc' 添加到int类型会错误
INSERT INTO `goods` (id, goods_name, price)
						  VALUES('30', '小米手机', 2000);
-- 2.数据的长度应在列的规定范围内，例如: 不能将一个长度为80的字符串加入到长度为40的列中
INSERT INTO `goods` (id, goods_name, price)
						  VALUES('40', '小米手机小米手机小米手机小米手机小米手机小米手机',3000);
-- 3.在values中列出的数据位置必须与被加入的列的排列位置相对应
INSERT INTO `goods` (id, goods_name, price)
						  VALUES('vovo手机', 40, 2000);
-- 4.字符和日期类型的数据应包含在单引号中
INSERT INTO `goods` (id, goods_name, price)
						  VALUES(40, vovo手机, 2000);
-- 5.字符可以插入空值[前提是该字段允许为空], insert into table value(null)
INSERT INTO `goods` (id, goods_name, price)
						  VALUES(40, 'vovo手机', 2000);
-- 6.insert into table name (列名..) valuse(),(),() 形式添加多条记录
INSERT INTO `goods` (id, goods_name, price)
						  VALUES(40, 'vovo手机', 2000), (50, '索尼手机', 4000), (60, '魅族手机', 3000);
-- 7.如果是给表中的所有字段添加数据,可以不屑前面的字段名称
INSERT INTO 'goods'
						VALUES(70, 'IBM手机', 3000);
-- 8.默认值的使用,当不给某个字段值时,如果以后默认值就会添加,否则报错
INSERT INTO 'goods'
						VALUES(70, 'IBM手机');
SELECT * FROM goods;						