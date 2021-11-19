package fr.coding.characters;

import java.util.Scanner;

public class Archetype //Archetype class
{
    private String name; //name of character
    private String type; //type of character

    private final float defaultLife = 100.f; //default life
    private final float defaultDamage = 20.f;  // default damage
    private final int defaultInitiative = 10; // default initiative

    public float life = defaultLife;   //character's life
    public float damage = defaultDamage;  //character's damage
    public int initiative = defaultInitiative ; //character's initiative

    public String getName() {  //give the character's name
        return name;
    }

    public void setName(String name) { //change the character's name
        this.name = name;
    }

    public String getType() {
        return type;
    }  //give the character's type

    public void setType(String type) {
        this.type = type;
    }  // change the character's type

    public float getLife() {  //give the character's life
        return life;
    }

    public void setLife(float life) { //change the character's life
        this.life = life;
    }

    public float getDamage(int defaultVar) {
        return damage;
    }  //give the character's damage

    public void setDamage(int damage) {  //change the character's damage
        this.damage = damage;
    }

    public int getInitiative() {
        return initiative;
    } // give the character's initiative

    public void setInitiative(int initiative) {  // change the character's initiative
        this.initiative = initiative;
    }

    public float getDefaultDamage() {
        return defaultDamage;
    }

    public float getDefaultLife() {
        return defaultLife;
    }

    public void damageMe(int damage) { //  receive damage
        life -= damage;
    }

    public String toString() {  //string of character's characteristics
        return "Archetype{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", life=" + life +
                ", initiative=" + initiative +
                '}';
    }

    public void changeSettings() //change character's characteristics
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Damage's character :");
        System.out.print("-> ");

        int newDamage = scanner.nextInt();

        System.out.println("Life's character :");
        System.out.print("-> ");

        int newLife = scanner.nextInt();

        System.out.println("Initiative's character :");
        System.out.print("-> ");

        int newInitiative = scanner.nextInt();

        setDamage(newDamage);
        setLife(newLife);
        setInitiative(newInitiative);
    }

    public void resetSettings() //To reset characters informations after the fight
    {
        setInitiative(defaultInitiative);
        setDamage((int)defaultDamage);
        setLife(defaultLife);
    }
}
