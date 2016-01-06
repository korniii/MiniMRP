/**
 * Created by Moritz on 18.12.2015.
 */
public class EinkaufListener implements HolzLager.Listener {

    private Holz Gesamtbedarf = new Holz(0);

    @Override
    public void getMaterialbedarf(Bauplan bauplan, int Bedarf, int nichtFertigbar) {
        if(Bedarf == 0){
            System.out.println("Kein Einkauf nötig");
        }
        else{
            System.out.println("Es werden "+Bedarf+" weitere Einheiten für die Fertigstellung des Aufrags benötigt");
            updateEinkaufsmenge(Bedarf);
            System.out.println("Insgesamt wird eine Bestellmenge von "+getEinkaufsmenge()+" Einheiten benötigt.");
        }
    }

    @Override
    public void updateLagerbestand(int Einheiten) {
        System.out.println("Neuer Lagerbestand sind "+Einheiten+" Einheiten.");
        if(Gesamtbedarf.getMaterial() <= Einheiten) Gesamtbedarf = new Holz(0);
        else Gesamtbedarf = new Holz(Gesamtbedarf.getMaterial() - Einheiten);
    }


    private void updateEinkaufsmenge(int Bedarf){
        Gesamtbedarf = new Holz(Gesamtbedarf.getMaterial()+ Bedarf);
    }

    public int getEinkaufsmenge(){
        return Gesamtbedarf.getMaterial();
    }

}
