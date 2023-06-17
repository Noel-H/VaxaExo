import java.util.Arrays;
import java.util.stream.Collectors;

public class VaxaExo {
    public static void main(String[] args) {
        vendre("Jellopy", "billy the kid 94");
        vendre("Opal", "billy the kid 94");
        vendre("3carat Diamond", "billy the kid 94");
        vendre("Garlet", "billy the kid 94");
        vendre("Scell", "billy the kid 94");
        vendre("Zargon", "billy the kid 94");
        vendre("Aquamarine", "Tommy");
        vendre("Amethyst", "Tommy");
        vendre("Zircon", "Tommy");
        vendre("1carat Diamond", "billy the kid 94");
        vendre("2carat Diamond", "billy the kid 94");
        vendre("Pearl", "billy the kid 94");
        vendre("Emerald", "billy the kid 94");
        vendre("Grit", "Tommy");
        vendre("Ruby", "Tommy");
        vendre("Cursed Ruby", "billy the kid 94");
        vendre("Cracked Diamond", "billy the kid 94");
        vendre("17carat Diamond", "billy the kid 94");
        vendre("Gold", "billy the kid 94");
        vendre("Fine grit", "billy the kid 94");
        vendre("50carat Diamond", "John");
        vendre("Fine grit", "Gary");
    }

    public static void vendre(String objet, String nom) {
        nom = nettoyerNom(nom);
        if (garyBug(nom)) {
            return;
        }

        int zeny = determinerZeny(objet);
        traiterPrix(zeny, nom);
    }

    private static int determinerZeny(String objet) {
        if ("Jellopy".equals(objet)) {
            return 3;
        } else if ("Opal".equals(objet)) {
            return 3000;
        } else if ("3carat Diamond".equals(objet)) {
            return 27500;
        } else if ("Garlet".equals(objet)) {
            return 20;
        } else if ("Scell".equals(objet)) {
            return 80;
        } else if ("Zargon".equals(objet)) {
            return 240;
        } else if ("Aquamarine ".equals(objet)) {
            return 3000;
        } else if ("Amethyst ".equals(objet)) {
            return 3000;
        } else if ("Zircon ".equals(objet)) {
            return 3000;
        } else if ("1carat Diamond".equals(objet)) {
            return 5000;
        } else if ("2carat Diamond".equals(objet)) {
            return 12500;
        } else if ("Pearl".equals(objet)) {
            return 3000;
        } else if ("Emerald".equals(objet)) {
            return 3000;
        } else if ("Grit".equals(objet)) {
            return 153;
        } else if ("Ruby".equals(objet)) {
            return 3000;
        } else if ("Cursed Ruby".equals(objet)) {
            return 300;
        } else if ("Cracked Diamond".equals(objet)) {
            return 5;
        } else if ("17carat Diamond".equals(objet)) {
            return 3000000;
        } else if ("Gold".equals(objet)) {
            return 75000;
        } else if ("Fine grit".equals(objet)) {
            return 60;
        }  else {
            return -1;
        }
    }

    private static boolean garyBug(String nom) {
        if (nom.equals("Gary")) {
            System.out.println("Boum !");
            return true;
        }
        return false;
    }

    private static void traiterPrix(int zeny, String nom) {
        if (zeny < 0) {
            traiterPrixInferieur0();
        } else if (zeny == 0) {
            traiterPrixEgal0();
        } else if (zeny == 1) {
            traiterPrixEgal1();
        } else if (zeny <= 1000) {
            traiterPrixInferieurEgal1000(zeny, nom);
        } else if (zeny <= 100000) {
            traiterPrixInferieurEgal100000(zeny, nom);
        } else {
            traiterPrixSuperieur100000(zeny, nom);
        }
    }

    private static void garyParle(String s) {
        System.out.println("Gary : " + s);
    }

    private static void traiterPrixInferieur0() {
        garyParle("Je n'accepte pas cet objet.");
    }

    private static void traiterPrixEgal0() {
        garyParle("...");
    }

    private static void traiterPrixEgal1() {
        garyParle("Voilà ton zeny, du balai !");
    }

    private static void traiterPrixInferieurEgal1000(int zeny, String nom) {
        garyParle("Voilà vos " + zeny + "z, " + nom);
    }

    private static void traiterPrixInferieurEgal100000(int zeny, String nom) {
        garyParle("Voilà voz " + zeny + "z, cher " + nom + ". Au plaisir de vous revoir bientôt !");
    }

    private static void traiterPrixSuperieur100000(int zeny, String nom) {
        String message = "Voilà vos " + zeny + "z, Maître " + nom + ". Laissez moi vous remercier à la hauteur de votre statut :";
        int nbMerci = zeny / 100000;
        for (int i = 0; i < nbMerci; i++) {
            message += " Merci";
        }
        message += " !";
        garyParle(message);
    }

    private static String nettoyerNom(String raw) {
        String strClean = raw.replaceAll("[^A-Za-z -]", "")
                .replaceAll("^[- ]*", "")
                .replaceAll("[- ]*$", "")
                .replaceAll("[-]{2,}", "-")
                .replaceAll("[ -]{2,}", " ")
                .toLowerCase();
        return mettreEnMajuscule(strClean);
    }

    private static String mettreEnMajuscule(String strClean) {
        return Arrays.stream(strClean.split("((?=[ -])|(?<=[ -]))"))
                .map(s -> s.matches("^[a-z]+$") ? s.substring(0, 1).toUpperCase() + s.substring(1) : s)
                .collect(Collectors.joining());
    }
}
