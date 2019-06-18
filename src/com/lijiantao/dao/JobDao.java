package com.lijiantao.dao;

import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Job;
import com.lijiantao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDao {
    public List<Job> findAllJobs(){
        DBUtil dbUtil=DBUtil.getInstance();
        List<Job> list=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("select * from job");
            rs=ps.executeQuery();
            list=new ArrayList<>();
            while (rs.next()){
                Job job=new Job();
                job.setId(rs.getInt(1));
                job.setName(rs.getString(2));
                list.add(job);


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
    public int editJob(Job job){
        DBUtil dbUtil=DBUtil.getInstance();
        PreparedStatement ps=null;
        Connection conn= null;
        int result=0;
        try {
            conn = dbUtil.getConnection();
            ps=conn.prepareStatement("update job set name=? where id=?");

            ps.setString(1,job.getName());
            ps.setInt(2,job.getId());
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
    public int addJob(Job job){
        DBUtil dbUtil=DBUtil.getInstance();
        PreparedStatement ps=null;
        Connection conn= null;
        int result=0;
        try {
            conn = dbUtil.getConnection();
            ps=conn.prepareStatement("insert into job(id,name) values(?,?)");
            ps.setInt(1,job.getId());
            ps.setString(2,job.getName());

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
    public int deleteJob(int id){
        DBUtil dbUtil=DBUtil.getInstance();
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("delete from job where id="+id);
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

    public Job findJob(int id){
        DBUtil dbUtil=DBUtil.getInstance();
        Job job=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("select * from job where id="+id);
            rs=ps.executeQuery();
            job=new Job();
            if(rs.next()){

                job.setId(rs.getInt(1));
                job.setName(rs.getString(2));



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
        return job;

    }
    public int findJobIdByName(String name){
        DBUtil dbUtil=DBUtil.getInstance();
        Job job=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn=dbUtil.getConnection();
            ps=conn.prepareStatement("select id from job where name like '"+name+"'");
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


}
