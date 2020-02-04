import human.*;
import pet.*;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] schedule = new String[7][2];
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        for (int i = 0; i < dayOfWeeks.length; i++) {
            schedule[i][0] = dayOfWeeks[i].name();
            System.out.println(dayOfWeeks[i].name()+" Enter your plans: ");
            schedule[i][1] = scanner.next();
        }

        Pet pet = new Pet(Species.DOG, "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Human child = new Human("Vovo", "Loulovich", 18, 96, schedule);
        Human child2 = new Human("Vovo2", "Loulovich2", 20, 96, schedule);
        Human child3 = new Human("Vovo3", "Loulovich3", 20, 96, schedule);
        Human child4 = new Human("Vovo4", "Loulovic4", 20, 96, schedule);
        Human child5 = new Human("Vovo5", "Loulovic5", 20, 96, schedule);
        Human child6 = new Human("Vovo6", "Loulovic6", 20, 96, schedule);

        Family family = new Family(mother, father);
        family.setPet(pet);
        family.addChild(child);
        family.addChild(child2);
        family.addChild(child3);
        family.addChild(child4);
        family.addChild(child5);
        family.addChild(child6);

        family.deleteChild(child6);
        family.deleteChild(0);

        System.out.println(family.toString());


//        for (int i = 0; i < 999999; i++) {
//            Human human = new Human("Vovo6", "Loulovic6", 20, 96, schedule);
//        }

    }
}
