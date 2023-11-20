<%@page import="com.emergentes.entidades.Contacto"%>

<%
 Contacto contacto = (Contacto)request.getAttribute("contacto");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>REGISTRO DE CONTACTOS</h1>
        <h2>Zulema Magali Mita Mendoza</h2>
        <form action="Main" method="post">
            <input type="hidden" name="id" value="<%= contacto.getId() %>">
            <table>
                
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= contacto.getNombre() %>"></td>
                </tr>
                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono" value="<%= contacto.getTelefono() %>"></td>
                </tr>
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="correo" value="<%= contacto.getCorreo() %>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
