import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UsernameFrame extends JFrame {
    private static final String BTN_TXT = " Start Chatting ...";
    private static final String LABEL_TXT = " Choose Your UserName  ";
    private static final int WIDTH = 300, HEIGHT = 200;

    public static ChatRoomGUI mainChatRoom;

    JTextField textField;
    JButton btn;
    public String userName;

    public static ChatRoomGUI getMainChatRoom() {
        return mainChatRoom;
    }

    public UsernameFrame() throws HeadlessException {
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Choose Your UserName");
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        add(textField, BorderLayout.CENTER);
        btn = new JButton("Enter Your UserName");
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                userName=textField.getText();
                setVisible(false);
                mainChatRoom = new ChatRoomGUI();
                mainChatRoom.addNewPart(userName);
                JTextField txtField = mainChatRoom.getMessageArea().getTextField();
                txtField.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent evt)
                    {
                        if(evt.getKeyCode() == KeyEvent.VK_ENTER && !evt.isShiftDown())
                        {
                            String txt = mainChatRoom.getMessageArea().getTextField().getText();
                            mainChatRoom.getChatBox().addMessage(userName,txt);
                            mainChatRoom.getMessageArea().setTextField("");
                        }
                        else if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                            txtField.setText(txtField.getText()+'\n');
                        else
                            txtField.setText(txtField.getText()+evt.getKeyChar());
                    }
                });
                JButton btn = mainChatRoom.getMessageArea().getBtn();
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String txt = mainChatRoom.getMessageArea().getTextField().getText();
                        mainChatRoom.getChatBox().addMessage(userName,txt);
                        mainChatRoom.getMessageArea().setTextField("");
                    }
                });
            }
        });

        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
    }

    public String getUserName() {
        return userName;
    }
}

