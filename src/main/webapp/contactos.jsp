<%@page import="com.emergentes.entidades.Contacto"%>
<%@page import="java.util.List"%>
<%
    List<Contacto> lista = (List<Contacto>)request.getAttribute("contactos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> LISTADO DE CONTACTO</h1>
        <h2>zulema Magali Mita Mendoza</h2>
        <a href="Main?action=add">NUEVO</a>
        <br>
           <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Nombre Completo</td>
                    <td>Telefono</td>
                    <td>Correo</td>
                    <td></td>
                    <td></td>
                </tr>
                <%
                for (Contacto item : lista){
                %>
                <tr>
                    <td><%=item.getId()%></td>
                    <td><%=item.getNombre()%></td>
                    <td><%=item.getTelefono()%></td>
                    <td><%=item.getCorreo()%></td>
                    <td><a href="Main?action=edit&id=<%=item.getId()%>">Editar</a></td>
                    <td><a href="Main?action=dele&id=<%=item.getId()%>" onclick="return(confirm('ESTAS SEGURO?'))">Eliminar</a></td>
                </tr>
                <%
                  }   
                %>
            </table>
    </body>
</html>
