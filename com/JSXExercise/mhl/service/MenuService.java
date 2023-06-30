package com.JSXExercise.mhl.service;

import com.JSXExercise.mhl.dao.MenuDAO;
import com.JSXExercise.mhl.domain.Menu;

import java.util.List;

/**
 * @author 姜上晓
 * @version 1.0
 * 完成对menu表的各种操作
 */
public class MenuService {
    //定义MenuDAO 属性
    private MenuDAO menuDAO = new MenuDAO();


    //返回所有的彩屏，返回给界面使用
    public List<Menu> menuList() {
        String sql = "select * from menu";
        return menuDAO.queryMulti(sql, Menu.class);
    }

    //需要方法, 根据id, 返回Menu对象
    public Menu getMenuById(int id) {
        String sql = "select * from menu where id = ?";
        return menuDAO.querySingle(sql, Menu.class, id);
    }
}
