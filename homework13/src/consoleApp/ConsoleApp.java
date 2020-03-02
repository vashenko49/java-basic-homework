package consoleApp;

import family.*;
import human.Human;
import human.Man;
import human.Woman;

import java.util.*;

public class ConsoleApp {
    private final Scanner scanner;
    private final FamilyController familyController;
    private final List<OperationApp> comm;
    private final List<OperationApp> editFamily;
    private boolean isExit = true;
    private boolean isReturnToMainMenu = true;

    public ConsoleApp() {
        this.scanner = new Scanner(System.in);
        FamilyDAO familyDAO = CollectionFamilyDao.instanceOf();
        FamilyService familyService = new FamilyService(familyDAO);
        familyController = new FamilyController(familyService);

        comm = Arrays.asList(
                new OperationApp("Восстановить данные", this::recoverData),
                new OperationApp("Отобразить весь список семей", this::printFamilyList),
                new OperationApp("Отобразить список семей, где количество людей больше заданного", this::printFamiliesBiggerThan),
                new OperationApp("Отобразить список семей, где количество людей меньше заданного", this::privateFamiliesLessThan),
                new OperationApp("Подсчитать количество семей, где количество членов равно", this::printCountFamiliesWithMemberNumber),
                new OperationApp("Создать новую семью", this::createNewFamily),
                new OperationApp("Удалить семью по индексу семьи в общем списке", this::removeFamilyByIndex),
                new OperationApp("Редактировать семью по индексу семьи в общем списке", this::editFamilyByIndex),
                new OperationApp("Удалить всех детей старше возраста", this::deleteAllChildrenOlderThen),
                new OperationApp("Сохранить данные", this::saveData),
                new OperationApp("Выход", this::exitTheApplication)
        );

        editFamily = Arrays.asList(
                new OperationApp("Родить ребенка", this::bornChild),
                new OperationApp("Усыновить ребенка", this::adoptChild),
                new OperationApp("Вернуться в главное меню", this::returnToMainMenu)
        );
    }


    public void run() {
        isExit = true;
        while (isExit) {
            printCommand(comm);
            OperationApp operationApp = comm.get(scanInteger(1, comm.size()) - 1);
            System.out.println(operationApp.operationName);
            operationApp.operation.operation();
        }
    }

    private void printCommand(List<OperationApp> command) {
        for (int i = 0; i < command.size(); i++) {
            System.out.println(i + 1 + " - " + command.get(i).operationName);
        }
        System.out.print("Print command -> ");
    }

    public static boolean isNumeric(String strNum, int from, int to) {
        return strNum.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(strNum) >= from && Integer.parseInt(strNum) <= to;
    }

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    public int scanInteger() {
        String integer = scanner.next();
        boolean isValid = isNumeric(integer);
        while (!isValid) {
            integer = scanner.next();
            isValid = isNumeric(integer);
            System.out.println("Enter valid data");
        }

        return Integer.parseInt(integer);
    }

    public int scanInteger(int from, int to) {
        String integer = scanner.next();
        boolean isValid = isNumeric(integer, from, to);
        while (!isValid) {
            System.out.print("Enter valid data -> ");
            integer = scanner.next();
            isValid = isNumeric(integer);
        }

        return Integer.parseInt(integer);
    }

    private void saveData() {
        if (familyController.saveDataToFile()) {
            System.out.println("Сохранение удачное");
        } else {
            System.out.println("Сохранение провалилось");
        }
    }

    private void exitTheApplication() {
        isExit = false;
    }

    private void returnToMainMenu() {
        isReturnToMainMenu = false;
    }

    private void recoverData() {
        if (familyController.loadData()) {
            System.out.println("Восстановление удачное");
        } else {
            System.out.println("Восстановление провалилось");
        }
    }

    private void printFamilyList() {
        System.out.println(familyController.toString());
    }

    private void printFamiliesBiggerThan() {
        System.out.print("Больше чем -> ");
        List<Family> familyList = familyController.getFamiliesBiggerThan(scanInteger());
        for (Family family : familyList) {
            System.out.println(family.prettyFormat());
        }
    }

    private void privateFamiliesLessThan() {
        System.out.print("Меньше чем -> ");
        List<Family> familyList = familyController.getFamiliesLessThan(scanInteger());
        for (Family family : familyList) {
            System.out.println(family.prettyFormat());
        }
    }

    private void printCountFamiliesWithMemberNumber() {
        System.out.print("Равно -> ");
        System.out.println("Количество семей -> " + familyController.countFamiliesWithMemberNumber(scanInteger()));
    }

    public void createNewFamily() {
        System.out.print("имя матери -> ");
        String motherName = scanner.next();
        System.out.print("фамилия матери -> ");
        String motherSurname = scanner.next();
        System.out.print("год рождения матери -> ");
        String motherYear = scanner.next();
        System.out.print("месяц рождения матери -> ");
        String motherMonth = scanner.next();
        System.out.print("день рождения матери -> ");
        String motherDay = scanner.next();
        System.out.print("iq матери -> ");
        int motherIQ = scanInteger();

        System.out.print("имя отца -> ");
        String fatherName = scanner.next();
        System.out.print("фамилия отца -> ");
        String fatherSurname = scanner.next();
        System.out.print("год рождения отца -> ");
        String fatherYear = scanner.next();
        System.out.print("месяц рождения отца -> ");
        String fatherMonth = scanner.next();
        System.out.print("день рождения отца -> ");
        String fatherDay = scanner.next();
        System.out.print("iq отца -> ");
        int fatherIQ = scanInteger();

        familyController.createNewFamily(
                new Woman(motherName, motherSurname, (motherDay + "/" + motherMonth + "/" + motherYear), motherIQ),
                new Man(fatherName, fatherSurname, (fatherDay + "/" + fatherMonth + "/" + fatherYear), fatherIQ)
        );
    }

    private void editFamilyByIndex() {
        isReturnToMainMenu = true;
        while (isReturnToMainMenu) {
            printCommand(editFamily);
            OperationApp operationApp = editFamily.get(scanInteger(1, editFamily.size()) - 1);
            System.out.println(operationApp.operationName);
            operationApp.operation.operation();
        }
    }

    private void removeFamilyByIndex() {
        System.out.print("Индекс -> ");
        boolean result = familyController.deleteFamilyByIndex(scanInteger());
        if (result) {
            System.out.println("Успешно");
        } else {
            System.out.println("Ошибка");
        }
    }

    private void deleteAllChildrenOlderThen() {
        System.out.print("старше чем -> ");
        List<Family> familyList = familyController.deleteAllChildrenOlderThen(scanInteger());
        for (Family family : familyList) {
            System.out.println(family.prettyFormat());
        }
    }

    private void bornChild() {
        System.out.print("Индекс семьи -> ");
        int indexFamily = scanInteger();
        System.out.print("Имя мальчика -> ");
        String boyName = scanner.next();
        System.out.print("Имя девочки -> ");
        String girlName = scanner.next();

        Family family = familyController.getFamilyByIndex(indexFamily);

        if (Objects.nonNull(family)) {
            System.out.println(familyController.bornChild(family, girlName, boyName).prettyFormat());
        }

    }

    private void adoptChild() {
        System.out.print("Индекс семьи -> ");
        int indexFamily = scanInteger();
        System.out.print("имя ребенка -> ");
        String childName = scanner.next();
        System.out.print("фамилия ребенка -> ");
        String childSurname = scanner.next();
        System.out.print("год рождения ребенка -> ");
        String childYear = scanner.next();
        System.out.print("месяц рождения ребенка -> ");
        String childMonth = scanner.next();
        System.out.print("день рождения ребенка -> ");
        String childDay = scanner.next();
        System.out.print("iq ребенка -> ");
        int childIQ = scanInteger();
        System.out.println("Пол ребенка 1-мальчик, 2-девочка");
        int gender = scanInteger(1, 2);

        Family family = familyController.getFamilyByIndex(indexFamily);

        if (Objects.nonNull(family)) {
            Human newHuman;
            if (gender == 1) {
                newHuman = new Man(childName, childSurname, (childDay + "/" + childMonth + "/" + childYear), childIQ);
            } else {
                newHuman = new Woman(childName, childSurname, (childDay + "/" + childMonth + "/" + childYear), childIQ);
            }

            System.out.println(familyController.adoptChild(family, newHuman).prettyFormat());
        }
    }
}
