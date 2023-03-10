package com.curso.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.curso.spring.entity.Libro;

@Repository
public class LibroDAOJdbc implements LibroDAO {

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Libro> getLibros() {

		System.out.println("PASO POR LibroDAOJdbc");
		List<Libro> libros = new ArrayList<>();

		// create sql statement
		String sql = "select * from libro order by titulo";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String titulo = myRs.getString("titulo");
				String autor = myRs.getString("autor");
				String editorial = myRs.getString("editorial");
				boolean disponible = myRs.getBoolean("disponible");

				// create new student object
				Libro tempLibro = new Libro(id, titulo, autor, editorial, disponible);

				// add it to the list of students
				libros.add(tempLibro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;

	}

	@Override
	public void saveLibro(Libro elLibro) {
		
		String sql = null;
		if(elLibro.getId() == 0)
			sql = "insert into libro " + "(titulo, autor, editorial, disponible) " + "values (?, ?, ?, ?)";
		else
			sql = "update libro " + "set titulo=?, autor=?, editorial=?, disponible=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, elLibro.getTitulo());
			ps.setString(2, elLibro.getAutor());
			ps.setString(3, elLibro.getEditorial());
			ps.setBoolean(4, elLibro.isDisponible());
			
			//id para where del update
			if(elLibro.getId() != 0)
				ps.setInt(5, elLibro.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public Libro getLibro(int theId) {
		Libro elLibro = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String titulo = myRs.getString("titulo");
				String autor = myRs.getString("autor");
				String editorial = myRs.getString("editorial");
				boolean disponible = myRs.getBoolean("disponible");

				// use the studentId during construction
				elLibro = new Libro(theId, titulo, autor, editorial, disponible);
			} else {
				System.out.println("Could not find libro id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elLibro;
	}

	private PreparedStatement crearStatementGetCustomer(Connection myConn, int libroId) throws SQLException {
		String sql = "select * from libro where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, libroId);
		return ps;
	}

	@Override
	public void deleteLibro(int theId) {

		// create sql to delete student
		String sql = "delete from libro where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// set params
			myStmt.setInt(1, theId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
