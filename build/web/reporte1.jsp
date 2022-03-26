<%-- 
    Document   : Reporte1
    Created on : 22-ene-2019, 11:43:20
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encuesta de Satisfacción</title>
    </head>
    <body>
        <h1>Reporte 1</h1>
        
        <table border="1">
            
            <tr><th>Cantidad de Respuestas con valoración 1,2 ó 3</th></tr>
            
            <tr><td>${lista}</td></tr>
            
        </table>
    </body>
    <a href="index.html">Volver</a>
</html>
