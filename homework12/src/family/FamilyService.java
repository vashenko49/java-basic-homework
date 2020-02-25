package family;

import human.Human;
import pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDAO familyDao;

    public FamilyService(FamilyDAO familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyDao.getAllFamilies().forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.getCountFamily() > number)
                .collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int number) {
        return familyDao.getAllFamilies().stream()
                .filter(f -> f.getCountFamily() < number)
                .collect(Collectors.toList());
    }

    public long countFamiliesWithMemberNumber(int number) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(f -> f.getCountFamily() == number)
                .count();

    }

    public void createNewFamily(Human mother, Human father) {
        familyDao.saveFamily(new Family(mother, father));
    }

    public boolean deleteFamilyByIndex(int index) {
        if (index < familyDao.getAllFamilies().size()) {
            return familyDao.deleteFamilyByIndex(index);
        }
        return false;
    }

    public Family bornChild(Family family, String male, String female) {
        if (family.getCountFamily() > 5) {
            throw new FamilyOverflowException("the number of family members cannot exceed 5", family.getCountFamily());
        }
        family.bornChild(male, female);
        return family;
    }

    public Family adoptChild(Family family, Human human) {
        if (family.getCountFamily() > 5) {
            throw new FamilyOverflowException("the number of family members cannot exceed 5", family.getCountFamily());
        }
        family.addChild(human);
        return family;
    }

    public List<Family> deleteAllChildrenOlderThen(int age) {
        return  familyDao.getAllFamilies()
                .stream()
                .peek(f->f.getChildren().removeIf(h->h.getYear()>age))
                .collect(Collectors.toList());
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyByIndex(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public void addPet(int index, Pet newPet) {
        familyDao.getFamilyByIndex(index).addPet(newPet);
    }

    public Set<Pet> getPets(int index) {
        return familyDao.getFamilyByIndex(index).getPets();
    }
}
