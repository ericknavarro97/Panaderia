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

    <h3>Modificando Pan</h3>

    </div>

        <div class="col s3">

            <form action="addpan" method="post">

                    <div>
                        <label>Nombre del Pan</label> 
                        <input type="text" name="nombre">
                    </div>

                    <div>
                        <label>Descripción</label> 
                        <input type="text" name="desc">
                    </div>


                    <div>
                        <label>Tamaño </label> 
                        <label><input class="with-gap" type="radio" name="tamano" value="Chico"><span>Chico</span></label>
                        <label><input class="with-gap" type="radio" name="tamano" value="Mediano"><span>Mediano</span></label>
                        <label><input class="with-gap" type="radio" name="tamano" value="Grande"><span>Grande</span></label>
                    </div>


                    <div>
                        <label>Precio</label> 
                        <input type="text" name="precio">
                    </div>


                    <div>
                        <input class="btn" type="submit" name="" value="Agregar Pan">

                    </div>
            </form>

        </div>

        <div>

            <a class="btn" href="/">Ver Panes</a>

        </div>

    </div>

	

</body>
</html>