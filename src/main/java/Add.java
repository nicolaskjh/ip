import java.util.Scanner;

public class Add {
    private Scanner sc;
    private boolean closed;

    public Add() {
        sc = new Scanner(System.in);
        closed = false;
    }

    public String readCommand() {
        return sc.next();
    }

    public String readInput() {
        return sc.nextLine().stripLeading();
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void close() {
        sc.close();
        closed = true;
    }
}
