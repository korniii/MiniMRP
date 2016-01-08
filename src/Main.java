/**
 * Created by Moritz on 06.01.2016.
 */
public class Main {

    public static void main (String[]args){

        BauplanBuilder bauplanBuilder = new BauplanBuilder();
        BauplanDatabaseListener databaseListener = new BauplanDatabaseListener();
        MaterialbedarfListener materialbedarfListener = new MaterialbedarfListener();

        bauplanBuilder.addListener(databaseListener);
        bauplanBuilder.addListener(materialbedarfListener);


        Bauteil stuhlBein = new Bauteil("Stuhlbein");
        Bauteil stuhlSitz = new Bauteil("Stuhlsitz");

        Holz bigBlock = new Holz("lala",520);


        bauplanBuilder.setName("Stuhl");
        stuhlBein.add(bigBlock);
        stuhlSitz.add(bigBlock);
        bauplanBuilder.addBauteil(stuhlBein);
        bauplanBuilder.addBauteil(stuhlSitz);

        Bauplan testBauplan = bauplanBuilder.create();



        StuhlBauplanBuilder s1 = new StuhlBauplanBuilder();
        s1.addListener(databaseListener);
        s1.addListener(materialbedarfListener);

        s1.create();

        databaseListener.getArchivSize();
        System.out.println(databaseListener.getBauplan(0).getName());



    }

}
