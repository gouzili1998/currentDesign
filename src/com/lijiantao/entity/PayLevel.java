package com.lijiantao.entity;

public class PayLevel {
    private int id;
    private String name;
    private double basePay;

    public PayLevel(int id, String name, double basePay) {
        this.id = id;
        this.name = name;
        this.basePay = basePay;
    }

    public PayLevel() {
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

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }
}
