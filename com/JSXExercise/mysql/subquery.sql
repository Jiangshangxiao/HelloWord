-- 子查询
-- 如何显示与SMITH同一部门的所有员工
SELECT * FROM emp 
					WHERE deptno = (
								SELECT deptno
								FROM emp
								WHERE ename = 'SMITH'
					);
-- 如何查询和部门10的工作相同的雇员的
-- 名字、岗位、工资、部门号，但是不含10自己的
SELECT DISTINCT job 
					FROM emp
					WHERE deptno = 20;
SELECT ename, job, sal, deptno
							FROM emp
							WHERE job IN (
										SELECT DISTINCT job
										FROM emp
										WHERE deptno = 10
							) AND deptno != 10; 


-- 查询ecshop中各个类别中,价格最高的商品
-- 查询商品表
-- 先得到各个类别中，价格最高的商品

SELECT cat_id, MAX(shop_price)
				FROM ecs_goods
				GROUP BY cat_id;
					
SELECT goods_id, ecs_goods.cat_id, goods_name, shop_price FROM (
						SELECT cat_id , MAX(shop_price) AS max_price
						FROM ecs_goods
						GROUP BY cat_id
				) temp, ecs_goods
				WHERE temp.cat_id = ecs_goods.cat_id 
				AND temp.max_price = ecs_goods.shop_price;
					
							