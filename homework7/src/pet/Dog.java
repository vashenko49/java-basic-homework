package pet;

public class Dog extends Pet implements FoulingPet {
    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
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
