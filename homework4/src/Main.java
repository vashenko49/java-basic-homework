public class Main {
    public static void main(String[] args) {
        String[][] schedule = new String[][]{{"mon", "go to school"}, {"tue", "go to school"}, {"wed", "go to school"}, {"thur", "go to school"}, {"fri", "go to school"}, {"Thr", "go home"}, {"sun", "go home"}};
        Pet pet = new Pet("dog", "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Human child = new Human("Vovo", "Loulovich", 18, 96, pet, mother, father, schedule);
        System.out.println("< child ------------------->");
        child.describePet();
        child.greetPet();
        System.out.println(child.feedPet(false));
        System.out.println(child.feedPet(true));
        System.out.println(child.toString());
        System.out.println("< pet ------------------->");
        System.out.println(pet.toString());
        pet.eat();
        pet.respond();
        pet.foul();
        System.out.println("< mother ------------------->");
        System.out.println(mother.toString());
        System.out.println("< father ------------------->");
        System.out.println(father.toString());

        System.out.println("< empty ------------------->");
        Human empty = new Human();
        System.out.println(empty.toString());

        System.out.println("< child 2 ------------------->");
        Human child2 = new Human("Vovo", "Loulovich",20, mother, empty);
        System.out.println(child2.toString());
    }
}
