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

    public User_Complains() {
        add(Pannel);
        setBounds(550,200,850,550);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Complain = textArea.getText();

                if (textArea.getText().equals("")) {
                    JOptionPane.showMessageDialog(Pannel, " Please fill all fields!");
                } else {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO Complains(complain_id,user_Complain ) VALUES(complain_id_seq.nextVal,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);

                        pst.setString(1, Complain);


                        pst.executeQuery();
                        System.out.println("Data saved successfully!");
                        JOptionPane.showMessageDialog(Pannel, "Route has been Added!");
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
