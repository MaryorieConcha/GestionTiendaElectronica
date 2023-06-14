<%--
  Created by IntelliJ IDEA.
  User: Aspire3
  Date: 13-06-2023
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Registro Clientes</title>
</head>
<body>
<h1 id="tituloEncabezado" class="encabezado">Agregar articulos</h1>
<br>
<form action="cliente" method="post">
    <div class="centrar">
        <label class="texto">Nombre:</label>
        <input name="nombre_cliente" type="text">
        <br>
        <label class="texto">RUT: </label>
        <input name="rut" type="text">
        <br>
        <label class="texto">Email:</label>
        <input name="mail" type="text">
        <br>
        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
<br>
<a class="centrar" href="index.jsp">Volver</a>
</body>
</html>
