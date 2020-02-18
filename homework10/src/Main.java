import family.*;
import human.ChildName;
import human.Human;
import human.Man;
import human.Woman;
import pet.Dog;
import pet.Pet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FamilyDAO familyDAO = CollectionFamilyDao.instanceOf();
        FamilyService familyService = new FamilyService(familyDAO);
        FamilyController familyController = new FamilyController(familyService);

        Human mother = new Woman("Lou", "Loulovich", "08/05/1996");
        Human father = new Man("Gogo", "Loulovich", "08/05/1990");

        familyController.createNewFamily(mother, father);
        familyController.createNewFamily(mother, father);
        familyController.createNewFamily(mother, father);

        Human child = new Human("Vovo", "Loulovich", "05/05/2005",85);

        System.out.println(child.describeAge());

        Human child1 = new Human("Vovo", "Loulovich", "05/12/2006");
        Human child2 = new Human("Vovo", "Loulovich", "05/12/200");

        Family family = familyController.getFamilyByIndex(0);

        family = familyController.adoptChild(family, child);
        family = familyController.adoptChild(family, child1);
        family = familyController.adoptChild(family, child2);
        family = familyController.bornChild(family, ChildName.Alexander.toString(), ChildName.Alfie.toString());

        Family family1 = familyController.getFamilyByIndex(1);

        family1 = familyController.adoptChild(family1, child);
        family1 = familyController.adoptChild(family1, child1);
        family1 = familyController.adoptChild(family1, child2);
        family1 = familyController.bornChild(family1, ChildName.Daniel.toString(), ChildName.Isaac.toString());

        Family family2 = familyController.getFamilyByIndex(2);

        family2 = familyController.adoptChild(family2, child);
        family2 = familyController.adoptChild(family2, child1);
        family2 = familyController.adoptChild(family2, child2);
        family2 = familyController.bornChild(family2, ChildName.Arthur.toString(), ChildName.Mohammed.toString());


        Set<String> habits = new HashSet<>();
        habits.add("very lazy");
        Pet pet = new Dog("Gogo", 2, 60, habits);

        familyController.addPet(0, pet);
        Set<Pet> petSet = familyController.getPets(0);


        List<Family> familyList = familyController.getAllFamilies();
        familyController.displayAllFamilies();

        familyList = familyController.getFamiliesBiggerThan(18);
        familyList = familyController.getFamiliesLessThan(18);
        familyList = familyController.deleteAllChildrenOlderThen(18);

        int count  = familyController.countFamiliesWithMemberNumber(5);
        count = familyController.count();

        boolean result = familyController.deleteFamilyByIndex(0);


    }
}
