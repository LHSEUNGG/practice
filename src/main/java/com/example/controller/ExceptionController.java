package com.example.controller;

import com.example.Exception.NoValueException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)    //유효성 검사 예외 발생 시
    public String notValid(MethodArgumentNotValidException validException) {    // 어느 부분에서 예외가 발생했는지

        BindingResult bindingResult = validException.getBindingResult();

        StringBuilder builder = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {

            builder.append("[");
            builder.append(fieldError.getField());
            builder.append("](은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: [");
            builder.append(fieldError.getRejectedValue());
            builder.append("]");
            builder.append(System.getProperty("line.separator"));
        }

        return builder.toString();
    }

    @ExceptionHandler(NoValueException.class)
    public String noValue() {
        return "저장된 회원이 없습니다.";
    }

}
