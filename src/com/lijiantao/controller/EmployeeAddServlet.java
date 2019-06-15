package com.lijiantao.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lijiantao.VO.EmployeeAddVO;
import com.lijiantao.VO.ResultVO;
import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Job;
import com.lijiantao.entity.Staff;
import com.lijiantao.service.EmployeeService;
import com.lijiantao.service.JobService;
import com.lijiantao.service.PayLevelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/addEmployee")
public class EmployeeAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String jobName=req.getParameter("jobName");
        String payName=req.getParameter("payName");
        EmployeeAddVO employeeAddVO=new EmployeeAddVO(id,name,jobName,payName);
        EmployeeService employeeService=new EmployeeService();
        int result=employeeService.addEmployee(employeeAddVO);
        ResultVO resultVO=new ResultVO();
        if(result>0){
            resultVO.setCode(300);
            resultVO.setMsg("成功");
            resultVO.setObj(null);
        }else {
            resultVO.setCode(500);
            resultVO.setMsg("失败");
            resultVO.setObj(null);
        }
        PrintWriter pw=resp.getWriter();
        String str= JSON.toJSONString(resultVO);
        pw.write(str);






    }
}
