/**
 * Created by Moritz on 06.01.2016.
 */
public class MaterialbedarfListener implements BauplanBuilder.Listener {
    @Override
    public void bauplanToListener(Bauplan bauplan) {

        System.out.println("\nMaterialbedarf gesamt:"+bauplan.getMaterial());
        System.out.println();

    }
}
