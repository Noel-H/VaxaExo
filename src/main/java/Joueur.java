import java.util.List;

public class Joueur extends Personnage {
    private Overcharge niveauOvercharge;
    private int argent;
    public int exp; // a mettre en public pour le test
    private int niveau;
    private int baseAtk;
    private int basePvMax;

    Joueur() {
        this("Newbie");
    }

    Joueur (String nom) {
        super(nom, 30, 8);
        this.niveauOvercharge = Overcharge.NIVEAU_0;
        this.argent = 0;
        this.exp = 0;
        this.niveau = 1;
        this.baseAtk = this.atk;
        this.basePvMax = this.pvMax;
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

    @Override
    public void comportementVictoire(Personnage personnage) {
        this.depouiller(personnage);
        if (personnage instanceof Poring) {
            gagnerExp(((Poring)personnage).getValeurExp());
        }
    }

    public void gagnerExp(int somme) {
        this.exp = this.exp + somme;
        int nouveauNiveau = NiveauExperience.fromExperience(this.exp).level;
        if (nouveauNiveau != this.niveau) {
            gagnerNiveau(nouveauNiveau);
        }
    }

    private void gagnerNiveau(int nouveauNiveau) {
        this.niveau = nouveauNiveau;
        recalculerStat();
        System.out.println(this.nom + " passe au niveau " + nouveauNiveau + " !");
    }

    private void recalculerStat() {
        calculerBaseAtk();
        calculerBasePvMax();
    }

    private void calculerBasePvMax() {
        this.pvMax = this.basePvMax + (15 * this.niveau);
    }

    private void calculerBaseAtk() {
        this.atk = this.baseAtk + (this.niveau * 2);
    }
}
