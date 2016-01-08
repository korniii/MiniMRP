import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moritz on 20.12.2015.
 */


public class BauplanBuilder {

        private String name;
        private final List<Materialplan> bauteile = new ArrayList<Materialplan>();

        public BauplanBuilder() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addBauteil(Bauteil bauteil) {
            this.bauteile.add(bauteil);
        }

        public Bauplan create() {
            for(Listener listener : listeners){
                listener.bauplanToListener(new Bauplan(name, bauteile));
            }
            return new Bauplan(name, bauteile);
        }

    //Observeranbau
    private final List<Listener> listeners = new ArrayList<Listener>();

    public void addListener( Listener listener ) {
        this.listeners.add( listener );
    }

    public void removeListener( Listener listener ) {
        this.listeners.remove( listener );
    }

    public interface Listener {

        void bauplanToListener(Bauplan bauplan);

    }


}



