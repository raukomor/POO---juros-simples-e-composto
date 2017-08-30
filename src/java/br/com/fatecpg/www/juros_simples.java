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
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Derek
 */
@WebServlet(name = "juros_simples", urlPatterns = {"/juros-simples"})
public class juros_simples extends HttpServlet {

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
            out.println("<title>Servlet juros_simples</title>");            
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +"/styles/design.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<a href='home'>");
            out.println("<span class='home' title='Voltar Para o Home' href='home.php'>");
            out.println("<img src='" + request.getContextPath() +"/images/home.png' />");
            out.println("</span>");
            out.println("</a>");
            out.println("<form>");
            out.println("<h1>Juros Simples</h1>");
            out.println("<input type='number' name='capital' placeholder='Capital' required/>");
            out.println("<input type='number' name='taxa' placeholder='Taxa de Juros' required/>");
            out.println("<input type='number' name='periodo' placeholder='Período(Meses)' required/>");
            try{
                double c;
                c = Double.parseDouble(request.getParameter("capital"));
                double i;
                i = Double.parseDouble(request.getParameter("taxa"));
                double t;
                t = Double.parseDouble(request.getParameter("periodo"));
                double j;
                j = c*i*t;
                double m;
                m=j+c;
				out.println("<input type='submit' value='Calcular'/>");
                out.println("<h2 class='result'>Juros = "+ j +"<br>Montante = "+m+"</h2>");
            }
            catch (Exception ex){
                out.println("<h2 style = 'color:red'>"
                        +"Parâmetros inválidos!"
                        +"</h2>");
            }
            
            out.println("<br/>");
            out.println("<br/>");
            out.println("</form>");
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
