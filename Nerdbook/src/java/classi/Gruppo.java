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
public class Gruppo {
    private int id;
    private String nomeGruppo;
    private int idProprietario;

    public Gruppo() {
        id=0;
        nomeGruppo="";
        idProprietario=0;
    }

    public int getId() {
        return id;
    }

    public String getNomeGruppo() {
        return nomeGruppo;
    }

    public int getIdProprietario() {
        return idProprietario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }
}