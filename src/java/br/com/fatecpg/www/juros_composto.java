/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodri
 */
@WebServlet(name = "juros_composto", urlPatterns = {"/juros-composto"})
public class juros_composto extends HttpServlet {

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
            out.println("<title>Servlet juros compostos</title>");
            out.println("<link rel='stylesheet' type='text/css' href='" + request.getContextPath() +"/styles/design.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<a href='home'>");
            out.println("<span class='home' title='Voltar Para o Home' href='/home'>");
            out.println("<img src='" + request.getContextPath() +"/images/home.png' />");
            out.println("</span>");
            out.println("</a>");
            out.println("<form>");
            out.println("<h1>Juros Compostos</h1>");
            out.println("<input type='number' name='capital' placeholder='Capital Inicial' step=0.01  required/>");
            out.println("<input type='number' name='taxa' placeholder='Taxa de Juros' step=0.01  required/>");
            out.println("<input type='number' name='periodo' placeholder='Período(Meses)' required/>");
            out.println("<input type='submit' value='Calcular'/>");
            out.println("</form>");
            out.println("<br/>");
            out.println("<br/>");
            double capital=Double.parseDouble(request.getParameter("capital"));
            double taxa=Double.parseDouble(request.getParameter("taxa"));
            double periodo=Double.parseDouble(request.getParameter("periodo"));
            double rentab=Double.parseDouble(request.getParameter("periodo"));
            if (capital>0 && taxa>0 && periodo>0){
                out.println("<h2 class='result'>Calculo de capital "+NumberFormat.getCurrencyInstance().format(capital));
                out.printf(" investido por %.0f meses a juros mensais de %.2f",periodo,taxa);
                out.println("%</h2>");
                out.println("<table>");
                out.println("<tr><th>Período</th><th>Capital</th><th>Rentabilidade</th><th>Total</th></tr>");
                for (int i=1; i<= periodo; i++){
                    out.println("<tr>");
                    out.println("<td>" + (i) + "</td>");
                    out.println("<td>" + NumberFormat.getCurrencyInstance().format(capital) + "</td>");
                    rentab = capital*(taxa/100);
                    out.println("<td>" + NumberFormat.getCurrencyInstance().format(rentab) + "</td>");
                    capital *= (taxa/100+1);
                    out.println("<td>" + NumberFormat.getCurrencyInstance().format(capital) + "</td>");
                    out.print("</tr>");
                }
                out.println("</table>");
                out.println("<h2 class='result'>O capital gerado foi "+NumberFormat.getCurrencyInstance().format(capital)+"</h2>");
            }
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