package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class User_Complains extends JFrame{
    private JTextArea textArea;
    private JButton submitButton;
    private JPanel Pannel;
    private JButton backButton;
    private JTextField namefield;

    public User_Complains() {
        add(Pannel);
        setBounds(300,100,850,550);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name= namefield.getText();
                String Complain = textArea.getText();

                if (namefield.getText().equals("") || textArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(Pannel, " Please enter all details!");
                } else
                {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO Complains(complain_id,user_name,user_Complain ) VALUES(complain_id_seq.nextVal,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);
                        pst.setString(1, Name);
                        pst.setString(2, Complain);


                        pst.executeQuery();
                        System.out.println("Data saved successfully!");
                        JOptionPane.showMessageDialog(Pannel, "Complain has been added!");
                        namefield.setText("");
                        textArea.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Pannel, ex);
                    }
                }

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerPannelGUI().setVisible(true);
                dispose();
            }
        });
    }
}
