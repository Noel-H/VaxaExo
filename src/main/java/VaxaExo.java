import java.util.Arrays;

public class VaxaExo {
    public static void main(String[] args) {
        Gary gary = new Gary();

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

        gary.vendre(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.AMETHYST, TypeObjet._3CARAT_DIAMOND), joueur1);
        gary.vendre(Arrays.asList(TypeObjet.CURSED_RUBY, TypeObjet.OPAL, TypeObjet.FINE_GRIT), joueur2);
        gary.vendre(Arrays.asList(TypeObjet.ZARGON, TypeObjet._17CARAT_DIAMOND, TypeObjet.GARLET), joueur3);
        gary.vendre(Arrays.asList(TypeObjet._1CARAT_DIAMOND, TypeObjet.CRACKED_DIAMOND, TypeObjet.CURSED_RUBY), joueur4);
        gary.vendre(Arrays.asList(TypeObjet.ZARGON, TypeObjet.FINE_GRIT, TypeObjet.AQUAMARINE), joueur5);
        gary.vendre(Arrays.asList(TypeObjet.EMERALD, TypeObjet.JELLOPY, TypeObjet.GOLD), joueur6);
        gary.vendre(Arrays.asList(TypeObjet.AMETHYST, TypeObjet.ZIRCON, TypeObjet.PEARL), joueur7);
        gary.vendre(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.SCELL, TypeObjet.CRACKED_DIAMOND), joueur8);
    }
}
