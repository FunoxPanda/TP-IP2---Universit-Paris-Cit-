
public class Salon {

    Message[] tabMessage;
    Utilisateur[] tabUtilisateur;
    int indexLibreMessage;
    int indexLibreUtilisateur;

    public Salon() {
        this.tabMessage = new Message[10];
        this.tabUtilisateur = new Utilisateur[10];
        this.indexLibreMessage = 0;
        this.indexLibreUtilisateur = 0;
    }

    public boolean estPresent(Utilisateur user) {
        for (int i = 0; i < this.tabUtilisateur.length; i++) {
            if (this.tabUtilisateur[i] == user) {
                return true;
            }
        }
        return false;
    }

    public void ajouterUtilisateur(Utilisateur user) {
        if (this.indexLibreUtilisateur > 9) {
            return;
        }

        this.tabUtilisateur[this.indexLibreUtilisateur] = user;
        this.indexLibreUtilisateur++;
    }

    public void ajouterMessage(Utilisateur sender, Message message) {
        if (!estPresent(sender)) {
            return;
        }
        if (this.indexLibreMessage > 9) {
            return;
        }

        this.tabMessage[this.indexLibreMessage] = message;
        this.indexLibreMessage++;
    }

    public void afficher() {
        if (this.indexLibreMessage == 0) {
            return;
        }
        for (int i = 0; i < this.tabMessage.length; i++) {
            if (this.tabMessage[i] == null) {
                return;
            }
            System.out.println(this.tabMessage[i].sender.getPseudonyme() + " : " + this.tabMessage[i].content);
        }
    }

    /*. (plus difficile) On souhaite pouvoir exclure un utilisateur d’un salon : la personne en question
ne fait plus partie du salon, et aucun de ses messages n’est plus conservé. Proposez une/des
méthodes pour implémenter cette fonctionnalité proprement.
     */
    public void ban(Utilisateur user) {
        if (!estPresent(user)) {
            return;
        }

        for (int i = 0; i < this.indexLibreUtilisateur; i++) {
            if (this.tabUtilisateur[i] == user) {
                this.tabUtilisateur[i] = null;
                if (i == 9) {
                    return;
                }

                for (int j = i + 1; j < this.indexLibreMessage - 1; j++) {
                    Utilisateur tmp = this.tabUtilisateur[j - 1];
                    this.tabUtilisateur[j] = this.tabUtilisateur[j + 1];
                    this.indexLibreMessage = j + 1;
                }
            }
        }

        for (int i = 0; i < this.indexLibreMessage; i++) {
            if (this.tabMessage[i].sender == user) {
                this.tabMessage[i] = null;
                if (i == 9) {
                    return;
                }

                for (int j = i + 1; j < this.indexLibreMessage - 1; j++) {
                    Message tmp = this.tabMessage[j - 1];
                    this.tabMessage[j] = this.tabMessage[j + 1];
                }
            }
        }
    }

    public int countUserMessages(Utilisateur user) {
        int res = 0;
        if (this.indexLibreMessage == 0) {
            return res;
        }
        for (int i = 0; i < this.tabMessage.length; i++) {
            if (this.tabMessage[i] == null) {
                return res;
            }
            if (this.tabMessage[i].sender == user) {
                res++;
            }
        }

        return res;
    }

    public Utilisateur bavard() {
        if(this.indexLibreUtilisateur == 0) return null;

        Utilisateur CCP = this.tabUtilisateur[0];
        for (int i = 1; i < this.tabUtilisateur.length; i++) {
            if (this.tabUtilisateur[i] == null) continue;
            if(countUserMessages(this.tabUtilisateur[i]) > countUserMessages(CCP)) CCP = this.tabUtilisateur[i];
        } 

        return CCP;
    }
}
