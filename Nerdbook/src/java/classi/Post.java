/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

/**
 *
 * @author Rik
 */
public class Post {
        
    private int id;    
    private int tipoPost;    
    private String messaggio;
    private int idAutore;
    private int idDestinatario;
    private String url;


    public Post() {
        id=0;
        tipoPost=1;    
        messaggio="";
        idAutore=-1;
        idDestinatario=-1;
        url="";
    }

    public int getId() {
        return id;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public int getTipoPost() {
        return tipoPost;
    }
    
    public int getIdAutore() {
        return idAutore;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipoPost(int tipoPost) {
        this.tipoPost = tipoPost;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public void setIdDestinatario(int idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
