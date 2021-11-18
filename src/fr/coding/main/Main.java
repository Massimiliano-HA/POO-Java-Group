package fr.coding.main;

import fr.coding.characters.*;
import java.util.*;

public class Main
{
    static Settings settings = new Settings();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Application has started !");

        menu();
    }

    static void menu()
    {
        int menuChoose = 0;

        System.out.println("----------------");
        System.out.println("| Menu :       |");
        System.out.println("| 1. Play      |");
        System.out.println("| 2. Quit      |");
        System.out.println("| 3. Settings  |");
        System.out.println("----------------");

        while (menuChoose < 1 || menuChoose > 3) {
            System.out.print("-> ");

            menuChoose = scanner.nextInt(); // Getting the number entered
        }

        while (!settings.end) // While the game is not ended or quit
        {
           if (menuChoose == 1)
           {
               int playerChoose = 0;

               System.out.println();
               System.out.println("------------------------------------------");
               System.out.println("| Choose the first number's character :  |");
               System.out.println("| 1. Warrior                             |");
               System.out.println("| 2. Wizard                              |");
               System.out.println("| 3. Thief                               |");
               System.out.println("------------------------------------------");
               while (playerChoose < 1 || playerChoose > 3)
               {
                   System.out.print("-> ");

                   playerChoose = scanner.nextInt();
               }

               createCharacter(playerChoose);

               playerChoose = 0;

               System.out.println();
               System.out.println("-------------------------------------------");
               System.out.println("| Choose the second number's character :  |");
               System.out.println("-------------------------------------------");
               while (playerChoose < 1  || playerChoose > 3) {
                   System.out.print("-> ");

                   playerChoose = scanner.nextInt();
               }

               createCharacter(playerChoose);

               fight(settings.archetypeList.get(0), settings.archetypeList.get(1));
           }

           else if (menuChoose == 2) {
               settings.end = true;
           }

           else { // menu == 3
               settings();
           }
        }
    }

/**----------    instance player  ----------**/

   static void createCharacter(int playerChoose) {
       if (playerChoose == 1)
       {
           Archetype warrior = new Warrior();
           settings.archetypeList.add(warrior);

           warrior.setType("Warrior");

           createName(warrior);
       }

       else if (playerChoose == 2)
       {
           Archetype wizard = new Wizard();
           settings.archetypeList.add(wizard);

           wizard.setType("Wizard");

           createName(wizard);
       }

       else
       {
           Archetype thief = new Thief();
           settings.archetypeList.add(thief);

           thief.setType("Thief");

           createName(thief);
       }

       settings.playerList.add(playerChoose);
   }

/*-------------  SkillCharacter   ---------------*/

    static void createName(Archetype archetype) {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("| Choose the player name :  |");
        System.out.println("-----------------------------");
        archetype.setName(new Scanner(System.in).nextLine()); //Setting-up the name of the player
   }

   /**-------------      Fight     --------------**/

  static void fight(Archetype p1, Archetype p2)
  {
      System.out.println();
      System.out.println("-------------------");
      System.out.println("| 1. Start game   |");
      System.out.println("| 2. Quit         |");
      System.out.println("-------------------");
      int start = 0;

      while (start < 1 || start > 2) {
          System.out.print("-> ");
          start = scanner.nextInt();
      }

      System.out.println();

      if (start == 1)
      {
          System.out.println("------------------------Start the fight--------------------------");

          int leadPlayer = 0;
          int initP1 = p1.getInitiative();
          int initP2 = p2.getInitiative();

          if (initP1 < initP2) {
              leadPlayer = 1;
          }

          do {
              System.out.println("-----------------------------------------------------------------");
              System.out.println("                           round : "+ settings.playerround());

              if (leadPlayer == 0)
              {
                  attack(p1, p2);
                  settings.GlobalRound++;
                  leadPlayer = 1;
                  System.out.println(p1.name + " attaque :");
                  System.out.println(p1);
                  System.out.println("P2 : "+ p2.life + "HP");
              }

              if (p2.life <= 0 || p1.life <= 0) {
                  break; //end game
              }
              System.out.println();
              System.out.println("-----------------------------------------------------------------");

              if (leadPlayer == 1)
              {
                  attack(p2, p1);
                  settings.GlobalRound++;
                  leadPlayer = 0;
              }

              System.out.println(p2.name + " attaque :");
              System.out.println(p2);
              System.out.println("P1 : " + p1.life + "HP");

          } while (p1.life > 0 && p2.life > 0);

          System.out.println();

          if (p1.life > p2.life) {
              System.out.println();
              System.out.println("------------------------Fight ended--------------------------");
              System.out.println(p1.name + " (" + p1.type + ") wins !");
          } else {
              System.out.println();
              System.out.println("------------------------Fight ended--------------------------");
              System.out.println(p2.name + " (" + p2.type + ") wins !");
          }

          settings.resetCharactersInfo();
      }

      else { // start == 2 (Quit)
          settings.end = true;
          return;
      }

      menu();
  }

  static void attack(Archetype attacker, Archetype defender) {
      defender.damageMe((int) attacker.getDamage(settings.playerround()));
   }

   static void settings()
   {
       System.out.println();
       System.out.println("---------------------------------_--");
       System.out.println("| Settings :                       |");
       System.out.println("| 1. Show character informations   |");
       System.out.println("| 2. Show characters list          |");
       System.out.println("| 3. Remove a character            |");
       System.out.println("| 4. Return to main menu           |");
       System.out.println("----------------------------_-------");

       int result = 0;

       while (result < 1 || result > 4)
       {
           System.out.print("-> ");
           result = scanner.nextInt();
       }

       if (result == 1)
       {
           if (settings.archetypeList.size() == 0)
           {
               System.out.println();
               System.out.println("Characters list empty.");

               return;
           }

           System.out.println();
           System.out.println("Indicate the character number :");
           settings.showAllCharaters();

           result = 0;

           while (result < 1 || result > settings.archetypeList.size() + 1) {
               System.out.print("-> ");
               result = scanner.nextInt();
           }

           settings.showCharacter(result - 1);
       }

       if (result == 2)
       {
           if (settings.archetypeList.size() == 0)
           {
                System.out.println();
                System.out.println("Characters list empty.");

                return;
           }

           System.out.println();
           settings.showAllCharaters();
       }

       if (result == 3)
       {
           if (settings.archetypeList.size() == 0)
           {
               System.out.println();
               System.out.println("Characters list empty.");

               return;
           }

           System.out.println();
           System.out.println("1. Remove one character with his number");
           System.out.println("2. Remove all characters");

           result = 0;

           while (result < 1 || result > 2)
           {
               System.out.print("-> ");
               result = scanner.nextInt();
           }

           if (result == 1)
           {
               System.out.println();
               System.out.println("Indicate the character number :");
               settings.showAllCharaters();

               result = 0;

               while (result < 1 || result > settings.archetypeList.size())
               {
                   System.out.print("-> ");
                   result = scanner.nextInt();
               }

               settings.removeCharacter(result);
           }

           if (result == 2) {
               settings.removeAllCharacters();
           }
       }

       if (result == 4) {
           menu();
       }
   }
}
