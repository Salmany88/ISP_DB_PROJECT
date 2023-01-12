package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Admin_Complains extends JFrame{
    private JTable table1;
    private JButton backButton;
    private JScrollPane scrollPane1;
    private JPanel Pannel;
    private JPanel Pannel1;

    public Admin_Complains() {
        add(Pannel);
        setBounds(550,200,850,550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminGUIPannel().setVisible(true);
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel modell=new DefaultTableModel();
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
            System.out.print("Connection Sucessful");
            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a select query
            String sql = "SELECT * FROM Complains";
            ResultSet rs = stmt.executeQuery(sql);

            // Get the metadata of the result set
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get the number of columns in the result set
            int columnCount = rsmd.getColumnCount();
            // Add the column names to the model
            for (int i = 1; i <= columnCount; i++) {
                modell.addColumn(rsmd.getColumnName(i));
            }

            // Add the rows to the model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                modell.addRow(row);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Pannel, ex);
        }



    }
}
