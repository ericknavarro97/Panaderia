/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.panaderia.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ericknavarro
 */
public class DatabaseUtil {

	public static final String URL_FORMAT = "jdbc:mysql://%s:%s/%s ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static Connection getConnection() {

		String serverHost = "localhost";
		String serverPort = "3306";
		String databaseName = "panaderia";
		String databaseUser = "root";
		String databasePass = "navarro97";

		Connection conn = null;

		try {

                        // Obtener Driver
                        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			String url = String.format(URL_FORMAT, serverHost, serverPort, databaseName);

			conn = DriverManager.getConnection(url, databaseUser, databasePass);

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Fallo al realizar la conexión");

		}

		return conn;
	}

	public static Connection getConnection(InputStream fileStream) {

		return null;

	}

	public static void closeConnection(Connection connection) {

		try {

			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Falló al cerrar la conexión");
		}

	}

}
