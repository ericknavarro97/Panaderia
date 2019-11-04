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

@WebServlet(name = "ActualizarPanServlet", urlPatterns = { "/pan/actualizar" })
public class ActualizarPanServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("txtId"));

		Pan pan = null;

		Connection conn = null;

		DatabaseManager dbManager = null;

		conn = DatabaseUtil.getConnection();

		dbManager = new DatabaseManager(conn);
		pan = dbManager.getPanById(id);

                switch (pan.getTamano()) {
                    case "Chico":
                        req.setAttribute("ch", "checked");
                        break;
                    case "Mediano":
                        req.setAttribute("ch2", "checked");
                        break;
                    case "Grande":
                        req.setAttribute("ch3", "checked");
                        break;
                    default:
                        break;
                }

		req.setAttribute("pan", pan);
		req.setAttribute("method", "post");
		req.setAttribute("boton", "Modificar");

		req.setAttribute("regresar", getServletContext().getContextPath() + "/panes");

		req.setAttribute("action", getServletContext().getContextPath() + "/pan/actualizar");

		req.getRequestDispatcher("/formpan.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("txtId"));
		String nombre = req.getParameter("nombre");
		String descripcion = req.getParameter("desc");
		String tamano = req.getParameter("tamano");
		float precio = Float.parseFloat(req.getParameter("precio"));

		Pan pan = new Pan();

		Connection conn = null;
		DatabaseManager dbManager = null;

		try {

			conn = DatabaseUtil.getConnection();

			dbManager = new DatabaseManager(conn);

			pan.setId(id);
			pan.setNombre(nombre);
			pan.setDescripcion(descripcion);
			pan.setTamano(tamano);
			pan.setPrecio(precio);

			dbManager.updatePan(pan);

			conn.close();

			resp.sendRedirect(getServletContext().getContextPath() + "/panes");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
