package com.in4people.bootrestapi.exception.dto;


import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@ToString
/* 예외 발생 시 보낼 데이터를 담을 DTO 객체 */
public class ApiExceptionDTO {

    private int status;   // 상태 코드
    private String message; // 에러 메시지
    public ApiExceptionDTO(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }
}
