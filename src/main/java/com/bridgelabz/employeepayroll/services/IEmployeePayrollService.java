package com.bridgelabz.employeepayroll.services;
import java.util.List;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
public interface IEmployeePayrollService {
	List<EmployeePayrollData> getEmployeePayrolldata();
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto);
	EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDto employeePayrollDto);
	void deleteEmployeePayrollData(int empId);
}
