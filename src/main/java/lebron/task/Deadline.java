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
    public Deadline(String description, LocalDate dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    /**
     * Returns the string representation of the task to be stored in a text file
     *
     * @return String representation of the task to be stored in a text file
     */
    @Override
    public String toDataString() {
        return "D, " + super.getStatusData() + ", " + super.getDescription()
                + ", " + DateParser.dateToDataString(dueDate);
    }

    /**
     * Returns the string representation of the task to be displayed by the chatbot
     *
     * @return String representation of the task to be displayed by the chatbot
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateParser.dateToString(this.dueDate) + ")";
    }
}
