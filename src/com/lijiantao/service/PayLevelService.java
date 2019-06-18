package com.lijiantao.service;

import com.lijiantao.dao.JobDao;
import com.lijiantao.dao.PayLevelDao;
import com.lijiantao.entity.Job;
import com.lijiantao.entity.PayLevel;

import java.util.List;

public class PayLevelService {
    public List<PayLevel> findAllPayLevels(){
        PayLevelDao payLevelDao=new PayLevelDao();
        return payLevelDao.findAllPayLevels();
    }
    public int addPayLevel(PayLevel payLevel) {

        PayLevelDao payLevelDao=new PayLevelDao();
        return payLevelDao.addPayLevel(payLevel);


    }
    public int deletePayLevel(int id){
        int result=0;
        PayLevelDao payLevelDao=new PayLevelDao();
        return payLevelDao.deletePayLevel(id);
    }
    public int findPayIdByPayName(String name){
        PayLevelDao payLevelDao=new PayLevelDao();
        return payLevelDao.findPayIdByPayName(name);
    }
    public int editPayLevel(PayLevel payLevel){
        PayLevelDao payLevelDao=new PayLevelDao();
        return payLevelDao.editPayLevel(payLevel);
    }
}
