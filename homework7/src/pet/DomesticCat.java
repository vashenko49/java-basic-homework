package pet;

public class DomesticCat extends Pet implements IPet {
    {
        setSpecies(Species.DomesticCat);
    }

    public DomesticCat(String nickname) {
        super(nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
