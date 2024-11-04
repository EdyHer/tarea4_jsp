/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Marcas;

/**
 *
 * @author edyeh
 */
public class sr_marcas_p extends HttpServlet {

   /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Marcas marcas;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_marcas_p</title>");            
            out.println("</head>");
            out.println("<body>");
            marcas = new Marcas(Integer.valueOf(request.getParameter("txt_id_marca")),request.getParameter("txt_marca"));
            //boton agregar
                if("agregar".equals(request.getParameter("btn_agregar"))){
                    if(marcas.agregar() > 0){ 
                        response.sendRedirect("marcas.jsp");
                    }else{
                        out.println("<h1>No se Agrego...........</h1>");
                        out.println("<a href ='marcas.jsp'>Regresar</a>");
                    }
                }
                //boton modificar
                if("modificar".equals(request.getParameter("btn_modificar"))){
                    if(marcas.modificar() > 0){ 
                        response.sendRedirect("marcas.jsp");
                    }else{
                        out.println("<h1>No se modifico...........</h1>");
                        out.println("<a href ='marcas.jsp'>Regresar</a>");
                    }
                }
                //boton eliminar
                if("eliminar".equals(request.getParameter("btn_eliminar"))){
                    if(marcas.eliminar() > 0){ 
                    response.sendRedirect("marcas.jsp");
                    }else{
                        out.println("<h1>No se eliminar...........</h1>");
                        out.println("<a href ='marcas.jsp'>Regresar</a>");
                    }
                }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}