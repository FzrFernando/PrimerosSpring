package com.jacaranda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jacaranda.model.Calculator;

@Controller
public class Controlador {
	
	@GetMapping("/wek")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/bienvenido")
	public String welcome(Model model) {
		model.addAttribute("mensaje", "Hola a todos");
		return "index";
	}
	
	@GetMapping({"suma"})
	public String suma(Model model) {
		Calculator calc = new Calculator();
		return null;
	}
}
