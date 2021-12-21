package com.bridgelabz.employeepayroll.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.exceptions.EmployeePayrollException;
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
		return employeePayrollList.stream()
				.filter(empData->empData.getEmployeeId()==empId)
				.findFirst()
				.orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
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
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
		empData.setName(employeePayrollDto.name);
		empData.setSalary(employeePayrollDto.salary);
		employeePayrollList.set(empId-1,empData);
		return empData;
	}
	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeePayrollList.stream()
		.filter(empData->empData.getEmployeeId()==empId)
		.findFirst()
		.orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
		employeePayrollList.remove(empId);
	}
}
