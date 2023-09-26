package com.SmartManager.SmartContactManager.controller;

import com.SmartManager.SmartContactManager.entity.Users;
import com.SmartManager.SmartContactManager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

@RequestMapping("/index")
    public String index(Model model){
    model.addAttribute("title","index page");
        return "user-index";
    }

@ModelAttribute
    private void userDetail(Model model, Principal principal){
    String email=principal.getName();
    Users users=usersRepository.findByEmail(email);
    model.addAttribute("user",users);
}

 }