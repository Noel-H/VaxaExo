import java.util.List;

public class MonstreInfo extends PersonnageInfo {
    private int valeurExp;

    public MonstreInfo(String nom, int pvMax, int pv, int atk, boolean vivant, List<TypeObjet> inventaire, int valeurExp) {
        super(nom, pvMax, pv, atk, vivant, inventaire);
        this.valeurExp = valeurExp;
    }

    public int getValeurExp() {
        return valeurExp;
    }

    public void setValeurExp(int valeurExp) {
        this.valeurExp = valeurExp;
    }

    @Override
    public TypePersonnage getType() {
        return TypePersonnage.MONSTRE;
    }
}
