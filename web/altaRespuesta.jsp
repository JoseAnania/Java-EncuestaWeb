<%-- 
    Document   : altaRespuesta
    Created on : 22-ene-2019, 10:58:26
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
        <h1>Alta de Respuestas</h1>
        
        <form method="post" action="ServletAltaRespuesta">
            
            <label form="nombre">Nombre: </label>
            <input type="text" name="nombre"/>
            <br>
            <br>
            <label form="Valor">Valor: </label>
            <select name="cboValor" id="cboValor" required="requiered">
                <option value="" disabled selected> Seleccione el Valor </option>
                    <c:forEach items="${lista}" var="V">
                        <option value=${V.idV}>${V.detalle}</option>
                    </c:forEach>               
            </select>
            <br>
            <br>
            <label form="opinion">Opinión: </label>
            <input type="text" name="opinion"/>
            <br>
            <br>
            <input type="submit" value="Aceptar"/>
        </form>
    </body>
    <a href="index.html">Volver</a>
</html>
