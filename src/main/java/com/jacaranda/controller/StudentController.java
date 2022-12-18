package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.Service.StudentService;
import com.jacaranda.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentService repositorio;
	
	@GetMapping("listStudent")
	public String listStudent(Model model) {
		model.addAttribute("lista", repositorio.getStudents());
		return "listStudents";
	}
	
	@GetMapping("addStudent")
	public String addStudent(Model model) {
		Student s = new Student();
		model.addAttribute("estudiante",s);
		return "addStudent";
	}
	
	@PostMapping("/addStudent/submit")
	public String studentSubmit(@ModelAttribute("estudiante") Student s) {
		repositorio.addStudent(s);
		
		return "redirect:/listStudent";
	}
	
	@GetMapping("/delStudent")
	public String delStudent(Model model, 
			@RequestParam(name="name") String name,
			@RequestParam(name="surname") String surname) {
		Student student = repositorio.getStudent(name, surname);
		model.addAttribute("estudent",student);
		return "delStudent";
	}
	
	@PostMapping("/delStudent/submit")
	public String delStudentSubmit(@ModelAttribute("student") Student s) {
		repositorio.removeStudent(s);
		return "redirect:/listStudent";
	}
	
	@GetMapping("updateStudent")
	public String updateStudent(Model model,
			@RequestParam(name="name")String name,
			@RequestParam(name="apellido")String apellido) {
			Student estudiante=repositorio.get(name, apellido);
			model.addAttribute("estudiante", estudiante);	
		return "updateStudent";
	}
	
	@PostMapping("/updateStudent/submit")
	public String updateStudentSubmit(Model model,Student s) {
		repositorio.updateStudent(s);
		return "redirect:/listStudent";
}
