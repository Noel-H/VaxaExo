import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VaxaExo {
    public static void main(String[] args) {
        Joueur joueur1 = new Joueur("Billy");
        Joueur joueur2 = new Joueur("Patrick");
        joueur2.setNiveauOvercharge(2);
        Joueur joueur3 = new Joueur("Erica");
        joueur3.setNiveauOvercharge(6);
        Joueur joueur4 = new Joueur("Gary");
        joueur4.setNiveauOvercharge(10);
        Joueur joueur5 = new Joueur(" -[ --_JeAn-MiCHeL!:-. ");
        joueur5.setNiveauOvercharge(1);
        Joueur joueur6 = new Joueur();
        joueur6.setNom("Daouda");
        joueur6.setNiveauOvercharge(6);
        Joueur joueur7 = new Joueur();
        joueur7.setNiveauOvercharge(7);
        Joueur joueur8 = new Joueur("");
        joueur8.setNiveauOvercharge(8);


        vendre(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.AMETHYST, TypeObjet._3CARAT_DIAMOND), joueur1);
        vendre(Arrays.asList(TypeObjet.CURSED_RUBY, TypeObjet.OPAL, TypeObjet.FINE_GRIT), joueur2);
        vendre(Arrays.asList(TypeObjet.ZARGON, TypeObjet._17CARAT_DIAMOND, TypeObjet.GARLET), joueur3);
        vendre(Arrays.asList(TypeObjet._1CARAT_DIAMOND, TypeObjet.CRACKED_DIAMOND, TypeObjet.CURSED_RUBY), joueur4);
        vendre(Arrays.asList(TypeObjet.ZARGON, TypeObjet.FINE_GRIT, TypeObjet.AQUAMARINE), joueur5);
        vendre(Arrays.asList(TypeObjet.EMERALD, TypeObjet.JELLOPY, TypeObjet.GOLD), joueur6);
        vendre(Arrays.asList(TypeObjet.AMETHYST, TypeObjet.ZIRCON, TypeObjet.PEARL), joueur7);
        vendre(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.SCELL, TypeObjet.CRACKED_DIAMOND), joueur8);
    }

    public static void vendre(List<TypeObjet> objets, Joueur joueur) {
        String nom = nettoyerNom(joueur.getNom());
        if (garyBug(nom)) {
            return;
        }

        int zeny = determinerZeny(objets, joueur.getNiveauOvercharge());
        traiterPrix(zeny, nom);
    }

    private static int determinerZeny(List<TypeObjet> objets, int niveauOvercharge) {
//        int sommeTotal = objets.stream().mapToInt(value -> value.prix).sum();
        int sommeTotal = 0;
        for (TypeObjet objet : objets) {
            sommeTotal = sommeTotal + objet.prix;
        }
        return sommeTotal + calculerGainOvercharge(sommeTotal, niveauOvercharge);
    }

    private static int calculerGainOvercharge(int sommeTotal, int niveauOvercharge) {
        int taux = Overcharge.fromNiveau(niveauOvercharge).taux;
        return sommeTotal * taux / 100;
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
