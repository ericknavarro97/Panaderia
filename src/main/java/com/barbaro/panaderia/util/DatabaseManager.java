/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.panaderia.util;

/**
 *
 * @author ericknavarro
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.barbaro.panaderia.models.Pan;


public class DatabaseManager {

	private Connection conn;

	public DatabaseManager() {
	}

	public DatabaseManager(Connection conn) {

		this.conn = conn;

	}

	public List<Pan> getPanes() {

		List<Pan> listaPanes = new ArrayList<>();

		String query = "SELECT * FROM pan";

		Statement stmnt = null;

		ResultSet rs = null;

		try {
			stmnt = conn.createStatement();

			// Ejecuta el query
			rs = stmnt.executeQuery(query);

			// Iterar todo el conjunto de resultados por fila
			while (rs.next()) {

				// Crear instancia
				Pan pan = new Pan();

				// Obtener datos de cada columna y setearlos en su respectvo campo (llenar el
				// PJO)
				pan.setId(rs.getInt(1));
				pan.setNombre(rs.getString(2));
				pan.setPrecio(rs.getFloat(3));
				pan.setTamano(rs.getString(4));
				pan.setDescripcion(rs.getString(5));
				pan.setFecha(rs.getDate(6));

				// Agregarmodelo a la lista de panes
				listaPanes.add(pan);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				stmnt.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return listaPanes;
	}

	public int addPan(Pan pan) {

		String query = "INSERT INTO pan (nombre, descripcion, tamanio, precio) values (?, ?, ?, ?)";

		int result = -1;

		PreparedStatement stmnt = null;

		try {

			stmnt = conn.prepareStatement(query);

			stmnt.setString(1, pan.getNombre());
			stmnt.setString(2, pan.getDescripcion());
			stmnt.setString(3, pan.getTamano());
			stmnt.setFloat(4, pan.getPrecio());

			result = stmnt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				stmnt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	public int updatePan(Pan pan) {

		String query = "UPDATE pan SET nombre = ?, descripcion = ?, tamanio = ?, precio = ? WHERE id = ?";

		int result = -1;

		PreparedStatement stmnt = null;

		try {

			stmnt = conn.prepareStatement(query);

			stmnt.setString(1, pan.getNombre());
			stmnt.setString(2, pan.getDescripcion());
			stmnt.setString(3, pan.getTamano());
			stmnt.setFloat(4, pan.getPrecio());
			stmnt.setInt(5, pan.getId());

			result = stmnt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				stmnt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	public int deletePan(int id) {

		String query = "DELETE FROM pan WHERE id = ?";

		int result = -1;

		PreparedStatement stmnt = null;

		try {

			stmnt = conn.prepareStatement(query);

			stmnt.setInt(1, id);

			result = stmnt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {
				stmnt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return result;

	}

	public Pan getPanById(int id) {

		String query = "SELECT * FROM pan WHERE id = ?";

		Pan pan = new Pan();

		PreparedStatement stmnt = null;

		ResultSet rs = null;

		try {

			stmnt = conn.prepareStatement(query);

			stmnt.setInt(1, id);

			rs = stmnt.executeQuery();

			if (rs.first()) {

				String nombre = rs.getString(2);
				float precio = rs.getFloat(3);
				String tamano = rs.getString(4);
				String descripcion = rs.getString(5);
				Date fecha = rs.getDate(6);

				pan.setId(id);
				pan.setNombre(nombre);
				pan.setPrecio(precio);
				pan.setTamano(tamano);
				pan.setDescripcion(descripcion);
				pan.setFecha(fecha);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {

				if (stmnt != null) {

					rs.close();
					stmnt.close();

				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return pan;

	}

}
