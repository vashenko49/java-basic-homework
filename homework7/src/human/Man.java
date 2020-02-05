package human;

public final class Man extends Human {
    public Man() {
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPet() != null) {
            if (getFamily().getPet().getNickname() != null) {
                System.out.println("Привет хозяин, " + getFamily().getPet().getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        } else {
            System.out.println("У меня нет питомца");
        }
    }

    public void repairCar(){
        System.out.println("Будем чинить");
    }
}
