import java.util.ArrayList;
import java.util.List;

public class Joueur extends Personnage {
    private JoueurInfo dataJoueur;

    public Joueur() {
        this("Newbie");
    }

    public Joueur(String nom) {
        super();
        this.data = new JoueurInfo(
                nom,
                Job.NOVICE.basePvMax,
                Job.NOVICE.basePvMax,
                Job.NOVICE.baseAtk,
                true,
                new ArrayList<>(),
                0,
                0,
                0,
                0,
                1,
                Job.NOVICE,
                0);
        this.dataJoueur = (JoueurInfo) this.data;
        System.out.println("Création de " + this.dataJoueur.getNom());
    }

    public int getNiveauOvercharge() {
        return this.dataJoueur.getNiveauOvercharge();
    }


    public void ramasser(List<TypeObjet> objets) {
        if (this.dataJoueur.isVivant()) {
            this.dataJoueur.getInventaire().addAll(objets);
        }
    }

    public void ajouterArgent(int valeur) {
        if (valeur < 0) {
            System.out.println("AU VOLEUR !");
        } else {
            this.dataJoueur.setArgent(this.dataJoueur.getArgent() + valeur);
        }
    }

    public int consulterArgent() {
        return this.dataJoueur.getArgent();
    }

    public boolean payer(int somme) {
        if (nePeutPasPayer(somme)) {
            return false;
        }
        reduireArgent(somme);
        return true;
    }

    private void reduireArgent(int somme) {
        this.dataJoueur.setArgent(this.dataJoueur.getArgent() - somme);
    }

    private boolean nePeutPasPayer(int somme) {
        return somme > this.dataJoueur.getArgent();
    }

    @Override
    public void comportementVictoire(Personnage personnage) {
        depouiller(personnage);
        if (personnage instanceof Poring) {
            gagnerExp(((Poring) personnage).getValeurExp());
        }
    }

    public void gagnerExp(int somme) {
        this.dataJoueur.setExp(this.dataJoueur.getExp() + somme);
        gererMonteeDeNiveau();
    }

    public void changerDeClasse(Job job) {
        this.dataJoueur.setJob(job);
        recalculerStats();
        gererCapacites();
        System.out.println(this.dataJoueur.getNom() + " devient " + job.libelle + " !");
    }

    private void gererMonteeDeNiveau() {
        int nouveauNiveau = NiveauExp.fromExp(this.dataJoueur.getExp()).niveau;
        if (this.dataJoueur.getNiveau() != nouveauNiveau) {
            this.dataJoueur.setNiveau(nouveauNiveau);
            recalculerStats();
            gererCapacites();
            this.dataJoueur.setPv(this.dataJoueur.getPvMax());
            System.out.println(this.dataJoueur.getNom() + " passe au niveau " + this.dataJoueur.getNiveau() + " !");
        }
    }

    private void gererCapacites() {
        int niveauxAuDelaDe10 = this.dataJoueur.getNiveau() - 10;

        if (Job.NOVICE.equals(this.dataJoueur.getJob())) {
            return;
        }

        if (niveauxAuDelaDe10 < 0) {
            return;
        }

        if (Job.EPEISTE.equals(this.dataJoueur.getJob())) {
            this.dataJoueur.setNiveauBash(Math.min(niveauxAuDelaDe10, 10));
        } else if (Job.MARCHAND.equals(this.dataJoueur.getJob())) {
            this.dataJoueur.setNiveauOvercharge(Math.min(niveauxAuDelaDe10, 10));
        }
    }

    private void recalculerStats() {
        this.dataJoueur.setAtk(this.dataJoueur.getJob().baseAtk + (this.dataJoueur.getNiveau() * 2));
        this.dataJoueur.setPvMax(this.dataJoueur.getJob().basePvMax + (this.dataJoueur.getNiveau() * 15));
    }

    public int getNiveau() {
        return this.dataJoueur.getNiveau();
    }

    public Job getJob() {
        return this.dataJoueur.getJob();
    }

    public void attaquer(Personnage personnage) {
        super.attaquer(personnage);

        if (this.dataJoueur.isVivant() && Job.EPEISTE.equals(this.dataJoueur.getJob())) {
            this.dataJoueur.setCompteurAtk(this.dataJoueur.getCompteurAtk() + 1);
            if (this.dataJoueur.getCompteurAtk() % 3 == 0) {
                double bashMultiplicateur = SkillBash.fromNiveau(this.dataJoueur.getNiveauBash()).multiplicateur;
                int attaqueBash = (int) (this.dataJoueur.getAtk() * bashMultiplicateur);
                System.out.println(this.dataJoueur.getNom() + " utilise Bash !");
                System.out.println(this.dataJoueur.getNom() + " inflige " + attaqueBash + " dégâts");
                personnage.recevoirDegats(attaqueBash);
            }
        }
    }
}