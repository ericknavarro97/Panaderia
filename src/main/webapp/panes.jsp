<%-- 
    Document   : panes
    Created on : Oct 18, 2019, 10:46:57 AM
    Author     : ericknavarro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>


        <title>Panadería chida</title>

    </head>

    <body>

        <div class="container">

            <div class="center-align">

                <h2>Lista Panes</h2>

            </div>

            <table>

                <thead>
                    <tr>

                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Tamaño</th>
                        <th>Precio</th>
                        <th>Fecha</th>
                        <th class="center-align" colspan="2">Acción</th>

                    </tr>

                </thead>

                <tbody>

                    <c:forEach var="pan" items="${ listaPanes }">

                        <tr>

                            <td>${ pan.getId() }</td>
                            <td>${ pan.getNombre() }</td>
                            <td>${ pan.getDescripcion() }</td>
                            <td>${ pan.getTamano() }</td>
                            <td>$ ${ String.format("%,.2f", pan.getPrecio()) }</td>
                            <td>${ pan.getFecha() }</td>
                            <td>

                                <div class="center-align">
                                    <form action="pan/actualizar">

                                        <input type="hidden" name="txtId" value="${pan.getId()}">
                                        <input class="btn blue" type="submit" value="Modificar">

                                    </form>

                                </div>



                            </td>

                            <td>
                                <div class="center-align">
                                    <form action="pan/delete" method="post">

                                        <input type="hidden" name="txtId" value="${pan.getId()}">
                                        <input class="btn red" type="submit" value="Eliminar">

                                    </form>

                                </div>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

            </table>



            <div>

                <a class="btn green" href="pan">Agregar Panes</a>

            </div>
        </div>

    </body>

</html>
