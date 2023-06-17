import java.util.Arrays;
import java.util.stream.Collectors;

public class VaxaExo {
    public static void main(String[] args) {
        vendre(TypeObjet.JELLOPY, "billy the kid 94");
        vendre(TypeObjet.OPAL, "billy the kid 94");
        vendre(TypeObjet._3CARAT_DIAMOND, "billy the kid 94");
        vendre(TypeObjet.GARLET, "billy the kid 94");
        vendre(TypeObjet.SCELL, "billy the kid 94");
        vendre(TypeObjet.ZARGON, "billy the kid 94");
        vendre(TypeObjet.AQUAMARINE, "Tommy");
        vendre(TypeObjet.AMETHYST, "Tommy");
        vendre(TypeObjet.ZIRCON, "Tommy");
        vendre(TypeObjet._1CARAT_DIAMOND, "billy the kid 94");
        vendre(TypeObjet._2CARAT_DIAMOND, "billy the kid 94");
        vendre(TypeObjet.PEARL, "billy the kid 94");
        vendre(TypeObjet.EMERALD, "billy the kid 94");
        vendre(TypeObjet.GRIT, "Tommy");
        vendre(TypeObjet.RUBY, "Tommy");
        vendre(TypeObjet.CURSED_RUBY, "billy the kid 94");
        vendre(TypeObjet.CRACKED_DIAMOND, "billy the kid 94");
        vendre(TypeObjet._17CARAT_DIAMOND, "billy the kid 94");
        vendre(TypeObjet.GOLD, "billy the kid 94");
        vendre(TypeObjet.FINE_GRIT, "billy the kid 94");
        vendre(TypeObjet.FINE_GRIT, "Gary");
    }

    public static void vendre(TypeObjet objet, String nom) {
        nom = nettoyerNom(nom);
        if (garyBug(nom)) {
            return;
        }

        int zeny = determinerZeny(objet);
        traiterPrix(zeny, nom);
    }

    private static int determinerZeny(TypeObjet objet) {
        return objet.prix;
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

    public enum TypeObjet {
        JELLOPY(3, "Jellopy"),
        OPAL(3000, "Opal"),
        _3CARAT_DIAMOND(27500, "3carat Diamond"),
        GARLET(20, "Garlet"),
        SCELL(80, "Scell"),
        ZARGON(240, "Zargon"),
        AQUAMARINE(3000, "Aquamarine"),
        AMETHYST(3000, "Amethyst"),
        ZIRCON(3000, "Zircon"),
        _1CARAT_DIAMOND(5000, "1carat Diamond"),
        _2CARAT_DIAMOND(12500, "2carat Diamond"),
        PEARL(3000, "Pearl"),
        EMERALD(3000, "Emerald"),
        GRIT(153, "Grit"),
        RUBY(3000, "Ruby"),
        CURSED_RUBY(300, "Cursed Ruby"),
        CRACKED_DIAMOND(5, "Cracked Diamond"),
        _17CARAT_DIAMOND(3000000, "17carat Diamond"),
        GOLD(75000, "Gold"),
        FINE_GRIT(60, "Fine grit");

        public final int prix;
        public final String libelle;

        TypeObjet(int prix, String libelle) {
            this.prix = prix;
            this.libelle = libelle;
        }
    }
}
