import java.util.Arrays;

public class VaxaExo {
    public static void main(String[] args) {
        Gary gary = new Gary();

        Joueur joueur1 = new Joueur("Billy");
        joueur1.ramasser(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.AMETHYST, TypeObjet._3CARAT_DIAMOND));

        Joueur joueur2 = new Joueur("Patrick");
        joueur2.ramasser(Arrays.asList(TypeObjet.CURSED_RUBY, TypeObjet.OPAL, TypeObjet.FINE_GRIT));
        joueur2.setNiveauOvercharge(2);

        Joueur joueur3 = new Joueur("Erica");
        joueur3.ramasser(Arrays.asList(TypeObjet.ZARGON, TypeObjet._17CARAT_DIAMOND, TypeObjet.GARLET));
        joueur3.setNiveauOvercharge(6);

        Joueur joueur4 = new Joueur("Gary");
        joueur4.ramasser(Arrays.asList(TypeObjet._1CARAT_DIAMOND, TypeObjet.CRACKED_DIAMOND, TypeObjet.CURSED_RUBY));
        joueur4.setNiveauOvercharge(10);

        Joueur joueur5 = new Joueur(" -[ --_JeAn-MiCHeL!:-. ");
        joueur5.ramasser(Arrays.asList(TypeObjet.ZARGON, TypeObjet.FINE_GRIT, TypeObjet.AQUAMARINE));
        joueur5.setNiveauOvercharge(1);

        Joueur joueur6 = new Joueur();
        joueur6.setNom("Daouda");
        joueur6.ramasser(Arrays.asList(TypeObjet.EMERALD, TypeObjet.JELLOPY, TypeObjet.GOLD));
        joueur6.setNiveauOvercharge(6);

        Joueur joueur7 = new Joueur();
        joueur7.ramasser(Arrays.asList(TypeObjet.AMETHYST, TypeObjet.ZIRCON, TypeObjet.PEARL));
        joueur7.ramasser(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.SCELL));
        joueur7.ramasser(Arrays.asList(TypeObjet.PEARL));
        joueur7.ramasser(Arrays.asList(TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY, TypeObjet.RUBY));
        joueur7.setNiveauOvercharge(7);

        Joueur joueur8 = new Joueur("");
        joueur8.setNiveauOvercharge(8);

        gary.vendreTout(joueur1);
        joueur1.ramasser(Arrays.asList(TypeObjet.JELLOPY, TypeObjet.AMETHYST, TypeObjet._3CARAT_DIAMOND));
        gary.vendreTout(joueur1);
        gary.vendreTout(joueur2);
        gary.vendreTout(joueur3);
        gary.vendreTout(joueur4);
        gary.vendreTout(joueur5);
        gary.vendreTout(joueur6);
        gary.vendreTout(joueur7);
        gary.vendreTout(joueur8);
        gary.vendreTout(joueur7);

        System.out.println();
        System.out.println(joueur1.getNom() + " possède " + joueur1.consulterArgent() + "z, résulat attendu : 61006z" );
        System.out.println(joueur2.getNom() + " possède " + joueur2.consulterArgent() + "z, résulat attendu : 3662z");
        System.out.println(joueur3.getNom() + " possède " + joueur3.consulterArgent() + "z, résulat attendu : 3510304z");
        System.out.println(joueur4.getNom() + " possède " + joueur4.consulterArgent() + "z, résulat attendu : 0z");
        System.out.println(joueur5.getNom() + " possède " + joueur5.consulterArgent() + "z, résulat attendu : 3531z");
        System.out.println(joueur6.getNom() + " possède " + joueur6.consulterArgent() + "z, résulat attendu : 91263z");
        System.out.println(joueur7.getNom() + " possède " + joueur7.consulterArgent() + "z, résulat attendu : 60788z");
        System.out.println(joueur8.getNom() + " possède " + joueur8.consulterArgent() + "z, résulat attendu : 0z");
    }
}
