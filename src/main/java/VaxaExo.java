import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VaxaExo {
    public static void main(String[] args) {
        vendre(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.AMETHYST, TypeObjet._3CARAT_DIAMOND), "billy the kid 94");
        vendre(Arrays.asList(TypeObjet.CURSED_RUBY, TypeObjet.OPAL, TypeObjet.FINE_GRIT), "billy the kid 94");
        vendre(Arrays.asList(TypeObjet.ZARGON, TypeObjet.EMERALD, TypeObjet.GARLET), "billy the kid 94");
        vendre(Arrays.asList(TypeObjet.CRACKED_DIAMOND, TypeObjet.CRACKED_DIAMOND, TypeObjet.CRACKED_DIAMOND, TypeObjet.CRACKED_DIAMOND), "billy the kid 94");
        vendre(Arrays.asList(), "billy the kid 94");
    }

    public static void vendre(List<TypeObjet> objets, String nom) {
        nom = nettoyerNom(nom);
        if (garyBug(nom)) {
            return;
        }

        int zeny = determinerZeny(objets);
        traiterPrix(zeny, nom);
    }

    private static int determinerZeny(List<TypeObjet> objets) {
        return objets.stream().mapToInt(value -> value.prix).sum();
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
