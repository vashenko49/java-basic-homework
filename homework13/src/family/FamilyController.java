package family;

import human.Human;
import logger.Logger;
import pet.Pet;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        Logger.info("createNewFamily");
        familyService.createNewFamily(mother, father);
    }

    public boolean deleteFamilyByIndex(int index) {
        Logger.info("deleteFamilyByIndex");
        return familyService.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String male, String female) {
        Family updatedFamily = family;
        try {
            updatedFamily = familyService.bornChild(family, male, female);
            Logger.info("bornChild");
        } catch (FamilyOverflowException ex) {
            Logger.error("Count number family = " + ex.getCountMembersFamily());
        }
        return updatedFamily;
    }

    public Family adoptChild(Family family, Human human) {
        Family updatedFamily = family;
        try {
            updatedFamily = familyService.adoptChild(family, human);
            Logger.info("adoptChild");
        } catch (FamilyOverflowException ex) {
            Logger.error("Count number family = " + ex.getCountMembersFamily());
        }
        return updatedFamily;
    }

    public List<Family> deleteAllChildrenOlderThen(int age) {
        Logger.info("deleteAllChildrenOlderThen");
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
        Logger.info("addPet");
        familyService.addPet(index, newPet);
    }

    public String toString() {
        return familyService.toString();
    }

    public boolean recoverData() {
        return familyService.recoverData();
    }

    public boolean loadData() {
        Logger.info("loadData");
        return familyService.loadData();
    }
}
