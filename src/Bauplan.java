import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 13.12.2015.
 */
public class Bauplan implements Materialplan {

    final private List<Materialplan> children = new ArrayList<Materialplan>();
    private final String name;

    public Bauplan(String name, List<Materialplan> children){
        this.name = name;
        this.children.addAll(children);
    }

    public String getName(){
        return name;
    }

    public void add(final Materialplan component) {
        children.add(component);
    }

    public void remove(final Materialplan component) {
        children.remove(component);
    }


    //Rückgabe der benötigten Einheiten für den Bau eines Produkts
    @Override
    public int getMaterial() {
        int Holzbedarf = 0;

        System.out.println(name+"-Komponenten:");

        for (final Materialplan bauteil : children) {

            Holzbedarf += bauteil.getMaterial();
        }

        //System.out.println("\nMaterialbedarf gesamt:"+Holzbedarf);

        return Holzbedarf;

    }



}
