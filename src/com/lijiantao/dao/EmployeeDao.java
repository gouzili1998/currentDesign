package com.lijiantao.dao;

import com.lijiantao.VO.EmployeeVO;
import com.lijiantao.VO.ResultVO;
import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Staff;
import com.lijiantao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public int addEmployee(Employee employee){
        DBUtil dbUtil=DBUtil.getInstance();
        PreparedStatement ps=null;
        Connection conn= null;
        int result=0;
        try {
            conn = dbUtil.getConnection();
            ps=conn.prepareStatement("insert into employee(id,name,job_id,level_id) values(?,?,?,?)");
            ps.setInt(1,employee.getId());
            ps.setString(2,employee.getName());
            ps.setInt(3,employee.getJobId());
            ps.setInt(4,employee.getPayId());
            result=ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=ps||!ps.isClosed()){
                    ps.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbUtil.closeConnection();
            return result;
        }


    }
    public List<EmployeeVO> findAllEmployees(){
        DBUtil dbUtil=DBUtil.getInstance();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<EmployeeVO> list=null;
        try {
            conn = dbUtil.getConnection();
            String sql="select employee.id,employee.name job_name,job.name,pay_level.base_pay " +
                    "from employee,job,pay_level " +
                    "where employee.job_id=job.id and employee.level_id=pay_level.id";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            list=new ArrayList<>();
            while (rs.next()){
                EmployeeVO employeeVO=new EmployeeVO();
                employeeVO.setId(rs.getInt(1));
                employeeVO.setName(rs.getString(2));
                employeeVO.setJobName(rs.getString(3));
                employeeVO.setPay(rs.getDouble(4));
                list.add(employeeVO);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(null!=ps||!ps.isClosed()){
                    ps.close();
                }
                if(null!=rs||!rs.isClosed()){
                    rs.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            dbUtil.closeConnection();
        }

        return list;

    }
    public int deleteEmployee(int id){
        DBUtil dbUtil=DBUtil.getInstance();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("delete from employee where id="+id);
            result=ps.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=ps||!ps.isClosed()){
                    ps.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbUtil.closeConnection();

        }
        return result;
    }
}
