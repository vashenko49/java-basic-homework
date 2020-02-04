package pet;

public enum Species {
    Fish(false, false, 0),
    DomesticCat(false, true, 4),
    Dog(false, true, 4),
    RoboCat(false, false, 4),
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
