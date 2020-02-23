package pet;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class PetTest {

    @Test
    public void petEqualityCheck() {
        //given
        Set<String> habits = new HashSet<>();
        habits.add("very lazy");
        Pet pet = new Dog("Gogo",2,60,habits );
        Pet pet1 = new Dog("Gogo",2,60,habits );
        //when
        boolean result = pet.equals(pet1);
        //than
        Assert.assertTrue(result);
    }
    @Test
    public void petNoEqualityCheck() {
        //given
        Set<String> habits = new HashSet<>();
        habits.add("very lazy");
        Pet pet = new Dog("Gogo",2,60,habits);
        Pet pet1 = new DomesticCat("Gogo",2,60,habits);
        //when
        boolean result = pet.equals(pet1);
        //than
        Assert.assertFalse(result);
    }
}