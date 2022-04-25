package com.alexismayoral.bookclub.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexismayoral.bookclub.models.LoginUser;
import com.alexismayoral.bookclub.models.User;
import com.alexismayoral.bookclub.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	//login and registration page
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User()); 
        model.addAttribute("newLogin", new LoginUser()); 
        return "logreg.jsp";
    }
	
	//registering a new user
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	userService.register(newUser, result);
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser()); 
            return "logreg.jsp";
        }
        

        session.setAttribute("userId", newUser.getId());
    
        return "redirect:/home";
    }
    
    //logging in after creating account
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
         User user = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User()); 
            return "logreg.jsp";
        }
    

        session.setAttribute("userId", user.getId());
    
        return "redirect:/home";
    }  
    
    //logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}
