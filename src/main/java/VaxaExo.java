import java.util.Arrays;

public class VaxaExo {
    public static void main(String[] args) {
        Foret foret = new Foret();
        Gary gary = new Gary();
        Soigneur healer = new Soigneur();
        Joueur zanmato = new Joueur("Zanmato");
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");


        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");


        System.out.println();
        zanmato.ramasser(Arrays.asList(TypeObjet._17CARAT_DIAMOND));

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
    }
}
