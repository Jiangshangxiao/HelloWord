package com.JSXExercise.mhl.service;

import com.JSXExercise.mhl.dao.BillDAO;
import com.JSXExercise.mhl.dao.MultiTableDAO;
import com.JSXExercise.mhl.domain.Bill;
import com.JSXExercise.mhl.domain.MultiTableBean;

import java.util.List;
import java.util.UUID;

/**
 * @author 姜上晓
 * @version 1.0
 * 处理和账单相关的业务逻辑
 */
public class BillService {
    //定义BillDAO属性
    private BillDAO billDAO = new BillDAO();
    //定义一个MenuService 属性
    private MenuService menuService = new MenuService();
    //定义一个DiningTableService
    DiningTableService diningTableService = new DiningTableService();
    //创建一个MultiTableDAO
    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    //编写点餐的方法
    //1.生成账单
    //2.需要更新对应餐桌的状态
    //3,如果成功返回true, 否则返回false
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //生成一个账单号，UUID
        String billID = UUID.randomUUID().toString();

        //将账单生成到bill表
        String sql = "insert into bill values(null,?,?,?,?,?, now(), '未结账')";
        int update = billDAO.update(sql, billID, menuId, nums,menuService.getMenuById(menuId).getPrice() * nums, diningTableId);

        if (update <= 0) {
            return false;
        }

        //需要更新对应餐桌的状态
        return diningTableService.updateDiningTableState(diningTableId, "就餐中");
    }

    //返回所有的账单,提供给View调用
    public List<Bill> getBillList() {
        String sql = "select * from bill";
        return billDAO.queryMulti(sql, Bill.class);
    }

    //返回所有的账单并带有菜品名,提供给View调用
    public List<MultiTableBean> getBillList1() {
        String sql = "SELECT bill.*, menu.`NAME`, menu.price FROM bill, menu WHERE bill.menuId = menu.Id";
        return multiTableDAO.queryMulti(sql, MultiTableBean.class);
    }

    //检查餐桌是否又未结账的账单
    public boolean hasPayBillByDiningTableId(int diningTableId) {
        String sql = "SELECT * FROM bill WHERE diningTableId = ? AND state = '未结账' LIMIT 0, 1";
        Bill bill = billDAO.querySingle(sql, Bill.class, diningTableId);
        return bill != null;
    }

    //完成结账【如果餐桌存在，并且该餐桌又未结账的账单】
    public boolean payBill(int diningTableId, String payMode) {

        //1. 修改bill表
        String sql = "update bill set state=? where diningTableId=? and state='未结账'";
        int update = billDAO.update(sql, payMode, diningTableId);

        if (update <= 0) { //如果更新没有成功，则表示失败
            return false;
        }

        //2. 修改diningTable表
        if (!diningTableService.updateDiningTableToFree(diningTableId, "空")) {
            return false;
        }

        return true;
    }
}
