package com.jacaranda.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.model.Student;

@Service
public class StudentService {
	
	private List<Student> lista;
	
	public StudentService() {
		lista = new ArrayList<Student>();
		lista.add(new Student("Inma","Olias",25));
		lista.add(new Student("Pepe","Perez",45));
		lista.add(new Student("Juan","Garcia",84));
		lista.add(new Student("Marta","Perea",18));
	}
	
	public List<Student> getStudents() {
		return lista;
	}

	public boolean addStudent(Student e) {
		return lista.add(e);
	}

	public boolean removeStudent(Student o) {
		return lista.remove(o);
	}

	public Student getStudent(String nombre, String apellido) {
		boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> iterator = this.lista.iterator();
		while (iterator.hasNext() && !encontrado){
			resultado = iterator.next();
			if (resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				encontrado = true;
			}
		}
		
		if (encontrado == true) {
			return resultado;
		}
		else {
			return null;
		}
	}
	
	public boolean updateStudent(String nombre, String apellido, int edad) {
		boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> iterator = this.lista.iterator();
		while (iterator.hasNext() && !encontrado){
			resultado = iterator.next();
			if (resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				resultado.setAge(edad);
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	
}
