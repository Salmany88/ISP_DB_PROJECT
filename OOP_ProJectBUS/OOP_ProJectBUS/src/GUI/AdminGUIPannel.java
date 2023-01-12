package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUIPannel extends JFrame
{
    private JLabel Title;
    private JButton addBusButton;
    private JButton addConnectionsButton;
    private JButton deleteRouteButton;
    private JButton Bookings;
    private JButton backButton;
    private JPanel AdminPannel;
    private JButton deleteBusButton;
    private JButton button1;
    private JButton registrationButton;
    private JButton usersButton;

    public AdminGUIPannel()
    {

        add(AdminPannel);
        setBounds(300,100,850,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
               new Admin_Login().setVisible(true);
               dispose();
            }
        });
        deleteBusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserData().setVisible(true);
                dispose();
            }

        });
        addBusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Admin_Complains().setVisible(true);
                dispose();
            }
        });
        addConnectionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Admin_AddConnection().setVisible(true);
                dispose();
            }
        });
    }



}


