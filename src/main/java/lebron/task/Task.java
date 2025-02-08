package lebron.task;

/**
 * Abstract class representing a Task
 */
public abstract class Task {
    private String description;
    private boolean isDone;

    /**
     * Constructor for Task
     *
     * @param description Task description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the task description
     *
     * @return Task description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns a status icon to indicate whether the task is done
     *
     * @return Status icon indicating whether the task is done
     */
    public String getStatusIcon() {
        return (this.isDone ? "X" : " ");
    }

    /**
     * Returns 1 or 0 to denote whether the task is done to format a task string to be stored
     *
     * @return 1 or 0 denoting whether the task is complete
     */
    public String getStatusData() {
        return (this.isDone ? "1" : "0");
    }

    /**
     * Marks the task as done
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Unmarks the task as done
     */
    public void unmarkDone() {
        this.isDone = false;
    }

    /**
     * Returns the string representation of the task to be stored in a text file
     *
     * @return String representation of the task to be stored in a text file
     */
    public abstract String toDataString();

    /**
     * Returns the string representation of the task to be displayed by the chatbot
     *
     * @return String representation of the task to be displayed by the chatbot
     */
    @Override
    public String toString() {
        return String.format("[%s] %s",
                this.getStatusIcon(),
                this.description);
    }
}
