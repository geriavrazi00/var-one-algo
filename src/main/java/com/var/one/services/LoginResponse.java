package com.var.one.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    @JsonProperty("SessionId")
    private String sessionId;

    @JsonProperty("Version")
    private String version;

    @JsonProperty("SessionTimeout")
    private Integer sessionTimeout;

}
