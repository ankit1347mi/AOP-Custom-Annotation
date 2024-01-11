package com.tyss.aopcustomannotation.exception;

import com.tyss.aopcustomannotation.structure.ResponseStructure;
import com.tyss.aopcustomannotation.structure.ServiceMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    private ServiceMessage serviceMessage;

    public AppExceptionHandler(ServiceMessage serviceMessage) {
        this.serviceMessage = serviceMessage;
    }

    @ExceptionHandler(NoSuchEmployeeFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleNoSuchEmployeeFoundException(NoSuchEmployeeFoundException exception) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(serviceMessage.getFailed());
        responseStructure.setData(exception.getMessage());

        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseStructure<String>> handleNullpointerException(NullPointerException exception) {
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(serviceMessage.getFailed());
        responseStructure.setData(exception.getMessage());

        return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
    }
}
