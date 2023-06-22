import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {
    protected String nom;
    protected int pvMax;
    protected int pv;
    protected int atk;
    protected boolean vivant;
    protected List<TypeObjet> inventaire;

    Personnage(String nom, int pvMax, int atk) {
        if (nom.isEmpty()){
            nom = "Newbie";
        }
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pvMax;
        this.atk = atk;
        this.vivant = true;
        this.inventaire = new ArrayList<>();
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
        if (this.pv <= 0) {
            this.pv = 0;
            this.vivant = false;
            System.out.println(this.nom + " est mort !");
        }
    }

    public List<TypeObjet> viderInventaire() {
        List<TypeObjet> objetsSupprimer = this.inventaire;
        this.inventaire = new ArrayList<>();
        return objetsSupprimer;
    }

    public void depouiller(Personnage personnage) {
        List<TypeObjet> objets = personnage.viderInventaire();
        this.inventaire.addAll(objets);
        System.out.println(this.nom + " ramasse " + objets.size() + " objets");
    }

    public void attaquer(Personnage personnage) {
        if (this.vivant) {
            System.out.println(this.nom + " inflige " + this.atk + " dégâts");
            personnage.recevoirDegats(this.atk);
        }
    }
}
