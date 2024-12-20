package tn.movom.app.movom.infrastructure.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tn.movom.app.infra.model.payload.ApiPayload;

import java.net.URI;

@ControllerAdvice
@Slf4j
class HttpExceptionHandler {
	
	@ExceptionHandler
	ResponseEntity<ApiPayload<ProblemDetail>> handleValidationException(MethodArgumentNotValidException e, HttpServletRequest request) {
		record InvalidField(String objName, String fieldName, String reason) {}
		
		var invalidFields = e.getBindingResult().getFieldErrors().stream()
				.map(field -> new InvalidField(
						field.getObjectName(),
						field.getField(),
						field.getDefaultMessage()))
				.toList();
		
		var problemDetail = ProblemDetail.forStatusAndDetail(e.getStatusCode(), "There is|are validation(s) error(s)");
		problemDetail.setType(URI.create(e.getClass().getSimpleName()));
		problemDetail.setInstance(URI.create(request.getRequestURL().toString()));
		problemDetail.setProperty("constraintViolations", invalidFields);
		log.error(e.getMessage());
		log.error(problemDetail.toString());
		
		var payload = ApiPayload.ofFailure(problemDetail);
		
		return ResponseEntity
				.status(payload.body().getStatus())
				.body(payload);
	}
	
	@ExceptionHandler
	ResponseEntity<ApiPayload<ProblemDetail>> handleException(Exception e, HttpServletRequest request) {
		
		var problemDetail = ProblemDetail.forStatusAndDetail(
				HttpStatus.INTERNAL_SERVER_ERROR,
				"Oups! An error has happened, please try later");
		problemDetail.setType(URI.create(e.getClass().getSimpleName()));
		problemDetail.setInstance(URI.create(request.getRequestURL().toString()));
		log.error(e.getMessage());
		log.error(problemDetail.toString());
		
		var payload = ApiPayload.ofFailure(problemDetail);
		
		return ResponseEntity
				.status(payload.body().getStatus())
				.body(payload);
	}
	
}



