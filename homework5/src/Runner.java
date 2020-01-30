public class Runner {
    public static void main(String[] args) {
        String[][] schedule = new String[][]{{"mon", "go to school"}, {"tue", "go to school"}, {"wed", "go to school"}, {"thur", "go to school"}, {"fri", "go to school"}, {"Thr", "go home"}, {"sun", "go home"}};
        Pet pet = new Pet("dog", "Bobo", 5, 60, new String[]{"lazy", "likes to eat a lot"});
        Human mother = new Human("Lou", "Loulovich", 35);
        Human father = new Human("Gogo", "Loulovich", 40);
        Human child = new Human("Vovo", "Loulovich", 18, 96, schedule);
    }
}
