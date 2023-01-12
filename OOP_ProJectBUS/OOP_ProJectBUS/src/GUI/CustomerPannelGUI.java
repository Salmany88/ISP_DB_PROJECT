package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPannelGUI extends JFrame
{
    private JPanel CustomerPannel;
    private JLabel Bookingt;
    private JButton bookTicketButton;
    private JButton myBookingsButton;
    private JButton backButton;

    public CustomerPannelGUI()
    {
        add(CustomerPannel);
        setBounds(300,100,850,550);
        setVisible(true);
        setTitle("Welcome to Pakistan Express");
        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new User_Connections().setVisible(true);
                dispose();
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               new WelcomeGUI().setVisible(true);
               dispose();
            }
        });

        myBookingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new User_Complains().setVisible(true);
                dispose();
            }
        });
    }
}
