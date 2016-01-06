
public class Holz implements Materialplan {

    private final int kubik;

    public Holz(int kubik){
        this.kubik = kubik;
    }

    @Override
    public int getMaterial() {
        return kubik;
    }
}