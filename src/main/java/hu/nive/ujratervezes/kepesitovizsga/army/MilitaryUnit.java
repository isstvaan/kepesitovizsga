package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {

    protected int hitPoints;
    private final int damagePoints;
    private final boolean haveArmor;

    public MilitaryUnit(int hitPoints, int damagePoints, boolean haveArmor) {
        if (hitPoints < 1) {
            throw new IllegalArgumentException("Hitpoints can't be less than 1");
        }

        if (damagePoints < 1) {
            throw new IllegalArgumentException("DamagePoints can't be less than 1");
        }

        this.hitPoints = hitPoints;
        this.damagePoints = damagePoints;
        this.haveArmor = haveArmor;
    }

    public abstract int doDamage();

    public abstract void sufferDamage(int damage);

    public boolean isAbleToFight() {
        return hitPoints > 25;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public boolean isHaveArmor() {
        return haveArmor;
    }
}
