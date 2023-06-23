import java.util.Arrays;

public class Poring extends Personnage {
    private MonstreInfo dataMonstre;

    public Poring() {
        super();
        this.data = new MonstreInfo(
                "Poring",
                50,
                50,
                3,
                true,
                Arrays.asList(TypeObjet.EMPTY_BOTTLE, TypeObjet.STICKY_MUCUS, TypeObjet.JELLOPY),
                100 * 100);
        this.dataMonstre = (MonstreInfo) this.data;
    }
    @Override
    public void comportementVictoire(Personnage personnage) {
        depouiller(personnage);
    }

    public int getValeurExp() {
        return this.dataMonstre.getValeurExp();
    }
}