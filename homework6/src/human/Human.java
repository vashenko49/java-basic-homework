package human;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    static {
        System.out.println("Loading a new class human.Human");
    }

    {
        System.out.println("A new human.Human object is created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Human() {
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;

    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public void greetPet() {
        if (family.getPet() != null) {
            if (family.getPet().getNickname() != null) {
                System.out.println("Привет, " + family.getPet().getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        } else {
            System.out.println("У меня нет питомца");
        }
    }

    public void describePet() {
        if (family.getPet() != null) {
            String describe = "";
            if (family.getPet().getSpecies() != null) {
                describe += "У меня есть " + family.getPet().getSpecies();
            } else {
                describe += "У меня есть питомец";
            }
            if (family.getPet().getAge() != 0) {
                describe += ", ему " + family.getPet().getAge() + " лет";
            }
            if (family.getPet().getTrickLevel() <= 50) {
                describe += ", он почти не хитрый";
            } else {
                describe += ", он очень хитрый";
            }

            System.out.println(describe);

        } else {
            System.out.println("У меня нет питомца");
        }
    }

    public boolean feedPet(boolean isTimeToFeed) {
        if (family.getPet() != null) {
            Random random = new Random();
            if (isTimeToFeed | (family.getPet().getTrickLevel() > random.nextInt(100))) {
                if (family.getPet().getNickname() != null) {
                    System.out.println("Хм... покормлю ка я " + family.getPet().getNickname());
                } else {
                    System.out.println("Хм... покормлю ка я. Дай мне имя");
                }
                return true;
            } else {
                if (family.getPet().getNickname() != null) {
                    System.out.println("Думаю, " + family.getPet().getNickname() + " не голоден");
                } else {
                    System.out.println("Думаю, не голоден. Дай мне имя");
                }
                return false;
            }
        } else {
            System.out.println("У меня нету собаки =(");
            return false;
        }
    }

    public String scheduleToString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < schedule.length; i++) {
            stringBuilder.append(schedule[i][0]);
            stringBuilder.append("={");
            stringBuilder.append(schedule[i][1]);
            stringBuilder.append("}");
            if (i != schedule.length - 1) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.toString();
    }

    public String getFirstNameAndLastName() {
        String firstNameAndLastName = "";
        if (name != null) {
            firstNameAndLastName += name;
        }
        if (surname != null) {
            firstNameAndLastName += " " + surname;
        }
        return firstNameAndLastName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Human{");
        if (name != null) {
            stringBuilder.append("name='");
            stringBuilder.append(name);
            stringBuilder.append('\'');
        }
        if (surname != null) {
            stringBuilder.append("surname='");
            stringBuilder.append(surname);
            stringBuilder.append('\'');
        }

        stringBuilder.append("year='");
        stringBuilder.append(year);
        stringBuilder.append('\'');

        stringBuilder.append("iq='");
        stringBuilder.append(iq);
        stringBuilder.append('\'');

        if (schedule != null) {
            stringBuilder.append("schedule='");
            stringBuilder.append(scheduleToString());
            stringBuilder.append('\'');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Arrays.equals(schedule, human.schedule) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, iq, family);
        result = 31 * result + Arrays.hashCode(schedule);
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(toString());
        super.finalize();
    }
}
