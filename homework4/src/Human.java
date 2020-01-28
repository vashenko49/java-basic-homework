import java.util.Arrays;
import java.util.Random;

public class Human {
    public String name;
    public String surname;
    public int year;
    public int iq;
    public Pet pet;
    public Human mother;
    public Human father;
    public String[][] schedule;

    public Human() {
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;

    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public void greetPet() {
        if (pet != null) {
            if (pet.nickname != null) {
                System.out.println("Привет, " + pet.nickname + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        } else {
            System.out.println("У меня нет питомца");
        }
    }

    public void describePet() {
        if (pet != null) {
            String describe = "";
            if (pet.species != null) {
                describe += "У меня есть " + pet.species;
            } else {
                describe += "У меня есть питомец";
            }
            if (pet.age != 0) {
                describe += ", ему " + pet.age + " лет";
            }
            if (pet.trickLevel <= 50) {
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
        if (pet != null) {
            Random random = new Random();
            if (isTimeToFeed | (pet.trickLevel > random.nextInt(100))) {
                if (pet.nickname != null) {
                    System.out.println("Хм... покормлю ка я " + pet.nickname);
                } else {
                    System.out.println("Хм... покормлю ка я. Дай мне имя");
                }
                return true;
            } else {
                if (pet.nickname != null) {
                    System.out.println("Думаю, " + pet.nickname + " не голоден");
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
        if (pet != null) {
            stringBuilder.append("pet='");
            stringBuilder.append(pet.toString());
            stringBuilder.append('\'');
        }
        if (pet != null) {
            stringBuilder.append("pet='");
            stringBuilder.append(pet.toString());
            stringBuilder.append('\'');
        }
        if (mother != null) {
            stringBuilder.append("mother='");
            stringBuilder.append(mother.toString());
            stringBuilder.append('\'');
        }
        if (father != null) {
            stringBuilder.append("father='");
            stringBuilder.append(father.toString());
            stringBuilder.append('\'');
        }
        if (schedule != null) {
            stringBuilder.append("schedule='");
            stringBuilder.append(scheduleToString());
            stringBuilder.append('\'');
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
