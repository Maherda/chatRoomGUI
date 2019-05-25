import javax.swing.*;
import java.awt.*;

public class ChatArea extends JTextArea {
    private static final int ROWS = 10, COLUMNS = 30;

    public ChatArea()
    {
        super(ROWS, COLUMNS);
        this.setEditable(false);
        this.setLineWrap(true);
        setVisible(true);
    }
//    public static void addComponentsToPane(Container pane) {
//    }

    public void addMessage(String username,String message)
    {
        this.append(username+": "+message+"\n");
    }
}