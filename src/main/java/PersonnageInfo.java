import java.util.List;

public abstract class PersonnageInfo {
    private String nom;
    private int pvMax;
    private int pv;
    private int atk;
    private boolean vivant;
    private List<TypeObjet> inventaire;

    public PersonnageInfo(String nom, int pvMax, int pv, int atk, boolean vivant, List<TypeObjet> inventaire) {
        this.nom = nom;
        this.pvMax = pvMax;
        this.pv = pv;
        this.atk = atk;
        this.vivant = vivant;
        this.inventaire = inventaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPvMax() {
        return pvMax;
    }

    public void setPvMax(int pvMax) {
        this.pvMax = pvMax;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public boolean isVivant() {
        return vivant;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public List<TypeObjet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(List<TypeObjet> inventaire) {
        this.inventaire = inventaire;
    }

    public abstract TypePersonnage getType();
}
