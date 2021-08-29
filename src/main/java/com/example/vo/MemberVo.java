package com.example.vo;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class MemberVo {

    private int uid ;

    @NotBlank
    private String name;

    @Min(0)
    private int age;
    private String address;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$")
    private String phone;

    @Email
    private String email;

    @Past
    private Date birth;

    @Min(0)
    @Max(1)
    private int enable;

}
