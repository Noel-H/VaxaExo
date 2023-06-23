public enum Job {
    NOVICE("Novice", 8, 30),
    EPEISTE("Épéiste", 12, 60),
    MARCHAND("Marchand", 10, 45);

    public final String libelle;
    public final int baseAtk;
    public final int basePvMax;

    Job(String libelle, int baseAtk, int basePvMax) {
        this.libelle = libelle;
        this.baseAtk = baseAtk;
        this.basePvMax = basePvMax;
    }
}
