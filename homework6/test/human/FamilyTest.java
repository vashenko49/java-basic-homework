package test.human;


import human.Family;
import human.Human;
import org.junit.Assert;
import org.junit.Test;
import pet.Pet;
import pet.Species;

public class FamilyTest {

    @Test
    public void addExistedChild() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        Human child = new Human("Vovo", "Loulovich", 18);
        //when
        int expectLength = 1;
        family.addChild(child);
        family.addChild(child);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void addChild() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        Human child = new Human("Vovo", "Loulovich", 18);
        //when
        int expectLength = 1;
        family.addChild(child);
        int actualLength = family.getCountChildren();
        boolean isEqualObjects = child.equals(family.getChildren()[0]);
        //than
        Assert.assertEquals(expectLength, actualLength);
        Assert.assertTrue(isEqualObjects);
    }

    @Test
    public void deleteExistedChildByObject() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        Human child = new Human("Vovo", "Loulovich", 18);
        //when
        int expectLength = 0;
        family.addChild(child);
        family.deleteChild(child);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void deleteNoExistedChildByObject() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        Human child = new Human("Vovo", "Loulovich", 18);
        //when
        int expectLength = 0;
        family.deleteChild(child);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void deleteExistedChildByIndex() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        Human child = new Human("Vovo", "Loulovich", 18);
        //when
        int expectLength = 0;
        family.addChild(child);
        family.deleteChild(0);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void deleteNoExistedChildByIndex() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        //when
        int expectLength = 0;
        family.deleteChild(0);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void getCountFamily() {
        //given
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Family family = new Family(mother, father);
        Human child = new Human("Vovo", "Loulovich", 18);
        //when
        int expectCount = 3;
        family.addChild(child);
        int actualCount = family.getCountFamily();
        //than
        Assert.assertEquals(expectCount, actualCount);
    }

    @Test
    public void testToString() {
        //given
        Pet pet = new Pet(Species.DOG, "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Human child = new Human("Vovo", "Loulovich", 18);
        Family family = new Family(mother, father);
        family.addChild(child);
        family.setPet(pet);
        //when
        String expectResult ="Family{mother=Human{name='Lou'surname='Loulovich'year='35'iq='0'}'father=Human{name='Gogo'surname='Loulovich'year='40'iq='0'}'children={Human{name='Vovo'surname='Loulovich'year='18'iq='0'}}, 'pet={nickname='Bobo'age='5'trickLevel='60'habits='[lazy, likes to eat a lot]'species='{species='DOG'hasFur='true'canFly='false'numberOfLegs='4'}''}";
        String actualResult = family.toString();
        //than
        Assert.assertEquals(expectResult, actualResult);
    }

}