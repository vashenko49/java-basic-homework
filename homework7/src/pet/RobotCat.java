package pet;

public class RobotCat extends Pet implements IPet {
    {
        setSpecies(Species.RoboCat);
    }
    public RobotCat(String nickname) {
        super(nickname);
    }

    public RobotCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void foul() {

    }

    @Override
    public void respond() {

    }
}
