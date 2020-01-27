import java.util.Scanner;

public class Calendar {
    private String[][] scedule;
    private Scanner scanner;

    public Calendar() {
        scanner = new Scanner(System.in);

        scedule = new String[7][2];
        scedule[0][0] = "monday";
        scedule[1][0] = "tuesday";
        scedule[2][0] = "wednesday";
        scedule[3][0] = "thursday";
        scedule[4][0] = "friday";
        scedule[5][0] = "saturday";
        scedule[6][0] = "sunday";
        scedule[0][1] = "Do home work";
        scedule[1][1] = "Go to school";
        scedule[2][1] = "Do work";
        scedule[3][1] = "translate a document";
        scedule[4][1] = "to learn new words";
        scedule[5][1] = "Do home work";
        scedule[6][1] = "Go to courses, watch a film";
    }

    public void start() {
        boolean isNotExit = true;
        while (isNotExit) {
            System.out.print("Please, input the day of the week: ");
            /*
             * 0 - week
             * 1 - change week
             * 2 - exit
             * 3 - incorrect input
             * */
            String enteredData = scanner.nextLine();
            int[] code = getCodeAndIndexWeekend(enteredData);

            switch (code[0]) {
                case 0:
                    System.out.println("Your tasks for " + scedule[code[1]][0] + " : " + scedule[code[1]][1]);
                    break;
                case 1:
                    changeDataDay(code[1]);
                    break;
                case 2:
                    isNotExit = false;
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");

            }
        }
    }

    private void changeDataDay(int indexDay) {
        System.out.print("Please, input new tasks for " + scedule[indexDay][0] + " :");
        scedule[indexDay][1] = scanner.nextLine();
    }

    private int getIndexDay(String day) {
        int response = 0;
        for (int i = 0; i < scedule.length; i++) {
            int temp = scedule[i][0].toLowerCase().indexOf(day.toLowerCase());
            if (temp >= 0) {
                response = i;
            }
        }
        return response;
    }

    private int[] getCodeAndIndexWeekend(String enteredData) {
        int[] response = new int[]{0, 0};
        if (enteredData.matches("(?i)\\b((mon|tues|wed(nes)?|thur(s)?|fri|sat(ur)?|sun)(day)?)\\b\\s?")) {
            response[1] = getIndexDay(enteredData);
        } else if (enteredData.matches("(?i)\\b(change)\\b (?i)\\b((mon|tues|wed(nes)?|thur(s)?|fri|sat(ur)?|sun)(day)?)\\b\\s?")) {
            response[0] = 1;
            response[1] = getIndexDay(enteredData.split(" ")[1]);
        } else if (enteredData.matches("(?i)\\b(exit)\\b")) {
            response[0] = 2;
        } else {
            response[0] = 3;
        }
        return response;
    }

}
