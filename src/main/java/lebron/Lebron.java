package lebron;

import lebron.command.Command;
import lebron.task.TaskList;
import lebron.parser.InputParser;
import lebron.storage.Storage;

import java.util.Scanner;

public class Lebron {
    private static TaskList taskList;
    private static Scanner sc;
    private static Storage storage;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        storage = new Storage();

        try {
            taskList = new TaskList(storage.loadTasks());
        } catch (LebronException e) {
            taskList = new TaskList();
        }

        Lebron.entry();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            try {
                Command currentCommand = InputParser.readInput(input);

                if (currentCommand.isExit()) {
                    Lebron.exit();
                    System.out.println(currentCommand.getResponse(taskList));
                    break;
                }

                System.out.println(currentCommand.getResponse(taskList));
            } catch (LebronException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void entry() {
        System.out.println("Hello! I'm LeBron!");
        System.out.println("What can I do for you?");
    }

    public static void exit() {
        storage.storeTasks(taskList);
    }
}
