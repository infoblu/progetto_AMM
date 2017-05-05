package classi;

/**
 *
 * @author Riccardo Vacca - mat. 49313
 */
public class UtenteRegistrato {

    private int id;
    private Boolean amministratore;
    private String nome;
    private String cognome;
    private String urlFotoProfilo;
    private String presentazione;
    private String dataNascita;
    private String password;

    public UtenteRegistrato() {
        this.id = 0;
        this.amministratore = false;
        this.nome = "";
        this.cognome = "";
        this.urlFotoProfilo = "";
        this.presentazione = "";
        this.dataNascita = "";
        this.password = "";
    }

    public int getId() {
        return id;
    }

    public Boolean getAmministratore() {
        return amministratore;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getUrlFotoProfilo() {
        return urlFotoProfilo;
    }

    public String getPresentazione() {
        return presentazione;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmministratore(Boolean amministratore) {
        this.amministratore = amministratore;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setUrlFotoProfilo(String urlFotoProfilo) {
        this.urlFotoProfilo = urlFotoProfilo;
    }

    public void setPresentazione(String presentazione) {
        this.presentazione = presentazione;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
