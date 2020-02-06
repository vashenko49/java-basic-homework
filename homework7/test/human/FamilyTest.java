package human;



import org.junit.Assert;
import org.junit.Test;
import pet.Dog;
import pet.Pet;

public class FamilyTest {
    //given
    Human mother = new Woman("Lou", "Loulovich", 35);
    Human father = new Man("Gogo", "Loulovich", 40);
    Human child = new Human("Vovo", "Loulovich", 18);
    Human child2 = new Human("Vovo1", "Loulovich1", 19);

    @Test
    public void addExistedChild() {
        Family family = new Family(mother, father);
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
        Family family = new Family(mother, father);
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
        Family family = new Family(mother, father);
        //when
        int expectLength = 1;
        family.addChild(child);
        family.addChild(child2);
        family.deleteChild(child);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void deleteNoExistedChildByObject() {
        //given
        Family family = new Family(mother, father);
        //when
        int expectLength = 0;
        family.deleteChild(child);
        family.deleteChild(child2);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void deleteExistedChildByIndex() {
        //given
        Family family = new Family(mother, father);
        //when
        int expectLength = 1;
        family.addChild(child);
        family.addChild(child2);
        family.deleteChild(0);
        int actualLength = family.getCountChildren();
        //than
        Assert.assertEquals(expectLength, actualLength);
    }

    @Test
    public void deleteNoExistedChildByIndex() {
        //given
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
        Family family = new Family(mother, father);
        //when
        int expectCount = 4;
        family.addChild(child);
        family.addChild(child2);
        int actualCount = family.getCountFamily();
        //than
        Assert.assertEquals(expectCount, actualCount);
    }

    @Test
    public void testToString() {
        //given
        Pet pet = new Dog("Gogo",2,60,new String[]{"very lazy"} );
        Family family = new Family(mother, father);
        family.addChild(child);
        family.setPet(pet);
        //when
        String expectResult = "Family{mother=Human{name='Lou'surname='Loulovich'year='35'iq='0'}'father=Human{name='Gogo'surname='Loulovich'year='40'iq='0'}'children={Human{name='Vovo'surname='Loulovich'year='18'iq='0'}}, 'pet={nickname='Gogo'age='2'trickLevel='60'habits='[very lazy]'species='{species='DOG'hasFur='true'canFly='false'numberOfLegs='4'}''}";
        String actualResult = family.toString();
        //than
        Assert.assertEquals(expectResult, actualResult);
    }

    @Test
    public void bornChild(){
        //given
        Family family = new Family(mother, father);
        mother.setIq(76);
        father.setIq(96);
        //when
        int expectLength = 1;
        Human newHuman = family.bornChild();
        int actualLength = family.getCountChildren();
        //than
        Assert.assertTrue(newHuman.getFamily().equals(family));
        Assert.assertEquals(expectLength, actualLength);

    }
}