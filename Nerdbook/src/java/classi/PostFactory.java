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


/**
 *
 * @author VCCRCR72A28B354P
 */
public class PostFactory {
    
    private String connectionString;
    //Pattern Design Singleton
    private static PostFactory singleton;

    private ArrayList<Post> listaPost = new ArrayList<Post>();
    
    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }
    
    public void setConnectionString(String s) {
            this.connectionString=s;
    }

    public String getConnectionString() {
            return this.connectionString;
    }


    public Post getPostById(int id) {
        for (Post post : this.listaPost) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }
    

    // restituisce tutti gli oggetti Post per un determinato utente
    public ArrayList<Post> getPostListById(int idAutore) {
        
        ArrayList<Post> listaPost = new ArrayList<Post>();

        try {
            Connection conn = DriverManager.getConnection(connectionString,"administrator","123");
            String query="select id,messaggio,tipoPost,url,autore,destinatario from posts where autore = ? order by id ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,idAutore);
            ResultSet res=stmt.executeQuery();
            
            while (res.next()) {                    
                    Post current= new Post();
                    current.setId(res.getInt("id"));
                    current.setMessaggio(res.getString("messaggio"));
                    current.setTipoPost(res.getInt("tipoPost"));
                    current.setUrl(res.getString("url")); 
                    current.setIdAutore(res.getInt("autore"));
                    current.setIdDestinatario(res.getInt("destinatario"));
                    listaPost.add(current);
            }
            
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }      
        return listaPost;
    }
    
    // Salva il Post nel Database
    public int setPost(Post post) {
        int res=0;
        try {
            Connection conn = DriverManager.getConnection(connectionString,"administrator","123");
            String query="insert into posts (id,messaggio,tipoPost,url,autore,destinatario) values (default, ?, ?, ?, ?, ?) ";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,post.getMessaggio());
            stmt.setInt(2,post.getTipoPost());
            stmt.setString(3,post.getUrl());
            stmt.setInt(4,post.getIdAutore());            
            stmt.setInt(5,post.getIdDestinatario());
            
            res=stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();            
        }

        return res;
    }
    

    // ArrayList<Post> getPostList(Gruppo gr) che restituisce tutti gli oggetti Post per un determinato gruppo    
    
    
    
}
