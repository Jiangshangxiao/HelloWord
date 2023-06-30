#练习insert 语句
-- 创建一张商品表goods (id int, goods_name varchar(10), price double);
-- 添加2条记录
create TABLE `goods` (
				id INT,
				goods_name VARCHAR(10),
				price double
)CHARSET utf8 COLLATE utf8_bin;
-- 添加数据
INSERT INTO `goods` (id, goods_name, price)
							VALUES(10, '苹果手机', 4000);
INSERT INTO `goods` (id, goods_name, price)
							VALUES(20, '三星手机', 3000);
SELECT * FROM goods;														