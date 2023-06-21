package com.var.one.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "authenticationClient", url = "${root.entrypoint}/Login")
public interface AuthenticationClient {

}
