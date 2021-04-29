package hu.nive.ujratervezes.kepesitovizsga.army;

public class Archer extends MilitaryUnit {

    public Archer() {
        super(50, 20, false);
    }

    @Override
    public int doDamage() {
        return getDamagePoints();
    }

    @Override
    public void sufferDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage can't be less the zero");
        }
        setHitpointsByDamage(damage);
    }
}
