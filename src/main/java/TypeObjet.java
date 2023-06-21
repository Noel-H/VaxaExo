public enum TypeObjet {
    JELLOPY(3, "Jellopy"),
    OPAL(3000, "Opal"),
    _3CARAT_DIAMOND(27500, "3carat Diamond"),
    GARLET(20, "Garlet"),
    SCELL(80, "Scell"),
    ZARGON(240, "Zargon"),
    AQUAMARINE(3000, "Aquamarine"),
    AMETHYST(3000, "Amethyst"),
    ZIRCON(3000, "Zircon"),
    _1CARAT_DIAMOND(5000, "1carat Diamond"),
    _2CARAT_DIAMOND(12500, "2carat Diamond"),
    PEARL(3000, "Pearl"),
    EMERALD(3000, "Emerald"),
    GRIT(153, "Grit"),
    RUBY(3000, "Ruby"),
    CURSED_RUBY(300, "Cursed Ruby"),
    CRACKED_DIAMOND(5, "Cracked Diamond"),
    _17CARAT_DIAMOND(3000000, "17carat Diamond"),
    GOLD(75000, "Gold"),
    FINE_GRIT(60, "Fine grit"),
    EMPTY_BOTTLE(3, "Empty Bottle"),
    STICKY_MUCUS(35, "Sticky Mucus");

    public final int prix;
    public final String libelle;

    TypeObjet(int prix, String libelle) {
        this.prix = prix;
        this.libelle = libelle;
    }
}
