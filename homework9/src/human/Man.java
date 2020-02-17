package human;

import pet.Pet;

import java.util.Map;

public final class Man extends Human {
    public Man() {
    }

    public Man(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet( Pet pet) {
        if (pet!= null) {
            if (pet.getNickname() != null) {
                System.out.println("Привет хозяин, " + pet.getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        }
    }

    public void repairCar(){
        System.out.println("Будем чинить");
    }
}
