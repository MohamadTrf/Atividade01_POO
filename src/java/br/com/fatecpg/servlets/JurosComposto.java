/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohamad Hicham Tarif e Daniel Rares
 */
public class JurosComposto extends HttpServlet {

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
            out.println("<title>Servlet JurosComposto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Insira os dados para calcular o Juros Composto</h1>\n");
            out.println("<form>");
            out.println("Capital:<input type = 'text'  name='capital' />  <br> <br> ");
            out.println("Taxa de Juros:<input type = 'text'  placeholder='Digite somente o número ' name='juros' /> <br> <br>");
            out.println("Meses:<input type = 'text'  name='meses' /> <br> ");
            out.println("<input type='submit' name='resultado' value=' Calcular '  /> <br>");
            out.println("</form>");
            out.println("<hr/>");
            
            out.println("<a href='home.html'> <h1> Voltar </h1></a>");
            out.println("<br>");
            try{
                if(request.getParameter("resultado")!=null){
                    double capital = Double.parseDouble(request.getParameter("capital"));
                    double taxaJuros = Double.parseDouble(request.getParameter("juros"));
                    int meses = Integer.parseInt(request.getParameter("meses"));
                   double montante;
                   double jurosTotalCapital;
                   // (1+(taxaJuros/100));
                   //capital*(1+taxaJuros)  -- motante
                   //montante - capital (juros)
             out.println("<table border='2'>");
                   out.println("<tr>");
                        out.println("<th> Capital </th>");
                        out.println("<th> Mês </th>");
                        out.println("<th> Juros </th>");
                        out.println("<th> Montante </th>");
                   out.println("</tr>");
                    taxaJuros = taxaJuros/100;
                   for(int i =1; i<=meses; i++){
                    jurosTotalCapital = taxaJuros*capital;
                    montante = capital + jurosTotalCapital;
                        out.println("<tr>");
                            out.println("<td>" + Math.round(capital) +"</td>");
                            out.println("<td>" + i +"</td>");
                            out.println("<td>" +Math.round(jurosTotalCapital) +"</td>");
                            out.println("<td>" + Math.round(montante) +"</td>");
                        capital = montante;
                  }
                   out.println("</table>");
            
                }
            }catch(Exception ex) {
                     out.println("<h1 style = 'color:red;'> Erro ao fazer o Motante do juros simples </h1>" );
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
