import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 06.01.2016.
 */
public class BauplanDatabaseListener implements BauplanBuilder.Listener {

    private final List<Bauplan> bauplanArchiv = new ArrayList<Bauplan>();

    @Override
    public void bauplanToListener(Bauplan bauplan) {

        bauplanArchiv.add(bauplan);
        System.out.println(bauplan.getName()+" wurde in der Datenbank gespeichert.");
    }

    public void getArchivSize(){
        System.out.println(bauplanArchiv.size());
    }

    public Bauplan getBauplan(int i){
        return bauplanArchiv.get(i);
    }

}