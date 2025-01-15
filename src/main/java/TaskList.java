public class TaskList {
    private String[] tasks;
    private int numTasks;

    public TaskList() {
        this.tasks = new String[100];
        this.numTasks = 0;
    }

    public void addTask(String task) {
        tasks[numTasks] = task;
        numTasks++;
    }

    public void listTasks() {
        System.out.println("--------------------------------------");
        for (int i = 1; i <= numTasks; i++) {
            System.out.println(i + ". " + tasks[i-1]);
        }
        System.out.println("--------------------------------------");
    }
}
