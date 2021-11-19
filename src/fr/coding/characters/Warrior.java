package fr.coding.characters;

import java.util.Scanner;

public class Warrior extends Archetype {

    private int defaultShield = 10;
    public int shield = defaultShield; //warrior's shield

    public int getShield() {
        setShield(shield);
        return shield;
    }

    public void setShield(int newShield) {
        this.shield = newShield;
    }


    public void damageMe(int damage) {
        if (shield >= damage) {
           life -= 0;
        }

        else {
            life -=(damage - getShield());
        }
    }

    public void changeSettings() //change character's characteristics
    {
        super.changeSettings();

        System.out.println("Shield's character :");
        int newShield = new Scanner(System.in).nextInt();

        setShield(newShield);
    }

    public void resetSettings()
    {
        super.resetSettings();
        setShield(defaultShield);
    }
}
