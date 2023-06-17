public class VaxaExo {
    public static void main(String[] args) {
        vendre("Jellopy", "billy the kid 94");
        vendre("Opal", "billy the kid 94");
        vendre("3carat Diamond", "billy the kid 94");
        vendre("", "billy the kid 94");
        vendre("Jellopy", "Gary");
        vendre("Garlet", "Tommy");
    }

    private static void vendre(String objet, String nom) {
        String nomDuJoueur = nettoyerNom(nom);

        if (EstCeQueLeNomDuJoueurEstGary(nomDuJoueur)) {
            System.out.println("Boum !");
            return;
        }
        int zeny;
        if (!lObjetEstIlAutorise(objet)) {
            System.out.println("Gary : Je n’accepte pas cet objet.");
        } else {
            zeny = obtenirPrixDeLObjet(objet);
            String niveauDeVente = obtenirNiveauDeVente(zeny);
            reponseDeGary(zeny, nomDuJoueur, niveauDeVente);
        }
    }

    private static boolean lObjetEstIlAutorise(String objet) {
        if (objet.equals("Jellopy")) {
            return true;
        }
        if (objet.equals("Opal")) {
            return true;
        }
        if (objet.equals("3carat Diamond")) {
            return true;
        }
        return false;
    }

    private static int obtenirPrixDeLObjet(String objet) {
        if (objet.equals("Jellopy")) {
            return 3;
        }
        if (objet.equals("Opal")) {
            return 3000;
        }
        if (objet.equals("3carat Diamond")) {
            return 27500;
        }
        return 0;
    }

    private static boolean EstCeQueLeNomDuJoueurEstGary(String nomDuJoueur) {
        return nomDuJoueur.equals("Gary");
    }

    private static String nettoyerNom(String nom) {

        StringBuilder nomDuJoueur = new StringBuilder();

        for (Character character : nom.toCharArray()) {
            if (Character.isLetter(character) || Character.isSpaceChar(character) || character.equals('-')) {
                nomDuJoueur.append((character + "").toLowerCase());
            }
        }

        while (nomDuJoueurEstIlSale(nomDuJoueur.toString())) {
            for (int i = 0; i < nomDuJoueur.length(); i++) {
                if (i + 1 != nomDuJoueur.length() && String.valueOf(nomDuJoueur.charAt(i)).equals(String.valueOf(nomDuJoueur.charAt(i + 1))) && String.valueOf(nomDuJoueur.charAt(i)).equals("-")) {
                    nomDuJoueur.deleteCharAt(i);
                }
                if (i + 1 != nomDuJoueur.length() && String.valueOf(nomDuJoueur.charAt(i)).equals(String.valueOf(nomDuJoueur.charAt(i + 1))) && String.valueOf(nomDuJoueur.charAt(i)).equals(" ")) {
                    nomDuJoueur.deleteCharAt(i);
                }
                if (i + 1 != nomDuJoueur.length() && String.valueOf(nomDuJoueur.charAt(i)).equals(" ") && String.valueOf(nomDuJoueur.charAt(i + 1)).equals("-")) {
                    nomDuJoueur.deleteCharAt(i + 1);
                }
                if (i + 1 != nomDuJoueur.length() && String.valueOf(nomDuJoueur.charAt(i)).equals("-") && String.valueOf(nomDuJoueur.charAt(i + 1)).equals(" ")) {
                    nomDuJoueur.deleteCharAt(i);
                }
                if (i + 1 != nomDuJoueur.length() && String.valueOf(nomDuJoueur.charAt(i)).equals("-") && Character.isLetter(nomDuJoueur.charAt(i+1))) {
                    String letter = String.valueOf(nomDuJoueur.charAt(i + 1)).toUpperCase();
                    nomDuJoueur.deleteCharAt(i+1);
                    nomDuJoueur.replace(i+1, i+1, letter);
                }
                if (i + 1 != nomDuJoueur.length() && String.valueOf(nomDuJoueur.charAt(i)).equals(" ") && Character.isLetter(nomDuJoueur.charAt(i+1))) {
                    String letter = String.valueOf(nomDuJoueur.charAt(i + 1)).toUpperCase();
                    nomDuJoueur.deleteCharAt(i+1);
                    nomDuJoueur.replace(i+1, i+1, letter);
                }
                if (String.valueOf(nomDuJoueur.charAt(0)).equals(" ") && Character.isLetter(nomDuJoueur.charAt(1))) {
                    nomDuJoueur.deleteCharAt(0);
                }
                if (String.valueOf(nomDuJoueur.charAt(nomDuJoueur.length() - 1)).equals(" ") && Character.isLetter(nomDuJoueur.charAt(nomDuJoueur.length() - 2))) {
                    nomDuJoueur.deleteCharAt(nomDuJoueur.length()-1);
                }
            }
        }
        return nomDuJoueur.toString().substring(0, 1).toUpperCase() + nomDuJoueur.substring(1);
    }

    private static boolean nomDuJoueurEstIlSale(String nomDuJoueur) {
        return nomDuJoueur.toString().contains("--") || nomDuJoueur.toString().contains("- ") || nomDuJoueur.toString().contains(" -") || nomDuJoueur.toString().contains("  ");
    }

    private static String obtenirNiveauDeVente(int zeny) {
        if (zeny < 0) {
            return "ARNAQUE";
        }

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
        reponse.append("Gary : ");

        if (niveauDeVente.equals("ARNAQUE")) {
            reponse.append("Je ne comprends pas.");
        }

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
            reponse.append(marqueDeRespectDeGary(nom));
            reponse.append(remerciementDeGarySuper(zeny));
        }
        System.out.println(reponse);
    }

    private static String marqueDeRespectDeGary(String nom) {
        return ", Maître " + nom;
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
