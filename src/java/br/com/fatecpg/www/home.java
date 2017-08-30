/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.www;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Home</title>");            
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +"/styles/design.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<head>");
            out.println("<h1>Juros Simples e Juros Composto</h1>");
            out.println("</head>");
            out.println("<ul>");
            out.println("<li><a href='juros-simples'>Juros Simples</a></li>");
            out.println("<li><a href='juros-composto'>Juros Compostos</a></li>");
            out.println("</br>");
            out.println("</ul>");
            out.println("<article>");
            out.println("<h1>Equipe</h1><br/>");
            out.println("<h4>Denis Olmedo da Silva</h4>");
            out.println("<h4>Derek Souza Szabo</h4>");
            out.println("<h4>Gabriela Santos Duarte</h4>");
            out.println("<h4>Rodrigo Corneta Ferreira de Alcantara</h4>");
            out.println("<h4>Rodrigo de Lima Figueiredo</h4>");
            out.println("</article>");
            out.println("<article>");
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
            
            out.println("</article>");
            out.println("<footer>Copyright &copy; FATEC PG - POO - Noturno</footer>");
            out.println("</div>");    
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
