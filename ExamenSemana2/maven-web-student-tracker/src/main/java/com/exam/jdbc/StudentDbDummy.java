package com.luv2code.web.jdbc;

import java.util.ArrayList;
import java.util.List;

public class StudentDbDummy {

	static List<Student> students = new ArrayList<>();
	static int idContador;

	StudentDbDummy() {
		students.add(new Student(++idContador, "Patrobas", "ApellidoPatrobas", "patrobas@gmail.com"));
		students.add(new Student(++idContador, "Tercio", "ApellidoTercio", "tercio@gmail.com"));
		students.add(new Student(++idContador, "Andronico", "ApellidoAndronico", "andronico@gmail.com"));
	}

	public List<Student> getStudents() throws Exception {
		return students;
	}

	public void addStudent(Student theStudent) throws Exception {
		theStudent.setId(++idContador);
		students.add(theStudent);
	}

	public Student getStudent(String theStudentId) throws Exception {
		for (Student e : students) {
			if (e.getId() == Integer.valueOf(theStudentId)) {
				return e;
			}
		}
		return null;
	}

	public void updateStudent(Student theStudent) throws Exception {		
		for (Student e : students) {
			if (e.getId() == theStudent.getId()) {
				e.setNombre(theStudent.getNombre());
				e.setApellido(theStudent.getApellido());
				e.setCasa(theStudent.getCasa());
			}
		}
	}

//  NO FUNCIONA	
//	public void updateStudent(Student theStudent) throws Exception {
//		for (Student e : students) {
//			if (e.getId() == theStudent.getId()) {
//				e = theStudent;
//			}
//		}
//	}

	public void deleteStudent(String theStudentId) throws Exception {

		for (Student e : students) {
			if (e.getId() == Integer.valueOf(theStudentId)) {
				students.remove(e);
				return;
			}
		}

	}
}
