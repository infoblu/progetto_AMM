/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;


/**
 *
 * @author Rik
 */
public class UtenteRegistratoFactory {

    private String connectionString;
    //Pattern Design Singleton
    private static UtenteRegistratoFactory singleton;

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }
    public void setConnectionString(String s) {
            this.connectionString=s;
    }

    public String getConnectionString() {
            return this.connectionString;
    }
    private ArrayList<UtenteRegistrato> listaUtentiRegistrati = new ArrayList<UtenteRegistrato>();

    private UtenteRegistratoFactory() {
        
    }

    public UtenteRegistrato getUtenteRegistratoById(int id) {
        
        try {
            Connection conn = DriverManager.getConnection(connectionString,"administrator","123");
            String query="select id,amministratore,nome,cognome,urlFotoProfilo,presentazione,dataNascita,password, CAST (dataNascita as varchar(10)) as sDataNascita from UtentiRegistrati where id=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,id);
            ResultSet res=stmt.executeQuery();
            if (res.next()) {
                    UtenteRegistrato current= new UtenteRegistrato();
                    current.setId(res.getInt("id"));
                    current.setAmministratore(res.getBoolean("amministratore"));
                    current.setNome(res.getString("nome"));
                    current.setCognome(res.getString("cognome")); 
                    current.setUrlFotoProfilo(res.getString("urlFotoProfilo"));
                    current.setPresentazione(res.getString("presentazione"));
                    current.setDataNascita(res.getString("sDataNascita"));
                    current.setPassword(res.getString("password"));
                    stmt.close();
                    conn.close();
                    return current;
            }
                    stmt.close();
                    conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }      
        return null;
    }
    
    public int getIdByUserAndPassword(String nome, String password){

try {
            Connection conn = DriverManager.getConnection(connectionString,"administrator","123");            
            String query="select * from UtentiRegistrati where nome= ? and password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,nome);
            stmt.setString(2,password);
            ResultSet res=stmt.executeQuery();
            if (res.next()) {
                    int id=res.getInt("id");
                    stmt.close();
                    conn.close();
                    return id;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    // restituisce tutti gli oggetti UtenteRegistrato
    public ArrayList<UtenteRegistrato> getUserList() {
        
        ArrayList<UtenteRegistrato> listaUtenti = new ArrayList<UtenteRegistrato>();

        try {
            Connection conn = DriverManager.getConnection(connectionString,"administrator","123");
            String query="select id,amministratore,nome,cognome,urlFotoProfilo,presentazione, CAST (dataNascita as varchar(10)) as sDataNascita from UtentiRegistrati order by nome ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet res=stmt.executeQuery();
            
            while (res.next()) {                    
                    UtenteRegistrato current= new UtenteRegistrato();
                    current.setId(res.getInt("id"));
                    current.setAmministratore(Int2Bool(res.getInt("Amministratore")));
                    current.setNome(res.getString("nome"));
                    current.setCognome(res.getString("cognome"));
                    current.setUrlFotoProfilo(res.getString("urlfotoprofilo"));
                    current.setDataNascita("sDataNascita");
                    listaUtenti.add(current);
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }      
        return listaUtenti;
    }    
    
     public Boolean CompleteProfile(UtenteRegistrato utente) {
        return !(utente.getNome().equals("") || utente.getCognome().equals("") || utente.getUrlFotoProfilo().equals("") || utente.getPresentazione().equals("")); 
     }
public Boolean Int2Bool(int b) {return (b==0 ? true : false);}

}

