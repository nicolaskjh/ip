package lebron.task;

import java.time.LocalDate;

import lebron.parser.DateParser;

/**
 * Represents a Deadline task
 */
public class Deadline extends Task {
    private LocalDate dueDate;

    /**
     * Constructor for Deadline
     *
     * @param description Task description
     * @param dueDate Due date of the task
     */
    public Deadline(String description, TaskPriority priority, LocalDate dueDate) {
        super(description, priority);
        this.dueDate = dueDate;
    }

    /**
     * Returns the string representation of the task to be stored in a text file
     *
     * @return String representation of the task to be stored in a text file
     */
    @Override
    public String toDataString() {
        return String.format("D, %s, %s, %s, %s",
                super.getStatusData(),
                super.getPriorityData(),
                super.getDescription(),
                DateParser.dateToDataString(this.dueDate));
    }

    /**
     * Returns the string representation of the task to be displayed by the chatbot
     *
     * @return String representation of the task to be displayed by the chatbot
     */
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)",
                super.toString(),
                DateParser.dateToString(this.dueDate));
    }
}
