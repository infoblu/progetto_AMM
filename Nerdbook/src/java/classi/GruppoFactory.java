/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author VCCRCR72A28B354P
 */
public class GruppoFactory {
    
    private String connectionString;
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    public void setConnectionString(String s) {
	this.connectionString=s;
    }

    public String getConnectionString() {
            return this.connectionString;
    }
    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {

    }

    public Gruppo getGruppiById(int id) {
        for (Gruppo gruppo : this.listaGruppi) {
            if (gruppo.getId() == id) {
                return gruppo;
            }
        }
        return null;
    }
    
    public int getIdByNomeGruppo(String nomeGruppo){
        for(Gruppo gruppo : this.listaGruppi){
            if(gruppo.getNomeGruppo().equals(nomeGruppo) ){
                return gruppo.getId();
            }
        }
        return -1;
    }    


    // restituisce tutti gli oggetti Gruppo
    public ArrayList<Gruppo> getGroupList() {
        
        ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

        try {
            Connection conn = DriverManager.getConnection(connectionString,"administrator","123");
            String query="select id,nome,proprietario from Gruppi order by nome ";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet res=stmt.executeQuery();
            
            while (res.next()) {                    
                    Gruppo current= new Gruppo();
                    current.setId(res.getInt("id"));
                    current.setNomeGruppo(res.getString("nome"));
                    current.setIdProprietario(res.getInt("proprietario"));
                    listaGruppi.add(current);
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }      
        return listaGruppi;
    }   

}
