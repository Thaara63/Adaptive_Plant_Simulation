package planet;

import java.util.HashMap;
import static planet.Radiation.ALPHA;
import static planet.Radiation.DELTA;
import static planet.Radiation.NO_RADIATION;


public class Parabush extends Plant {
    
    public Parabush(String name, int nutrients){
        super(name,nutrients);
    }
    

    @Override
    protected  void reactionToRadiation(Radiation r) {
        if(r == null ){
            System.out.println("null value for radiation");
        }
        else switch (r) {
            case ALPHA:
                nutrients += 1;
                break;
            case DELTA:
                nutrients += 1;
                break;
            case NO_RADIATION:
                nutrients -= 1;
                break;
        }
    }

    @Override
    protected HashMap<Radiation,Integer> radiationNeed() {
        HashMap<Radiation,Integer> radiationDemand = new HashMap<>();
//        radiationDemand.put(,0);
        return radiationDemand;
    }
}
