import java.util.ArrayList;
import java.util.List;

public class Poring {
    private int pvMax;
    private int pv;
    private int atk;
    private boolean vivant;
    private List<TypeObjet> inventaire;

    Poring() {
        this.pvMax = 50;
        this.pv = this.pvMax;
        this.atk = 3;
        this.vivant = true;
        this.inventaire = new ArrayList<>();
        this.inventaire.add(TypeObjet.EMPTY_BOTTLE);
        this.inventaire.add(TypeObjet.STICKY_MUCUS);
        this.inventaire.add(TypeObjet.JELLOPY);
    }

    public boolean estVivant() {
        return this.vivant;
    }

    public void recevoirDegats(int degats) {
        this.pv = this.pv - degats;
        System.out.println("Poring subit " + degats + " dégâts");
        if (this.pv <= 0) {
            this.pv = 0;
            this.vivant = false;
            System.out.println("Poring est mort !");
        }
    }

    public List<TypeObjet> viderInventaire() {
        List<TypeObjet> objetsSupprimer = this.inventaire;
        this.inventaire = new ArrayList<>();
        return objetsSupprimer;
    }

    public void depouiller(Joueur joueur) {
        List<TypeObjet> objets = joueur.viderInventaire();
        this.inventaire.addAll(objets);
        System.out.println("Poring ramasse " + objets.size() + " objets");
    }

    public void attaquer(Joueur joueur) {
        if (this.vivant) {
            System.out.println("Poring inflige " + this.atk + " dégâts");
            joueur.recevoirDegats(this.atk);
        }
    }
}
