package planet;

import java.util.HashMap;
import static planet.Radiation.ALPHA;
import static planet.Radiation.DELTA;
import static planet.Radiation.NO_RADIATION;


public class Deltatree extends Plant {
    
    public Deltatree(String name, int nutrients, String type){
        super(name,nutrients,"d");
    }
    

    @Override
    protected  void reactionToRadiation(Radiation r) {
        if(r == null ){
            System.out.println("null value for radiation"); //prob. need an exception
        }
        else switch (r) {
            case ALPHA:
                nutrients -=3 ;
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
    protected HashMap<Radiation,Integer> radiationNeed(Radiation r) {
        HashMap<Radiation,Integer> radiationDemand = new HashMap<>();
        int demand = 0;
        if(r == DELTA){
            if(nutrients < 5){
                demand += 4 ;
                radiationDemand.put(r,demand);
            }
            else if(nutrients >= 5 && nutrients <= 10){
                demand += 1 ;
                radiationDemand.put(r,demand);
            }    
        }else{
            radiationDemand.put(r,demand);
        }
        
        return radiationDemand;
    }
}
