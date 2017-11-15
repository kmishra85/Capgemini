package com.cg.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.book.model.Book;
import com.cg.book.service.IBookingService;

@Controller
public class BookingController {

	@Autowired
	IBookingService service;
	
	@RequestMapping("/index")
	public String start(Model m){
		m.addAttribute("book", new Book());
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute("book") @Valid Book book, BindingResult result, Model m){
		
		if(result.hasErrors()){
			return "home";
		}
		else{
			Book b = service.addDetails(book);
			m.addAttribute("k", b);
			return "success";
		}
		
	}
	
}
