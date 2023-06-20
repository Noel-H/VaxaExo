public class Joueur {
    private String nom;

    Joueur() {
        this("Newbie");
    }

    Joueur (String nom) {
        if (nom.isEmpty()){
            nom = "Newbie";
        }
        this.nom = nom;
        System.out.println("Création de " + nom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
