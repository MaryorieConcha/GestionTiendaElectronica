<%--
  Created by IntelliJ IDEA.
  User: Aspire3
  Date: 08-06-2023
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar articulos</title>
</head>
<body>
<h1 id="tituloEncabezado" class="encabezado">Agregar articulos</h1>
<br>
<form action="producto" method="post">
    <div class="centrar">
        <label class="texto">Nombre:</label>
        <input name="nombre_producto" type="text">
        <br>
        <label class="texto">Tipo de Articulo</label>
        <input name="tipo" type="text">
        <br>
        <label class="texto">Peso:</label>
        <input name="peso" type="text">
        <br>
        <label class="texto">Precio</label>
        <input name="precio" type="number">
        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
<br>
<a class="centrar" href="index.jsp">Volver</a>
</body>
</html>
