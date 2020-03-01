package pet;

import java.io.Serializable;

public enum Species implements Serializable {
    FISH(false, false, 0),
    DOMESTICCAT(false, true, 4),
    DOG(false, true, 4),
    ROBOCAT(false, false, 4),
    UNKNOWN(false,false,-1);

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(boolean canFly, boolean hasFur, int numberOfLegs) {
        this.canFly = canFly;
        this.hasFur = hasFur;
        this.numberOfLegs = numberOfLegs;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public boolean isHasFur() {
        return hasFur;
    }
}
