package com.gabbar.controller;

import java.io.NotSerializableException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gabbar.entity.Notes;
import com.gabbar.entity.User;
import com.gabbar.repository.UserRepository;
import com.gabbar.service.NotesService;

import jakarta.servlet.http.HttpSession;

@Controller()
@RequestMapping("/")
public class UserController 
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private NotesService nService;
	
	@ModelAttribute
	public User getUser(Principal p, Model m)
	{
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
		return user;
	}
	
	@GetMapping("/addnotes")
	   public String addNotes ()
	   {
		return "Add_notes";
		   
	   }
	
	@GetMapping("/viewnotes")
	   public String viewNotes (Model m, Principal p)
	   {
		User user = getUser(p, m);
		List<Notes> list = nService.getNotesByUser(user);
		m.addAttribute("list", list);
		return "view_notes";
		   
	   }
	
	@GetMapping("/editnotes/{id}")
	   public String editNotes (@PathVariable int id, Model m)
	   {
		Notes notes = nService.getNotesById(id);
		m.addAttribute("n", notes);
		return "Edit_notes";
		   
	   }
	
	@PostMapping("/saveNotes")
	public String saveNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m)
	{
		notes.setDate(LocalDate.now());
		notes.setUser(getUser(p, m));
		
		Notes savenotes = nService.saveNotes(notes);
		if(savenotes != null)
		{
			session.setAttribute("msg", "Notes Save Success");
		}
		else
		{
			session.setAttribute("msg", "Something wrong on server");
		}
		return "redirect:/addnotes";
	}
	
	@PostMapping("/updatenotes")
	public String updateNotes(@ModelAttribute Notes notes, HttpSession session, Principal p, Model m)
	{
		notes.setDate(LocalDate.now());
		notes.setUser(getUser(p, m));
		
		Notes savenotes = nService.saveNotes(notes);
		if(savenotes != null)
		{
			session.setAttribute("msg", "Notes Update Success");
		}
		else
		{
			session.setAttribute("msg", "Something wrong on server");
		}
		return "redirect:/viewnotes";
	}
	
	@GetMapping("/deletenotes/{id}")
	   public String deleteNotes (@PathVariable int id, HttpSession session)
	   {
		boolean f = nService.deleteNotes(id);
		
		if(f)
		{
			session.setAttribute("msg", "Notes Delete Success");
		}
		else
		{
			session.setAttribute("msg", "Something wrong on server");
		}
		return "redirect:/viewnotes";
		   
	   }
}
