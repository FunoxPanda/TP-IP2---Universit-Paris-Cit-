public class Arbre {
    private Noeud sommet;

    public Arbre(Noeud sommet) {
        this.sommet = sommet;
    }
    
    public Arbre(Arbre a) {
        this.sommet = new Noeud(a.sommet);
    }

    public void afficheInfixe() {
        if (this.sommet == null) {
            System.out.println("Arbre vide");
            return;
        }

        this.sommet.afficheInfixe();
        System.out.println();

    }

    public void affichePrefixe() {
        if (this.sommet == null) {
            System.out.println("Arbre vide");
            return;
        }

        this.sommet.affichePrefixe();
        System.out.println();

    }

    public void afficheSuffixe() {
        if (this.sommet == null) {
            System.out.println("Arbre vide");
            return;
        }

        this.sommet.afficheSuffixe();
        System.out.println();

    }

    public int nbDeNoeuds() {
        return this.sommet.nbDeNoeuds();
    }

    public int somme() {
        return this.sommet.somme();
    }

    public int hauteur() {
        if(this.sommet==null) return -1;
        return this.sommet.hauteur();
    }

    public boolean recherche(int el) {
        return this.sommet.recherche(el);
    }

    
}