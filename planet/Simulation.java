package planet;

import static planet.Radiation.ALPHA;
import static planet.Radiation.DELTA;
import static planet.Radiation.NO_RADIATION;

public class Simulation {
    
    public void simulate(String filename){
        //Getting the data
        DataReader data = new DataReader();
        
        try{
            data.read(filename);            
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        catch (IOException ex) {
            System.out.println("Invalid Input");
        }
        
        //Simulation day one
        System.out.println("Day 1 \nRadiation: NO_RADIATION");
        for(Plant p: data.getPlants()){
            p.reactionToRadiation(NO_RADIATION);
            p.livingStatus();
            System.out.println(p.toString());
        }
        Radiation r = radiationOnNextDay(data);        
        
        //simulation from day 2 to end
        for(int i = 1; i < (data.getNumOfDays()); i++){
            System.out.println("Day " + (i+1));
            System.out.println("Radiation: " + r);
            for(Plant p: data.getPlants()){
                p.reactionToRadiation(r);
                p.livingStatus();
                System.out.println(p.toString());    
            }
            r = radiationOnNextDay(data);
        }
        
        System.out.println("\n\n******SURVIVORS*****");
        for(Plant p : data.getPlants()){
            if(p.living){
                System.out.println(p.getName() + " | Nutrient level: "+p.getNutrient());
            }
        }

    }

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
