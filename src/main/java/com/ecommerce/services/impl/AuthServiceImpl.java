package com.ecommerce.services.impl;

import com.ecommerce.exception.SystemErrorException;
import com.ecommerce.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String ping() {
        try {
            return "SUCCESS";
        } catch (Exception e) {
            throw new SystemErrorException(e);
        }
    }
}
