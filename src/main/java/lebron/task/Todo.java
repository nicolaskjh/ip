package lebron.task;

/**
 * Represents a Todo task
 */
public class Todo extends Task {
    /**
     * Constructor for Todo
     *
     * @param description Task description
     */
    public Todo(String description, TaskPriority priority) {
        super(description, priority);
    }

    /**
     * Returns a string representation of the task to be stored in a text file
     *
     * @return String representation of the task to be stored in a text file
     */
    @Override
    public String toDataString() {
        return String.format("T, %s, %s, %s",
                super.getStatusData(),
                super.getPriorityData(),
                super.getDescription());
    }

    /**
     * Returns the string representation of the task to be displayed by the chatbot
     *
     * @return String representation of the task to be displayed by the chatbot
     */
    @Override
    public String toString() {
        return String.format("[T]%s",
                super.toString());
    }
}
