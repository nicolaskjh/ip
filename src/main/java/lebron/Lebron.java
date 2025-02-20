package lebron;

import java.io.IOException;

import lebron.command.Command;
import lebron.parser.InputParser;
import lebron.storage.Storage;
import lebron.task.TaskList;

/**
 * Represents the main class for LeBron ChatBot
 */
public class Lebron {
    private static TaskList taskList;
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
     * Returns the response by LeBron chatbot for a user input
     *
     * @param input User input provided
     * @return Response from LeBron chatbot
     */
    public String getResponse(String input) {
        try {
            Command currentCommand = InputParser.readInput(input);
            return currentCommand.getResponse(taskList);
        } catch (LebronException e) {
            return e.getMessage();
        }
    }

    /**
     * Exits the LeBron chatbot when the exit command is given by the user
     */
    public void exit() {
        try {
            storage.storeTasks(taskList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
