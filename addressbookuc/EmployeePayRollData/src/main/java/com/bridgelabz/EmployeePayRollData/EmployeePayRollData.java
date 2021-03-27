package com.bridgelabz.EmployeePayRollData;

public class EmployeePayRollData {
	private int empId;
	private String empName;
	private double salary;

	public EmployeePayRollData(int empId, String empName, double salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayRollData [ employee id = "+empId+ " employee Name = "+empName+" salary = "+salary+" ]";
	}
}