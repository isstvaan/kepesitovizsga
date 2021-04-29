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
        hitPoints -= isHaveArmor() ? damage / 2 : damage;
    }
}
