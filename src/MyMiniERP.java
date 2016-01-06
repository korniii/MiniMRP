import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 20.12.2015.
 */
public class MyMiniERP {

    public static void main(String[]args) throws IOException {

        Bauteil Stuhlbein = new Bauteil("Stuhlbein", new Holz(5));
        Bauteil Stuhlsitz = new Bauteil("Stuhlsitz", new Holz(20));
        Bauteil Tischbein = new Bauteil("Tischbein", new Holz(10));
        Bauteil Tischsitz = new Bauteil("Tischsitz", new Holz(40));

        List<Materialplan> basisTeile = new ArrayList<Materialplan>();
        basisTeile.add(Stuhlsitz);

        Bauplan stuhlBauplan = new Bauplan("Stuhl", basisTeile);

        HolzLager Lager = new HolzLager();

        EinkaufListener einkaufListener = new EinkaufListener();
        FertigungListener fertigungListener = new FertigungListener();

        Lager.addListener(einkaufListener);
        Lager.addListener(fertigungListener);

        Lager.addHolzpaket(new Holz(60));

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {

            int eingabe = Integer.parseInt(br.readLine());
            switch (eingabe) {
                case 1:
                    Lager.addHolzpaket(new Holz(100));
                    System.out.println(Lager.getLagerBestand());
                    break;
                case 2:
                    StuhlBauplanBuilder Builder = new StuhlBauplanBuilder();
                    System.out.println("Wieviele Stuhlbeine wollen Sie hinzufügen?");
                    int bauteil = Integer.parseInt(br.readLine());
                    for(int i = 0; i < bauteil; i++){
                        Builder.addBauteil(Stuhlbein);
                    }
                    stuhlBauplan = Builder.create();
                    break;
                case 3:
                    int einheiten = Integer.parseInt(br.readLine());
                    Lager.runBestellung(stuhlBauplan, einheiten);
                break;
                case 4:
                    fertigungListener.getPendingAuftraege();
                break;
                case 5:
                    System.out.println(einkaufListener.getEinkaufsmenge()+" Einheiten müssen für die vorhanden Aufträge eingekauft werden.");
                break;
            }
        }




    }
}
