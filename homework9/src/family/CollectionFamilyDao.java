package family;

import java.util.ArrayList;
import java.util.List;

public final class CollectionFamilyDao implements FamilyDAO{
    private static final CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();
    private  List<Family> families = new ArrayList<>();

    private CollectionFamilyDao() {
    }

    public static CollectionFamilyDao instanceOf() {
        return collectionFamilyDao;
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        return families.remove(index) != null;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        families.add(family);
    }
}
