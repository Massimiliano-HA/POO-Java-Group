package fr.coding.main;

import fr.coding.characters.Archetype;

import java.util.*;

public class Settings
{
    boolean end = false;

    public int GlobalRound = 0;  //round of each player
    List<Integer> playerList = new ArrayList<>();   //new list
    List<Archetype> archetypeList = new ArrayList<>();  //new list

    static Scanner scanner = new Scanner(System.in); //new scanner

   public int playerround() //round
   {
        int PlayerRound;

        if (GlobalRound < 2) {
            PlayerRound = 0;
        }

        else {
            PlayerRound = GlobalRound / 2;
        }

        return PlayerRound;
    }

    public void resetCharactersInfo()
    {
        for (Archetype archetype : archetypeList) {
            archetype.resetSettings();
        }
    }

    void removeCharacter(int index)
    {
        index--;
        System.out.println();
        System.out.println("The character (" + (index + 1) + ") Name : " + archetypeList.get(index).getName() + " | Type : " + archetypeList.get(index).getType() + " has been removed.");
        archetypeList.remove(index);
   }

    void removeAllCharacters()
    {
        playerList.clear();
        archetypeList.clear();

        System.out.println();
        System.out.println("All characters has been removed.");
    }

    void showCharacter(int index)
    {
        System.out.println();
        System.out.println("Character " + (index + 1) + " informations :");
        System.out.println("Type : " + archetypeList.get(index).getType());
        System.out.println("Name : " + archetypeList.get(index).getName());
        System.out.println("Life : " + archetypeList.get(index).getLife());
        System.out.println("Damage : " + archetypeList.get(index).getDamage(0));

      //  if (archetypeList.get(index).getType().equals(new Wizard().getType())) {
       //     System.out.println("Magical Damage : " + archetypeList.get(index).getDefaultMagicalDamage());
      //  }

        System.out.println("Initiative : " + archetypeList.get(index).getInitiative());
    }

    void showAllCharaters()
    {
        for (int i = 0; i < archetypeList.size(); i++) {
            System.out.println((i + 1) + ". Name : " + archetypeList.get(i).getName() + " | Type : " + archetypeList.get(i).getType());
        }
    }

    void ChangeCharacteristic(int index)
    {
        Archetype archetype = archetypeList.get(index);
        System.out.println(archetype);
        archetype.changeSettings();
    }
}
