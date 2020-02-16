package pet;

import java.util.Set;

public class RobotCat extends Pet implements FoulingPet {
    public RobotCat(String nickname) {
        super(nickname);
    }

    public RobotCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    @Override
    public void foul() {
        System.out.println("need to put back your leg");
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
