public enum NiveauExp {
    NIVEAU_1(1, 0),
    NIVEAU_2(2, 548),
    NIVEAU_3(3, 1442),
    NIVEAU_4(4, 2928),
    NIVEAU_5(5, 5101),
    NIVEAU_6(6, 8253),
    NIVEAU_7(7, 11985),
    NIVEAU_8(8, 16097),
    NIVEAU_9(9, 20538),
    NIVEAU_10(10, 25404),
    NIVEAU_11(11, 30741),
    NIVEAU_12(12, 36545),
    NIVEAU_13(13, 42428),
    NIVEAU_14(14, 48534),
    NIVEAU_15(15, 54958),
    NIVEAU_16(16, 61984),
    NIVEAU_17(17, 69608),
    NIVEAU_18(18, 77589),
    NIVEAU_19(19, 85925),
    NIVEAU_20(20, 94614),
    NIVEAU_21(21, 103748),
    NIVEAU_22(22, 113418),
    NIVEAU_23(23, 123714),
    NIVEAU_24(24, 134726),
    NIVEAU_25(25, 146821),
    NIVEAU_26(26, 159807),
    NIVEAU_27(27, 173679),
    NIVEAU_28(28, 188432),
    NIVEAU_29(29, 204060),
    NIVEAU_30(30, 220558);

    public final int niveau;
    public final int exp;

    NiveauExp(int niveau, int exp) {
        this.niveau = niveau;
        this.exp = exp;
    }

    public static NiveauExp fromExp(int exp) {
        NiveauExp niveauAtteint = NIVEAU_1;
        for (NiveauExp elem : values()) {
            if (exp < elem.exp) {
                return niveauAtteint;
            }
            niveauAtteint = elem;
        }
        return niveauAtteint;
    }
}
