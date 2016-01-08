import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Moritz on 06.01.2016.
 */
public class MyMiniERP {

    public static void main(String[]args) throws IOException {

        Holz bigBlock = new Holz("BigBlock", 20);

        Bauteil Stuhlbein = new Bauteil("Stuhlbein");
        Bauteil Stuhlsitz = new Bauteil("Stuhlsitz");

        Stuhlbein.add(bigBlock);
        Stuhlsitz.add(bigBlock);

        BauplanBuilder normalBuilder = new BauplanBuilder();
        normalBuilder.setName("Stuhl");
        BauplanDatabaseListener databaseListener = new BauplanDatabaseListener();
        MaterialbedarfListener materialbedarfListener = new MaterialbedarfListener();

        normalBuilder.addListener(databaseListener);
        normalBuilder.addListener(materialbedarfListener);

        StuhlBauplanBuilder stuhlBuilder = new StuhlBauplanBuilder();
        stuhlBuilder.addListener(databaseListener);
        stuhlBuilder.addListener(materialbedarfListener);


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);


        while(true){

            int eingabe = Integer.parseInt(buffer.readLine());
            switch(eingabe){
                case 1:
                    normalBuilder.addBauteil(Stuhlbein);
                    System.out.println("Stuhlbein hinzugefügt.");
                    break;
                case 2:
                    normalBuilder.create();
                    break;
                case 3:
                    stuhlBuilder.addBauteil(Stuhlbein);
                    System.out.println("Stuhlbein hinzugefügt.");
                    break;
                case 4: stuhlBuilder.create();
                    break;
                case 5:
                    databaseListener.getArchivSize();
            }

        }



    }

}
