package com.lijiantao.dao;

import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Job;
import com.lijiantao.entity.PayLevel;
import com.lijiantao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayLevelDao {
    public List<PayLevel> findAllPayLevels(){
        DBUtil dbUtil=DBUtil.getInstance();
        List<PayLevel> list=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("select * from pay_level");
            rs=ps.executeQuery();
            list=new ArrayList<>();
            while (rs.next()){
                PayLevel payLevel=new PayLevel();
                payLevel.setId(rs.getInt(1));
                payLevel.setName(rs.getString(2));
                payLevel.setBasePay(rs.getDouble(3));
                list.add(payLevel);


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
    public int addPayLevel(PayLevel payLevel){
        DBUtil dbUtil=DBUtil.getInstance();
        PreparedStatement ps=null;
        Connection conn= null;
        int result=0;
        try {
            conn = dbUtil.getConnection();
            ps=conn.prepareStatement("insert into pay_level(id,name,base_pay) values(?,?,?)");
            ps.setInt(1,payLevel.getId());
            ps.setString(2,payLevel.getName());
            ps.setDouble(3,payLevel.getBasePay());
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
    public int deletePayLevel(int id){
        DBUtil dbUtil=DBUtil.getInstance();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("delete from pay_level where id="+id);
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
    public int findPayIdByPayName(String name){
        DBUtil dbUtil=DBUtil.getInstance();
        Job job=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("select id from pay_level where name like '"+name+"'");
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
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
        return id;

    }
    public int editPayLevel(PayLevel payLevel){
        DBUtil dbUtil=DBUtil.getInstance();
        PreparedStatement ps=null;
        Connection conn= null;
        int result=0;
        try {
            conn = dbUtil.getConnection();
            ps=conn.prepareStatement("update pay_level set name=?,base_pay=? where id=?");

            ps.setString(1,payLevel.getName());
            ps.setDouble(2,payLevel.getBasePay());
            ps.setInt(3,payLevel.getId());
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
    public static void ssss(){

    }
}
