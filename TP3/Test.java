public class Test {
    
    public static void main(String[] args) {
        Utilisateur myself = new Utilisateur("kikoulol", "bfc@bfc.fr", "bfc@bfc.fr");
        Utilisateur other = new Utilisateur("glabellelle", "blibloup@blibloup.fr", "blibloup@blibloup.fr");
        Message msg = new Message("Salut les royas", myself);
        Message msg2Message = new Message("ouaiche !", other);
        Message msg3 = new Message("sava?", myself);
        Salon channel = new Salon();

        channel.ajouterUtilisateur(myself);
        channel.ajouterUtilisateur(other);
        channel.ajouterMessage(myself, msg);
        channel.ajouterMessage(other, msg2Message);
        channel.ajouterMessage(myself, msg3);
        channel.afficher();

        channel.ban(other);
        channel.afficher();
    }

}
