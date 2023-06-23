public enum SkillBash {
    NIVEAU_0(0, 0),
    NIVEAU_1(1, 1.2),
    NIVEAU_2(2, 1.4),
    NIVEAU_3(3, 1.6),
    NIVEAU_4(4, 1.8),
    NIVEAU_5(5, 2),
    NIVEAU_6(6, 2.2),
    NIVEAU_7(7, 2.4),
    NIVEAU_8(8, 2.6),
    NIVEAU_9(9, 2.8),
    NIVEAU_10(10, 3);

    public int niveau;
    public double multiplicateur;

    SkillBash(int niveau, double multiplicateur) {
        this.niveau = niveau;
        this.multiplicateur = multiplicateur;
    }

    public static SkillBash fromNiveau(int niveau) {
        for (SkillBash element : SkillBash.values()) {
            if (element.niveau == niveau) {
                return element;
            }
        }
        return NIVEAU_0;
    }
}
