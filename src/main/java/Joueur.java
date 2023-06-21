import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private int pvMax;
    private int pv;
    private boolean vivant;
    private Overcharge niveauOvercharge;
    private List<TypeObjet> inventaire;
    private int argent;

    Joueur() {
        this("Newbie");
    }

    Joueur (String nom) {
        if (nom.isEmpty()){
            nom = "Newbie";
        }
        this.nom = nom;
        this.niveauOvercharge = Overcharge.NIVEAU_0;
        this.inventaire = new ArrayList<>();
        this.argent = 0;
        this.pvMax = 30;
        this.pv = this.pvMax;
        this.vivant = true;
        System.out.println("Création de " + nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean estVivant() {
        return this.vivant;
    }

    public void recevoirDegats(int degats) {
        this.pv = this.pv - degats;
        System.out.println(this.nom + " subit " + degats + " dégâts");
        if (this.pv < 0) {
            this.pv = 0;
            this.vivant = false;
            System.out.println(this.nom + " est mort !");
        }
    }

    public int getNiveauOvercharge() {
        return niveauOvercharge.niveau;
    }

    public void setNiveauOvercharge(int niveauOvercharge) {
        this.niveauOvercharge = Overcharge.fromNiveau(niveauOvercharge);
    }

    public List<TypeObjet> viderInventaire() {
        List<TypeObjet> objetsSupprimer = this.inventaire;
        this.inventaire = new ArrayList<>();
        return objetsSupprimer;
    }

    public void ramasser(List<TypeObjet> objets) {
        if (this.vivant) {
            this.inventaire.addAll(objets);
        }
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
}
