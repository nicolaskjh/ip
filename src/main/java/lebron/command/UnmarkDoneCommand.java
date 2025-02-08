package lebron.command;

import lebron.task.TaskList;

/**
 * Represents a UnmarkDoneCommand to unmark a task as done
 */
public class UnmarkDoneCommand extends Command {
    private int taskNumber;

    /**
     * Constructor for UnmarkDoneCommand
     *
     * @param taskNumber The task number to be unmarked
     */
    public UnmarkDoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Returns the response given upon successfully unmarking a task as done
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response given upon successfully unmarking a task as done
     */
    @Override
    public String getResponse(TaskList taskList) {
        taskList.unmarkDone(this.taskNumber);

        return "I've unmarked this task:\n"
                + taskList.getTask(taskNumber).toString();
    }
}
