public class Noeud {
    private int etiquette;
    private Noeud gauche;
    private Noeud droit;

    public Noeud(int etiquette, Noeud g, Noeud d) {
        this.etiquette = etiquette;
        this.gauche = g;
        this.droit = d;
    }

    public Noeud(int etiquette) {
        this(etiquette, null, null);
    }

    public Noeud(Noeud n) {
        this.etiquette = n.etiquette;
        if (n.gauche != null) {
            this.gauche = new Noeud(n.gauche);
        }
        if (n.droit != null) {
            this.droit = new Noeud(n.droit);
        }
    }

    public void afficheInfixe() {
        if (this.gauche != null) {
            this.gauche.afficheInfixe();
        }

        System.out.print(this.etiquette + " ");

        if (this.droit != null) {
            this.droit.afficheInfixe();
        }
    }

    public void affichePrefixe() {
        System.out.print(this.etiquette + " ");
        if (this.gauche != null)
            this.gauche.affichePrefixe();
        if (this.droit != null)
            this.droit.affichePrefixe();
    }

    public void afficheSuffixe() {
        if (this.gauche != null)
            this.gauche.afficheSuffixe();
        if (this.droit != null)
            this.droit.afficheSuffixe();
        System.out.print(this.etiquette + " ");
    }

    public int nbDeNoeuds() {
        int res = 1;
        if (this.gauche != null)
            res += this.gauche.nbDeNoeuds();
        if (this.droit != null)
            res += this.droit.nbDeNoeuds();

        return res;
    }

    public int somme() {
        int res = this.etiquette;
        if (this.gauche != null)
            res += this.gauche.somme();
        if (this.droit != null)
            res += this.droit.somme();

        return res;
    }

    /*
     * Rappelons que la hauteur d’un arbre non vide est définie comme étant le
     * nombre d’arêtes
     * dans le plus long chemin de la racine à une feuille. La hauteur de l’arbre
     * vide est −1 par
     * définition. Par exemple, la hauteur de l’arbre donné en exemple est 4 : sa
     * plus longue branche
     * est 3 – 5 – 9 – 6 – 8, qui contient 4 arêtes. Définir une méthode int
     * hauteur() qui retourne
     * la hauteur d’un arbre.
     */

    public int hauteur() {
        int hg = (this.gauche != null) ? this.gauche.hauteur() : -1;
        int hd = (this.droit != null) ? this.droit.hauteur() : -1;

        return 1 + Math.max(hg, hd);
    }

    /*
     * Définir une méthode boolean recherche(int e) qui renvoie true si un nœud de
     * l’arbre
     * est étiqueté par e.
     */

    public boolean recherche(int el) {
        if (this.etiquette == el)
            return true;
        else {
            boolean leftContains = this.gauche != null ? this.gauche.recherche(el) : false;
            if (leftContains)
                return true;

            return this.droit != null ? this.droit.recherche(el) : false;
        }
    }

}