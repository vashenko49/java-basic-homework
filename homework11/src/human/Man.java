package human;

import pet.Pet;

import java.util.Map;

public final class Man extends Human {
    public Man() {
    }

    public Man(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet(Pet pet) {
        if (pet != null) {
            if (pet.getNickname() != null) {
                System.out.println("Привет хозяин, " + pet.getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        }
    }

    public void repairCar() {
        System.out.println("Будем чинить");
    }
}
