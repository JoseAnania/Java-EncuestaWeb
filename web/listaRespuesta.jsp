<%-- 
    Document   : listaRespuesta
    Created on : 22-ene-2019, 10:03:04
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encuesta de Satisfacción</title>
    </head>
    <body>
        <h1>Listado de Respuestas</h1>
        
        <table border="1">
            <tr><th>Número</th><th>Nombre</th><th>Valoración</th><th>Opinión</th></tr>
            
            <c:forEach items="${lista}" var="R">
                <tr><td>${R.idR}</td><td>${R.nombre}</td><td>${R.idV}</td><td>${R.opinion}</td></tr>
            </c:forEach>
        </table>   
    </body>
    <a href="index.html">Volver</a>
</html>
