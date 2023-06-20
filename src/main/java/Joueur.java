public class Joueur {
    private String nom;
    private Overcharge niveauOvercharge;

    Joueur() {
        this("Newbie");
    }

    Joueur (String nom) {
        if (nom.isEmpty()){
            nom = "Newbie";
        }
        this.nom = nom;
        this.niveauOvercharge = Overcharge.NIVEAU_0;
        System.out.println("Création de " + nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNiveauOvercharge() {
        return niveauOvercharge.niveau;
    }

    void setNiveauOvercharge(int niveauOvercharge) {
        this.niveauOvercharge = Overcharge.fromNiveau(niveauOvercharge);
    }
}
