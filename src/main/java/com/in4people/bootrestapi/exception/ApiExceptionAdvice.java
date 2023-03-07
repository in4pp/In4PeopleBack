package com.in4people.bootrestapi.exception;

import com.in4people.bootrestapi.exception.dto.ApiExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/* 예외 처리용 어드바이스 */
/* Controller 단에서 발생하는 각 예외 처리용 (@ControllerAdvice + @ResponseBody)*/
@RestControllerAdvice
public class ApiExceptionAdvice {

    /* AuthService에서 비밀번호 불일치 시 발생하는 예외 상황 처리 */
    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity<ApiExceptionDTO> exceptionHandler(LoginFailedException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage()));
    }
}




