package human;

import family.Family;
import pet.Pet;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Map<DayOfWeek, String> schedule;
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

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public void addDayToSchedule(DayOfWeek dayOfWeek, String plan) {
        schedule.put(dayOfWeek, plan);
    }

    public void deleteDayFromSchedule(DayOfWeek dayOfWeek) {
        schedule.remove(dayOfWeek);
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Human() {
    }

    public Human(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
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

    public void greetPet(Pet pet) {
        if (pet != null) {
            if (pet.getNickname() != null) {
                System.out.println("Привет, " + pet.getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        }
    }

    public void describePet(Pet pet) {
        if (pet != null) {
            String describe = "";
            if (pet.getSpecies() != null) {
                describe += "У меня есть " + pet.getSpecies();
            } else {
                describe += "У меня есть питомец";
            }
            if (pet.getAge() != 0) {
                describe += ", ему " + pet.getAge() + " лет";
            }
            if (pet.getTrickLevel() <= 50) {
                describe += ", он почти не хитрый";
            } else {
                describe += ", он очень хитрый";
            }

            System.out.println(describe);

        }
    }

    public boolean feedPet(boolean isTimeToFeed, Pet pet) {
        if (pet != null) {
            Random random = new Random();
            if (isTimeToFeed | (pet.getTrickLevel() > random.nextInt(100))) {
                if (pet.getNickname() != null) {
                    System.out.println("Хм... покормлю ка я " + pet.getNickname());
                } else {
                    System.out.println("Хм... покормлю ка я. Дай мне имя");
                }
                return true;
            } else {
                if (pet.getNickname() != null) {
                    System.out.println("Думаю, " + pet.getNickname() + " не голоден");
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
            stringBuilder.append(schedule.toString());
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
                schedule.equals(human.schedule) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, year, iq, family);
        result = 31 * result + schedule.hashCode();
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(toString());
        super.finalize();
    }
}
