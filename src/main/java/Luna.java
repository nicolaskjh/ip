import Tasks.*;

public class Luna {
    private static Add add;
    private static TaskList taskList;

    public static void main(String[] args) {
        Luna.entry();
        add = new Add();
        taskList = new TaskList();
        while (!add.isClosed()) {
            String input = add.readCommand();
            switch (input) {
                case "bye":
                    add.close();
                    break;
                case "todo":
                    String task = add.readInput();
                    taskList.addTask(new Todo(task));
                    break;
                case "deadline":
                    String[] deadlineDetails = add.readInput().split("/");
                    taskList.addTask(new Deadline(deadlineDetails[0], deadlineDetails[1]));
                    break;
                case "event":
                    String[] eventDetails = add.readInput().split("/");
                    taskList.addTask(new Event(eventDetails[0], eventDetails[1], eventDetails[2]));
                    break;
                case "list":
                    taskList.listTasks();
                    break;
                case "mark":
                    int markTaskId = Integer.parseInt(add.readInput());
                    taskList.markTaskDone(markTaskId);
                    break;
                case "unmark":
                    int unmarkTaskId = Integer.parseInt(add.readInput());
                    taskList.markTaskNotDone(unmarkTaskId);
                    break;
                default:
                    System.out.println("--------------------------------------");
                    System.out.println("Unknown command!");
                    System.out.println("--------------------------------------");
                    break;
            }
        }
        Luna.exit();
    }

    public static void entry() {
        System.out.println("--------------------------------------");
        System.out.println("Hello! I'm Luna!");
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------");
    }

    public static void exit() {
        System.out.println("-------------------------------------");
        System.out.println("Hope to see you again soon! meow");
        System.out.println("-------------------------------------");
    }
}
