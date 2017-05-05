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
public class GruppoFactory {
    //Pattern Design Singleton
    private static GruppoFactory singleton;

    public static GruppoFactory getInstance() {
        if (singleton == null) {
            singleton = new GruppoFactory();
        }
        return singleton;
    }

    private ArrayList<Gruppo> listaGruppi = new ArrayList<Gruppo>();

    private GruppoFactory() {
        //Creazione gruppi

        //gruppo 0
        Gruppo gruppo0 = new Gruppo();
        gruppo0.setId(0);
        gruppo0.setNomeGruppo("Riders");
        gruppo0.setIdProprietario(1);
        //gruppo 0
        Gruppo gruppo1 = new Gruppo();
        gruppo0.setId(1);
        gruppo0.setNomeGruppo("Squash");
        gruppo0.setIdProprietario(2);
        //gruppo 0
        Gruppo gruppo2 = new Gruppo();
        gruppo0.setId(2);
        gruppo0.setNomeGruppo("Star Trek");
        gruppo0.setIdProprietario(3);
        
 

        listaGruppi.add(gruppo0);
        listaGruppi.add(gruppo1);
        listaGruppi.add(gruppo2);
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
}
