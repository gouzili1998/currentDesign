package com.lijiantao.VO;

public class EmployeeAddVO {
    private int id;
    private String name;
    private String jobName;
    private String payName;

    public EmployeeAddVO(int id, String name, String jobName, String payName) {
        this.id = id;
        this.name = name;
        this.jobName = jobName;
        this.payName = payName;
    }

    public EmployeeAddVO() {
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

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }
}
