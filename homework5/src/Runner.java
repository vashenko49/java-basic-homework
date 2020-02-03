public class Runner {
    public static void main(String[] args) {
        String[][] schedule = new String[][]{{"mon", "go to school"}, {"tue", "go to school"}, {"wed", "go to school"}, {"thur", "go to school"}, {"fri", "go to school"}, {"Thr", "go home"}, {"sun", "go home"}};
        Pet pet = new Pet("dog", "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Human child = new Human("Vovo", "Loulovich", 18, 96, schedule);
        Human child2 = new Human("Vovo2", "Loulovich2", 20, 96, schedule);
        Human child3 = new Human("Vovo3", "Loulovich3", 20, 96, schedule);
        Human child4 = new Human("Vovo4", "Loulovic4", 20, 96, schedule);
        Human child5 = new Human("Vovo5", "Loulovic5", 20, 96, schedule);
        Human child6 = new Human("Vovo6", "Loulovic6", 20, 96, schedule);

        Family family = new Family(mother, father);
        family.setPet(pet);
        family.addChild(child);
        family.addChild(child2);
        family.addChild(child3);
        family.addChild(child4);
        family.addChild(child5);
        family.addChild(child6);
        System.out.println("-->");
        family.deleteChild(child4);
        family.deleteChild(child);
        family.deleteChild(child2);
        family.deleteChild(child3);

        System.out.println(family.getCountFamily());
        System.out.println(family.toString());
    }
}
