import command.*;
import task.*;

public class InputReader {
    private static final String EXIT = "bye";
    private static final String LIST = "list";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String MARK = "mark";
    private static final String UNMARK = "unmark";
    private static final String DELETE = "delete";

    private static final String DEADLINE_SPLIT = "/by";
    private static final String EVENT_SPLIT = "/";

    public static Command readInput(String input) throws CheetoException {
        if (input.startsWith(EXIT)) {
            return new ExitCommand();
        } else if (input.startsWith(LIST)) {
            return new ListCommand();
        } else if (input.startsWith(TODO)) {
            return readTodoInput(input);
        } else if (input.startsWith(DEADLINE)) {
            return readDeadlineInput(input);
        } else if (input.startsWith(EVENT)) {
            return readEventInput(input);
        } else if (input.startsWith(MARK)) {
            return readMarkInput(input);
        } else if (input.startsWith(UNMARK)) {
            return readUnmarkInput(input);
        } else if (input.startsWith(DELETE)) {
            return readDeleteInput(input);
        } else {
            throw new CheetoException("I'm not sure what you mean by this meow :(");
        }
    }

    public static Command readTodoInput(String input) throws CheetoException {
        String[] split = input.split(" ", 2);
        if (split.length != 2) {
            throw new CheetoException("I need a description for your todo task!");
        } else if (split[1].trim().isEmpty()) {
            throw new CheetoException("I need a description for your todo task!");
        }
        return new AddCommand(new Todo(split[1].trim()));
    }

    public static Command readDeadlineInput(String input) {
        String[] split = input.split(" ", 2);
        String[] deadlineSplit = split[1].split(DEADLINE_SPLIT);
        return new AddCommand(new Deadline(deadlineSplit[0].trim(), deadlineSplit[1].trim()));
    }

    public static Command readEventInput(String input) {
        String[] split = input.split(" ", 2);
        String[] eventSplit = split[1].split(EVENT_SPLIT);
        return new AddCommand(new Event(eventSplit[0].trim(), eventSplit[1].trim(), eventSplit[2].trim()));
    }

    public static Command readMarkInput(String input) throws CheetoException {
        String[] split = input.split(" ", 2);
        if (split.length != 2) {
            throw new CheetoException("I need a task number to mark!");
        } else if (split[1].trim().isEmpty()) {
            throw new CheetoException("I need a task number to mark!");
        }
        return new MarkDoneCommand(Integer.parseInt(split[1]) - 1);
    }

    public static Command readUnmarkInput(String input) throws CheetoException {
        String[] split = input.split(" ", 2);
        if (split.length != 2) {
            throw new CheetoException("I need a task number to unmark!");
        } else if (split[1].trim().isEmpty()) {
            throw new CheetoException("I need a task number to unmark!");
        }
        return new UnmarkDoneCommand(Integer.parseInt(split[1]) - 1);
    }

    public static Command readDeleteInput(String input) throws CheetoException {
        String[] split = input.split(" ", 2);
        if (split.length != 2) {
            throw new CheetoException("I need a task number to delete!");
        } else if (split[1].trim().isEmpty()) {
            throw new CheetoException("I need a task number to delete!");
        }
        return new DeleteCommand(Integer.parseInt(split[1]) - 1);
    }
}
