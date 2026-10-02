package planet;

import java.util.HashMap;
import static planet.Radiation.ALPHA;
import static planet.Radiation.DELTA;
import static planet.Radiation.NO_RADIATION;


public class Deltatree extends Plant {
    
    public Deltatree(String name, int nutrients){
        super(name,nutrients);
    }
    

    @Override
    protected  void reactionToRadiation(Radiation r) {
        if(r == null ){
            System.out.println("null value for radiation"); //prob. need an exception
        }
        else switch (r) {
            case ALPHA:
                nutrients -=3;
                break;
            case DELTA:
                nutrients += 4;
                break;
            case NO_RADIATION:
                nutrients -= 1;
                break;
        }
    }

    @Override
    protected HashMap<Radiation,Integer> radiationNeed() {
        HashMap<Radiation,Integer> radiationDemand = new HashMap<>();
        int demand = 0;
        if(living){
            if(nutrients < 5){
                demand += 4 ;
                radiationDemand.put(DELTA,demand);
                }
            else if(nutrients >= 5 && nutrients <= 10){
                demand += 1 ;
                radiationDemand.put(DELTA,demand);
            }            
        }
        else{
            radiationDemand.put(DELTA,demand);
        }
 
        return radiationDemand;
    }
}
