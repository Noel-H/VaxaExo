import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {

    protected PersonnageInfo data;

    public Personnage() {

    }

    public Personnage(PersonnageInfo personnageInfo) {
        this.data = personnageInfo;
    }

    public String getNom() {
        return this.data.getNom();
    }

    public void setNom(String nom) {
        this.data.setNom(nom);
    }

    public boolean estVivant() {
        return this.data.isVivant();
    }

    public void recevoirDegats(int degats) {
        this.data.setPv(this.data.getPv() - degats);
        System.out.println(this.data.getNom() + " subit " + degats + " dégâts");
        if (this.data.getPv() <= 0) {
            this.data.setPv(0);
            this.data.setVivant(false);
            System.out.println(this.data.getNom() + " est mort !");
        }
    }

    public List<TypeObjet> viderInventaire() {
        List<TypeObjet> objetsSupprimer = this.data.getInventaire();
        this.data.setInventaire(new ArrayList<>());
        return objetsSupprimer;
    }

    public void depouiller(Personnage personnage) {
        List<TypeObjet> objets = personnage.viderInventaire();
        this.data.getInventaire().addAll(objets);
        System.out.println(data.getNom() + " ramasse " + objets.size() + " objets");
    }

    public void attaquer(Personnage personnage) {
        if (this.data.isVivant()) {
            System.out.println(this.data.getNom() + " inflige " + this.data.getAtk() + " dégâts");
            personnage.recevoirDegats(this.data.getAtk());
        }
    }

    public void recupererPV(int valeur) {
        int pvSoignes = calculerPvSoignes(data.getPv(), data.getPvMax(), valeur);
        data.setPv( data.getPv() + pvSoignes);
        System.out.println(data.getNom() + " récupère " + pvSoignes + " points de vie");
    }

    private int calculerPvSoignes(int pv, int pvMax, int valeur) {
        int pvManquant = pvMax - pv;
        if (pvManquant > valeur) {
            return valeur;
        }
        return pvManquant;
    }

    public int getPvMax() {
        return data.getPvMax();
    }

    public abstract void comportementVictoire(Personnage personnage);
}
