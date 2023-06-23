public enum SkillOvercharge {
    NIVEAU_0(0,0),
    NIVEAU_1(1,7),
    NIVEAU_2(2,9),
    NIVEAU_3(3,11),
    NIVEAU_4(4,13),
    NIVEAU_5(5,15),
    NIVEAU_6(6,17),
    NIVEAU_7(7,19),
    NIVEAU_8(8,21),
    NIVEAU_9(9,23),
    NIVEAU_10(10,24);

    public final int niveau;
    public final int taux;

    SkillOvercharge(int niveau, int taux) {
        this.niveau = niveau;
        this.taux = taux;
    }

    public static SkillOvercharge fromNiveau(int niveau) {
        for (SkillOvercharge element : SkillOvercharge.values()) {
            if (element.niveau == niveau) {
                return element;
            }
        }
        return NIVEAU_0;
    }
}
