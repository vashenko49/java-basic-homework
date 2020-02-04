package test.pet;


import org.junit.Assert;
import org.junit.Test;
import pet.*;

public class PetTest {

    @Test
    public void petEqualityCheck() {
        //given
        Pet pet = new Pet(Species.DOG, "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        Pet pet1 = new Pet(Species.DOG, "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        //when
        boolean result = pet.equals(pet1);
        //than
        Assert.assertTrue(result);
    }
    @Test
    public void petNoEqualityCheck() {
        //given
        Pet pet = new Pet(Species.CAT, "Gogo", 5, 60, new String[]{"lazy", "likes to eat a lot", "very hungry"});
        Pet pet1 = new Pet(Species.DOG, "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        //when
        boolean result = pet.equals(pet1);
        //than
        Assert.assertFalse(result);
    }
}