package com.exam.jdbc;

import java.util.ArrayList;
import java.util.List;

public class StudentDbDummy {

	static List<Estudiante> students = new ArrayList<>();
	static int idContador;

	StudentDbDummy() {
		students.add(new Estudiante(++idContador, "Patrobas", "ApellidoPatrobas", "S", "gato"));
		students.add(new Estudiante(++idContador, "Tercio", "ApellidoTercio", "H", "buho"));
		students.add(new Estudiante(++idContador, "Andronico", "ApellidoAndronico", "G", "sapo"));
	}

	public List<Estudiante> getStudents() throws Exception {
		return students;
	}

	public void addStudent(Estudiante theStudent) throws Exception {
		theStudent.setId(++idContador);
		students.add(theStudent);
	}

	public Estudiante getStudent(String theStudentId) throws Exception {
		for (Estudiante e : students) {
			if (e.getId() == Integer.valueOf(theStudentId)) {
				return e;
			}
		}
		return null;
	}

	public void updateStudent(Estudiante theStudent) throws Exception {		
		for (Estudiante e : students) {
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

		for (Estudiante e : students) {
			if (e.getId() == Integer.valueOf(theStudentId)) {
				students.remove(e);
				return;
			}
		}

	}
}
