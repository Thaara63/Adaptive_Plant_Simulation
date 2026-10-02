package planet;

import java.util.Scanner;

//import java.io.IOException;

public class Planet {

    public static void main(String[] args) {
          
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();
        
        Simulation s = new Simulation();
        s.simulate(fileName);
        
    }
}
