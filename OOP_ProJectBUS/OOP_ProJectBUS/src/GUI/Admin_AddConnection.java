package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin_AddConnection extends JFrame{
    private JTextField PackageName;
    private JTextField SpeedField;
    private JTextField Ratefield;
    private JLabel package_Name;
    private JPanel pannel;
    private JLabel rate;
    private JButton addButton;
    private JButton backButton;

    public Admin_AddConnection() {
        add(pannel);
        setBounds(300,100,850,550);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Package =PackageName.getText();
                String Speed = SpeedField.getText();
                String Rate= Ratefield.getText();
                try
                {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ISP_DB","abc");
                    System.out.print("Connection Successful");
                    PreparedStatement pst=conn.prepareStatement("insert into connections (connection_id,PackageName,MBs,Rate) Values (connection_id_seq.nextVal,?,?,?)");
                    System.out.print("Saved");
                    pst.setString(1,Package);
                    pst.setString(2,Speed);
                    pst.setString(3,Rate);
                    ResultSet rs=pst.executeQuery();

                    JOptionPane.showMessageDialog(pannel,"Success");
                    dispose();
                    new AdminGUIPannel().setVisible(true);
                    PackageName.setText("");
                    SpeedField.setText("");
                    Ratefield.setText("");



                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex);
                }

            }
        });
    }
}
