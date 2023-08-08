package com.yunhe.entity;

public class Emp {
    private int employeeId;
    private String name;
    private Double salary;
    private String hireDate;
    private int departmentId;

    public Emp(int employeeId, String name, Double salary, String hireDate, int departmentId) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }

    public Emp() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate='" + hireDate + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
