package com.barbaro.panaderia.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.panaderia.util.DatabaseManager;
import com.barbaro.panaderia.util.DatabaseUtil;
import com.barbaro.panaderia.models.Pan;

@WebServlet(name = "AltaPanServlet", urlPatterns = { "/pan" })
public class AltaPanServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("action", "pan");
		req.setAttribute("method", "post");
		req.setAttribute("boton", "Agregar");

		req.setAttribute("regresar", getServletContext().getContextPath() + "/panes");
		req.getRequestDispatcher("formpan.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("desc");
		String tamano = req.getParameter("tamano");
		float precio = Float.parseFloat(req.getParameter("precio"));

		Pan pan = new Pan();

		pan.setNombre(nombre);
		pan.setDescripcion(descripcion);
		pan.setTamano(tamano);
		pan.setPrecio(precio);

		Connection conn = null;

		conn = DatabaseUtil.getConnection();

		if (conn != null) {

			DatabaseManager database = new DatabaseManager(conn);

			database.addPan(pan);

			DatabaseUtil.closeConnection(conn);

			resp.sendRedirect(getServletContext().getContextPath() + "/panes");

		} else {

			resp.setContentType("text/html");
			resp.getWriter().println("<h2>No conectó a la base de datos</h2>");

		}

	}

}
