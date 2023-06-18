package ge.nick.utils;

public class Terminal {

    public record Memento(String text) {}

    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Memento cacheCommand() {
        return new Memento(text);
    }

    public void previous(Memento memento) {
        text = memento.text;
    }

    @Override
    public String toString() {
        return text;
    }
}
