public class Poring extends Personnage {

    private int valeurExp;

    Poring() {
        super("Poring", 50, 3);
        this.valeurExp = 100 * 100;  // Changer les rates à *100
        this.inventaire.add(TypeObjet.EMPTY_BOTTLE);
        this.inventaire.add(TypeObjet.STICKY_MUCUS);
        this.inventaire.add(TypeObjet.JELLOPY);
    }

    @Override
    public void comportementVictoire(Personnage personnage) {
        depouiller(personnage);
    }

    public int getValeurExp() {
        return valeurExp;
    }
}