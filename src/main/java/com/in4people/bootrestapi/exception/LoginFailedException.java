package com.in4people.bootrestapi.exception;

/* ReuntimeException을 상속 받아 예외 발생 시 throws로처리 하지 않아도 되도록 함. */
public class LoginFailedException extends RuntimeException{

    public LoginFailedException(String message) {super(message);}
}
