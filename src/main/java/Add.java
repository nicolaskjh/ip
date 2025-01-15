import java.util.Scanner;

public class Add {
    private Scanner sc;
    private boolean closed;

    public Add() {
        sc = new Scanner(System.in);
        closed = false;
    }

    public String read() {
        return sc.nextLine();
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void close() {
        sc.close();
        closed = true;
    }

    public void printAddedTask(String task) {
        System.out.println("--------------------------------------");
        System.out.println("added: " + task);
        System.out.println("--------------------------------------");
    }
}
