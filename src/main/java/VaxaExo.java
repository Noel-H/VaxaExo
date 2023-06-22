public class VaxaExo {
    public static void main(String[] args) {
        Gary gary = new Gary();
        Foret foret = new Foret();

        Joueur joueur1 = new Joueur("Seyren");
        gary.vendreTout(joueur1);

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(joueur1.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(joueur1);
        gary.vendreTout(joueur1);

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(joueur1.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(joueur1);
        gary.vendreTout(joueur1);
    }
}
