package com.var.one.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.var.one.clients.RestClient;
import com.var.one.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final RestClient restClient;

    public LoginResponse login(LoginRequest loginRequest) throws IOException, InterruptedException {
        log.info("AuthenticationService: Attempting login for user {}", loginRequest.getUserName());

        LoginResponse loginResponse = this.restClient.post(Constants.LOGIN_URL, loginRequest, new TypeReference<>() {});

        log.info("AuthenticationService: User {} logged in successfully!", loginRequest.getUserName());

        return loginResponse;
    }
}
