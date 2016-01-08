
public class Holz implements Materialplan {

    private final int kubik;
    private final String name;

    public Holz(String name, int kubik){
        this.name = name;
        this.kubik = kubik;
    }

    @Override
    public int getMaterial() {
        return kubik;
    }

    public String getName(){
        return name;
    }
}