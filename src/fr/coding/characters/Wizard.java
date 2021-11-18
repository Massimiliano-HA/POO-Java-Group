package fr.coding.characters;
import fr.coding.main.Settings;
public class Wizard extends Archetype {
    private float magic_damage = 10.f;
    float ResetMagicDamage = magic_damage;
    float damageReset = damage;


    public int getInitiative() {
        initiative = initiative + 1;
        return initiative;
    }

    public float getMagicDamage(int round) {

        magic_damage = ResetMagicDamage;
        magic_damage = (float) (magic_damage/(Math.pow(2,round)));

        return magic_damage;
    }

    public float getDamage(int round) {

        damage= damageReset;
        damage += getMagicDamage(round);
        return damage;
    }

    public void damageMe(int damage) {
        life -= damage;
    }
}
