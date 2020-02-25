package human;

import family.Family;
import pet.Pet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.regex.Pattern;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
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

    public long getYear() {
        return birthDate;
    }

    public void setYear(long birthDate) {
        this.birthDate = birthDate;
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

    public Human(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = StringDateToLongDate(birthDate);
        this.iq = iq;
        this.schedule = schedule;

    }

    public Human(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;

    }

    public Human(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = StringDateToLongDate(birthDate);
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = StringDateToLongDate(birthDate);
        this.iq = iq;
    }

    private long StringDateToLongDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return simpleDateFormat.parse(dateString).getTime();
        } catch (ParseException e) {
            return System.currentTimeMillis();
        }
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


    private Period getCurrentYearsMonthsDays() {
        return Period.between(LocalDate.ofInstant(Instant.ofEpochMilli(birthDate), TimeZone.getDefault().toZoneId()), LocalDate.now());
    }

    public String describeAge() {
        Period period = getCurrentYearsMonthsDays();
        return period.getYears() +
                " years " +
                period.getMonths() +
                " months " +
                period.getDays() +
                " days";
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

        LocalDate localDate = LocalDate.ofInstant(Instant.ofEpochMilli(birthDate), TimeZone.getDefault().toZoneId());
        stringBuilder.append("birthDate='");
        stringBuilder.append(localDate.getDayOfMonth());
        stringBuilder.append("/");
        stringBuilder.append(localDate.getMonthValue());
        stringBuilder.append("/");
        stringBuilder.append(localDate.getYear());
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
        return birthDate == human.birthDate &&
                iq == human.iq &&
                Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                schedule.equals(human.schedule) &&
                Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthDate, iq, family);
        result = 31 * result + schedule.hashCode();
        return result;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(toString());
        super.finalize();
    }
}
