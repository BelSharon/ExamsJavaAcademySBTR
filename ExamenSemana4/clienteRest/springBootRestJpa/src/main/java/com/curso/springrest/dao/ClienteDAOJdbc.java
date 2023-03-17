package com.curso.springrest.dao;

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
import com.curso.springrest.entity.Cliente;

@Repository
public class ClienteDAOJdbc implements ClienteDAO{

	@Autowired
	//INTERFAZ DE CONEXION A BD
	DataSource dataSource;
	
	@Override
	public List<Cliente> getClientes() {
		
		List<Cliente> clientes = new ArrayList<>();

		//CONSULTA SQL
		String sql = "select * from cliente order by nombre";
		
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				Double saldoPrestamo = myRs.getDouble("saldo_prestamo");

				// create new customer object
				Cliente tempCliente = new Cliente(id, nombre, apellido, correo, saldoPrestamo);

				// add it to the list of customers
				clientes.add(tempCliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println("Pasó por JDBC");
		return clientes;
	}
	
	

	@Override
	public Cliente guardarCliente(Cliente elCliente) {
		
		String sql = null;
		
		if(elCliente.getId() == 0)
			sql = "insert into arboles_viveros " + "(nombre_comun, nombre_cientifico, familia, estatus_nom) " + "values (?, ?, ?, ?)";
		else
			sql = "update arboles_viveros " + "set nombre_comun=?, nombre_cientifico=?, familia=?, estatus_nom=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, elCliente.getNombre());
			ps.setString(2, elCliente.getApellido());
			ps.setString(3, elCliente.getCorreo());
			ps.setDouble(4, elCliente.getSaldoPrestamo());
			
			//id para where del update
			if(elCliente.getId() != 0)
				ps.setInt(5, elCliente.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}

		return elCliente;
	}

	@Override
	public Cliente getCliente(int elId) {
		
		Cliente elCliente = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, elId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				Double saldoPrestamo = myRs.getDouble("saldo_prestamo");

				// use the customerId during construction
				elCliente = new Cliente(elId, nombre, apellido, correo, saldoPrestamo);
			} else {
				System.out.println("No se encontró id de registro: - " + elId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elCliente;
	}
	
	private PreparedStatement crearStatementGetCustomer(Connection myConn, int customerId) throws SQLException {
		String sql = "select * from cliente where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, customerId);
		return ps;
	}

	@Override
	public void eliminarCliente(int elId) {
		
		//SENTENCIA SQL PARA ELIMINAR POR ID
		String sql = "delete from arboles_viveros where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			myStmt.setInt(1, elId);

			// SE EJECUTA LA SENTENCIA SQL
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
