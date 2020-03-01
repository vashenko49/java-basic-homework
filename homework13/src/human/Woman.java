package human;

import pet.Pet;

import java.io.Serializable;
import java.util.Map;

public final class Woman extends Human implements Serializable {
    public Woman() {
    }

    public Woman(String name, String surname, String birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, long birthDate, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthDate, iq, schedule);
    }

    public Woman(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, long birthDate) {
        super(name, surname, birthDate);
    }

    public Woman(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    @Override
    public void greetPet(Pet pet) {
        if (pet != null) {
            if (pet.getNickname() != null) {
                System.out.println("Привет хозяйка, " + pet.getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        }
    }

    public void makeup() {
        System.out.println("Нужно покраситься");
    }
}
