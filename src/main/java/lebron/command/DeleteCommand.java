package lebron.command;

import lebron.task.Task;
import lebron.task.TaskList;

/**
 * Represents a DeleteCommand to remove a task from the list
 */
public class DeleteCommand extends Command {
    private int taskNumber;

    /**
     * Constructor for DeleteCommand
     *
     * @param taskNumber The task number to be deleted
     */
    public DeleteCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Returns the response given by the chatbot after successful deletion of the task
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response given upon successful deletion of the task
     */
    @Override
    public String getResponse(TaskList taskList) {
        Task removed = taskList.getTask(taskNumber);
        taskList.removeTask(this.taskNumber);

        return "Got it, I've removed this task:\n" + removed.toString()
                + "\nYou now have " + taskList.getNumTasks() + " tasks.";
    }
}
