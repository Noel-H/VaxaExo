import java.util.Arrays;

public class VaxaExo {
    public static void main(String[] args) {
        // La valeur exp de Poring doit etre à 100 * 100 pour le test
        Foret foret = new Foret();
        Gary gary = new Gary();
        JobChanger jobChanger = new JobChanger();
        Soigneur healer = new Soigneur();
        Joueur zanmato = new Joueur("Zanmato");
        jobChanger.promotion(zanmato, Job.EPEISTE);
        jobChanger.promotion(zanmato, Job.NOVICE);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");

        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        jobChanger.promotion(zanmato, Job.EPEISTE);
        zanmato.ramasser(Arrays.asList(TypeObjet.OPAL));
        gary.vendreTout(zanmato);
        jobChanger.promotion(zanmato, Job.EPEISTE);
        jobChanger.promotion(zanmato, Job.NOVICE);

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");


        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");

        System.out.println();

        System.out.println("-----------------------------------------");
        System.out.println(zanmato.getNom() + " Visite la forêt.");
        System.out.println("-----------------------------------------");
        foret.visiter(zanmato);
//        System.out.println(zanmato.getNom() + " a " + zanmato.exp + " d'experience");
        gary.vendreTout(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
        healer.soigner(zanmato);
        System.out.println(zanmato.getNom() + " possède " + zanmato.consulterArgent() + "z");
    }
}
