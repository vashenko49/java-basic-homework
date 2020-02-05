package pet;

public class Fish extends Pet {
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
        if (getNickname() != null) {
            System.out.println("Привет, хозяин. Я - " + getSpecies() + " " + getNickname() + ". Я соскучился!");
        } else {
            System.out.println("Привет, хозяин. Я " + getSpecies() + " и я соскучился! Дай мне имя!");
        }
    }
}
