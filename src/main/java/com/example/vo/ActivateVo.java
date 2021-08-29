package com.example.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ActivateVo {

    @NotBlank
    private int uid;

    @NotBlank
    @Min(0)
    @Max(1)
    private int enable;
}
