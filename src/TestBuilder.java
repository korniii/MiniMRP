/**
 * Created by Moritz on 20.12.2015.
 */
public class TestBuilder {

public static void main(String[]args){

    BauplanBuilder b1 = new BauplanBuilder();

    Holz ErsatzSteckteile = new Holz(1);

    Bauteil stuhlBein = new Bauteil("Stuhlbein", ErsatzSteckteile);
    Bauteil stuhlSitz = new Bauteil("Stuhlsitz", ErsatzSteckteile);

    Holz mahagoni = new Holz(5);
    Holz eiche = new Holz(10);

    //Bauteile zusammensetzung
    stuhlSitz.add(eiche);

    stuhlBein.add(mahagoni);

    b1.addBauteil(stuhlBein);
    b1.addBauteil(stuhlSitz);

    b1.create().getMaterial();

    b1.addBauteil(stuhlBein);

    b1.setName("Koalatisch");

    Bauplan btest = b1.create();

    //Holzlager
    HolzLager l1 = new HolzLager();

    EinkaufListener e1 = new EinkaufListener();
    FertigungListener f1 = new FertigungListener();

    l1.addListener(e1);
    l1.addListener(f1);

    l1.addHolzpaket(new Holz(20));

    l1.runBestellung(btest,10);
    l1.runBestellung(btest,10);

    f1.getPendingAuftraege();

    System.out.println("-----------------------------");

    l1.addHolzpaket(new Holz(500));

}

}
