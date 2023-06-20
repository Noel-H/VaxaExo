import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gary {

    public int vendre(List<TypeObjet> objets, Joueur joueur) {
        String nom = nettoyerNom(joueur.getNom());
        if (garyBug(nom)) {
            return 0;
        }

        int zeny = determinerZeny(objets, joueur.getNiveauOvercharge());
        traiterPrix(zeny, nom);
        return zeny;
    }

    private int determinerZeny(List<TypeObjet> objets, int niveauOvercharge) {
//        int sommeTotal = objets.stream().mapToInt(value -> value.prix).sum();
        int sommeTotal = 0;
        for (TypeObjet objet : objets) {
            sommeTotal = sommeTotal + objet.prix;
        }
        return sommeTotal + calculerGainOvercharge(sommeTotal, niveauOvercharge);
    }

    private int calculerGainOvercharge(int sommeTotal, int niveauOvercharge) {
        int taux = Overcharge.fromNiveau(niveauOvercharge).taux;
        return sommeTotal * taux / 100;
    }

    private boolean garyBug(String nom) {
        if (nom.equals("Gary")) {
            System.out.println("Boum !");
            return true;
        }
        return false;
    }

    private void traiterPrix(int zeny, String nom) {
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

    private void garyParle(String s) {
        System.out.println("Gary : " + s);
    }

    private void traiterPrixInferieur0() {
        garyParle("Je n'accepte pas cet objet.");
    }

    private void traiterPrixEgal0() {
        garyParle("...");
    }

    private void traiterPrixEgal1() {
        garyParle("Voilà ton zeny, du balai !");
    }

    private void traiterPrixInferieurEgal1000(int zeny, String nom) {
        garyParle("Voilà vos " + zeny + "z, " + nom);
    }

    private void traiterPrixInferieurEgal100000(int zeny, String nom) {
        garyParle("Voilà voz " + zeny + "z, cher " + nom + ". Au plaisir de vous revoir bientôt !");
    }

    private void traiterPrixSuperieur100000(int zeny, String nom) {
        String message = "Voilà vos " + zeny + "z, Maître " + nom + ". Laissez moi vous remercier à la hauteur de votre statut :";
        int nbMerci = zeny / 100000;
        for (int i = 0; i < nbMerci; i++) {
            message += " Merci";
        }
        message += " !";
        garyParle(message);
    }

    private String nettoyerNom(String raw) {
        String strClean = raw.replaceAll("[^A-Za-z -]", "")
                .replaceAll("^[- ]*", "")
                .replaceAll("[- ]*$", "")
                .replaceAll("[-]{2,}", "-")
                .replaceAll("[ -]{2,}", " ")
                .toLowerCase();
        return mettreEnMajuscule(strClean);
    }

    private String mettreEnMajuscule(String strClean) {
        return Arrays.stream(strClean.split("((?=[ -])|(?<=[ -]))"))
                .map(s -> s.matches("^[a-z]+$") ? s.substring(0, 1).toUpperCase() + s.substring(1) : s)
                .collect(Collectors.joining());
    }

}
