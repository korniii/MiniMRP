/**
 * Created by Moritz on 20.12.2015.
 */
public class Auftrag {

    private final Bauplan bauplan;
    private final int Anzahl;

    public Auftrag(Bauplan bauplan, int Anzahl){

        this.bauplan = bauplan;
        this.Anzahl = Anzahl;
    }

    public Bauplan getBauplan(){
        return bauplan;
    }

    public int getAnzahl(){
        return Anzahl;
    }


}
