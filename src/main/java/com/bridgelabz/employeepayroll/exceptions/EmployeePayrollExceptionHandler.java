package com.bridgelabz.employeepayroll.exceptions;
import java.util.List;
import java.util.stream.Collector;
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
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDto> handleMethodArguementNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList=exception.getBindingResult().getAllErrors();
		List<String> errMsg=errorList.stream()
							.map(objError->objError.getDefaultMessage())
							.collect(Collectors.toList());
		ResponseDto responseDto=new ResponseDto("Exception while processing Rest Request",errMsg);
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.BAD_REQUEST);

	}
}
