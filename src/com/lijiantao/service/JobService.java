package com.lijiantao.service;

import com.lijiantao.dao.EmployeeDao;
import com.lijiantao.dao.JobDao;
import com.lijiantao.entity.Employee;
import com.lijiantao.entity.Job;

import java.util.List;

public class JobService {
    public List<Job> findAllJobs(){
        JobDao jobDao=new JobDao();
        return jobDao.findAllJobs();
    }
    public int addJob(Job job) {

        JobDao jobDao=new JobDao();
        return jobDao.addJob(job);


    }
    public int editJob(Job job){
        JobDao jobDao=new JobDao();
        return jobDao.editJob(job);
    }
    public int deleteJob(int id){
        JobDao jobDao=new JobDao();
        return jobDao.deleteJob(id);
    }
    public Job findJob(int id){
        JobDao jobDao=new JobDao();
        return jobDao.findJob(id);
    }
    public int findJobIdByName(String name){
        JobDao jobDao=new JobDao();
        return jobDao.findJobIdByName(name);
    }
}
