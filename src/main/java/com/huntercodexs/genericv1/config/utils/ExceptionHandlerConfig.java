package com.huntercodexs.genericv1.config.utils;

import com.huntercodexs.genericv1.dto.response.GenericErrorResponseDto;
import com.huntercodexs.genericv1.exception.MMBISException;
import com.huntercodexs.genericv1.exception.MMBISExceptionGeneric;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = {MMBISExceptionGeneric.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

    	GenericErrorResponseDto genericServiceErrorResponseDTO = new GenericErrorResponseDto();

		if (ex instanceof MMBISException) {
    		
    		MMBISException mmbisException = (MMBISException) ex;
    		genericServiceErrorResponseDTO.setCodeError(mmbisException.getCodeError());
    		genericServiceErrorResponseDTO.setMessage(mmbisException.getMessage());
    		genericServiceErrorResponseDTO.setSubCodeError(mmbisException.getSubCodeError());

            return handleExceptionInternal(
					ex,
					genericServiceErrorResponseDTO,
                    new HttpHeaders(),
					HttpStatus.CONFLICT,
					request);

    	} else {

    		genericServiceErrorResponseDTO.setMessage("Unknown error");

    		return handleExceptionInternal(
					ex,
					ex.getMessage(),
                    new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR,
					request);

    	}
    }
}
