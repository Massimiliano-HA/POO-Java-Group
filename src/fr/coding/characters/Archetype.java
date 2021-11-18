package fr.coding.characters;

public class Archetype {
    public String name;
    public float damage = 20.f;
    public float life = 100.f;
    public float magical_damage = 10.f;

    public float default_damage = 20.f;
    public float default_life = 100.f;
    public float default_magical_damage = 10.f;

    public int initiative= 10;
    public String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDamage(int defaultVar) {
        return damage;
    }

    public float getLife() {
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