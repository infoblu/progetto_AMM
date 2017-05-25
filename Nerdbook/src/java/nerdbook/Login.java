package nerdbook;

import classi.UtenteRegistrato;
import classi.UtenteRegistratoFactory;
import classi.PostFactory;
import classi.GruppoFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author Riccardo Vacca
 */
@WebServlet (loadOnStartup=0)

public class Login extends HttpServlet {


private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";    
// private static final String DB_BUILD_PATH = "//localhost:1527/ammdb";

@Override
   public void init(){
              
       String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
       try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
       }
       UtenteRegistratoFactory.getInstance().setConnectionString(dbConnection);
       PostFactory.getInstance().setConnectionString(dbConnection);
       GruppoFactory.getInstance().setConnectionString(dbConnection);
   }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Apertura della sessione
        HttpSession session = request.getSession();
        
        //Se è impostato il parametro GET logout, distrugge la sessione
        if(request.getParameter("logout")!=null)
        {            
            session.invalidate();
            request.getRequestDispatcher("descrizione.jsp").forward(request, response);
            return;
        }
        
        //Se esiste un attributo di sessione loggedIn e questo vale true
        //(Utente già loggato)
        if (session.getAttribute("loggedIn") != null &&
            session.getAttribute("loggedIn").equals(true)) { 
            
            request.getRequestDispatcher("login.jsp").forward(request, response);            
            return;
        
        //Se l'utente non è loggato...
        } else {
            
            String nomeUtente = request.getParameter("nomeUtente");
            String password = request.getParameter("password");
        
            
            /*
            Se Utente registrato (id!=-1) imposta :
            -attributo di sessione loggedIn = true
            -attributo di sessione loggedUserId = userID dell'utente loggato
            */
            
            if (nomeUtente != null && password != null) 
            {
                int loggedUserID = UtenteRegistratoFactory.getInstance().getIdByUserAndPassword(nomeUtente, password);
                
                // autenticazione valida
                if(loggedUserID!=-1)
                {                    
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("loggedUserID", loggedUserID);                    
                    request.setAttribute("user", loggedUserID);
                    // se manca qualche dato, come ad esempio 
                    // nome, cognome, immagine del profilo o frase di presentazione
                    // Si aprirà la pagina del Profilo, altrimenti quella della Bacheca
                    
                    UtenteRegistrato utente = UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(loggedUserID);                                                            
                    if (!UtenteRegistratoFactory.getInstance().CompleteProfile(utente)){                            
                        request.getRequestDispatcher("Profilo").forward(request, response);}
                    else
                        request.getRequestDispatcher("Bacheca").forward(request, response);                    
                    return;
                } else { //coppia user/pass non valida (id==-1)                    
                    //ritorno al form del login informando che i dati non sono validi
                    request.setAttribute("loggedIn", false);
                    request.setAttribute("invalidData", true);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    return;
                }
            }
        }
        
        /*
          Se non si verifica nessuno degli altri casi, significa che c'è stato un
          tentativo di accesso diretto alla servlet Login -> reindirizzo verso 
          il form di login.
        */
        request.setAttribute("loggedIn", false);
        request.setAttribute("invalidData", false);
        request.setAttribute("info", "Servizio: Accesso diretto alla Login");
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
