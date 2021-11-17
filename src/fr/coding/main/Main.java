package fr.coding.main;

import fr.coding.characters.*;
import java.util.*;

public class Main
{
    static Settings settings = new Settings(); //currently static bcz idk why this is not working

    public static void main(String[] args) {
        menu();

        fight(settings.archetypeList.get(0), settings.archetypeList.get(1));
    }

    /**------------       Menu       ------------**/

    static void menu()
    {
       System.out.println("Application has started !");
       System.out.println("Menu :");
       System.out.println("1. Play");
       System.out.println("2. Quit");
       System.out.println("3. Options");
       System.out.print("enter a number : ");

       Scanner scanner = new Scanner(System.in); // Creating a new scanner
       int menuChoose = scanner.nextInt(); // Getting the number entered

       while (settings.end == false) // While the game is not ended or quit
       {
           if (menuChoose < 1 || menuChoose > 3) // If the entered number is under 1 or
           {
               System.out.println("1. Play");
               System.out.println("2. Quit");
               System.out.println("3. Options");
               System.out.print("Wrong number retry : ");

               menuChoose = scanner.nextInt();
           }

           /**------------      Menu Player Choose      ------------**/

           else if (menuChoose == 1)
           {
               System.out.println("Choose the first number's character :");
               System.out.println("1. Warrior");
               System.out.println("2. Wizard");
               System.out.println("3. Thief");

               int playerChoose = scanner.nextInt();

               while (playerChoose < 1 || playerChoose > 3) {
                   System.out.println("wrong number's character retry :");
                   playerChoose = scanner.nextInt();
               }

               createCharacter(playerChoose);

               System.out.print("Choose the second number's character : ");
               playerChoose = scanner.nextInt();

               while (playerChoose < 1  || playerChoose > 3) {
                   System.out.print("wrong number's character retry : ");
                   playerChoose = scanner.nextInt();
               }
               
               createCharacter(playerChoose);

               break;

               /**--------     Option/ Quit    ---------**/

           } else if (menuChoose == 2) {
               settings.end = true;

           } else if (menuChoose == 3) {
               System.out.println("Option :");
           }
       }
    }

/**----------    instance player  ----------**/

   static void createCharacter (int playerChoose) {
       if (playerChoose == 1) {
           Archetype warrior = new Warrior();
           settings.archetypeList.add(warrior);

           createName(warrior);
       } else if (playerChoose == 2) {
           Archetype wizard = new Wizard();
           settings.archetypeList.add(wizard);

           createName(wizard);
       } else {
           Archetype thief = new Thief();
           settings.archetypeList.add(thief);

           createName(thief);
       }

       settings.playerList.add(playerChoose);
   }

/*-------------  SkillCharacter   ---------------*/

    static void createName(Archetype archetype) {
       System.out.print("Choose player name : ");

       Scanner scanner = new Scanner(System.in); // Creating a new scanner

       archetype.setName(scanner.nextLine()); // Setting-up the name of thr player
   }

   /**-------------      Fight     --------------**/

  static void fight(Archetype p1, Archetype p2)
  {
      System.out.println("press 1 to start or 2 to quit :");
      Scanner scanner = new Scanner(System.in);
      int start = scanner.nextInt();

      if (start == 1)
      {
          int leadPlayer = 0;
          int initP1 = p1.getInitiative();
          int initP2 = p2.getInitiative();

          if (initP1 < initP2) {
              leadPlayer = 1;
          }

          do {
              System.out.println("round : " + settings.round);

              if (leadPlayer == 0)
              {
                  attack(p1, p2);

                  leadPlayer = 1;
              }

              if (p2.life <= 0 || p1.life <= 0) {
                  System.out.println("break");

                  break;
              }

              if (leadPlayer == 1)
              {
                  attack(p2, p1);

                  leadPlayer = 0;
              }

              settings.round++;

              System.out.println(p1);
              System.out.println(p2);

          } while (p1.life > 0 && p2.life > 0);

          System.out.println("End game.");
       }
  }

  static void attack(Archetype attacker, Archetype defender) {
      //defender.life = defender.life - attacker.damage;
      defender.life -= attacker.damage;
   }
}
