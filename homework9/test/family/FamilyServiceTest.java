package family;

import human.ChildName;
import human.Human;
import human.Man;
import human.Woman;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class FamilyServiceTest {
    Human mother = new Woman("Lou", "Loulovich", 35);
    Human father = new Man("Gogo", "Loulovich", 40);
    Human child = new Human("Vovo", "Loulovich", 18);
    Human child2 = new Human("Vovo1", "Loulovich1", 19);
    FamilyDAO familyDAO = CollectionFamilyDao.instanceOf();
    FamilyService familyService = new FamilyService(familyDAO);

    @Before
    public void resetFamilies() {
        for (Iterator<Family> iterator = familyDAO.getAllFamilies().iterator(); iterator.hasNext(); ) {
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
        int expected = 0;
        int actual = familyService.countFamiliesWithMemberNumber(3);
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
        int expected = 3;
        int actual = familyService.countFamiliesWithMemberNumber(2);
        //than
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void countFamiliesWithMemberNumber_whenThereAreNotSuitableFamilies() {
        //given
        familyService.createNewFamily(mother, father);
        //when
        int expected = 0;
        int actual = familyService.countFamiliesWithMemberNumber(3);
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
}