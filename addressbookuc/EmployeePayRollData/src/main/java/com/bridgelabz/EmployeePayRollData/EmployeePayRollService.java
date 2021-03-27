package com.bridgelabz.EmployeePayRollData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
	private List<EmployeePayRollData> empPayrollList;

	public EmployeePayRollService(List<EmployeePayRollData> empPayrollList) {
		this.empPayrollList = empPayrollList;
	}

	public EmployeePayRollService() {
		super();
	}

	private void readEmployeePayRollData(Scanner sc) {
		System.out.println("Enter Employee Id: ");
		int empId = sc.nextInt();
		System.out.println("Enter Employee Name: ");
		String empName = sc.next();
		System.out.println("Enter Employee salary: ");
		double salary = sc.nextDouble();
		empPayrollList.add(new EmployeePayRollData(empId, empName, salary));
	}

	private void writeEmployeePayRollData() {
		System.out.println("Employee Payroll Details: "+empPayrollList);
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayRollData> empPayrollList = new ArrayList<>();
		EmployeePayRollService empPayrollService = new EmployeePayRollService(empPayrollList);
		Scanner sc = new Scanner(System.in);
		empPayrollService.readEmployeePayRollData(sc);
		empPayrollService.writeEmployeePayRollData();
	}
}