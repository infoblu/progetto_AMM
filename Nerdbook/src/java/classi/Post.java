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
    private UtenteRegistrato user;
    // private Gruppo group;
    private String messaggio;
    private String urlLink;
    private String urlImmagine;

    public Post() {
            id=0;
            user=null;
            // group=null;
            messaggio="";
            urlLink="";
            urlImmagine="";
    }

    public int getId() {
        return id;
    }

    public UtenteRegistrato getUser() {
        return user;
    }
/*
    public Gruppo getGroup() {
        return group;
    }
*/
    public String getMessaggio() {
        return messaggio;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public String getUrlImmagine() {
        return urlImmagine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(UtenteRegistrato user) {
        this.user = user;
    }
/*
    public void setGroup(Gruppo group) {
        this.group = group;
    }
*/
    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public void setUrlImmagine(String urlImmagine) {
        this.urlImmagine = urlImmagine;
    }

}
