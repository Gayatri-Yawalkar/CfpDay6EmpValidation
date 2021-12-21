package com.bridgelabz.employeepayroll.dto;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Data
public class EmployeePayrollDto {
	@NotEmpty(message="Employee Name cannot be Empty")
	@Pattern(regexp="[A-Z][a-z]{2,}",message="Employee Name Invalid")
	public String name;
	@Min(value=1000,message="Min wage should be more than 1000")
	public long salary;
	public EmployeePayrollDto(String name,long salary) {
		this.name=name;
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "Name="+name+" salary="+salary;
	}
}
