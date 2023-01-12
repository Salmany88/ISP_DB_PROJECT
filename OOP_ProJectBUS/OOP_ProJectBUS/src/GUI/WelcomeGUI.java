package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeGUI extends JFrame
{
    private JButton adminButton;
    private JButton userButton;
    private JPanel welcomepannel;
    private JPanel Headerpannel;
    private JLabel Title;
    private JPanel HeaderPanel;


    public WelcomeGUI()
    {
        adminButton.setFocusable(false);
        userButton.setFocusable(false);

        add(welcomepannel);
        setBackground(Color.WHITE);
        setBounds(300,100,850,550);

        adminButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Admin_Login().setVisible(true);
                dispose();
            }
        });
        userButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new UserLoginGUI().setVisible(true);
                dispose();
            }
        });
    }

}
