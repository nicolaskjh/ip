package lebron.task;

import java.time.LocalDate;

import lebron.parser.DateParser;

public class Deadline extends Task {
    private LocalDate dueDate;

    public Deadline(String description, LocalDate dueDate) {
        super(description);
        this.dueDate = dueDate;
    }

    @Override
    public String toDataString() {
        return "D, " + super.getStatusData() + ", " + super.getDescription()
                + ", " + DateParser.dateToDataString(dueDate);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + DateParser.dateToString(this.dueDate) + ")";
    }
}
