package com.loyer.hrsystem.service;

import com.loyer.hrsystem.model.User;

public interface UserService {
    User getUserByUsername(String username);
}
