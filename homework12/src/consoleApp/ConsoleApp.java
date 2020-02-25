package consoleApp;

import family.CollectionFamilyDao;
import family.FamilyDAO;
import family.FamilyService;
import human.ChildName;
import human.Human;
import human.Man;
import human.Woman;

import java.util.*;

public class ConsoleApp {
    private final Scanner scanner;
    private final FamilyDAO familyDAO;
    private final FamilyService familyService;
    private final List<OperationApp> comm;
    private boolean isExit = true;

    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
        familyDAO = CollectionFamilyDao.instanceOf();
        familyService = new FamilyService(familyDAO);

        comm = Arrays.asList(
                new OperationApp("Заполнить тестовыми данными", this::fillWithTestData),
                new OperationApp("Отобразить весь список семей", this::printFamilyList),
                new OperationApp("Отобразить список семей, где количество людей больше заданного", this::printFamiliesBiggerThan),
                new OperationApp("Отобразить список семей, где количество людей меньше заданного", this::privateFamiliesLessThan),
                new OperationApp("Подсчитать количество семей, где количество членов равно", this::printCountFamiliesWithMemberNumber),
                new OperationApp("Создать новую семью", this::createNewFamily),
                new OperationApp("Удалить семью по индексу семьи в общем списке", this::removeFamilyByIndex),
                new OperationApp("Редактировать семью по индексу семьи в общем списке", this::editFamilyByIndex),
                new OperationApp("Удалить всех детей старше возраста", this::deleteAllChildrenOlderThen),
                new OperationApp("Выход", this::exitTheApplication)
        );
    }


    public void run() {
        isExit = true;
        while (isExit) {
            printCommand();
            String command = scanner.next();
            if (isNumeric(command, 1, comm.size())) {
                OperationApp operationApp = comm.get(Integer.parseInt(command)-1);
                System.out.println(operationApp.operationName);
                operationApp.operation.operation();
                System.out.println("\n");
            } else {
                System.out.println("Enter valid data");
            }
        }
    }


    private void printCommand() {
        for (int i = 0; i < comm.size(); i++) {
            System.out.println(i + 1 + " - " + comm.get(i).operationName);
        }
        System.out.print("Print command -> ");
    }

    public static boolean isNumeric(String strNum, int from, int to) {
        return strNum.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(strNum) >= from && Integer.parseInt(strNum) <= to;
    }


    private void exitTheApplication() {
        isExit = false;
    }

    private void fillWithTestData() {
        Human mother = new Woman("Lou", "Loulovich", 35);
        Human father = new Man("Gogo", "Loulovich", 40);
        familyService.createNewFamily(mother, father);
        familyService.createNewFamily(mother, father);
        familyService.bornChild(familyService.getFamilyByIndex(0), ChildName.Alexander.toString(), ChildName.Henry.toString());
        familyService.bornChild(familyService.getFamilyByIndex(0), ChildName.Arthur.toString(), ChildName.Archie.toString());
        familyService.bornChild(familyService.getFamilyByIndex(1), ChildName.Arthur.toString(), ChildName.Archie.toString());
    }

    private void printFamilyList() {
        System.out.println("1");
    }

    private void printFamiliesBiggerThan() {

    }

    private void privateFamiliesLessThan() {

    }

    private void printCountFamiliesWithMemberNumber() {

    }

    public void createNewFamily() {

    }

    private void removeFamilyByIndex() {

    }

    private void editFamilyByIndex() {

    }

    private void deleteAllChildrenOlderThen() {

    }
}
