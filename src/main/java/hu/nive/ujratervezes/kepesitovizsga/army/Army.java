package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {

    List<MilitaryUnit> militaryUnits = new ArrayList<>();

    public void addUnit(MilitaryUnit militaryUnit) {
        if (militaryUnit == null) {
            throw new IllegalArgumentException("Militiary unit can't be null");
        }

        militaryUnits.add(militaryUnit);
    }

    public int getArmySize() {
        return militaryUnits.size();
    }

    public int getArmyDamage() {
        int sumDamage = 0;

        for (MilitaryUnit item : militaryUnits) {
            sumDamage += item.doDamage();
        }

        return sumDamage;
    }

    public void damageAll(int damage) {
        Iterator<MilitaryUnit> unitIterator = militaryUnits.iterator();

        while (unitIterator.hasNext()) {
            MilitaryUnit unit = unitIterator.next();
            unit.sufferDamage(damage);

            if (!unit.isAbleToFight()) {
                unitIterator.remove();
            }
        }
    }
}
