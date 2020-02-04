package pet;

public class Fish extends Pet implements IPet {
    {
        setSpecies(Species.Fish);
    }

    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
