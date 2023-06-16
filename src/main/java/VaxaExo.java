public class VaxaExo {
    public static void main(String[] args) {
        int nombreDeZeny = 0;
        String prenomDeLInterlocuteur = "Peter";
//        System.out.println("Voilà vos " + nombreDeZeny + "z, " + prenomDeLInterlocuteur);

        if (nombreDeZeny < 1) {
            System.out.println("...");
        }

        if (nombreDeZeny == 1) {
            System.out.println("Voilà ton zeny, du balai !");
        }

        if (nombreDeZeny > 1 && nombreDeZeny <= 1_000) {
            System.out.println("Voilà voz " + nombreDeZeny + "z, " + prenomDeLInterlocuteur);
        }

        if (nombreDeZeny > 1_000 && nombreDeZeny <= 100_000) {
            System.out.println("Voilà voz " + nombreDeZeny + "z, cher " + prenomDeLInterlocuteur + ". Au plaisir de vous revoir bientôt !");
        }

        if (nombreDeZeny > 100_000) {
            System.out.printf("Voilà vos " + nombreDeZeny + "z, Maître " + prenomDeLInterlocuteur + ". Laissez moi vous remercier à la hauteur de votre statut : " + afficheMerci(nombreDeZeny) + "!");
        }
    }

    private static String afficheMerci(int nombreDeZeny) {
       int nombreDeMerci = nombreDeZeny/100_000;
       String reponse = "";
        for (int i = 0; i < nombreDeMerci; i++) {
            reponse = reponse + "Merci ";
        }
        return reponse;
    }
}
