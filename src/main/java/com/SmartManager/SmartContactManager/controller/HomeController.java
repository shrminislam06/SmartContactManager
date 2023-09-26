package com.SmartManager.SmartContactManager.controller;

import com.SmartManager.SmartContactManager.entity.Users;
import com.SmartManager.SmartContactManager.helper.Message;
import com.SmartManager.SmartContactManager.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class HomeController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home-Smart Contact management");
        return "home";

    }

    @RequestMapping("/signup")
    public String singnup(Model model) {
        model.addAttribute("title", "Sign Up");
        model.addAttribute("user", new Users());
        return "register";
    }

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") Users users, BindingResult result,
                               @RequestParam(value = "checkbox", defaultValue = "false")
                               boolean checkbox, Model model, HttpSession session) {


        try {

            if (!checkbox) {
                System.out.println("checkbox error");
                throw new Exception("chkbox error");
            }

            if (result.hasErrors()) {

                model.addAttribute("user", users);
                return "register";
            }
            System.out.println("checkbox:" + checkbox);
            System.out.println("user:" + users);
            model.addAttribute("user", users);
            users.setRole("USER");
            users.setEnabled(true);
            users.setImageUrl("default.png");
//            users.setPassword(passwordEncoder.encode(users.getPassword()));

            Users user = this.usersRepository.save(users);
            model.addAttribute("user", new Users());
            session.setAttribute("message", new Message("register successfully.!!", "alert-success"));
            //status.setComplete();
//         request.removeAttribute("message", WebRequest.SCOPE_SESSION);
            // session.removeAttribute("user");
            return "register";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", users);
            session.setAttribute("message", new Message("something went wrong..!" + e.getMessage(), "alert-danger"));
            return "register";
        }
    }


    @GetMapping(value = ("/login"))
    public String login(Model model) {
        model.addAttribute("title", "Login Page");

        return "login";
    }

//@RequestMapping(value = ("/dologin"),method = RequestMethod.POST)
//    public String do


}
