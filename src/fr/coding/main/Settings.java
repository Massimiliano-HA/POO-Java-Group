package fr.coding.main;

import fr.coding.characters.Archetype;

import java.util.List;
import java.util.ArrayList;

public class Settings {
    boolean end = false;

    public int GlobalRound = 0;
    List<Integer> playerList = new ArrayList<Integer>();
    List<Archetype> archetypeList = new ArrayList<Archetype>();


   public int playerround() {
        int PlayerRound ;

        if(GlobalRound <2){
            PlayerRound = 0;
        }
        else {
            PlayerRound = GlobalRound/2;
        }
        return PlayerRound;
    }

    public void resetCharactersInfo()
    {
        for (int i = 0; i < archetypeList.size(); i++) {
            archetypeList.get(i).life = new Archetype().default_life;
            archetypeList.get(i).damage = new Archetype().default_damage;

            if (archetypeList.get(i).getType() == "Warrior") {
                archetypeList.get(i).magical_damage = new Archetype().default_magical_damage;
            }
        }
    }

    void removeCharacter(int index)
    {
        index--;
        System.out.println();
        System.out.println("The character (" + (index + 1) + ") Name : " + archetypeList.get(index).name + " | Type : " + archetypeList.get(index).type + " has been removed.");
        archetypeList.remove(index);
   }

    void removeAllCharacters()
    {
        playerList.clear();
        archetypeList.clear();

        System.out.println();
        System.out.println("All characters has been removed.");
    }

    void showCharacter(int index) {
        System.out.println();
        System.out.println("Character " + (index + 1) + " informations :");
        System.out.println("Type : " + archetypeList.get(index).getType());
        System.out.println("Name : " + archetypeList.get(index).name);
        System.out.println("Life : " + archetypeList.get(index).default_life);
        System.out.println("Damage : " + archetypeList.get(index).default_damage);

        if (archetypeList.get(index).getType() == "Wizard") {

            System.out.println("Magical Damage : " + archetypeList.get(index).default_magical_damage);
        }

        System.out.println("Initiative : " + archetypeList.get(index).initiative);

    }

    void showAllCharaters() {
        for (int i = 0; i < archetypeList.size(); i++) {
            System.out.println((i + 1) + ". Name : " + archetypeList.get(i).name + " | Type : " + archetypeList.get(i).type);
        }
    }
}

