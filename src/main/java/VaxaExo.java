import java.util.Arrays;

public class VaxaExo {
    public static void main(String[] args) {
        Gary gary = new Gary();

        Joueur joueur1 = new Joueur("Billy");

        System.out.println(joueur1.getNom() + " est vivant ? " + joueur1.estVivant());
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z");
        System.out.println(joueur1.getNom() + " ramasse des objets");
        joueur1.ramasser(Arrays.asList(TypeObjet._17CARAT_DIAMOND));
        gary.vendreTout(joueur1);
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z");


        System.out.println();

        joueur1.recevoirDegats(29);
        System.out.println(joueur1.getNom() + " est vivant ? " + joueur1.estVivant());
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z");
        System.out.println(joueur1.getNom() + " ramasse des objets");
        joueur1.ramasser(Arrays.asList(TypeObjet._17CARAT_DIAMOND, TypeObjet._17CARAT_DIAMOND));
        gary.vendreTout(joueur1);
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z");

        System.out.println();

        joueur1.recevoirDegats(29);
        System.out.println(joueur1.getNom() + " est vivant ? " + joueur1.estVivant());
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z");
        System.out.println(joueur1.getNom() + " ramasse des objets");
        joueur1.ramasser(Arrays.asList(TypeObjet._17CARAT_DIAMOND, TypeObjet._17CARAT_DIAMOND, TypeObjet._17CARAT_DIAMOND, TypeObjet._17CARAT_DIAMOND, TypeObjet._17CARAT_DIAMOND));
        gary.vendreTout(joueur1);
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z");

        System.out.println();
    }
}
