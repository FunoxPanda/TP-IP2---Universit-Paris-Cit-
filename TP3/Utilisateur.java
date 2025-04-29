public class Utilisateur {
    private String pseudo;
    private String motDePasse;
    private final String adresseMail;

    public Utilisateur(String pseudo, String motDePasse, String adresseMail) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.adresseMail = adresseMail;
    }

    public boolean testMotDePasse(String pwd) {
        if(pwd.equals(this.motDePasse)) return true;
        return false;
    }

    public void changerMotDePasse(String currentPwd ,String newPwd) {
        if(!testMotDePasse(currentPwd)) return;

        this.motDePasse = newPwd;
    }

    public String getPseudonyme() {
        return this.pseudo;
    }

    public void setPseudonyme(String pwd, String nametag) {
        if(!testMotDePasse(pwd)) return;
        this.pseudo = nametag;
    }
}