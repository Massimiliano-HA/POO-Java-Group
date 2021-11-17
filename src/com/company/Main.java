package com.company;

import java.util.*;
import java.util.List;
import com.company.Settings;

public class Main
{
    public static void main(String[] args) {
        menu();
    }

    /**-----------------------   Fonction   ------------------------**/

   static void menu()
   {
       /**------------       Menu       ------------**/

       System.out.println("Application has started !");
       System.out.println("Menu :");
       System.out.println("1. Play");
       System.out.println("2. Quit");
       System.out.println("3. Options");
       System.out.print("enter a number : ");

       Scanner scanner = new Scanner(System.in);
       int menuChoose = scanner.nextInt();

       while (Settings.end == false)
       {
           if (menuChoose < 1 || menuChoose > 3)
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

               CreateCharc(playerChoose);

               System.out.println("Choose the second number's character :");
               playerChoose = scanner.nextInt();

               while (playerChoose < 1  || playerChoose > 3) {
                   System.out.println("wrong number's character retry :");
                   playerChoose = scanner.nextInt();
               }

               CreateCharc(playerChoose);

           } else if (menuChoose == 2) {
               Settings.end = true;

           } else if (menuChoose == 3) {
               System.out.println("Option :");
           }
       }

   }

/**----------    instance player  ----------**/

   static void CreateCharc (int playerChoose) {
       if (playerChoose == 1) {
           Archetype warrior = new Warrior();
       } else if (playerChoose == 2) {
           Archetype wizard = new Wizard();
       } else {
           Archetype thief = new Thief();
       }

       Settings.playerList.add(playerChoose);
   }
}
