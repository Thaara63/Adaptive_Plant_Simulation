package planet;

import java.util.HashMap;


public abstract class Plant {
    protected String name;
    protected int nutrients;
    protected String type;
    protected boolean living;
    
    public Plant(String name, int nutrients, String type){
        this.name = name;
        this.nutrients = nutrients;
        this.type = type;
        this.living = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getNutrient(){
        return this.nutrients;
    }
    
    public void setNutrient(int nutrient){
        this.nutrients = nutrient;
    }
    
    public boolean getIsLiving(){
        return this.living;
    }
    
    protected boolean livingStatus(){
       if(nutrients < 0){
           this.living = false;
       }
       return this.living;
    }
    
    protected abstract void reactionToRadiation(Radiation r);
    
    protected abstract HashMap<Radiation,Integer> radiationNeed(Radiation r);
 
    
}
