package pet;

public class Dog extends Pet implements IPet {
    {
        setSpecies(Species.Dog);
    }

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void foul() {

    }

    @Override
    public void respond() {

    }
}
