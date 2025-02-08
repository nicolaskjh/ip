package lebron.command;

import lebron.task.TaskList;

/**
 * Represents a MarkDoneCommand to mark a task as done
 */
public class MarkDoneCommand extends Command {
    private int taskNumber;

    /**
     * Constructor for MarkDoneCommand
     *
     * @param taskNumber The task number to be marked
     */
    public MarkDoneCommand(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * Returns the response given upon successfully marking a task as done
     *
     * @param taskList Task list containing the tasks added by the user
     * @return Response given upon successfully marking a task as done
     */
    @Override
    public String getResponse(TaskList taskList) {
        taskList.markDone(this.taskNumber);

        return "I've marked this task as done:\n"
                + taskList.getTask(taskNumber).toString();
    }
}
