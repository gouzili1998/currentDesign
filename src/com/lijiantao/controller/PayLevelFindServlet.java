package com.lijiantao.controller;

import com.alibaba.fastjson.JSON;
import com.lijiantao.VO.ResultVO;
import com.lijiantao.entity.Employee;
import com.lijiantao.entity.PayLevel;
import com.lijiantao.service.EmployeeService;
import com.lijiantao.service.PayLevelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/findAllPayLevels")
public class PayLevelFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PayLevelService payLevelService=new PayLevelService();


        List<PayLevel> list=payLevelService.findAllPayLevels();
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(300);
        resultVO.setMsg("成功");
        resultVO.setObj(list);
        String json= JSON.toJSONString(resultVO);
        PrintWriter pw=resp.getWriter();
        pw.write(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
