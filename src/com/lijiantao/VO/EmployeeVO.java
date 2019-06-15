package com.lijiantao.VO;

public class EmployeeVO {
    private int id;
    private String name;
    private String jobName;
    private double pay;

    public EmployeeVO(int id, String name, String jobName, double pay) {
        this.id = id;
        this.name = name;
        this.jobName = jobName;
        this.pay = pay;
    }

    public EmployeeVO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}
