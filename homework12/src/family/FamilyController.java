package family;

import human.Human;
import pet.Pet;

import java.util.List;
import java.util.Set;

public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return familyService.getFamiliesBiggerThan(number);
    }

    public List<Family> getFamiliesLessThan(int number) {
        return familyService.getFamiliesLessThan(number);
    }

    public long countFamiliesWithMemberNumber(int number) {
        return familyService.countFamiliesWithMemberNumber(number);
    }

    public void createNewFamily(Human mother, Human father) {
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String male, String female) {
        Family updatedFamily = family;
        try {
            updatedFamily = familyService.bornChild(family, male, female);
        } catch (FamilyOverflowException ex) {
            System.out.println("Count number family = " + ex.getCountMembersFamily());
            ex.printStackTrace();
        }
        return updatedFamily;
    }

    public Family adoptChild(Family family, Human human) {
        Family updatedFamily = family;
        try {
            updatedFamily =  familyService.adoptChild(family, human);
        } catch (FamilyOverflowException ex) {
            System.out.println("Count number family = " + ex.getCountMembersFamily());
            ex.printStackTrace();
        }
        return updatedFamily;
    }

    public List<Family> deleteAllChildrenOlderThen(int age) {
        return familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int index, Pet newPet) {
        familyService.addPet(index, newPet);
    }
}
