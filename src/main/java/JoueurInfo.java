import java.util.List;

public class JoueurInfo extends PersonnageInfo {
    private int niveauOvercharge;
    private int niveauBash;
    private int argent;
    private int exp;
    private int niveau;
    private Job job;
    private int compteurAtk;

    public JoueurInfo(String nom, int pvMax, int pv, int atk, boolean vivant, List<TypeObjet> inventaire, int niveauOvercharge, int niveauBash, int argent, int exp, int niveau, Job job, int compteurAtk) {
        super(nom, pvMax, pv, atk, vivant, inventaire);
        this.niveauOvercharge = niveauOvercharge;
        this.niveauBash = niveauBash;
        this.argent = argent;
        this.exp = exp;
        this.niveau = niveau;
        this.job = job;
        this.compteurAtk = compteurAtk;
    }

    public int getNiveauOvercharge() {
        return niveauOvercharge;
    }

    public void setNiveauOvercharge(int niveauOvercharge) {
        this.niveauOvercharge = niveauOvercharge;
    }

    public int getNiveauBash() {
        return niveauBash;
    }

    public void setNiveauBash(int niveauBash) {
        this.niveauBash = niveauBash;
    }

    public int getArgent() {
        return argent;
    }

    public void setArgent(int argent) {
        this.argent = argent;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getCompteurAtk() {
        return compteurAtk;
    }

    public void setCompteurAtk(int compteurAtk) {
        this.compteurAtk = compteurAtk;
    }

    @Override
    public TypePersonnage getType() {
        return TypePersonnage.JOUEUR;
    }
}
