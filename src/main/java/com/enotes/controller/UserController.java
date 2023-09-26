package com.enotes.controller;

import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.enotes.dao.UserDao;
import com.enotes.entity.Notes;
import com.enotes.entity.User;




@Controller
@RequestMapping("/user/")  
public class UserController {

	@Autowired
	private UserDao userDao;
	
	
	@RequestMapping("/addNotes")
	public String addNotes() {
		return "add_notes";
	}

	@RequestMapping("/viewNotes")
	public String viewNotes(HttpSession session, Model model) {
		User us=(User) session.getAttribute("userObj");
		
		List<Notes> notes=userDao.getNotesByUser(us);
		
		model.addAttribute("list",notes);
		
		userDao.getNotesByUser(us);
		return "view_notes";
	}

	@RequestMapping("/editNotes")
	public String editNotes(@RequestParam("id") int id, Model m) {
		
		Notes n=userDao.getNotesById(id);
		m.addAttribute("note", n);
		return "edit_notes";
	}
	
	@RequestMapping(path="/updateNotes", method=RequestMethod.POST)
	public String updateNote(@ModelAttribute Notes n, HttpSession session)
	{
		User us= (User) session.getAttribute("userObj");
		n.setUser(us);
		n.setDate(LocalDateTime.now().toString());
		userDao.updateNotes(n);
		
		session.setAttribute("updatemsg", "Note Updated Successfully");
		return "redirect:/user/viewNotes";
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("userObj");
		session.setAttribute("msg", "Logout Successfully..");
		return "redirect:/login";
		
	}
	
	@RequestMapping(path="/saveNotes",method = RequestMethod.POST)
	public String saveNotes(@ModelAttribute Notes n,HttpSession session)
	{
		User us = (User)session.getAttribute("userObj");
		n.setDate(LocalDateTime.now().toString());
		n.setUser(us);
		userDao.saveNotes(n);
		session.setAttribute("msg", "note added successfully");
		return "redirect:/user/addNotes";
	}
	
	@RequestMapping("/deleteNotes")
	public String deleteNotes(@RequestParam("id") int id,HttpSession session)
	{
		userDao.deleteNotes(id);
		session.setAttribute("msg", "Note Deleted Successfully");
		return "redirect:/user/viewNotes";
		
	}
	
}
