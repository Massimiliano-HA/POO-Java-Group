package fr.coding.characters;

import java.util.Scanner;

public class Wizard extends Archetype
{
    private final float defaultMagicDamage = 10.f; //default magic damage
    private float magic_damage = defaultMagicDamage;  //magic damage
    private final float ResetMagicDamage = magic_damage;
    private float damageReset = damage ;

    public void setInitiative(int newinitiative) //change initiative
    {
        initiative = newinitiative;

    }
    public  void setMagicDamage(int round){  // calculation of magic damage
        magic_damage = ResetMagicDamage;
        magic_damage = (float)(magic_damage / (Math.pow(2, round)));
    }

    public  float getMagicDamage(int round) //give magic damage
    {
        setMagicDamage(round);
        return magic_damage;
    }


    public float getDamage(int round)  //make damage
    {
        damage = damageReset;   // reset damage
        damage += getMagicDamage(round);  // add magic damage to damage

        return damage; // return
    }


    public void changeSettings(){ //change character's characteristics
        super.changeSettings();
        System.out.println("Magical damage's character :");
        Scanner scanner = new Scanner(System.in);
        int newMagicalDamage = scanner.nextInt();
        setMagicDamage(newMagicalDamage);
    }

    public void resetSettings()
    {
        super.resetSettings();
        setMagicDamage((int) defaultMagicDamage);
    }
}
