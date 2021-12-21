package com.bridgelabz.employeepayroll.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
@Service
public class EmployeePayrollService implements IEmployeePayrollService{
	private List<EmployeePayrollData> employeePayrollList=new ArrayList<EmployeePayrollData>();
	@Override
	public List<EmployeePayrollData> getEmployeePayrolldata() {
		return employeePayrollList;
	}
	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		try {
			return employeePayrollList.get(empId-1);
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
		EmployeePayrollData empData=null;
		empData=new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDto);
		employeePayrollList.add(empData);
		return empData;
	}
	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDto employeePayrollDto) {
		try {
			EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
			empData.setName(employeePayrollDto.name);
			empData.setSalary(employeePayrollDto.salary);
			employeePayrollList.set(empId-1,empData);
			return empData;
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	@Override
	public int deleteEmployeePayrollData(int empId) {
		try {
			employeePayrollList.remove(empId-1);
			return 1;
		} catch(IndexOutOfBoundsException e) {
			return 0;
		}
	}
}
