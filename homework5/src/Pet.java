public class Pet {
    private String species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    static {
        System.out.println("Loading a new class Pet");
    }
    {
        System.out.println("A new Pet object is created");
    }

    public Pet() {
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
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
