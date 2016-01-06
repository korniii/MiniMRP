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
            return new Bauplan(name, bauteile);
        }

}



