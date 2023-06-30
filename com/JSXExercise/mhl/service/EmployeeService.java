package com.JSXExercise.mhl.service;

import com.JSXExercise.mhl.dao.EmployeeDAO;
import com.JSXExercise.mhl.domain.Employee;

/**
 * @author 姜上晓
 * @version 1.0
 * 该类完成对employee表的各种操作(通过调用EmployeeDAO对象完成)
 */
public class EmployeeService {
    //定义一个EmployeeDAO属性
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //方法，根据empId 和 pwd 返回一个Employee对象
    //如果查询不到, 就返回null
    public Employee getEmployeeByIdAndPwd(String empId, String empPwd) {
        String sql = "select * from employee where empId=? and pwd=md5(?)";
        return employeeDAO.querySingle(sql,Employee.class, empId, empPwd);
    }
}
