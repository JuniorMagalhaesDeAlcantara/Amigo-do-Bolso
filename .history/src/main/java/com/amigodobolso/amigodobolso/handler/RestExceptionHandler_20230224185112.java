package com.amigodobolso.amigodobolso.handler;

import java.util.Date;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amigodobolso.amigodobolso.common.ConversorData;
import com.amigodobolso.amigodobolso.domain.exception.ResourceBadRequestException;
import com.amigodobolso.amigodobolso.domain.exception.ResourceNotFoundException;
import com.amigodobolso.amigodobolso.domain.model.ErrorResposta;
import com.amigodobolso.amigodobolso.domain.model.Titulo;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResposta> handlerResourceNotFoundException(ResourceNotFoundException ex){

        String dataHora = ConversorData.converterDateParaDataEHora(new Date());

        ErrorResposta erro = new ErrorResposta(
            dataHora,
            HttpStatus.NOT_FOUND.value(),
            "Not Found",
            ex.getMessage());

    return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);    
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResposta> handlerResourceBadRequestException(ResourceBadRequestException ex){

        String dataHora = ConversorData.converterDateParaDataEHora(new Date());

        ErrorResposta erro = new ErrorResposta(
            dataHora,
            HttpStatus.BAD_REQUEST.value(),
            "Bad Request",
            ex.getMessage());

    return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);    
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResposta> handlerRequestException(Exception ex){

        String dataHora = ConversorData.converterDateParaDataEHora(new Date());

        ErrorResposta erro = new ErrorResposta(
            dataHora,
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            ex.getMessage());

    return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);    
    }
    

}
