package machine;
import java.util.Scanner;

public class CoffeeMachine {
    static int iWater = 400; 
    static int iMilk = 540;
    static int iBeans = 120;
    static int iCups = 9;
    static int iMoney = 550;
    static int counter = 0; 
    static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) { 
        while (true){        
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");       
            String action = scanner.nextLine();
            switch (action) { 
            case "buy":
                buy ();     
                break;
            case "fill":
	            fill ();
                break;
            case "take":
		        System.out.println("I gave you $" + iMoney);
                iMoney = 0; 
                break;
        		case "clean":   
        		    clean ();
         		    break;
        		case "remaining":
        		    status ();
        		    break;
        		case "exit":
                scanner.close (); 
		            return; 
            } 
        }
    } 


	  public static void status () {
	      System.out.println("The coffee machine has:");
            System.out.println(iWater + " ml of water");
            System.out.println(iMilk + " ml of milk");
            System.out.println(iBeans + " g of coffee beans");
            System.out.println(iCups + " disposable cups");
            System.out.println("$" + iMoney + " of money");	
  }

	  public static void buy () {
        if (counter >= 10) {  
          System.out.println ("I need cleaning!");
          return; // no buying, go back to main menu
        }
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "); 
        String choice = scanner.nextLine(); 
        switch (choice) { 
            case "1":			 
               CoffeeTypes.espresso (); 
               break;
            case "2":			 
               CoffeeTypes.latte ();       
               break;	
            case "3":			 
               CoffeeTypes.cappuccino ();
               break;   	 
            case "back":
               return; 
            }
      }

      public static void fill () {
		  System.out.println("Write how many ml of water you want to add:");
			  int addWater = scanner.nextInt();
			  iWater += addWater;
			  System.out.println("Write how many ml of milk you want to add:");	
			  int addMilk = scanner.nextInt();
			  iMilk += addMilk;
			  System.out.println("Write how many grams of coffee beans you want to add:");	
			  int addBeans = scanner.nextInt();
			  iBeans += addBeans;
			  System.out.println("Write how many disposable cups you want to add:");
			  int addCups = scanner.nextInt();
			  iCups += addCups;
      }

      public static String check (int needW, int needM, int needB) { 
          if (iWater < needW) return "water"; 
          if (iMilk < needM) return "milk";
          if (iBeans < needB) return "coffee beans";       
          if (iCups < 1) return "cups";    
          return "";                       
      }

      public static void clean () { 
          System.out.println("I have been cleaned!");
          counter = 0;       
      }
}

class CoffeeTypes {
	  public static void espresso () { 
		  String missing = CoffeeMachine.check (250,0,16); 
		  if (missing.equals("")){ 
			  System.out.println("I have enough resources, making you a coffee!");
			  CoffeeMachine.iWater -= 250; 
			  CoffeeMachine.iBeans -= 16;
			  CoffeeMachine.iMoney += 4;
			  CoffeeMachine.iCups -= 1;
			  CoffeeMachine.counter ++; 
	      } else {
		      System.out.println("Sorry, not enough " + missing + "!");
	      }                
    }

    public static void latte () { 
		 String missing = CoffeeMachine.check (350,75,20);
		 if (missing.equals("")){
			  System.out.println("I have enough resources, making you a coffee!");
			  CoffeeMachine.iWater -= 350;
			  CoffeeMachine.iMilk -= 75;
			  CoffeeMachine.iBeans -= 20;
			  CoffeeMachine.iMoney += 7;
			  CoffeeMachine.iCups -= 1; 
			  CoffeeMachine.counter ++;
		 } else {
			  System.out.println("Sorry, not enough " + missing + "!");
		 }                    
    }

    public static void cappuccino () { 
	   String missing = CoffeeMachine.check (200,100,12);
		 if (missing.equals("")){
			  System.out.println("I have enough resources, making you a coffee!");
			  CoffeeMachine.iWater -= 200;
			  CoffeeMachine.iMilk -= 100;
			  CoffeeMachine.iBeans -= 12;
			  CoffeeMachine.iMoney += 6;
			  CoffeeMachine.iCups -= 1; 
			  CoffeeMachine.counter ++;
		 } else {
			  System.out.println("Sorry, not enough " + missing + "!");
		 }                    
    }
}
