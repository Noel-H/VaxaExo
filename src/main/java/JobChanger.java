public class JobChanger {
    public void promotion(Joueur joueur, Job job) {
        if (joueur.getNiveau() < 10) {
            System.out.println("C’est pas une garderie ici !");
            return;
        }
        if (joueur.getJob() == Job.NOVICE) {
            System.out.println("Tu es déjà novice");
            return;

        }
        if (joueur.getJob() != Job.NOVICE) {
            System.out.println("Tu as déjà un job");
            return;

        }
        if (!joueur.payer(300)) {
            System.out.println("Tu es fauché, va farmer !");
            return;
        }
        joueur.changerDeClasse(job);
    }
}
