package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUIPannel extends JFrame
{
    private JLabel Title;
    private JButton addBusButton;
    private JButton addRouteButton;
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
       // Bookings.setFocusable(false);
//        addBusButton.setFocusable(false);
//        addRouteButton.setFocusable(false);
//        deleteBusButton.setFocusable(false);
//        deleteRouteButton.setFocusable(false);
        //Bookings.setFocusable(false);
//        backButton.setFocusable(false);


        add(AdminPannel);
        setBounds(550,200,850,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
               new LoginGUI().setVisible(true);
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
    }



}


