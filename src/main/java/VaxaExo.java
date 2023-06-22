import java.util.Arrays;

public class VaxaExo {
    public static void main(String[] args) {
        Foret foret = new Foret();
        Gary gary = new Gary();
        Soigneur healer = new Soigneur();
        Joueur zanmato = new Joueur("Zanmato");
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");

        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
    }
}
