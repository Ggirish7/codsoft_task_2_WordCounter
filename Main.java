import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        wordCounter();
    }

    public static void wordCounter() {

        Scanner sc = new Scanner(System.in); // initialising the scanner

        System.out.println("WORD COUNTER!\nEnter: 1 for typing text\nEnter: 2 for reading the file text");
        int response = sc.nextInt();
        sc.nextLine();

        if (response == 1) {

            System.out.println("\nEnter text:");
            String inputText = sc.nextLine();
            count(inputText);

        } 
        else if (response == 2) {

            System.out.println("\nEnter file path:");
            String filePath = sc.nextLine();
            File file = new File(filePath);

            try (Scanner scanner = new Scanner(file)) {
                String inputText = scanner.nextLine();
                count(inputText);
                scanner.close();
            } 
            catch (FileNotFoundException e) {
                System.err.println("The system cannot find the file specified");
            }

        }
        sc.close(); // closing the scanner

    }

    public static void count(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+"); // declaring array of words
        System.out.println("The number of words are " + words.length);
    }
}