package com.lijiantao.controller;

import com.alibaba.fastjson.JSONArray;
import com.lijiantao.VO.ResultVO;
import com.lijiantao.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/deleteEmployee")
public class EmployeeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        BufferedReader reader=new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line=null;
        List<Integer> idList=null;
        while((line=reader.readLine())!=null){
            idList= JSONArray.parseArray(line,Integer.class);
        }
        EmployeeService employeeService=new EmployeeService();
        int result=employeeService.deleteEmployee(idList);

        ResultVO resultVO=new ResultVO();
        resultVO.setCode(300);
        resultVO.setMsg("成功");
        resultVO.setObj(result);
        PrintWriter pw=resp.getWriter();
        pw.print(resultVO);
    }

}
