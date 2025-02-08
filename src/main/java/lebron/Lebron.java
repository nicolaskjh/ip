package lebron;

import java.util.Scanner;

import lebron.command.Command;
import lebron.parser.InputParser;
import lebron.storage.Storage;
import lebron.task.TaskList;

/**
 * The main class for LeBron ChatBot
 */
public class Lebron {
    private static TaskList taskList;
    private static Scanner sc;
    private static Storage storage;

    /**
     * Constructor for LeBron
     *
     * @param filePath Path to file containing tasks to be loaded
     */
    public Lebron(String filePath) {
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.loadTasks());
        } catch (LebronException e) {
            taskList = new TaskList();
        }
    }

    /**
     * Main method to run LeBron chatbot
     *
     * @param args Arguments to be provided
     */
    public static void main(String[] args) {
        new Lebron("data/lebron.txt").run();
    }

    /**
     * Launches the LeBron chatbot
     */
    public void run() {
        sc = new Scanner(System.in);
        System.out.println("Hello! I'm LeBron!");
        System.out.println("What can I do for you?");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            try {
                Command currentCommand = InputParser.readInput(input);

                if (currentCommand.isExit()) {
                    this.exit();
                    System.out.println(currentCommand.getResponse(taskList));
                    break;
                }

                System.out.println(currentCommand.getResponse(taskList));
            } catch (LebronException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Exits the LeBron chatbot when the exit command is given by the user
     */
    public void exit() {
        storage.storeTasks(taskList);
    }
}
