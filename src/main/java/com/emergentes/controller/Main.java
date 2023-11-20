package com.emergentes.controller;

import com.emergentes.bean.BeanContacto;
import com.emergentes.entidades.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/Main"})
public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id ;
        BeanContacto daoContacto = new BeanContacto();
        Contacto c = new Contacto();
        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

        switch (action) {
            case "add":
                System.out.println("Aqui se debe adicionar.... ");
                
                request.setAttribute("contacto", c);
                request.getRequestDispatcher("contactos-edit.jsp").forward(request, response);
                break;
            case "edit":
                id =Integer.parseInt(request.getParameter("id")); 
                c = daoContacto.buscar(id);
                request.setAttribute("contacto", c);
                request.getRequestDispatcher("contactos-edit.jsp").forward(request, response);
                break;
            case "dele":
                id = Integer.parseInt(request.getParameter("id"));
                daoContacto.eliminar(id);
                response.sendRedirect("Main");
                break;
            case "view":
                List<Contacto> lista = daoContacto.listarTodos();
                request.setAttribute("contactos", lista);
                request.getRequestDispatcher("contactos.jsp").forward(request, response);
            default:
                break;        
        }

        

        /*
        for(Contacto c : lista)
        {
            System.out.println("Id: " + c.getId());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Telefono: "+ c.getTelefono());
            System.out.println("Correo: "+ c.getCorreo());
            System.out.println("-----------------------------");
        }
        */    
           // nuevo();
       
       // mostrar();
       /* try {
            editar();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
   */
     //  eliminar();
     //   mostrar();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        BeanContacto daoContacto = new BeanContacto();
        Contacto c = new Contacto();
        
        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setNombre(request.getParameter("nombre"));
        c.setTelefono(request.getParameter("telefono"));
        c.setCorreo(request.getParameter("correo"));
        
        if(c.getId()==0){
            System.out.println("REGISTRO NUEVO...");
            daoContacto.insertar(c);
        }
        else{
            try {
                daoContacto.editar(c);
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("Main");
        
        
    }
    /*  
    private void nuevo() {
        BeanContacto dao = new BeanContacto();
        Contacto c = new Contacto();

        c.setNombre("Wilson Alanoca");
        c.setTelefono("68044836");
        c.setCorreo("wilson@gmail.com");

        dao.insertar(c);
    }
    
    private void editar() throws Exception
    {
      BeanContacto dao = new BeanContacto();
      
      // Id para editar
      Integer id = 1;
      
      Contacto c = dao.buscar(id);
      
      c.setNombre("Matias Rocha");
       c.setCorreo("Matias@gmail.com");
       
       dao.editar(c);
      
    }
    
    private void eliminar()
    {
      BeanContacto dao = new BeanContacto();
      
      // Id para eliminar
      Integer id = 12;
      
      dao.eliminar(id);
    }

    private void mostrar() {
        BeanContacto dao = new BeanContacto();

        List<Contacto> lista = dao.ListarTodos();

        for (Contacto item : lista) {
            System.out.println(item.toString());
        }
    }
*/
}
