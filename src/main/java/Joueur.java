import java.util.List;

public class Joueur extends Personnage {
    private int niveauOvercharge;
    private int niveauBash;
    private int argent;
    public int exp;
    private int niveau;
    private Job job;
    private int compteurAtk;

    Joueur() {
        this("Newbie");
    }

    Joueur(String nom) {
        super(nom, 30, 8);
        this.niveauOvercharge = SkillOvercharge.NIVEAU_0.niveau;
        this.argent = 0;
        this.exp = 0;
        this.niveau = 1;
        this.job = Job.NOVICE;
        this.compteurAtk = 0;
        System.out.println("Création de " + this.nom);
    }

    public int getNiveauOvercharge() {
        return niveauOvercharge;
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

    public boolean payer(int somme) {
        if (nePeutPasPayer(somme)) {
            return false;
        }
        reduireArgent(somme);
        return true;
    }

    private void reduireArgent(int somme) {
        this.argent = this.argent - somme;
    }

    private boolean nePeutPasPayer(int somme) {
        return somme > argent;
    }

    @Override
    public void comportementVictoire(Personnage personnage) {
        depouiller(personnage);
        if (personnage instanceof Poring) {
            gagnerExp(((Poring) personnage).getValeurExp());
        }
    }

    public void gagnerExp(int somme) {
        this.exp += somme;
        gererMonteeDeNiveau();
    }

    public void changerDeClasse(Job job) {
        this.job = job;
        recalculerStats();
        gererCapacites();
        System.out.println(nom + " devient " + job.libelle + " !");
    }

    private void gererMonteeDeNiveau() {
        int nouveauNiveau = NiveauExp.fromExp(this.exp).niveau;
        if (this.niveau != nouveauNiveau) {
            this.niveau = nouveauNiveau;
            recalculerStats();
            gererCapacites();
            this.pv = this.pvMax;
            System.out.println(this.nom + " passe au niveau " + this.niveau + " !");
        }
    }

    private void gererCapacites() {
        int niveauxAuDelaDe10 = this.niveau - 10;

        if (Job.NOVICE.equals(this.job)) {
            return;
        }

        if (niveauxAuDelaDe10 < 0) {
            return;
        }

        if (Job.EPEISTE.equals(this.job)) {
            this.niveauBash = Math.min(niveauxAuDelaDe10, 10);
        } else if (Job.MARCHAND.equals(this.job)) {
            this.niveauOvercharge = Math.min(niveauxAuDelaDe10, 10);
        }
    }

    private void recalculerStats() {
        this.atk = this.job.baseAtk + (this.niveau * 2);
        this.pvMax = this.job.basePvMax + (this.niveau * 15);
    }

    public int getNiveau() {
        return niveau;
    }

    public Job getJob() {
        return job;
    }

    public void attaquer(Personnage personnage) {
        super.attaquer(personnage);

        if (this.vivant && Job.EPEISTE.equals(this.job)) {
            this.compteurAtk += 1;
            if (this.compteurAtk % 3 == 0) {
                double bashMultiplicateur = SkillBash.fromNiveau(this.niveauBash).multiplicateur;
                int attaqueBash = (int) (this.atk * bashMultiplicateur);
                System.out.println(this.nom + " utilise Bash !");
                System.out.println(this.nom + " inflige " + attaqueBash + " dégâts");
                personnage.recevoirDegats(attaqueBash);
            }
        }
    }
}