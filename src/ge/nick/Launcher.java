package ge.nick;

import ge.nick.utils.Bash;

public class Launcher {

    public static void main(String[] args) {

        Bash editor = new Bash();

        editor.run("mkdir test");
        editor.run("ls test");
        editor.run("rm -r test");
        System.out.println(editor);

        editor.undo();
        System.out.println(editor);

        editor.undo();
        System.out.println(editor);

        editor.redo();
        editor.redo();
        System.out.println(editor);
    }
}