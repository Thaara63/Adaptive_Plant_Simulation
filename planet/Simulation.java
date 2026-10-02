package planet;

import static planet.Radiation.ALPHA;
import static planet.Radiation.DELTA;
import static planet.Radiation.NO_RADIATION;

public class Simulation {

    //Decides the radiation on the next day
    public Radiation radiationOnNextDay(DataReader data){
        int alphaSum = 0;
        int deltaSum = 0;
        for(Plant p: data.getPlants()){
            if(p.radiationNeed().containsKey(ALPHA)){
                alphaSum += p.radiationNeed().get(ALPHA);
            }
            else if(p.radiationNeed().containsKey(DELTA)){
                deltaSum += p.radiationNeed().get(DELTA);
            }
        }
//        System.out.println("Alpha: " + alphaSum +" | "+"Delta: " + deltaSum);
        if(alphaSum - deltaSum >= 3){
            return ALPHA;
        }
        else if(deltaSum - alphaSum >= 3){
            return DELTA;
        }
        else{
            return NO_RADIATION;
        }
    }
    
}
