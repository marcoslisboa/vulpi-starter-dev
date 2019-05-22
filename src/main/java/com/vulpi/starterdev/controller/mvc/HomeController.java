package com.vulpi.starterdev.controller.mvc;

import com.vulpi.starterdev.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
	private ContactService service;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("contacts", service.findAll());
		return "home";
	}

    @GetMapping("/api-docs")
    public String doc() {
        return "api-docs";
    }

}
