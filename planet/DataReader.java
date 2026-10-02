package planet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataReader {
    private final ArrayList<Plant> plants;
    
    public DataReader(){
        plants = new ArrayList<>();
    }
    
    public void read(String filename) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        
        int numOfPlants = sc.nextInt();
        
        for(int i = 0; i < numOfPlants; i++){
            Plant plant;
            String plantName =sc.next();
            switch(sc.next()){
                case "p":
                    plant = new Puffs(plantName,sc.nextInt(),"p");
                    break;
                case "d":
                    plant = new Deltatree(plantName,sc.nextInt(),"d");
                    break;
                case "b":
                    plant = new Parabush(plantName,sc.nextInt(),"b");
                    break;
                default:
                    throw new IOException();
            }
            plants.add(plant);
            
        }
        int numOfDays = sc.nextInt();
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Plant p : plants){
            s += p.name + " " + p.type + " " + p.nutrients +"\n" ;
        }
        return s;
    }
}
