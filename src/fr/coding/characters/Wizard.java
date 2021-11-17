package fr.coding.characters;

public class Wizard extends Archetype {
    private float magic_damage = 10.f;

    public int getInitiative() {
        initiative = initiative + 1;
        return initiative;
    }

    public float getMagicDamage() {
        return magic_damage;
    }
}
