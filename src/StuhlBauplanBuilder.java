/**
 * Created by Moritz on 21.12.2015.
 */
public class StuhlBauplanBuilder extends BauplanBuilder {

    public StuhlBauplanBuilder(){
        addBauteil(new Bauteil("Stuhlsitz", new Holz(20)));
    }

    public Bauplan create(){
        return super.create();
    }

}
