import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 13.12.2015.
 */
public class Bauteil implements Materialplan {

    private final Holz Ersatzteile;
    private final String name;

    public Bauteil(String name, Holz Ersatzteile){
        this.name = name;
        this.Ersatzteile = Ersatzteile;
    }

    final private List<Materialplan> children = new ArrayList<Materialplan>(10);

    public void add(final Materialplan component) {
        children.add(component);
    }

    public void remove(final Materialplan component) {
        children.remove(component);
    }

    @Override
    public int getMaterial() {
        int Holzbedarf = 0;
        int Number = 0;


        for (final Materialplan bauteil : children) {
            Holzbedarf += bauteil.getMaterial();
            Number++;
            System.out.println(name+Number);
        }

        //System.out.println(getClass().getName()+": benötigt "+Holzbedarf+" Einheiten Holz");
        //System.out.println("Benötige Einheiten Ersatzteile: "+Ersatzteile.getMaterial());
        Holzbedarf = Holzbedarf + Ersatzteile.getMaterial(); // Ersatzteile

        return Holzbedarf;
    }

}
