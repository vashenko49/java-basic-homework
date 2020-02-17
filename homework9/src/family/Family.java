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

    static {
        System.out.println("Loading a new class family.Family");
    }

    {
        random = new Random();
        children = new ArrayList<>();
        pets = new HashSet<>();
        System.out.println("A new family.Family object is created");
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
        if (children.size()-1>indexOldChild) {
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
    public Human bornChild(String male, String female) {
        Human newHuman;
        if (random.nextBoolean()) {
            newHuman = new Woman(female, father.getSurname(), 0);
        } else {
            newHuman = new Man(male, father.getSurname(), 0);
        }
        newHuman.setFamily(this);
        newHuman.setIq((father.getIq() + mother.getIq()) / 2);
        addChild(newHuman);
        return newHuman;
    }
}
