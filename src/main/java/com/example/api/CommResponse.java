package com.example.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@JsonPropertyOrder()
public class CommResponse<T>{

    @JsonProperty("code")
    private int code = 200;

    @JsonProperty("message")
    private String message = "SUCCESS";

    @JsonProperty("data")
    private T data;

    public CommResponse(T data) {
        this.data = data;
    }

}
