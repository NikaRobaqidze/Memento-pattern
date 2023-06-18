package ge.nick.utils;

import ge.nick.utils.Terminal.Memento;

import java.util.Stack;

public class Bash {

    private final Stack<Memento> undoHistory = new Stack<>();
    private final Stack<Memento> redoHistory = new Stack<>();

    private final Terminal bash = new Terminal();

    { run(""); }

    public void run(String text) {

        redoHistory.clear();
        bash.setText(text);
        undoHistory.push(bash.cacheCommand());
    }

    public void undo() {

        if (undoHistory.isEmpty()) {

            System.err.println("Command history exceed.");
            return;
        }

        redoHistory.push(undoHistory.pop());
        bash.previous(undoHistory.peek());
    }

    public void redo() {

        if (redoHistory.isEmpty()) {

            System.err.println("Command history exceed.");
            return;
        }

        Memento nextState = redoHistory.pop();
        undoHistory.push(nextState);
        bash.previous(nextState);
    }

    @Override
    public String toString() {
        return bash.toString();
    }
}
