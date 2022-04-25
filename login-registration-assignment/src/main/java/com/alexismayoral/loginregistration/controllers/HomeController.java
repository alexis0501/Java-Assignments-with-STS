package com.alexismayoral.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexismayoral.loginregistration.models.LoginUser;
import com.alexismayoral.loginregistration.models.User;
import com.alexismayoral.loginregistration.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User()); 
        model.addAttribute("newLogin", new LoginUser()); 
        return "logreg.jsp";
    }
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "home.jsp";
	}
	
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
}
