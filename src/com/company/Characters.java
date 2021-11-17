package com.company;

class Archetype {
    private String name;
    private int damage;
    private int life;
    private int initiative;

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getLife() {
        return life;
    }

    public int getInitiative() {
        return initiative;
    }

    public void damageMe(int damage) {
      life -= damage;
    }

    public String toString() {
        return "Archetype{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", life=" + life +
                ", initiative=" + initiative +
                '}';
    }
}

class Wizard extends Archetype {

}

class Thief extends Archetype {

}

class Warrior extends Archetype {

}