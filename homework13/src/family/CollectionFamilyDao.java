package family;

import logger.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CollectionFamilyDao implements FamilyDAO {

    private static final CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();
    private List<Family> families = new ArrayList<>();

    private CollectionFamilyDao() {
    }

    public static CollectionFamilyDao instanceOf() {
        return collectionFamilyDao;
    }

    @Override
    public List<Family> getAllFamilies() {
        Logger.info("getAllFamilies");
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        Logger.info("getFamilyByIndex " + index);
        return families.get(index);
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        Logger.info("deleteFamilyByIndex " + index);
        return families.remove(index) != null;
    }

    @Override
    public boolean deleteFamily(Family family) {
        Logger.info("deleteFamily");
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        Logger.info("saveFamily");
        families.add(family);
    }

    @Override
    public boolean loadData() {
        if (families.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
                objectOutputStream.writeObject(families);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();
            try (OutputStream outputStream = new FileOutputStream("families")) {
                Logger.info("loadData");
                outputStream.write(bytes);
            } catch (IOException e) {
                Logger.error("Ошибка сохранения");
                return false;
            }

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean recoverData() {
        File file = new File("families");

        if (file.isFile()) {
            try (InputStream inputStream = new FileInputStream(file)) {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                families.addAll((ArrayList<Family>) objectInputStream.readObject());
                Logger.info("recoverData");
            } catch (IOException | ClassNotFoundException e) {
                Logger.error("Ошибка восстановления");
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
