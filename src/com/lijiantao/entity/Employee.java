package com.lijiantao.entity;

public class Employee {
    private int id;
    private String name;
    private int jobId;
    private int payId;


    public Employee(int id, String name, int jobId, int payId) {
        this.id = id;
        this.name = name;
        this.jobId = jobId;
        this.payId = payId;
    }

    public Employee() {
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

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobId=" + jobId +
                ", payId=" + payId +
                '}';
    }
}
