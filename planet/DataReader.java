package planet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class DataReader {
    private ArrayList<Plant> plants;
    private int numOfDays;
    
    public DataReader(){
        plants = new ArrayList<>();
        numOfDays = 0;
    }
    
    public void read(String filename) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        
        int numOfPlants = sc.nextInt();
        
        for(int i = 0; i < numOfPlants; i++){
            Plant plant;
            String plantName =sc.next();
            switch(sc.next()){
                case "p":
                    plant = new Puffs(plantName,sc.nextInt());
                    break;
                case "d":
                    plant = new Deltatree(plantName,sc.nextInt());
                    break;
                case "b":
                    plant = new Parabush(plantName,sc.nextInt());
                    break;
                default:
                    throw new IOException();
            }
            plants.add(plant);
            
        }
        this.numOfDays =sc.nextInt();
    }
    
    public int getSize(){
        return plants.size();
    }
    public int getNumOfDays(){
        return numOfDays;
    }
    
    public ArrayList<Plant> getPlants(){
        ArrayList<Plant> plantsCopy = new ArrayList<>(plants);
        return plantsCopy;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Plant p : plants){
            s += p.name + " " + p.nutrients +"\n" ;
        }
        return s + "num of days: " + numOfDays;
    }
}
