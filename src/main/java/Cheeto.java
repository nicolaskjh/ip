import command.*;
import task.*;
import java.util.Scanner;

public class Cheeto {
    private static TaskList taskList;
    private static Scanner sc;

    public static void main(String[] args) {
        taskList = new TaskList();
        sc = new Scanner(System.in);
        Cheeto.entry();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            try {
                Command currentCommand = InputReader.readInput(input);
                System.out.println(currentCommand.getResponse(taskList));
                if (currentCommand.isExit()) {
                    break;
                }
            } catch (CheetoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void entry() {
        System.out.println("Hello! I'm Cheeto!");
        System.out.println("What can I do for you?");
    }
}
