import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChatRoomGUI extends JFrame {
    private final String WINDOWS_TITLE = "AUT Chat Room";
    private final int WIDTH = 500, HEIGHT = 500;
    private final int X = 100, Y = 100;
    private ArrayList<String> users = new ArrayList<>();
    ParticipantsArea participantsArea = new ParticipantsArea();
    MessageArea messageArea = new MessageArea();
    ChatArea chatBox = new ChatArea();

    public ChatRoomGUI() {
        super();
        this.setFont(new Font("serif", Font.PLAIN, 40));
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);
        this.add(new JScrollPane(chatBox), BorderLayout.CENTER);
        this.add(participantsArea, BorderLayout.WEST);
        this.add(messageArea, BorderLayout.SOUTH);
        this.setVisible(true);

        //chatBox.addComponentsToPane(chatBox);
    }

    public ChatArea getChatBox() {
        return chatBox;
    }

    public MessageArea getMessageArea() {
        return messageArea;
    }

    public void showGUI() {
        this.setVisible(true);
    }

    public void addNewPart(String user) {
        users.add(user);
        participantsArea.addPart(user);
    }

    public void removePart(String user) {
        try
        {
            users.remove(user);
        } catch (Exception e)
        {

        }
    }


}