package planet;

import java.util.HashMap;
import static planet.Radiation.ALPHA;
import static planet.Radiation.DELTA;
import static planet.Radiation.NO_RADIATION;


public class Puffs extends Plant {
    
    public Puffs(String name, int nutrients){
        super(name,nutrients);
    }
    
    @Override
    protected boolean livingStatus(){
        if(this.nutrients > 10){
            this.living = false;
        }
        else{
            this.living = true;
        }
        return living;
    }

    @Override
    protected  void reactionToRadiation(Radiation r) {
        if(r == null ){
            System.out.println("null value for radiation");
        }
        else switch (r) {
            case ALPHA:
                nutrients += 2;
                break;
            case DELTA:
                nutrients -= 2;
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
            demand = 10 - nutrients ;
            radiationDemand.put(ALPHA,demand);            
        }
        else{
            radiationDemand.put(ALPHA,demand);            
        }
        return radiationDemand;
    }
}
