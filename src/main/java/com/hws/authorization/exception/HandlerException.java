package com.hws.authorization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hws.exception.DataConflictException;
import com.hws.exception.DataNotFoundException;
import com.hws.exception.InternalServerException;
import com.hws.exception.ParameterInvalidException;
import com.hws.exception.PermissionForbiddenException;
import com.hws.exception.RemoteAccessException;
import com.hws.exception.UserNotLoginException;
import com.hws.model.ResultModel;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler({ParameterInvalidException.class})
    public ResponseEntity<ResultModel> handlerParameterInvalidException(ParameterInvalidException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }
    
    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<ResultModel> handlerDataNotFoundException(DataNotFoundException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }
    
    @ExceptionHandler({DataConflictException.class})
    public ResponseEntity<ResultModel> handlerDataConflictException(DataConflictException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }
    
    @ExceptionHandler({UserNotLoginException.class})
    public ResponseEntity<ResultModel> handlerUserNotLoginException(UserNotLoginException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }
    
    @ExceptionHandler({PermissionForbiddenException.class})
    public ResponseEntity<ResultModel> handlerPermissionForbiddenException(PermissionForbiddenException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }
    
    @ExceptionHandler({RemoteAccessException.class})
    public ResponseEntity<ResultModel> handlerRemoteAccessException(RemoteAccessException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }
    
    @ExceptionHandler({InternalServerException.class})
    public ResponseEntity<ResultModel> handlerInternalServerException(InternalServerException e) {
        return new ResponseEntity<>(ResultModel.error(e), HttpStatus.OK);
    }

}