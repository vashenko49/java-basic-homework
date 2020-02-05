
package human;

import pet.Pet;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator {
    private final int COUNT_MEMBERS = 5;
    private Human mother;
    private Human father;
    private Human[] children;
    private Random random;
    private Pet pet;
    private int indexArrayChild;

    static {
        System.out.println("Loading a new class human.Family");
    }

    {
        random = new Random();
        children = new Human[COUNT_MEMBERS];
        indexArrayChild = 0;
        System.out.println("A new human.Family object is created");
    }

    public Family(Human mother, Human father) {
        mother.setFamily(this);
        father.setFamily(this);
        this.mother = mother;
        this.mother.setFamily(this);
        this.father = father;
        this.father.setFamily(this);
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human[] getChildren() {
        Human[] cutArray = new Human[indexArrayChild];
        System.arraycopy(children, 0, cutArray, 0, indexArrayChild);
        return cutArray;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human newChild) {
        if (newChild != null && findChildByIndex(newChild) < 0) {
            if (children.length * 0.8 < indexArrayChild) {
                expandArray();
            }
            children[indexArrayChild] = newChild;
            children[indexArrayChild].setFamily(this);
            indexArrayChild++;
        }
    }

    public void deleteChild(Human oldChild) {
        int indexChildren = findChildByIndex(oldChild);
        if (oldChild != null && indexChildren >= 0) {
            shiftArrayChild(indexChildren);
        }
    }

    public void deleteChild(int indexOldChild) {
        if (indexOldChild < indexArrayChild && children[indexOldChild] != null) {
            shiftArrayChild(indexOldChild);
        }
    }

    private void shiftArrayChild(int startIndex) {
        for (int i = startIndex; i < children.length - 1; i++) {
            if (children[i] != null) {
                indexArrayChild = i;
            }
            children[i] = children[i + 1];
        }
        if (children.length * 0.8 > indexArrayChild) {
            reduceArray();
        }
    }

    public int getCountFamily() {
        return indexArrayChild + 2;
    }

    public int getCountChildren() {
        return indexArrayChild;
    }

    private int findChildByIndex(Human child) {
        if (child == null) {
            return -1;
        }

        int result = -1;
        for (int i = 0; i < indexArrayChild; i++) {
            if (children[i].equals(child)) {
                result = i;
                break;
            }
        }
        return result;
    }

    private void expandArray() {
        Human[] newArray = new Human[children.length * 2];
        System.arraycopy(children, 0, newArray, 0, children.length);
        children = newArray;
    }

    private void reduceArray() {
        int newLength = (int) (children.length * 0.8);
        Human[] newArray = new Human[newLength];
        System.arraycopy(children, 0, newArray, 0, newLength);
        children = newArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Family{");
        stringBuilder.append("mother=");
        stringBuilder.append(mother.toString());
        stringBuilder.append('\'');
        stringBuilder.append("father=");
        stringBuilder.append(father.toString());
        stringBuilder.append('\'');


        stringBuilder.append("children=");
        if (children != null && indexArrayChild > 0) {
            for (int i = 0; i < indexArrayChild; i++) {
                stringBuilder.append("{");
                stringBuilder.append(children[i].toString());
                stringBuilder.append("}");
                if (i != children.length - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.append('\'');

        stringBuilder.append("pet=");
        stringBuilder.append(pet.toString());
        stringBuilder.append('\'');

        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(toString());
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return indexArrayChild == family.indexArrayChild &&
                mother.equals(family.mother) &&
                father.equals(family.father) &&
                Arrays.equals(children, family.children) &&
                pet.equals(family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(father, pet, indexArrayChild);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public Human bornChild() {
        String name = ChildName.values()[random.nextInt(ChildName.values().length)].name();
        Human newHuman;
        if(random.nextBoolean()){
            newHuman = new Woman(name, father.getSurname(), 0);
        }else {
            newHuman= new Man(name, father.getSurname(), 0);
        }
        newHuman.setFamily(this);
        newHuman.setIq((father.getIq()+mother.getIq())/2);
        addChild(newHuman);
        return newHuman;
    }
}
