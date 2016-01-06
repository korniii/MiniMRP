import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 13.12.2015.
 */
public class HolzLager {

    final private List<Holz> Bestand = new ArrayList<Holz>();

    public HolzLager(){

    }

    //Anzahl der HolzPakete im Lager (Inhalt der Pakete kann variieren z.B. durch herausnahme)
    public int getAnzahlHolzpakete(){
        return Bestand.size();
    }

    //Hinzufügen eines HolzPakets zum Lager
    public void addHolzpaket(Holz neuerBaum){
        Bestand.add(neuerBaum);
        for(Listener listener : listeners){
            listener.updateLagerbestand(getLagerBestand());
        }
    }

    //Anzahl verwertbarer Einheiten in den Paketen im Holzlager
    public int getLagerBestand(){
        int Lagerbestand = 0;
        for(final Holz holzMenge: Bestand){
            Lagerbestand += holzMenge.getMaterial();
        }
        return Lagerbestand;
    }

    //heraussnehmen von Einheiten aus den Paketen, private da nur für Bestellung verwendet und Observer immmer angesprochen werden sollen
    private void subBestand(int HolzMenge){

        if(getLagerBestand() > 0){

            while (HolzMenge >= Bestand.get(Bestand.size() - 1).getMaterial()) {
                HolzMenge = HolzMenge - Bestand.get(Bestand.size() - 1).getMaterial();
                Bestand.remove(Bestand.size() - 1);
            }

            if (HolzMenge > 0) {
                int HolzPlatzhalter = Bestand.get(Bestand.size() - 1).getMaterial() - HolzMenge;
                Bestand.remove(Bestand.size() - 1);
                Bestand.add(new Holz(HolzPlatzhalter));
            }
        }
    }


    public void runBestellung(Bauplan bauplan, int Anzahl){
        int gesamtBedarf = bauplan.getMaterial()*Anzahl;
        int nichtFertigbar = 0;
        if(gesamtBedarf <= getLagerBestand()){
            subBestand(gesamtBedarf);
            System.out.println(gesamtBedarf+" Einheiten aus dem Lager entfernt.");
            for ( Listener listener : listeners ) {
                listener.getMaterialbedarf(bauplan, 0, nichtFertigbar);
            }
            System.out.println(getLagerBestand()+" Einheiten im Lager.");
        }
        else{
            nichtFertigbar =  (int)Math.floor((gesamtBedarf-getLagerBestand())/bauplan.getMaterial());
            for ( Listener listener :listeners ){
                listener.getMaterialbedarf(bauplan, (gesamtBedarf-getLagerBestand()), nichtFertigbar);
            }
            if(getLagerBestand() > 0) Bestand.clear();
        }

        System.out.println(nichtFertigbar+"....................");

    }


    //Observeranbau
    private final List<Listener> listeners = new ArrayList<Listener>();

    public void addListener( Listener listener ) {
        this.listeners.add( listener );
    }

    public void removeListener( Listener listener ) {
        this.listeners.remove( listener );
    }

    public interface Listener {

        void getMaterialbedarf(Bauplan bauplan, int Bedarf, int nichtFertigbar);

        void updateLagerbestand(int Einheiten);

    }



}
