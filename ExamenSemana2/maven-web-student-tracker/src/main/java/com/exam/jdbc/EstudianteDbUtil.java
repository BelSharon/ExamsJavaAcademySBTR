package com.exam.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EstudianteDbUtil {

	private DataSource dataSource;

	public EstudianteDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Estudiante> getStudents(){
		
		List<Estudiante> students = new ArrayList<>();
		
		// create sql statement
		String sql = "select * from estudiante order by apellido";
		
		//TRY-WITH-RESOURSES
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// recuperar datos de result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String casa = myRs.getString("casa");
				String mascota = myRs.getString("mascota");

				// create new student object
				Estudiante tempStudent = new Estudiante(id, nombre, apellido, casa, mascota);

				// add it to the list of students
				students.add(tempStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;		
	}

	/*
	 * private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
	 * 
	 * try { if (myRs != null) { myRs.close(); }
	 * 
	 * if (myStmt != null) { myStmt.close(); }
	 * 
	 * if (myConn != null) { myConn.close(); // doesn't really close it ... just
	 * puts back in connection pool } } catch (Exception exc) {
	 * exc.printStackTrace(); } }
	 */

	public void addStudent(Estudiante theStudent) throws Exception {

		String sql = "insert into estudiante " + "(nombre, apellido, casa, mascota) " + "values (?, ?, ?, ?)";
		
		try (Connection myConn = dataSource.getConnection(); PreparedStatement ps = myConn.prepareStatement(sql);){
			ps.setString(1, theStudent.getNombre());
			ps.setString(2, theStudent.getApellido());
			ps.setString(3, theStudent.getCasa());
			ps.setString(4, theStudent.getMascota());

			ps.execute();
		}
	}

	public Estudiante getStudent(String theStudentId) throws Exception {

		Estudiante theStudent = null;
		int studentId = Integer.parseInt(theStudentId);

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetStudent(myConn, studentId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String casa = myRs.getString("casa");
				String mascota = myRs.getString("mascota");

				// use the studentId during construction
				theStudent = new Estudiante(studentId, nombre, apellido, casa, mascota);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}

			return theStudent;
		}
	}
	
	private PreparedStatement crearStatementGetStudent(Connection myConn, int studentId) throws SQLException {
		String sql = "select * from estudiante where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, studentId);
		return ps;
	}

	public void updateStudent(Estudiante theStudent) throws Exception {
		

		// create SQL update statement
		String sql = "update estudiante " + "set nombre=?, apellido=?, mascota=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
			
			// set params
			myStmt.setString(1, theStudent.getNombre());
			myStmt.setString(2, theStudent.getApellido());
			myStmt.setString(3, theStudent.getMascota());
			myStmt.setInt(4, theStudent.getId());

			// execute SQL statement
			myStmt.execute();
		} 
	}

	public void deleteStudent(String theStudentId) throws Exception {

		// create sql to delete student
				String sql = "delete from estudiante where id=?";

				try (Connection myConn = dataSource.getConnection();
					 PreparedStatement myStmt = myConn.prepareStatement(sql);) {
					
					// convert student id to int
					int studentId = Integer.parseInt(theStudentId);

					// set params
					myStmt.setInt(1, studentId);

					// execute sql statement
					myStmt.execute();
				} 
	}
}















