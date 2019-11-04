package com.barbaro.panaderia.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.panaderia.util.DatabaseManager;
import com.barbaro.panaderia.util.DatabaseUtil;

@WebServlet(name = "ElminarPanServlet", urlPatterns = { "/pan/delete" })
public class EliminarPanServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("txtId"));

		Connection conn = null;

		DatabaseManager dbManager = null;

		conn = DatabaseUtil.getConnection();

		dbManager = new DatabaseManager(conn);

		dbManager.deletePan(id);

		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		resp.sendRedirect(getServletContext().getContextPath() + "/panes");

	}

}
