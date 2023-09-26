package com.SmartManager.SmartContactManager.service;

import com.SmartManager.SmartContactManager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements UserServices{
    @Autowired
    private UsersRepository usersRepository;
//comment

}
