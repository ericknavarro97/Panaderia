<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<title>Insertar Panes</title>

</head>
<body>

    <div class="container">

        <div class="col 12 center-align">

                <h3>${boton} Pan</h3>

        </div>

        <div class="col s3">

            <form action="${ action }" method="${ method }">

                <input type="hidden" name="txtId" value="${ pan.getId() }">

                <div class="input-field">
                    <label for="Nombre"> Nombre del Pan</label>
                    <input id="Nombre"type="text" name="nombre" value="${ pan.getNombre() }">
                </div>

                <div class="input-field">
                    <label for="Des">Descripción</label>
                    <input id="Des" type="text" name="desc" value="${ pan.getDescripcion() }">
                </div>


                <div>
                    <label>Tamaño </label> 
                    <label><input type="radio"name="tamano" value="Chico" ${ ch }><span>Chico</span></label> 
                    <label><input type="radio" name="tamano" value="Mediano" ${ ch2 }><span>Mediano</span></label>
                    <label><input type="radio" name="tamano" value="Grande" ${ ch3 }><span>Grande</span></label>
                </div>


                <div class="input-field">
                    <label for="precio">Precio</label>
                    <input id="precio" type="text"name="precio" value="${ pan.getPrecio() }">
                </div>


                <div>
                    <input class="btn" type="submit" name="" value="${ boton }">
                    <a class="btn secondary-content" href="${ regresar }">Ver Panes</a>

                </div>
            </form>

        </div>

    </div>
                                        
</body>
</html>