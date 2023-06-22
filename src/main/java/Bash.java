public enum Bash {
    LEVEL_0(0, 0.0),
    LEVEL_1(1, 1.2),
    LEVEL_2(2, 1.4),
    LEVEL_3(3, 1.6),
    LEVEL_4(4, 1.8),
    LEVEL_5(5, 2.0),
    LEVEL_6(6, 2.2),
    LEVEL_7(7, 2.4),
    LEVEL_8(8, 2.6),
    LEVEL_9(9, 2.8),
    LEVEL_10(10, 3.0);

    public final int level;
    public final double damageMultiplier;

    Bash(int level, double damageMultiplier) {
        this.level = level;
        this.damageMultiplier = damageMultiplier;
    }
}
