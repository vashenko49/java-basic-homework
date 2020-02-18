package pet;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    {
        species = Species.valueOf(this.getClass().getSimpleName().toUpperCase());
    }


    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public void addHabit(String newHabit) {
        if (newHabit != null) {
            habits.add(newHabit);
        }
    }

    public void deleteHabit(String oldHabit) {
        if (oldHabit != null) {
            habits.remove(oldHabit);
        }
    }

    public void eat() {
        System.out.println("Я кушаю!");
    }

    public abstract void respond();

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
        stringBuilder.append(habits.toString());
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
                habits.equals(pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickname, age, trickLevel);
        result = 31 * result + habits.hashCode();
        return result;
    }
}
