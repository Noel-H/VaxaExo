public class Poring extends Personnage{

    Poring() {
        super("Poring", 50, 3);
        this.inventaire.add(TypeObjet.EMPTY_BOTTLE);
        this.inventaire.add(TypeObjet.STICKY_MUCUS);
        this.inventaire.add(TypeObjet.JELLOPY);
    }
}
