package lebron.command;

import lebron.task.Task;
import lebron.task.TaskList;

/**
 * Represents an AddCommand to add a task to the list
 */
public class AddCommand extends Command {
    private Task task;

    /**
     * Constructor for AddCommand
     *
     * @param task Task to be added to the list
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Returns the response given by the chatbot after successfully adding the task
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response message displayed by the chatbot upon successful addition of the task
     */
    @Override
    public String getResponse(TaskList taskList) {
        taskList.addTask(this.task);
        return "Got it, I've added this task:\n" + this.task.toString() +
                "\nYou now have " + taskList.getNumTasks() + " tasks.";
    }
}
