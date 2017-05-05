/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.util.ArrayList;

/**
 *
 * @author Rik
 */
public class UtenteRegistratoFactory {

    //Pattern Design Singleton
    private static UtenteRegistratoFactory singleton;

    public static UtenteRegistratoFactory getInstance() {
        if (singleton == null) {
            singleton = new UtenteRegistratoFactory();
        }
        return singleton;
    }

    private ArrayList<UtenteRegistrato> listaUtentiRegistrati = new ArrayList<UtenteRegistrato>();

    private UtenteRegistratoFactory() {
        //Creazione utenti registrati

        //utente 0
        UtenteRegistrato user0 = new UtenteRegistrato();
        user0.setId(0);
        user0.setAmministratore(true);
        user0.setNome("Riccardo");
        user0.setCognome("Vacca");
        user0.setUrlFotoProfilo("/img/vacca.jpg");
        user0.setPresentazione("Sono l'amministratore");
        user0.setDataNascita("28/01/1972");
        user0.setPassword("123");        
        
        //utente 1
        UtenteRegistrato user1 = new UtenteRegistrato();
        user1.setId(1);
        user1.setAmministratore(false);
        user1.setNome("Ken");
        user1.setCognome("Follet");
        user1.setUrlFotoProfilo("/img/kenfollett.jpg");
        user1.setPresentazione("Buongiorno, leggete i miei libri");
        user1.setDataNascita("01/03/1950");
        user1.setPassword("123");
        
        //utente 2
        UtenteRegistrato user2 = new UtenteRegistrato();
        user2.setId(2);
        user2.setAmministratore(false);
        user2.setNome("Barack");
        user2.setCognome("Obama");
        user2.setUrlFotoProfilo("/img/barackobama.jpg");
        user2.setPresentazione("Vote for me!!!");
        user2.setDataNascita("05/04/1963");
        user2.setPassword("123");
        
        //utente 3
        UtenteRegistrato user3 = new UtenteRegistrato();
        user3.setId(3);
        user3.setAmministratore(false);
        user3.setNome("Jean Luc");
        user3.setCognome("Picard");
        user3.setUrlFotoProfilo("/M3/img/picard.png");
        user3.setPresentazione("Engage!");
        user3.setDataNascita("23/11/1953");
        user3.setPassword("123");
        
        //utente 4
        UtenteRegistrato user4 = new UtenteRegistrato();
        user4.setId(4);
        user4.setAmministratore(false);
        user4.setNome("incompleto");
        user4.setCognome("");
        user4.setUrlFotoProfilo("");
        user4.setPresentazione("");
        user4.setDataNascita("");
        user4.setPassword("");
        
        listaUtentiRegistrati.add(user0);
        listaUtentiRegistrati.add(user1);
        listaUtentiRegistrati.add(user2);
        listaUtentiRegistrati.add(user3);
        listaUtentiRegistrati.add(user4);
    }

    public UtenteRegistrato getUtenteRegistratoById(int id) {
        for (UtenteRegistrato user : this.listaUtentiRegistrati) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public int getIdByUserAndPassword(String nome, String password){
        for(UtenteRegistrato user : this.listaUtentiRegistrati){
            if(user.getNome().equals(nome) && user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return -1;
    }
}

