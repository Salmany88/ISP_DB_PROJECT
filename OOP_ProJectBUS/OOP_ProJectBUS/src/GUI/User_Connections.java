package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class User_Connections extends JFrame{
    private JPanel pannel;
    private JComboBox PackagecomboBox;
    private JComboBox MBscomboBox;
    private JLabel Packagelabel;
    private JLabel MBsLabel;
    private JButton confirmButton;
    private JButton backButton;


    public User_Connections() {
        add(pannel);
        setBounds(300,100,850,550);
        setVisible(true);
        PackageCombo();
        MBsCombo();

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (PackagecomboBox.getSelectedItem().equals("")
                        || MBscomboBox.getSelectedItem().equals(""))
                {
                    JOptionPane.showMessageDialog(pannel, " Please fill all fields!");
                }
                else{

                    String Package= PackagecomboBox.getSelectedItem().toString();
                    String MBs = MBscomboBox.getSelectedItem().toString();
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO New_Connections(conn_id,PackageName,MBs) VALUES(conn_id_seq.nextVal,?,?)";
                        PreparedStatement pst = ((Connection) conn).prepareStatement(sql);
                        pst.setString(1, Package);
                        pst.setString(2, MBs);

                        pst.executeQuery();
                        System.out.println("Data saved successfully!");

                        PackagecomboBox.setSelectedItem("");
                        MBscomboBox.setSelectedItem("");

                        new User_Connections().setVisible(true);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pannel, ex);
                    }
                }
            }

        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new CustomerPannelGUI().setVisible(true);
                dispose();
            }
        });
    }
    public void PackageCombo()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
            System.out.print("Connection Successful");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select PackageName from Connections");
            while (rs.next()) {
                String data = rs.getString("PackageName");
               PackagecomboBox.addItem(data);
            }

            System.out.println("Data saved!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void MBsCombo()
    {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
            System.out.print("Connection Successful");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select MBs from Connections");
            while (rs.next()) {
                String data = rs.getString("MBs");
                MBscomboBox.addItem(data);
            }

            System.out.println("Data saved!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
