package com.var.one.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank
    @JsonProperty("CompanyDB")
    private String companyDB;

    @NotBlank
    @JsonProperty("UserName")
    private String userName;

    @NotBlank
    @JsonProperty("Password")
    private String password;

}
