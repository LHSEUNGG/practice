package com.example.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@ToString
public class ApiResponse {

    private int code = HttpStatus.OK.value();
    private Object success;

    public ApiResponse(){}
    public ApiResponse(Object responseData) {
        this.success = responseData;
    }

    public ApiResponse(int code, Object responseData) {
        this.code = code;
        this.success = responseData;
    }

    public Object getSuccess(){
        return this.success;
    }

    protected void setSuccess(Object responseData) {
        this.success = responseData;
    }

}
