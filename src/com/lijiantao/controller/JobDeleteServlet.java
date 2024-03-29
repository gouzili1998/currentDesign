package com.lijiantao.controller;

import com.lijiantao.VO.ResultVO;
import com.lijiantao.service.EmployeeService;
import com.lijiantao.service.JobService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteJob")
public class JobDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id=req.getParameter("id");
        JobService jobService=new JobService();
        int result=jobService.deleteJob(Integer.parseInt(id));
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(300);
        resultVO.setMsg("成功");
        resultVO.setObj(result);
        PrintWriter pw=resp.getWriter();
        pw.print(resultVO);
    }
}
