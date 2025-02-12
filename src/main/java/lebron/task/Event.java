package lebron.task;

import java.time.LocalDateTime;

import lebron.parser.DateParser;

/**
 * Represents an Event task
 */
public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    /**
     * Constructor for Event
     *
     * @param description Event description
     * @param start Event start date and time
     * @param end Event end date and time
     */
    public Event(String description, TaskPriority priority, LocalDateTime start, LocalDateTime end) {
        super(description, priority);
        this.start = start;
        this.end = end;
    }

    /**
     * Returns the string representation of the task to be stored in a text file
     *
     * @return String representation of the task to be stored in a text file
     */
    @Override
    public String toDataString() {
        return String.format("E, %s, %s, %s, %s, %s",
                super.getStatusData(),
                super.getPriorityData(),
                super.getDescription(),
                DateParser.dateTimeToDataString(this.start),
                DateParser.dateTimeToDataString(this.end));
    }

    /**
     * Returns the string representation of the task to be displayed by the chatbot
     *
     * @return String representation of the task to be displayed by the chatbot
     */
    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)",
                super.toString(),
                DateParser.dateTimeToString(this.start),
                DateParser.dateTimeToString(this.end));
    }
}
