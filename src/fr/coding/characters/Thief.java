package fr.coding.characters;

import fr.coding.main.PseudoRandomGenerator;

public class Thief extends Archetype {
    private int critic_damage  ;
    float damageReset = damage;

    public int getInitiative() {
        initiative = initiative + 2;
        return initiative;
    }

    public boolean getDodge() {

        double value = Math.random();


        if (value > 0.5) {
            return true;
        }

        else {
            return false;
        }
    }

    public int CriticDamage() {

       // PseudoRandomGenerator randomNumber = new PseudoRandomGenerator();
        double value = Math.random();


        if (value > 0.5) {
            return critic_damage  =2;
        }
        else {
            return critic_damage=1;
        }

    }

    public float getDamage(int DefaultVar) {

        damage = damageReset;
        damage *= CriticDamage();
        return damage;

    }

    public void damageMe(int damage) {
       if(getDodge()== true){
           life -= 0;
       }else{
           life -= damage;
       }

    }

}