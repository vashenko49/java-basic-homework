package family;

import human.*;
import pet.Pet;

import java.util.*;

public class Family implements HumanCreator {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Random random;
    private Set<Pet> pets;

    {
        random = new Random();
        children = new ArrayList<>();
        pets = new HashSet<>();
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

    public List<Human> getChildren() {
        return children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet newPet) {
        if (newPet != null) {
            pets.add(newPet);
        }
    }

    public void addChild(Human newChild) {
        if (newChild != null && !children.contains(newChild)) {
            children.add(newChild);
        }
    }

    public void deletePet(Pet oldPet) {
        if (oldPet != null) {
            pets.remove(oldPet);
        }
    }

    public void deleteChild(Human oldChild) {
        if (oldChild != null) {
            children.remove(oldChild);
        }
    }

    public void deleteChild(int indexOldChild) {
        if (children.size() - 1 > indexOldChild) {
            children.remove(indexOldChild);
        }
    }

    public int getCountFamily() {
        return children.size() + 2;
    }

    public int getCountChildren() {
        return children.size();
    }


    @Override
    public String toString() {
        return "Family{" + "mother=" +
                mother.toString() +
                '\'' +
                "father=" +
                father.toString() +
                '\'' +
                "children=" +
                "{" +
                children.toString() +
                "}" +
                '\'' +
                "pet=" +
                pets.toString() +
                '\'' +
                "}";
    }

    public String prettyFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("family:\n");
        stringBuilder.append("\tmother: ");
        stringBuilder.append(getMother().prettyFormat());
        stringBuilder.append("\n");
        stringBuilder.append("\tfather: ");
        stringBuilder.append(getFather().prettyFormat());
        stringBuilder.append("\n");
        stringBuilder.append("\t\tchildren: \n");
        for (Human child : getChildren()) {
            if (child instanceof Woman) {
                stringBuilder.append("\t\t\tgirl: ");
            } else {
                stringBuilder.append("\t\t\tboy: ");
            }
            stringBuilder.append(child.prettyFormat());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\tpets: ");
        stringBuilder.append(pets.toString());
        stringBuilder.append("\n");
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
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                children.equals(family.children) &&
                pets.equals(family.pets);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(father, pets);
        result = 31 * result + children.hashCode();
        return result;
    }

    @Override
    public Human bornChild(String female, String male) {
        Human newHuman;
        if (random.nextBoolean()) {
            newHuman = new Woman(female, father.getSurname(), System.currentTimeMillis());
        } else {
            newHuman = new Man(male, father.getSurname(), System.currentTimeMillis());
        }
        newHuman.setFamily(this);
        newHuman.setIq((father.getIq() + mother.getIq()) / 2);
        addChild(newHuman);
        return newHuman;
    }
}
