public enum NiveauExperience {
    LEVEL_1(1, 0),
    LEVEL_2(2, 548),
    LEVEL_3(3, 1442),
    LEVEL_4(4, 2928),
    LEVEL_5(5, 5101),
    LEVEL_6(6, 8253),
    LEVEL_7(7, 11985),
    LEVEL_8(8, 16097),
    LEVEL_9(9, 20538),
    LEVEL_10(10, 25404),
    LEVEL_11(11, 30741),
    LEVEL_12(12, 36545),
    LEVEL_13(13, 42428),
    LEVEL_14(14, 48534),
    LEVEL_15(15, 54958),
    LEVEL_16(16, 61984),
    LEVEL_17(17, 69608),
    LEVEL_18(18, 77589),
    LEVEL_19(19, 85925),
    LEVEL_20(20, 94614),
    LEVEL_21(21, 103748),
    LEVEL_22(22, 113418),
    LEVEL_23(23, 123714),
    LEVEL_24(24, 134726),
    LEVEL_25(25, 146821),
    LEVEL_26(26, 159807),
    LEVEL_27(27, 173679),
    LEVEL_28(28, 188432),
    LEVEL_29(29, 204060),
    LEVEL_30(30, 220558);

    public final int level;
    public final int experiencePoints;

    NiveauExperience(int level, int experiencePoints) {
        this.level = level;
        this.experiencePoints = experiencePoints;
    }

    public static NiveauExperience fromExperience(int exp) {
        NiveauExperience niveau = NiveauExperience.LEVEL_1;
        for (NiveauExperience element : NiveauExperience.values()) {
            if (exp < element.experiencePoints) {
                return niveau;
            }
            niveau = element;
        }
        return niveau;
    }
}