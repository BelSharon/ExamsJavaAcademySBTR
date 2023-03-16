package com.curso.springdemo.dao;

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

import com.curso.springdemo.entity.Arbol;

@Repository
public class ArbolDAOJdbc implements ArbolDAO{

	@Autowired
	//INTERFAZ DE CONEXION A BD
	DataSource dataSource;
	
	@Override
	public List<Arbol> getArboles() {
		
		List<Arbol> arboles = new ArrayList<>();

		//CONSULTA SQL
		String sql = "select * from arboles_viveros order by nombre_comun";
		
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombreComun = myRs.getString("nombre_comun");
				String nombreCientifico = myRs.getString("nombre_cientifico");
				String familia = myRs.getString("familia");
				String estatus = myRs.getString("estatus_nom");

				// create new customer object
				Arbol tempArbol = new Arbol(id, nombreComun, nombreCientifico, familia, estatus);

				// add it to the list of customers
				arboles.add(tempArbol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println("Pasó por JDBC");
		return arboles;
	}
	
	

	@Override
	public Arbol saveArbol(Arbol elArbol) {
		
		String sql = null;
		
		if(elArbol.getId() == 0)
			sql = "insert into arboles_viveros " + "(nombre_comun, nombre_cientifico, familia, estatus_nom) " + "values (?, ?, ?, ?)";
		else
			sql = "update arboles_viveros " + "set nombre_comun=?, nombre_cientifico=?, familia=?, estatus_nom=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, elArbol.getNombreComun());
			ps.setString(2, elArbol.getNombreCientifico());
			ps.setString(3, elArbol.getFamilia());
			ps.setString(4, elArbol.getEstatus());
			
			//id para where del update
			if(elArbol.getId() != 0)
				ps.setInt(5, elArbol.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}

		return elArbol;
	}

	@Override
	public Arbol getArbol(int theId) {
		
		Arbol elArbol = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombreComun = myRs.getString("nombre_comun");
				String nombreCientifico = myRs.getString("nombre_cientifico");
				String familia = myRs.getString("familia");
				String estatus = myRs.getString("estatus_nom");

				// use the customerId during construction
				elArbol = new Arbol(theId, nombreComun, nombreCientifico, familia, estatus);
			} else {
				System.out.println("No se encontró id de registro: - " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elArbol;
	}
	
	private PreparedStatement crearStatementGetCustomer(Connection myConn, int customerId) throws SQLException {
		String sql = "select * from arboles_viveros where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, customerId);
		return ps;
	}

	@Override
	public void deleteArbol(int theId) {
		
		//SENTENCIA SQL PARA ELIMINAR POR ID
		String sql = "delete from arboles_viveros where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			myStmt.setInt(1, theId);

			// SE EJECUTA LA SENTENCIA SQL
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
