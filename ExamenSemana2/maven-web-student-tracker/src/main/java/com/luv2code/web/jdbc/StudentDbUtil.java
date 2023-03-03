package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Student> getStudents(){
		
		List<Student> students = new ArrayList<>();
		
		// create sql statement
		String sql = "select * from estudiante order by apellido";
		
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String casa = myRs.getString("casa");

				// create new student object
				Student tempStudent = new Student(id, nombre, apellido, casa);

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

	public void addStudent(Student theStudent) throws Exception {

		String sql = "insert into estudiante " + "(nombre, apellido, casa) " + "values (?, ?, ?)";
		
		try (Connection myConn = dataSource.getConnection(); PreparedStatement ps = myConn.prepareStatement(sql);){
			ps.setString(1, theStudent.getNombre());
			ps.setString(2, theStudent.getApellido());
			ps.setString(3, theStudent.getCasa());

			ps.execute();
		}
	}

	public Student getStudent(String theStudentId) throws Exception {

		Student theStudent = null;
		int studentId = Integer.parseInt(theStudentId);

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetStudent(myConn, studentId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String casa = myRs.getString("casa");

				// use the studentId during construction
				theStudent = new Student(studentId, nombre, apellido, casa);
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

	public void updateStudent(Student theStudent) throws Exception {
		

		// create SQL update statement
		String sql = "update estudiante " + "set nombre=?, apellido=?, casa=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
			
			// set params
			myStmt.setString(1, theStudent.getNombre());
			myStmt.setString(2, theStudent.getApellido());
			myStmt.setString(3, theStudent.getCasa());
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















