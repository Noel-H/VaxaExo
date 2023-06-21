public class VaxaExo {
    public static void main(String[] args) {
        Gary gary = new Gary();
        Foret foret = new Foret();

        Joueur joueur1 = new Joueur("Billy");
        Joueur joueur2 = new Joueur("Patrick");
        Joueur joueur3 = new Joueur("Erica");
        gary.vendreTout(joueur1);

        System.out.println();

        foret.visiter(joueur1);
        foret.visiter(joueur2);
        foret.visiter(joueur3);

        System.out.println();

        gary.vendreTout(joueur1);
    }
}
