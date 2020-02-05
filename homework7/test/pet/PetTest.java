package pet;


import org.junit.Assert;
import org.junit.Test;
import pet.*;

public class PetTest {

    @Test
    public void petEqualityCheck() {
        //given
        Pet pet = new Dog("Gogo",2,60,new String[]{"very lazy"} );
        Pet pet1 = new Dog("Gogo",2,60,new String[]{"very lazy"} );
        //when
        boolean result = pet.equals(pet1);
        //than
        Assert.assertTrue(result);
    }
    @Test
    public void petNoEqualityCheck() {
        //given
        Pet pet = new Dog("Gogo",2,60,new String[]{"very lazy"} );
        Pet pet1 = new DomesticCat("Gogo",2,60,new String[]{"very lazy"} );
        //when
        boolean result = pet.equals(pet1);
        //than
        Assert.assertFalse(result);
    }
}