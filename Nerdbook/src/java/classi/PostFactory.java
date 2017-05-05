/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.util.ArrayList;

/**
 *
 * @author VCCRCR72A28B354P
 */
public class PostFactory {
    //Pattern Design Singleton
    private static PostFactory singleton;

    public static PostFactory getInstance() {
        if (singleton == null) {
            singleton = new PostFactory();
        }
        return singleton;
    }

    private ArrayList<Post> listaPost = new ArrayList<Post>();

    private PostFactory() {
        //Creazione post

        //Post 0
        Post post0 = new Post();
        post0.setId(0);
        post0.setUser(UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(0));
        // post0.setGroup(null);
        post0.setMessaggio("Messaggio 0");
        post0.setUrlLink("");
        post0.setUrlImmagine("");
        //Post 1
        Post post1 = new Post();
        post1.setId(1);
        post1.setUser(UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(1));
        // post1.setGroup(null);
        post1.setMessaggio("Ecco il mio messaggio nr.1");
        post1.setUrlLink("");
        post1.setUrlImmagine("");        
        //Post 2
        Post post2 = new Post();
        post2.setId(2);
        post2.setUser(UtenteRegistratoFactory.getInstance().getUtenteRegistratoById(2));
        // post2.setGroup(null);
        post2.setMessaggio("Questo è il messaggio nr. 2");
        post2.setUrlLink("");
        post2.setUrlImmagine(""); 

        listaPost.add(post0);
        listaPost.add(post1);
        listaPost.add(post2);
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
    public ArrayList<Post> getPostList(UtenteRegistrato usr) {
        
        ArrayList<Post> listaPost = new ArrayList<Post>();

        for (Post post : this.listaPost) {
            if (post.getUser().equals(usr)) {
                listaPost.add(post);
            }
        }
        return listaPost;
    }
    
    
    // ArrayList<Post> getPostList(Gruppo gr) che restituisce tutti gli oggetti Post per un determinato gruppo    
    
    
    
}
