package com.bridgelabz.employeepayroll.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employeepayroll.dto.EmployeePayrollDto;
import com.bridgelabz.employeepayroll.dto.ResponseDto;
import com.bridgelabz.employeepayroll.model.EmployeePayrollData;
import com.bridgelabz.employeepayroll.services.IEmployeePayrollService;
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<ResponseDto> getEmployeeData() {
		List<EmployeePayrollData> employeePayrollDataList=employeePayrollService.getEmployeePayrolldata();
		ResponseDto respDto=new ResponseDto("Get Call Success",employeePayrollDataList);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDto> getEmployeeData(@PathVariable("empId") int empId) {
		ResponseDto respDto;
		EmployeePayrollData employeePayrollData=employeePayrollService.getEmployeePayrollDataById(empId);
		if(employeePayrollData!=null) {
			respDto=new ResponseDto("Get Call For Id Success",employeePayrollData.getName());
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
		} else {
			respDto=new ResponseDto("Id is not Present");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> addEmployeeData(@Valid @RequestBody EmployeePayrollDto employeePayrolldto) {
		employeePayrollService.createEmployeePayrollData(employeePayrolldto);
		ResponseDto respDto=new ResponseDto("Created Employee Payroll Data Successfully");
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
	}
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDto> updateEmployeeData(@PathVariable("empId") int empId,@Valid @RequestBody EmployeePayrollDto employeePayrolldto) {
		ResponseDto respDto;
		if(employeePayrollService.updateEmployeePayrollData(empId,employeePayrolldto)!=null) {
			respDto=new ResponseDto("Updated Employee Payroll Data Successfully");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
		} else {
			respDto=new ResponseDto("Id is not Present");
			return new ResponseEntity<ResponseDto>(respDto,HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDto> deleteEmployeeData(@PathVariable("empId") int empId) {
		ResponseDto respDto;
		employeePayrollService.deleteEmployeePayrollData(empId);
		respDto=new ResponseDto("Deleted Successfully id:"+empId);
		return new ResponseEntity<ResponseDto>(respDto,HttpStatus.OK);
		
	}
}	