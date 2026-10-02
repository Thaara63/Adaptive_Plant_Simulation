package planet;

import java.util.HashMap;


public abstract class Plant {
    protected String name;
    protected int nutrients;
    protected boolean living;
    
    public Plant(String name, int nutrients){
        this.name = name;
        this.nutrients = nutrients;
        this.living = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    
    public int getNutrient(){
        return this.nutrients;
    }
    
    public boolean getIsLiving(){
        return this.living;
    }
    
    protected boolean livingStatus(){
       if(nutrients <= 0){
            this.living = false;
       }else{
           this.living = true;
       }
       return living;
    }
    
    protected abstract void reactionToRadiation(Radiation r);
    
    protected abstract HashMap<Radiation,Integer> radiationNeed();

    @Override
    public String toString(){
        return "Plant name: "+name+", "+"Nutrient level: "+ nutrients +", "+"Plant is alive? "+living ;
    }
    
    
    
}
