public enum Job {
    NOVICE("Novice", 8, 30),
    EPEISTE("Epéiste", 12, 60),
    MARCHAND("Marchand", 10, 45);

    public final String jobName;
    public final int baseAtk;
    public final int basePvMax;

    Job(String jobName, int baseAtk, int basePvMax) {
        this.jobName = jobName;
        this.baseAtk = baseAtk;
        this.basePvMax = basePvMax;
    }
}
