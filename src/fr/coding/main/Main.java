package fr.coding.main;

import fr.coding.characters.*;
import java.util.*;

public class Main
{
    static Settings settings = new Settings(); //Object from Setting bcz it is used many times
    static Scanner scanner = new Scanner(System.in); //same

    public static void main(String[] args)
    {
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

        while (menuChoose < 1 || menuChoose > 3)  //wrong input
        {
            System.out.print("-> ");

            menuChoose = scanner.nextInt(); // Getting the number entered
        }

        System.out.println();

        while (!settings.end) // While the game is not ended or quit
        {
           if (menuChoose == 1) {

               System.out.println("---------------------------");
               System.out.println("| 1. Play                 |");
               System.out.println("| 2. Create charactere    |");
               System.out.println("| 3. Return to main menu  |");
               System.out.println("---------------------------");

               menuChoose = 0;
               while (menuChoose < 1 || menuChoose > 3)  //wrong input
               {
                   System.out.print("-> ");

                   menuChoose = scanner.nextInt(); // Getting the number entered
               }

               if (menuChoose == 2) {
                   chooseCharacter();
                   menu();
               }

               if (menuChoose == 1) {
                   int p1 =0;
                   int p2=1;
                   if (settings.archetypeList.size() == 0) {
                       chooseCharacter();
                       chooseCharacter();
                   }

                   if (settings.archetypeList.size() == 1) {
                       chooseCharacter();
                   }

                   if(settings.archetypeList.size() >2){
                       for(int i = 0; i < settings.archetypeList.size(); i++) {
                           System.out.print(i + 1 + " ");
                           System.out.println(settings.archetypeList.get(i));
                       }
                           int playerChoose = 0;
                           System.out.println("choose the first player");
                           while (playerChoose < 0 || playerChoose > settings.archetypeList.size())
                           {
                               System.out.print("-> ");
                               playerChoose = scanner.nextInt()-1; // Getting the number entered
                           }
                            p1 = playerChoose;
                           System.out.println("choose the second player");
                           playerChoose = 0;
                           while (playerChoose < 0 || playerChoose > settings.archetypeList.size())
                           {
                               System.out.print("-> ");
                               playerChoose = scanner.nextInt()-1; // Getting the number entered
                           }
                           p2 = playerChoose;

                   }
                   if (settings.archetypeList.size()<=2){
                       p1 = 0;
                       p2 = 1;
                   }

                   fight(settings.archetypeList.get(p1), settings.archetypeList.get(p2));
               }




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

static void chooseCharacter(){
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

}
   static void createCharacter(int playerChoose)
   {
       if (playerChoose == 1)
       {
           Warrior warrior = new Warrior();

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

    static void createName(Archetype archetype)
    {
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("| Choose the player name :  |");
        System.out.println("-----------------------------");
        archetype.setName(new Scanner(System.in).nextLine()); //Setting-up the name of the player

        System.out.println();
   }

   /**-------------      Fight     --------------**/

  static void fight(Archetype p1, Archetype p2) //fight player 1 versus player 2
  {
      System.out.println();
      System.out.println("-------------------");
      System.out.println("| 1. Start game   |");
      System.out.println("| 2. Quit         |");
      System.out.println("-------------------");

      int start = 0;

      while (start < 1 || start > 2)  //wrong input
      {
          System.out.print("-> ");
          start = scanner.nextInt();
      }

      System.out.println();

      if (start == 1)
      {
          System.out.println("------------------------Start the fight--------------------------");

          int leadPlayer = 0;  // choose starter
          int initP1 = p1.getInitiative(); // take player 1 initiative
          int initP2 = p2.getInitiative(); // take player 2 initiative

          if (initP1 < initP2) {
              leadPlayer = 1;
          }

          else if (initP1 == initP2)
          {
             double PlayerStart = Math.random();

             if (PlayerStart <= 0.5) {
                 leadPlayer = 0;
             }
          }

          do
          {
              if (leadPlayer == 0)
              {
                  System.out.println();
                  System.out.println("-----------------------------------------------------------------");
                  System.out.println("                           round : "+ (settings.playerround() + 1));

                  attack(p1, p2);
                  settings.GlobalRound++;
                  leadPlayer = 1;

                  System.out.println(p1.getName() + " attack :");
                  System.out.println(p1);
                  System.out.println(p1.getName() +" (P1) : " + p1.getLife() + "HP");
                  System.out.println(p2.getName() +" (P2) : " + p2.getLife() + "HP");
              }

              if (p2.getLife() <= 0.F || p1.getLife() <= 0.F) {
                  break; //end game
              }

              if (leadPlayer == 1)
              {
                  System.out.println();
                  System.out.println("-----------------------------------------------------------------");

                  attack(p2, p1);
                  settings.GlobalRound++;
                  leadPlayer = 0;

                  System.out.println(p2.getName() + " attack :");
                  System.out.println(p2);
                  System.out.println(p1.getName() +" (P1) : " + p1.getLife() + "HP");
                  System.out.println(p2.getName() +" (P2) : " + p2.getLife() + "HP");
              }
          } while (p1.getLife() > 0 && p2.getLife() > 0);

          if (p1.getLife() > p2.getLife())
          {
              System.out.println();
              System.out.println("------------------------Fight ended--------------------------");
              System.out.println(p1.getName() + " (" + p1.getType() + ") wins !");
          }

          else
          {
              System.out.println();
              System.out.println("------------------------Fight ended--------------------------");
              System.out.println(p2.getName() + " (" + p2.getType() + ") wins !");
          }

          System.out.println();

          settings.resetCharactersInfo();
          settings.GlobalRound = 0;
      }

      else // start == 2 (Quit)
      {
          settings.end = true;
          return;
      }

      menu();
  }

  static void attack(Archetype attacker, Archetype defender) {
      defender.damageMe((int) attacker.getDamage(settings.playerround()));
   }

   /**---------------------Settings-----------------**/

   static void settings()
   {
       System.out.println();
       System.out.println("-----------------------------------------");
       System.out.println("| Settings :                            |");
       System.out.println("| 1. Show character informations        |");
       System.out.println("| 2. Show characters list               |");
       System.out.println("| 3. Remove a character                 |");
       System.out.println("| 4. Change character's characteristics |");
       System.out.println("| 5. Reset character                    |");
       System.out.println("| 6. Return to main menu                |");
       System.out.println("-----------------------------------------");

       int result = 0;

       while (result < 1 || result > 6)
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

       if (result == 4)
       {
           while (settings.archetypeList.size() == 0)
           {
               System.out.println();
               System.out.println("Characters list empty.");
               System.out.println("------------------------------------------");
               System.out.println("| Choose the number's character :        |");
               System.out.println("| 1. Warrior                             |");
               System.out.println("| 2. Wizard                              |");
               System.out.println("| 3. Thief                               |");
               System.out.println("------------------------------------------");
              int  playerChoose = scanner.nextInt();
               while (playerChoose < 1  || playerChoose > 3)
               {
                   System.out.print("-> ");

                   playerChoose = scanner.nextInt();
               }

               createCharacter(playerChoose);
           }

           System.out.println();
           System.out.println("Indicate the character number :");
           settings.showAllCharaters();

           result = 0;

           while (result < 0 || result > settings.archetypeList.size())
           {
               System.out.print("-> ");
               result = scanner.nextInt()-1;
           }
           settings.ChangeCharacteristic(result);
       }

       if(result == 5){

           while (settings.archetypeList.size() == 0) {
               System.out.println();
               System.out.println("Characters list empty.");
               menu();
           }

           System.out.println();
           System.out.println("Indicate the character number :");
           settings.showAllCharaters();

           result = 0;

           while (result < 0 || result > settings.archetypeList.size())
           {
               System.out.print("-> ");
               result = scanner.nextInt();
           }
           settings.resetCharactersInfo();
       }

       if (result == 6) {
           System.out.println();
           menu();
       }
   }
}
