<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="modelo.almacen"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        <a href="controlador?action=nuevo" >nuevo</a>
        <table border="1" >
            <tr>
                <td>Id </td>
                <td>Descripcion</td>
                <td>Stock</td>
                <td></td>
                <td></td>
           
            </tr>
           <c:forEach var="item" items="${avisos}">
            <tr>
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.stock}</td>
                <td><a href="controlador?action=editar&id=${item.id}" >Editar</a></td>
                <td><a  href="controlador?action=eliminar&id=${item.id}">Eliminar</a></td>
            </tr>
             </c:forEach>
          </table>
        
    </body>
</html>
