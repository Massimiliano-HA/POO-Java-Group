package fr.coding.characters;

import fr.coding.main.PseudoRandomGenerator;

public class Thief extends Archetype {
    private int critic_damage;

    public int getInitiative() {
        initiative = initiative + 2;
        return initiative;
    }

    public boolean getDodge() {
        PseudoRandomGenerator randomNumber = new PseudoRandomGenerator();

        double value = randomNumber.random();

        if (value > 0.5) {
            return true;
        }

        else {
            return false;
        }
    }


    public int CriticDamage() {
        return critic_damage;
    }

    public float getDamage() {
        damage +=critic_damage;
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