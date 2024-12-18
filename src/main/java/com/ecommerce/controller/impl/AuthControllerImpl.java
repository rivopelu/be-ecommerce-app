package com.ecommerce.controller.impl;

import com.ecommerce.annotations.BaseControllerImpl;
import com.ecommerce.controller.AuthController;
import com.ecommerce.model.response.BaseResponse;
import com.ecommerce.services.AuthService;
import com.ecommerce.utils.ResponseHelper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@BaseControllerImpl
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;

    @Override
    public BaseResponse ping() {
        return ResponseHelper.createBaseResponse(authService.ping());
    }
}
