/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import classi.UtenteRegistrato;
import classi.UtenteRegistratoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VCCRCR72A28B354P
 */

public class Iscrizione extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(false);

        // request.setAttribute("messaggio", "Ok" + request.getAttribute("id"));// "Attenzione: Il campo Nome deve avere un valore");
        // request.getRequestDispatcher("profilo.jsp").forward(request, response);
        
        if (request.getAttribute("nome")==null) {
            request.setAttribute("messaggio", "Attenzione: Il campo Nome deve avere un valore"+request.getAttribute("nome"));
            request.setAttribute("loggedIn", request.getAttribute("loggedIn"));
            request.getRequestDispatcher("profilo.jsp").forward(request, response);
        }
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato) significa che l'utente sta agiornando le proprie info
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {                        
            Integer loggedUserID = (Integer)session.getAttribute("loggedUserID");
            int userID = loggedUserID;            
            UtenteRegistrato utente = UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(userID);
             
            request.setAttribute("loggedIn", true);
            request.setAttribute("utente", utente);
            request.getRequestDispatcher("Bacheca").forward(request, response);
            
        //Se l'utente non è loggato, significa che si sta iscrivendo...
        } else {
            request.setAttribute("loggedIn", false);
            
            
            request.setAttribute("messaggio", "Attenzione, ");
            request.getRequestDispatcher("Profilo").forward(request, response);
        }

        
        return;
    

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