package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {

    private boolean firstAttack = true;

    public HeavyCavalry() {
        super(150, 20, true);
    }

    @Override
    public int doDamage() {
        int damage = getDamagePoints();

        if (firstAttack) {
            firstAttack = false;
            damage *= 3;
        }

        return damage;
    }

    @Override
    public void sufferDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage can't be less the zero");
        }
        setHitpointsByDamage(damage);
    }
}
