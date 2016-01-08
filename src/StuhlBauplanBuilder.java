/**
 * Created by Moritz on 21.12.2015.
 */
public class StuhlBauplanBuilder extends BauplanBuilder {



    public StuhlBauplanBuilder(){
        Bauteil stuhlSitz = new Bauteil("Stuhlsitz");
        stuhlSitz.add(new Holz("BigBlock", 20));
        addBauteil(stuhlSitz);
    }

    public Bauplan create(){
        return super.create();
    }

}
