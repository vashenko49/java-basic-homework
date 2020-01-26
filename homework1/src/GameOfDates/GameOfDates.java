package GameOfDates;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameOfDates {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        Object[][] events = {
                {1971, "When was Elon Musk born?"},
                {1856, "When was Nikola Tesla born?"},
                {1814, "when was Shevchenko born?"},
                {1955, "When was Bill Gates born?"},
                {1955, "When was Steve Jobs born?"},
                {1984, "When was Mark Zuckerberg born?"},
                {1964, "When was Jeff Bezos born?"},
                {1960, "When was Tim Cook born?"}
        };

        int indexRandEvent = rand.nextInt(events.length);
        int yearEvents = (int) events[indexRandEvent][0];

        System.out.println("Enter your name");
        String nameUser = scanner.nextLine();

        System.out.println("Let the game begin!");
        System.out.println(events[indexRandEvent][1]);

        int[] answersUser = {};
        int answerUser = 0;
        do {
            try {
                answerUser = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Enter number only int type");
                scanner.next();
                continue;
            }

            if(answerUser<yearEvents){
                System.out.println("Your number is too small. Please, try again.");
            }else if(answerUser>yearEvents){
                System.out.println("Your number is too big. Please, try again.");
            }
            answersUser = addToArray(answersUser, answerUser);
        } while (answerUser!=yearEvents);
        System.out.printf("Congratulations, %s! %n", nameUser);
        bubbleSort(answersUser);
        System.out.printf("Your numbers: %s%n", String.join(", ", Arrays.stream(answersUser).mapToObj(String::valueOf).collect(Collectors.joining(", "))));
    }

    private static int[] addToArray (int[] answerUser,int newAnswer ){
        int [] newArray = new int[answerUser.length+1];
        System.arraycopy(answerUser, 0,newArray,0, answerUser.length);
        newArray[answerUser.length]=newAnswer;
        return newArray;
    }

    private static void bubbleSort(int[] intArray) {
        int n = intArray.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(intArray[j-1] > intArray[j]){
                    temp = intArray[j-1];
                    intArray[j-1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
    }
}

