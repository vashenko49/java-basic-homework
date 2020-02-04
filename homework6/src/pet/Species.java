package pet;

public enum Species {
    CAT(false, true,4),
    DOG(false, true,4),
    RABBIT(false, true, 4),
    OTTER(false, true, 4),
    DUCK(true, false, 2),
    CHICKEN(true, false, 2);

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(boolean canFly, boolean hasFur, int numberOfLegs){
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
