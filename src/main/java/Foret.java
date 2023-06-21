import java.util.ArrayList;
import java.util.List;

public class Foret {
    private List<TypeObjet> objets;

    Foret() {
        objets = new ArrayList<>();
        this.objets.add(TypeObjet.EMPTY_BOTTLE);
        this.objets.add(TypeObjet.STICKY_MUCUS);
        this.objets.add(TypeObjet.JELLOPY);
    }

    public void visiter(Joueur joueur) {
        System.out.println(joueur.getNom() + " visite la forêt");
        joueur.ramasser(objets);
        viderForet();
        renouvellerObjetForet();
    }

    private void renouvellerObjetForet() {
        this.objets.add(TypeObjet.EMPTY_BOTTLE);
        this.objets.add(TypeObjet.STICKY_MUCUS);
        this.objets.add(TypeObjet.JELLOPY);
    }

    private void viderForet() {
        this.objets = new ArrayList<>();
    }
}
