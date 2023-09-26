package com.enotes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enotes.dao.UserDao;
import com.enotes.entity.User;

@Controller
public class HomeController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	/*
	 * @RequestMapping("/addNotes") public String addNotes() { return "add_notes"; }
	 * 
	 * @RequestMapping("/viewNotes") public String viewNotes() { return
	 * "view_notes"; }
	 * 
	 * @RequestMapping("/editNotes") public String editNotes() { return
	 * "edit_notes"; }
	 */
	@RequestMapping(path = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user, Model model, HttpSession session) {
		
	
		session.setAttribute("msg", "Registration Successfully");
		// System.out.println(user);

		userDao.saveUser(user);

		System.out.println("Exec...");
		return "redirect:/register";
	}

	@RequestMapping(path = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		
		
		System.out.println("Inside Login user method");
		
		User user = userDao.login(email, password);
		
		
		if (user != null) {
			session.setAttribute("userObj", user);
			
			System.out.println("Matched :");
			return "redirect:/home";
		}
		else {
			System.out.println("Invalid"); 
			session.setAttribute("msg", "invalid email and password");
			return "redirect:/login"; 
		}
	}
}
