import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 18.12.2015.
 */
public class FertigungListener implements HolzLager.Listener {

    final private List<Auftrag> auftraege = new ArrayList<Auftrag>();

    @Override
    public void getMaterialbedarf(Bauplan bauplan, int Bedarf, int nichtFertigbar) {
        if(Bedarf == 0){
            System.out.println("Alles kann gefertigt werden.");
        }
        else{
            System.out.println("Mit dem aktuellen Lagerbestand können nicht alle bestellten Produkte gefertigt werden.");
            auftraege.add(new Auftrag(bauplan, nichtFertigbar));
        }

    }

    @Override
    public void updateLagerbestand(int Einheiten) {
        int auftragsBestand = 0;
        for(final Auftrag auftragsliste : auftraege){
            auftragsBestand += (auftragsliste.getBauplan().getMaterial()*auftragsliste.getAnzahl());
        }
        if(auftragsBestand <= Einheiten) System.out.println("Mit den neunen Beständen können die angehäuften Aufträge gefertigt werden.");
    }

    public void getPendingAuftraege(){
        for (final Auftrag auftragsliste : auftraege) {
            System.out.println(auftragsliste.getBauplan().getName()+" "+auftragsliste.getAnzahl());
        }
    }

}
