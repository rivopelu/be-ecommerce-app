package com.ecommerce.controller;

import com.ecommerce.annotations.BaseController;
import com.ecommerce.model.response.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;

@BaseController("auth")
public interface AuthController {

    @GetMapping("ping")
    BaseResponse ping();

}
