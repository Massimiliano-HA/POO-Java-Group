package fr.coding.characters;

import java.util.Scanner;

public class Thief extends Archetype
{
    static int critic_damage;
    float damageReset = damage;
    public float defaultLuck = 0.5f;
    float luck = defaultLuck;

    public void setInitiative(int newinitiative)  // change initiative
    {
        initiative = newinitiative;

    }

    public void setLuck(int newluck){ //change luck
            this.luck = newluck;
    }


    public boolean getDodge() //give luck dodge
    {
        double value = Math.random();

        return value > luck;
    }

    public int CriticDamage() //calculation of critical damage with luck to make a crit
    {
        double value = Math.random();
        boolean Crit  = false;
        if (value > luck && Crit != true) {
            Crit = true;
            return critic_damage = 2;
        }else if(value > luck && Crit == true){
            Crit = false;
            return critic_damage = 1;
        }

        else {
            Crit = false;
            return critic_damage = 1;
        }
    }

    public float getDamage(int DefaultVar) //give damage
    {
        damage = damageReset;
        damage *= CriticDamage();

        return damage;
    }

    public void damageMe(int damage)  //receive damage
    {
        float life = getLife();

       if (getDodge()) {
           life -= 0;
       }

       else {
           life -= damage;
       }

       setLife(life);
    }

    public void changeSettings(){ //change character's characteristics
       super.changeSettings();
        Scanner scanner = new Scanner(System.in);
            System.out.println("luck's character :");
            int  newLuck = scanner.nextInt();
            setLuck(newLuck);
    }

    public void resetSettings(){
        super.resetSettings();
        setLuck((int) defaultLuck);
    }

}
