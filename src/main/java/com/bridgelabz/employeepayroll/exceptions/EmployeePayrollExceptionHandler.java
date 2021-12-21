package com.bridgelabz.employeepayroll.exceptions;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bridgelabz.employeepayroll.dto.ResponseDto;
@ControllerAdvice
public class EmployeePayrollExceptionHandler {
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDto> handleEmployeePayrollException(EmployeePayrollException exception){
		ResponseDto responseDto=new ResponseDto("Exception while processing Rest Request",exception.getMessage());
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.BAD_REQUEST);
	}
}
