/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.panaderia.servlets;

/**
 *
 * @author ericknavarro
 */
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barbaro.panaderia.util.DatabaseManager;
import com.barbaro.panaderia.util.DatabaseUtil;
import com.barbaro.panaderia.models.Pan;

@WebServlet(name = "ListPanServlet", urlPatterns = { "/" })
public class ListPanServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static final String INSERT_FORMAT = "INSERT INTO pan (nombre, descripcion, tamanio, precio) values ('%s','%s','%s',%.2f)";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            // Identificar la fuente de datos (base de datos, archivo, REST API).

            // Creamos una lista de panes.
            List<Pan> listaPanes = new ArrayList<>();

            // Objerto para estableder la conexión con la base de datos
            Connection conn = null;

            // Objeto para decirle a la base de datos que haga.
            // Statement stmnt = null;

            // Objeto para manipular los datos que regresa la consulta a la base de datos.
            // ResultSet rs = null;

            // Consulta para obtener datos
            // String queryPan = "SELECT * FROM pan";

            // Obtener conexion a la base de datos
            conn = DatabaseUtil.getConnection();

            // Puede regresar nulos
            if (conn != null) {

                    DatabaseManager database = new DatabaseManager(conn);

                    listaPanes = database.getPanes();

                    // try {
                    // Crear comando para realizar operaciones en la base de datos
                    // stmnt = conn.createStatement();

                    // Ejecuta el query
                    // rs = stmnt.executeQuery(queryPan);

                    // Iterar todo el conjunto de resultados por fila
                    // while (rs.next()) {

                    // Crear instancia
                    // Pan pan = new Pan();

                    // Obtener datos de cada columna y setearlos en su respectvo campo (llenar el
                    // PJO)
                    // pan.setId(rs.getInt(1));
                    // pan.setNombre(rs.getString(2));
                    // pan.setPrecio(rs.getFloat(3));
                    // pan.setTamano(rs.getString(4));
                    // pan.setDescripcion(rs.getString(5));
                    // pan.setFecha(rs.getDate(6));

                    // Agregarmodelo a la lista de panes
                    // listaPanes.add(pan);

                    // }

                    // rs.close();
                    // stmnt.close();
                    DatabaseUtil.closeConnection(conn);

                    req.setAttribute("listaPanes", listaPanes);

                    RequestDispatcher dispacher = req.getRequestDispatcher("panes.jsp");
                    dispacher.forward(req, resp);

                    /*
                     * } catch (SQLException e) {
                     * 
                     * e.printStackTrace();
                     * 
                     * System.out.println("Falló al crear Statment"); } catch (Exception e) {
                     * 
                     * e.printStackTrace();
                     * 
                     * }
                     */

            } else {

                    resp.setContentType("text/html");
                    resp.getWriter().println("<h2>No conectó a la base de datos</h2>");

            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            /*
             * String nombre = req.getParameter("nombre"); String descripcion =
             * req.getParameter("desc"); String tamano = req.getParameter("tamano"); float
             * precio = Float.parseFloat(req.getParameter("precio"));
             * 
             * Pan pan = new Pan();
             * 
             * pan.setNombre(nombre); pan.setDescripcion(descripcion);
             * pan.setTamano(tamano); pan.setPrecio(precio);
             * 
             * Connection conn = null;
             * 
             * conn = DatabaseUtil.getConnection();
             * 
             * if (conn != null) {
             * 
             * DatabaseManager database = new DatabaseManager(conn);
             * 
             * database.addPan(pan);
             * 
             * DatabaseUtil.closeConnection(conn);
             * 
             * doGet(req, resp);
             * 
             * } else {
             * 
             * resp.setContentType("text/html");
             * resp.getWriter().println("<h2>No conectó a la base de datos</h2>");
             * 
             * }
             */

    }

}