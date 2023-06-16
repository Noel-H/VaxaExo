public class VaxaExo {
    public static void main(String[] args) {
        vendre(300000, "Peter");
    }

    private static void vendre(int zeny, String nom) {
        String niveauDeVente = obtenirNiveauDeVente(zeny);
        reponseDeGary(zeny, nom, niveauDeVente);
    }

    private static String obtenirNiveauDeVente(int zeny) {
        if (zeny < 1) {
            return "NUL";
        }

        if (zeny == 1) {
            return "MEDIOCRE";
        }

        if (zeny > 1 && zeny <= 1_000) {
            return "OK";
        }

        if (zeny > 1_000 && zeny <= 100_000) {
            return "BON";
        }

            return "SUPER";
    }

    private static void reponseDeGary(int zeny, String nom, String niveauDeVente) {
        StringBuilder reponse = new StringBuilder();

        if (niveauDeVente.equals("NUL")) {
            reponse.append(remerciementDeGaryNul());
        }

        if (niveauDeVente.equals("MEDIOCRE")) {
            reponse.append(remerciementDeGaryMediocre());
        }

        if (niveauDeVente.equals("OK")) {
            reponse.append(rendreLaMonnaie(zeny, nom));
        }

        if (niveauDeVente.equals("BON")) {
            reponse.append(rendreLaMonnaie(zeny, nom));
            reponse.append(remerciementDeGaryBon());
        }

        if (niveauDeVente.equals("SUPER")) {
            reponse.append(rendreLaMonnaie(zeny, nom));
            reponse.append(remerciementDeGarySuper(zeny));
        }
        System.out.println(reponse);
    }

    private static String rendreLaMonnaie(int zeny, String nom) {
        return "Voilà vos " + zeny + "z, cher " + nom;
    }

    private static String remerciementDeGaryNul() {
        return "...";
    }

    private static String remerciementDeGaryMediocre() {
        return "Voilà ton zeny, du balai !";
    }

    private static String remerciementDeGaryBon() {
        return ". Au plaisir de vous revoir bientôt !";
    }

    private static String remerciementDeGarySuper(int zeny) {
        return ". Laissez moi vous remercier à la hauteur de votre statut : " + afficheMerci(zeny) + "!";
    }

    private static String afficheMerci(int nombreDeZeny) {
       int nombreDeMerci = nombreDeZeny/100_000;
        return "Merci ".repeat(Math.max(0, nombreDeMerci));
    }
}
