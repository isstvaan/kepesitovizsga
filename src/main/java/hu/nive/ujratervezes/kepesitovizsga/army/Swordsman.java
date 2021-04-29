package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {

    private boolean firstAttack = true;

    public Swordsman(boolean haveArmor) {
        super(100, 10, haveArmor);
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

        if (firstAttack) {
            firstAttack = false;
            return;
        }
        setHitpointsByDamage(damage);
    }
}
