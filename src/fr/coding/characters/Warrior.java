package fr.coding.characters;

public class Warrior extends Archetype {
    private float shield = 10;

    public float getShield() {
        return shield;
    }

    public float getDamage() {
        return damage;
    }

    public void damageMe(int damage) {
        life -= damage - shield;
    }



}

