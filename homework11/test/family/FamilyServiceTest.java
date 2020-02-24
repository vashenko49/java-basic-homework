package family;

import human.ChildName;
import human.Human;
import human.Man;
import human.Woman;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pet.Dog;
import pet.Pet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FamilyServiceTest {
    Human mother = new Woman("Lou", "Loulovich", 35);
    Human father = new Man("Gogo", "Loulovich", 40);
    Human child = new Human("Vovo", "Loulovich", 18);
    Human child2 = new Human("Vovo1", "Loulovich1", 25);
    Human child3 = new Human("Vovo2", "Loulovich", 18);
    FamilyDAO familyDAO = CollectionFamilyDao.instanceOf();
    FamilyService familyService = new FamilyService(familyDAO);


    @Before
    public void resetFamilies() {
        List<Family> allFamilies = familyDAO.getAllFamilies();
        Iterator<Family> iterator = allFamilies.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }


    @Test
    public void checkGetAllFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        //when
        int expectedSize = 3;
        int actualSize = familyService.count();
        //than
        Assert.assertEquals(expectedSize, actualSize);
    }


    @Test
    public void getFamiliesBiggerThan_whenNoFamilies() {
        //given

        //when
        int expected = 0;
        List<Family> familyList = familyService.getFamiliesBiggerThan(3);
        //than
        Assert.assertEquals(expected, familyList.size());
    }

    @Test
    public void getFamiliesBiggerThan_whenThereAreNotSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        //when
        int expected = 0;
        List<Family> familyList = familyService.getFamiliesBiggerThan(3);
        //than
        Assert.assertEquals(expected, familyList.size());
    }


    @Test
    public void getFamiliesBiggerThan_whenThereAreSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);

        familyService.bornChild(familyService.getFamilyByIndex(1), ChildName.Alexander.toString(), ChildName.Henry.toString());
        familyService.bornChild(familyService.getFamilyByIndex(1), ChildName.Archie.toString(), ChildName.George.toString());

        //when
        int expected = 1;
        List<Family> familyList = familyService.getFamiliesBiggerThan(3);
        //than
        Assert.assertEquals(expected, familyList.size());
    }

    @Test
    public void getFamiliesLessThan_whenNoFamilies() {
        //given

        //when
        int expected = 0;
        List<Family> familyList = familyService.getFamiliesLessThan(3);
        //than
        Assert.assertEquals(expected, familyList.size());
    }

    @Test
    public void getFamiliesLessThan_whenThereAreSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        //when
        int expected = 3;
        List<Family> familyList = familyService.getFamiliesLessThan(3);
        //than
        Assert.assertEquals(expected, familyList.size());
    }


    @Test
    public void getFamiliesLessThan_whenThereAreNotSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);

        familyService.bornChild(familyService.getFamilyByIndex(1), ChildName.Alexander.toString(), ChildName.Henry.toString());
        familyService.bornChild(familyService.getFamilyByIndex(1), ChildName.Archie.toString(), ChildName.George.toString());

        //when
        int expected = 2;
        List<Family> familyList = familyService.getFamiliesLessThan(3);
        //than
        Assert.assertEquals(expected, familyList.size());
    }

    @Test
    public void countFamiliesWithMemberNumber_whenNoFamilies() {
        //given
        //when
        long expected = 0;
        long actual = familyService.countFamiliesWithMemberNumber(3);
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countFamiliesWithMemberNumber_whenThereAreSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        //when
        long expected = 3;
        long actual = familyService.countFamiliesWithMemberNumber(2);
        //than
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void countFamiliesWithMemberNumber_whenThereAreNotSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        long expected = 0;
        long actual = familyService.countFamiliesWithMemberNumber(3);
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createNewFamily_CheckFatherAndMother() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        Human motherFromService = familyService.getFamilyByIndex(0).getMother();
        Human fatherFromService = familyService.getFamilyByIndex(0).getFather();
        //than
        Assert.assertEquals(mother, motherFromService);
        Assert.assertEquals(father, fatherFromService);
    }

    @Test
    public void deleteFamilyByIndex_indexMoreNumberFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        //when
        boolean result = familyService.deleteFamilyByIndex(3);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void deleteFamilyByIndex_noFamilies() {
        //given
        //when
        boolean result = familyService.deleteFamilyByIndex(0);
        //than
        Assert.assertFalse(result);
    }

    @Test
    public void deleteFamilyByIndex_isSuitableFamily() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        //when
        boolean result = familyService.deleteFamilyByIndex(0);
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void bornChild_checkANewChildren() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        familyService.bornChild(familyService.getFamilyByIndex(0), ChildName.Alexander.toString(), ChildName.Alfie.toString());
        int expected = 1;
        int actual = familyService.getFamilyByIndex(0).getChildren().size();
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void adoptChild_checkNewChildren() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        familyService.adoptChild(familyService.getFamilyByIndex(0), child);
        //than
        Assert.assertEquals(child, familyService.getFamilyByIndex(0).getChildren().get(0));
    }

    @Test
    public void deleteAllChildrenOlderThen_thereAreSuitableChildren() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.adoptChild(familyService.getFamilyByIndex(0), child);
        familyService.adoptChild(familyService.getFamilyByIndex(0), child2);
        //when
        List<Family> newFamilyList = familyService.deleteAllChildrenOlderThen(20);
        int expected = 1;
        int actual = newFamilyList.get(0).getChildren().size();
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAllChildrenOlderThen_thereAreNotSuitableChildren() {
        //given
        familyService.createNewFamily(mother, father);
        familyService.adoptChild(familyService.getFamilyByIndex(0), child);
        familyService.adoptChild(familyService.getFamilyByIndex(0), child3);
        //when
        List<Family> newFamilyList = familyService.deleteAllChildrenOlderThen(20);
        int expected = 2;
        int actual = newFamilyList.get(0).getChildren().size();
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAllChildrenOlderThen_noFamilies() {
        //given
        //when
        List<Family> newFamilyList = familyService.deleteAllChildrenOlderThen(20);
        int expected = 0;
        int actual = newFamilyList.size();
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteAllChildrenOlderThen_noChildrenInFamily() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        List<Family> newFamilyList = familyService.deleteAllChildrenOlderThen(20);
        int expected = 0;
        int actual = newFamilyList.get(0).getChildren().size();
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void count_check() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        int expected = 1;
        int actual = familyService.count();
        //than
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFamilyByIndex_checkEqual() {
        //given
        familyService.createNewFamily(mother, father);
        Family family = new Family(mother, father);
        //when
        boolean result = family.equals(familyService.getFamilyByIndex(0));
        //than
        Assert.assertTrue(result);
    }

    @Test
    public void addPetAndGetPet_checkPushANewPet() {
        //given
        familyService.createNewFamily(mother, father);
        Set<String> habits = new HashSet<>();
        habits.add("very lazy");
        Pet pet = new Dog("Gogo", 2, 60, habits);
        Set<Pet> petSet = new HashSet<>();
        petSet.add(pet);
        //when
        familyService.addPet(0, pet);
        boolean result = familyService.getPets(0).equals(petSet);
        //than
        Assert.assertTrue(result);
    }

}