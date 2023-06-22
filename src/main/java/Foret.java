public class Foret {
    private Poring poring;

    Foret() {
        this.poring = new Poring();
    }

    public void visiter(Joueur joueur) {
        while (joueur.estVivant() && this.poring.estVivant()) {
            joueur.attaquer(this.poring);
            this.poring.attaquer(joueur);
        }

        if (!this.poring.estVivant()) {
            joueur.depouiller(this.poring);
            this.poring = new Poring();
        }

        if (!joueur.estVivant()) {
            this.poring.depouiller(joueur);
        }
    }
}
