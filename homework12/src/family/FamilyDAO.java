package family;

import java.util.List;

public interface FamilyDAO {
    public  List<Family> getAllFamilies();

    public Family getFamilyByIndex(int index);

    public boolean deleteFamilyByIndex(int index);

    public boolean deleteFamily(Family family);

    public void saveFamily(Family family);
}
