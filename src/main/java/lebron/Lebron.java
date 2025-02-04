package cheeto;

import cheeto.command.Command;
import cheeto.task.TaskList;
import cheeto.reader.InputReader;
import cheeto.storage.Storage;

import java.util.Scanner;

public class Cheeto {
    private static TaskList taskList;
    private static Scanner sc;
    private static Storage storage;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        storage = new Storage();

        try {
            taskList = new TaskList(storage.loadTasks());
        } catch (CheetoException e) {
            taskList = new TaskList();
        }

        Cheeto.entry();

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            try {
                Command currentCommand = InputReader.readInput(input);

                if (currentCommand.isExit()) {
                    Cheeto.exit();
                    System.out.println(currentCommand.getResponse(taskList));
                    break;
                }

                System.out.println(currentCommand.getResponse(taskList));
            } catch (CheetoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void entry() {
        System.out.println("Hello! I'm Cheeto!");
        System.out.println("What can I do for you?");
    }

    public static void exit() {
        storage.storeTasks(taskList);
    }
}
