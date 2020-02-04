package pet;

import java.util.Arrays;
import java.util.Objects;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;


    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet( String nickname, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public String getSpecies() {
        return species.name();
    }

    public void setSpecies(Species species) {
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

    public void eat() {
        System.out.println("Я кушаю!");
    }

    public abstract void respond();

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
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append("nickname='");
        stringBuilder.append(nickname);
        stringBuilder.append('\'');
        stringBuilder.append("age='");
        stringBuilder.append(age);
        stringBuilder.append('\'');
        stringBuilder.append("trickLevel='");
        stringBuilder.append(trickLevel);
        stringBuilder.append('\'');
        stringBuilder.append("habits='");
        stringBuilder.append(habitToString());
        stringBuilder.append('\'');

        if (species != null) {
            stringBuilder.append("species='{");

            stringBuilder.append("species='");
            stringBuilder.append(species.name());
            stringBuilder.append('\'');

            stringBuilder.append("hasFur='");
            stringBuilder.append(species.isHasFur());
            stringBuilder.append('\'');

            stringBuilder.append("canFly='");
            stringBuilder.append(species.isCanFly());
            stringBuilder.append('\'');

            stringBuilder.append("numberOfLegs='");
            stringBuilder.append(species.getNumberOfLegs());
            stringBuilder.append('\'');

            stringBuilder.append("}'");
        }

        return stringBuilder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(toString());
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age &&
                trickLevel == pet.trickLevel &&
                species.equals(pet.species) &&
                nickname.equals(pet.nickname) &&
                Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }
}
