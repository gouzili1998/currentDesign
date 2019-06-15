package com.lijiantao.controller;

import com.alibaba.fastjson.JSONObject;
import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Job;
import com.lijiantao.service.EmployeeService;
import com.lijiantao.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addJob")
public class JobAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Job job=new Job(3,"产品部");
        JobService jobService=new JobService();
        int result=jobService.addJob(job);
        JSONObject jsonObject=new JSONObject();
        if(result>0){
            jsonObject.put("id","300");
            jsonObject.put("msg","添加成功");
        }else {
            jsonObject.put("id","500");
            jsonObject.put("msg","添加失败");
        }
        PrintWriter pw=resp.getWriter();
        pw.print(jsonObject);
    }
}
