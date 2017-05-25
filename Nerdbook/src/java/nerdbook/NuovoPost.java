/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdbook;

import classi.Gruppo;
import classi.GruppoFactory;
import classi.UtenteRegistrato;
import classi.UtenteRegistratoFactory;
import classi.PostFactory;
import classi.Post;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VCCRCR72A28B354P
 */

public class NuovoPost extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) {
            
            // Controllo se deve inserire o confermare
            if (request.getParameter("review").equals("true")){                                            
                
                Integer usr = Integer.parseInt(request.getParameter("usr"));
                int usrID = usr;
                UtenteRegistrato utenteBacheca = UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(usrID);
                
                int loggedUsrID = (Integer)session.getAttribute("loggedUserID");
                UtenteRegistrato utenteLoggato = UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(loggedUsrID);
                
                request.setAttribute("loggedIn", true);
                request.setAttribute("utenteLoggato", utenteLoggato);
                request.setAttribute("utenteBacheca", utenteBacheca); 
                request.setAttribute("review", true);                
                                                              
                Integer postType = Integer.parseInt(request.getParameter("postType"));
                
                int postTypeID = postType;            
                
                if (postTypeID==1) {
                    request.setAttribute("tipopost", "Testo");
                }
                
                if (postTypeID==2) {
                    request.setAttribute("tipopost", "Testo + Immagine");
                }
                if (postTypeID==3) {
                    request.setAttribute("tipopost", "Testo + URL");
                }
                
                request.setAttribute("idTipoPost",postType);
                request.setAttribute("textPost",request.getParameter("textPost"));
                
                if (postTypeID==2) {
                    request.setAttribute("urlText","<img src='" + request.getParameter("imgPost") + "' class='postImg'>");
                    request.setAttribute("url",request.getParameter("imgPost"));
                }
                if (postTypeID==3) {
                    request.setAttribute("urlText","<a href='" + request.getParameter("urlPost") + "' target=_blank>" + request.getParameter("urlPost") +"</a>");
                    request.setAttribute("url",request.getParameter("urlPost"));
                }
                
                request.setAttribute("loggedIn", true);
                request.setAttribute("review", false);
                request.getRequestDispatcher("nuovopost.jsp").forward(request, response);
            }
            else { // Inserimento del Post                                               
                
                int idTipoPost=Integer.parseInt(request.getParameter("idTipoPost"));                                
                String url=request.getParameter("url");
                int idAutore = Integer.parseInt(request.getParameter("idAutore"));                
                int idDestinatario = Integer.parseInt(request.getParameter("idDestinatario"));                 
                String textPost=request.getParameter("textPost");
                                                
                Post nuovoPost=new Post();               
                nuovoPost.setTipoPost(idTipoPost);
                nuovoPost.setMessaggio(textPost);
                nuovoPost.setIdAutore(idAutore);
                nuovoPost.setIdDestinatario(idDestinatario);
                nuovoPost.setUrl(url);
                
                int recordsAffected=PostFactory.getInstance().setPost(nuovoPost);
                request.setAttribute("recordsAffected", recordsAffected);
                request.setAttribute("loggedIn", true); 
                request.setAttribute("review", true);   
                request.getRequestDispatcher("nuovopost.jsp").forward(request, response);
            
            }
        //Se l'utente non è loggato...
        } else {

            request.setAttribute("loggedIn", false);
            request.getRequestDispatcher("nuovopost.jsp").forward(request, response);
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