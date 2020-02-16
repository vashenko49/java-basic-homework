package human;

import pet.Pet;

import java.util.Map;

public final class Woman extends Human {
    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet( Pet pet) {
        if (pet != null) {
            if (pet.getNickname() != null) {
                System.out.println("Привет хозяйка, " + pet.getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        }
    }
    public void makeup(){
        System.out.println("Нужно покраситься");
    }
}
