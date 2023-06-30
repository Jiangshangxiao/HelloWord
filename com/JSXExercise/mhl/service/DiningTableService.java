package com.JSXExercise.mhl.service;

import com.JSXExercise.mhl.dao.DiningTableDAO;
import com.JSXExercise.mhl.domain.DiningTable;

import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class DiningTableService { //业务层
    //定义一个DiningTableDAO对象
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //返回所有餐桌的信息
    public List<DiningTable> getAllDiningTable() {
        String sql = "select id, state from diningTable";
        return diningTableDAO.queryMulti(sql, DiningTable.class);
    }

    //根据id, 查询对应的餐桌DiningTable对象
    //如果返回null, 表示id编号对应的餐桌不存在
    public DiningTable getDiningTableById(int id) {
        String sql = "select * from diningTable where id = ?";
        return  diningTableDAO.querySingle(sql, DiningTable.class, id);
    }

    //如果餐厅可以预定，调用方法，对其状态进行更新(包括预定人的名字和电话)
    public boolean orderDiningTable(int id, String orderName, String orderTel) {
        String sql = "update diningTable set state = '已经预定', orderName = ?, orderTel = ? where id = ?";
        return  diningTableDAO.update(sql, orderName, orderTel, id) > 0 ? true : false;
    }

    //需要提供一个更新餐桌状态的方法
    public boolean updateDiningTableState(int id, String state) {
        String sql = "update diningTable set state=? where id=?";
        int update = diningTableDAO.update(sql, state, id);
        return update > 0;
    }

    //提供方法，将指定的餐桌设置为空闲的状态
    public boolean updateDiningTableToFree(int id, String state) {
        String sql = "update diningTable set state=?,orderName='',orderTel='' where id=?";
        int update = diningTableDAO.update(sql, state, id);
        return update > 0;
    }
}
