import java.util.Arrays;

public class Pet {
    public String species;
    public String nickname;
    public int age;
    public int trickLevel;
    public String[] habits;

    public Pet() {
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я кушаю!");
    }

    public void respond() {
        if (nickname != null) {
            System.out.println("Привет, хозяин. Я - " + nickname + ". Я соскучился!");
        } else {
            System.out.println("Привет, хозяин. Я соскучился! Дай мне имя!");
        }
    }

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    private String habitToString() {
        StringBuilder habitString = new StringBuilder("[");

        for (int i = 0; i < habits.length; i++) {
            habitString.append(habits[i]);
            if (i != habits.length - 1) {
                habitString.append(", ");
            }
        }
        habitString.append("]");
        return habitString.toString();
    }

    @Override
    public String toString() {
        return species + "{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habitToString() +
                '}';
    }
}
