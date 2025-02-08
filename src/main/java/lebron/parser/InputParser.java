package lebron.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lebron.LebronException;
import lebron.command.AddCommand;
import lebron.command.Command;
import lebron.command.DeleteCommand;
import lebron.command.ExitCommand;
import lebron.command.FindCommand;
import lebron.command.ListCommand;
import lebron.command.MarkDoneCommand;
import lebron.command.SingCommand;
import lebron.command.UnmarkDoneCommand;
import lebron.task.Deadline;
import lebron.task.Event;
import lebron.task.Todo;

/**
 * Represents an InputParser to parse user input
 */
public class InputParser {
    private static final String PREFIX_EXIT = "bye";
    private static final String PREFIX_LIST = "list";
    private static final String PREFIX_TODO = "todo";
    private static final String PREFIX_DEADLINE = "deadline";
    private static final String PREFIX_EVENT = "event";
    private static final String PREFIX_MARK = "mark";
    private static final String PREFIX_UNMARK = "unmark";
    private static final String PREFIX_DELETE = "delete";
    private static final String PREFIX_FIND = "find";
    private static final String PREFIX_SING = "sing";

    private static final String SPLIT_DEADLINE = "/by";
    private static final String SPLIT_EVENT = "/";

    /**
     * Reads the user input to determine the command to execute
     *
     * @param input Text input from user
     * @return Command to be executed based on user input
     * @throws LebronException If command given is invalid
     */
    public static Command readInput(String input) throws LebronException {
        if (input.startsWith(PREFIX_EXIT)) {
            return new ExitCommand();
        } else if (input.startsWith(PREFIX_LIST)) {
            return new ListCommand();
        } else if (input.startsWith(PREFIX_TODO)) {
            return readTodoInput(input);
        } else if (input.startsWith(PREFIX_DEADLINE)) {
            return readDeadlineInput(input);
        } else if (input.startsWith(PREFIX_EVENT)) {
            return readEventInput(input);
        } else if (input.startsWith(PREFIX_MARK)) {
            return readMarkInput(input);
        } else if (input.startsWith(PREFIX_UNMARK)) {
            return readUnmarkInput(input);
        } else if (input.startsWith(PREFIX_DELETE)) {
            return readDeleteInput(input);
        } else if (input.startsWith(PREFIX_FIND)) {
            return readFindInput(input);
        } else if (input.startsWith(PREFIX_SING)) {
            return new SingCommand();
        } else {
            throw new LebronException("I'm not sure what you mean by this.");
        }
    }

    /**
     * Reads a Todo input given by the user
     *
     * @param input Text input from the user
     * @return AddCommand to be executed
     * @throws LebronException If task description is empty
     */
    public static Command readTodoInput(String input) throws LebronException {
        String[] split = input.split(" ", 2);

        if (split.length != 2) {
            throw new LebronException("I need a description for your todo task!");
        } else if (split[1].trim().isEmpty()) {
            throw new LebronException("I need a description for your todo task!");
        }

        return new AddCommand(new Todo(split[1].trim()));
    }

    /**
     * Reads a Deadline input given by the user
     *
     * @param input Text input from the user
     * @return AddCommand to be executed
     */
    public static Command readDeadlineInput(String input) {
        String[] split = input.split(" ", 2);
        String[] deadlineSplit = split[1].split(SPLIT_DEADLINE);
        LocalDate deadline = DateParser.parseDate(deadlineSplit[1].trim());

        return new AddCommand(new Deadline(deadlineSplit[0].trim(), deadline));
    }

    /**
     * Reads an Event input given by the user
     *
     * @param input Text input from the user
     * @return AddCommand to be executed
     */
    public static Command readEventInput(String input) {
        String[] split = input.split(" ", 2);
        String[] eventSplit = split[1].split(SPLIT_EVENT);
        LocalDateTime from = DateParser.parseDateTime(eventSplit[1].trim());
        LocalDateTime to = DateParser.parseDateTime(eventSplit[2].trim());

        return new AddCommand(new Event(eventSplit[0].trim(), from, to));
    }

    /**
     * Reads a Mark input given by the user
     *
     * @param input Text input from the user
     * @return MarkDoneCommand to be executed
     * @throws LebronException If task number given is empty
     */
    public static Command readMarkInput(String input) throws LebronException {
        String[] split = input.split(" ", 2);

        if (split.length != 2) {
            throw new LebronException("I need a task number to mark!");
        } else if (split[1].trim().isEmpty()) {
            throw new LebronException("I need a task number to mark!");
        }

        return new MarkDoneCommand(Integer.parseInt(split[1]) - 1);
    }

    /**
     * Reads an Unmark input given by the user
     *
     * @param input Text input from the user
     * @return UnmarkDoneCommand to be executed
     * @throws LebronException If task number given is empty
     */
    public static Command readUnmarkInput(String input) throws LebronException {
        String[] split = input.split(" ", 2);

        if (split.length != 2) {
            throw new LebronException("I need a task number to unmark!");
        } else if (split[1].trim().isEmpty()) {
            throw new LebronException("I need a task number to unmark!");
        }

        return new UnmarkDoneCommand(Integer.parseInt(split[1]) - 1);
    }

    /**
     * Reads a Delete input given by the user
     *
     * @param input Text input from the user
     * @return DeleteCommand to be executed
     * @throws LebronException If task number given is empty
     */
    public static Command readDeleteInput(String input) throws LebronException {
        String[] split = input.split(" ", 2);

        if (split.length != 2) {
            throw new LebronException("I need a task number to delete!");
        } else if (split[1].trim().isEmpty()) {
            throw new LebronException("I need a task number to delete!");
        }

        return new DeleteCommand(Integer.parseInt(split[1]) - 1);
    }

    /**
     * Reads a Find input given by the user
     *
     * @param input Text input from the user
     * @return FindCommand to be executed
     * @throws LebronException If keyword given is empty
     */
    public static Command readFindInput(String input) throws LebronException {
        String[] split = input.split(" ", 2);

        if (split.length != 2) {
            throw new LebronException("I need a keyword to filter tasks!");
        } else if (split[1].trim().isEmpty()) {
            throw new LebronException("I need a keyword to filter tasks!");
        }

        return new FindCommand(split[1].trim());
    }
}
