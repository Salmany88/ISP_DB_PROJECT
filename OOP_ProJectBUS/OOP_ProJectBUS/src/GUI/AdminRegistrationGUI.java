package GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminRegistrationGUI extends JFrame {
    private JTextField UserField1;
    private JTextField ContactField2;
    private JTextField AdddressField3;
    private JTextField textField4;
    private JTextField PasswordField5;
    private JButton registerButton;
    private JButton backButton;
    private JLabel name;
    private JLabel contact;
    private JLabel address;
    private JLabel email;
    private JPanel Pannel;

    public AdminRegistrationGUI()
    {
        add(Pannel);
        setBounds(550,200,850,550);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminGUIPannel().setVisible(true);
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }
        });
    }
}
