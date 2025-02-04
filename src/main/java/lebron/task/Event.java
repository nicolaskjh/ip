package lebron.task;

import java.time.LocalDateTime;

import lebron.parser.DateParser;

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String description, LocalDateTime start, LocalDateTime end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toDataString() {
        return "E,  " + super.getStatusData() + ", " + super.getDescription() +
                ", " + DateParser.dateTimeToDataString(this.start) +  ", "
                + DateParser.dateTimeToDataString(this.end);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + DateParser.dateTimeToString(this.start)
                + " to: " + DateParser.dateTimeToString(this.end) + ")";
    }
}
