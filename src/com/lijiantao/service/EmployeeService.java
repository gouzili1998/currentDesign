package com.lijiantao.service;

import com.lijiantao.VO.EmployeeAddVO;
import com.lijiantao.VO.EmployeeVO;
import com.lijiantao.dao.EmployeeDao;
import com.lijiantao.dao.JobDao;
import com.lijiantao.dao.PayLevelDao;
import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Staff;

import java.util.List;

public class EmployeeService {
    public int addEmployee(EmployeeAddVO employeeAddVO) {
        JobDao jobDao=new JobDao();
        PayLevelDao payLevelDao=new PayLevelDao();
        int jobId=jobDao.findJobIdByName(employeeAddVO.getJobName());
        int payId=payLevelDao.findPayIdByPayName(employeeAddVO.getPayName());
        int result=0;
        if(jobId>0&&payId>0){
            EmployeeDao employeeDao=new EmployeeDao();
            Employee employee=new Employee(employeeAddVO.getId(),employeeAddVO.getName(),jobId,payId);
            result=employeeDao.addEmployee(employee);
        }


        return result;


    }
    public List<EmployeeVO> findAllEmployees(){
        EmployeeDao employeeDao=new EmployeeDao();
        return employeeDao.findAllEmployees();
    }
    public int deleteEmployee(List<Integer> idList){
        int result=0;
        EmployeeDao employeeDao=new EmployeeDao();
        return employeeDao.deleteEmployee(idList);
    }

}
