package family;

import human.Human;
import pet.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FamilyService {
    private FamilyDAO familyDao;

    public FamilyService(FamilyDAO familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        System.out.println(familyDao.getAllFamilies().toString());
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> familyFiltered = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.getCountFamily() > number) {
                System.out.println(family);
                familyFiltered.add(family);
            }
        }
        return familyFiltered;
    }

    public List<Family> getFamiliesLessThan(int number) {
        List<Family> familyFiltered = new ArrayList<>();
        for (Family family : familyDao.getAllFamilies()) {
            if (family.getCountFamily() < number) {
                System.out.println(family);
                familyFiltered.add(family);
            }
        }
        return familyFiltered;
    }

    public int countFamiliesWithMemberNumber(int number) {
        int count = 0;
        for (Family family : familyDao.getAllFamilies()) {
            if (number == family.getCountFamily()) {
                count++;
            }
        }
        return count;
    }

    public void createNewFamily(Human mother, Human father) {
        familyDao.saveFamily(new Family(mother, father));
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyDao.deleteFamilyByIndex(index);
    }

    public Family bornChild(Family family, String male, String female) {
        family.bornChild(male, female);
        return family;
    }
    public  Family adoptChild(Family family, Human human){
        family.addChild(human);
        return family;
    }
    public List<Family> deleteAllChildrenOlderThen(int age){
        for (Family family : familyDao.getAllFamilies()) {
            for (Human child : family.getChildren()) {
                if(child.getYear()>age){
                    family.deleteChild(child);
                    familyDao.saveFamily(family);
                }
            }
        }
        return familyDao.getAllFamilies();
    }

    public int count(){
        return familyDao.getAllFamilies().size();
    }
    public Family getFamilyByIndex(int index){
        return  familyDao.getFamilyByIndex(index);
    }
    public Set<Pet> getPets(int index){
        return familyDao.getFamilyByIndex(index).getPets();
    }
    public void  addPet(int index, Pet newPet){
        familyDao.getFamilyByIndex(index).addPet(newPet);
    }


}
