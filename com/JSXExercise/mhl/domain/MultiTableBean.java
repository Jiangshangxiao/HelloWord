package com.JSXExercise.mhl.domain;

import java.util.Date;

/**
 * @author 姜上晓
 * @version 1.0
 * 这是一个javabean 可以和多张表进行对应
 */
public class MultiTableBean {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Double money;
    private Integer nums;
    private Integer diningTableId;
    private Date billDate;
    private String state;
    //增加一个来自menu表的列name
    private String name;
    //增加来自menu表的列price
    private Double price;

    public MultiTableBean() {
    }

    public MultiTableBean(Integer id, String billId, Integer menuId, Double money,Integer nums, Integer diningTableId, Date billDate, String state, String name, Double price) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.money = money;
        this.nums = nums;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + menuId +
                "\t\t\t" + nums +
                "\t\t\t" + money +
                "\t\t" + diningTableId +
                "\t\t" + billDate +
                "\t\t" + state +
                "\t\t" + name +
                "\t\t" + price;
    }
}
