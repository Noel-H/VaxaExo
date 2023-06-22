import java.util.List;

public class Joueur extends Personnage {
    private Overcharge niveauOvercharge;
    private int argent;

    Joueur() {
        this("Newbie");
    }

    Joueur (String nom) {
        super(nom, 30, 8);
        this.niveauOvercharge = Overcharge.NIVEAU_0;
        this.argent = 0;
        System.out.println("Création de " + nom);
    }

    public int getNiveauOvercharge() {
        return niveauOvercharge.niveau;
    }

    public void setNiveauOvercharge(int niveauOvercharge) {
        this.niveauOvercharge = Overcharge.fromNiveau(niveauOvercharge);
    }

    public void ajouterArgent(int valeur) {
        if (valeur < 0) {
            System.out.println("AU VOLEUR !");
        } else {
            this.argent = this.argent + valeur;
        }
    }

    public int consulterArgent() {
        return this.argent;
    }

    public void ramasser(List<TypeObjet> objets) {
        if (this.vivant) {
            this.inventaire.addAll(objets);
        }
    }

    public boolean payer(int somme) {
        if (somme > this.argent) {
            return false;
        }
        this.argent = this.argent - somme;
        return true;
    }
}
