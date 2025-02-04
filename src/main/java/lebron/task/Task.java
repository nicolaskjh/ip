package cheeto.task;

abstract public class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatusIcon() {
        return (this.isDone ? "X" : " ");
    }

    public String getStatusData() {
        return (this.isDone ? "1" : "0");
    }

    public void markDone() {
        this.isDone = true;
    }

    public void unmarkDone() {
        this.isDone = false;
    }

    public abstract String toDataString();

    @Override
    public String toString() {
        return String.format("[%s] %s",
                this.getStatusIcon(),
                this.description);
    }
}
