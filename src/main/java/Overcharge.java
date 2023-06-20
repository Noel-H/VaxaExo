public enum Overcharge {
    NIVEAU_0(0,0),
    NIVEAU_1(7,1),
    NIVEAU_2(9,2),
    NIVEAU_3(11,3),
    NIVEAU_4(13,4),
    NIVEAU_5(15,5),
    NIVEAU_6(17,6),
    NIVEAU_7(19,7),
    NIVEAU_8(21,8),
    NIVEAU_9(23,9),
    NIVEAU_10(24,10);

    public final int taux;
    public final int niveau;

    Overcharge(int taux, int niveau) {
        this.taux = taux;
        this.niveau = niveau;
    }

    public static Overcharge fromNiveau(int niveau) {
        for (Overcharge elem : Overcharge.values()) {
            if (elem.niveau == niveau) {
                return elem;
            }
        }
        return Overcharge.NIVEAU_0;
    }
}
