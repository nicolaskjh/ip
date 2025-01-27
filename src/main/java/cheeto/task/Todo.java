package cheeto.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toDataString() {
        return "T, " + super.getStatusData() + ", " + super.getDescription();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
