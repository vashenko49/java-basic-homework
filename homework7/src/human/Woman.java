package human;

public final class Woman extends Human {
    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        if (getFamily().getPet() != null) {
            if (getFamily().getPet().getNickname() != null) {
                System.out.println("Привет хозяйка, " + getFamily().getPet().getNickname() + "!");
            } else {
                System.out.println("Привет! Дай мне имя");
            }
        } else {
            System.out.println("У меня нет питомца");
        }
    }
    public void makeup(){
        System.out.println("Нужно покраситься");
    }
}
