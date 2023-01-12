package GUI;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationGUI extends JFrame {
    private JPanel pannel;
    private JTextField Namefield;
    private JTextField ContactField2;
    private JTextField AddressField3;
    private JTextField passwordfield;
    private JButton registerButton;
    private JButton backButton;
    private JLabel name;
    private JLabel contact;
    private JLabel password;
    private JLabel title;
    private JTextField textField1;

    public RegistrationGUI()
    {
         backButton.setFocusable(false);
         registerButton.setFocusable(false);
        setBounds(300,100,850,550);
        setTitle("Welcome to Pakistan Express");
        add(pannel);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String Name = Namefield.getText();
                String Contact = ContactField2.getText();
                String Address = textField1.getText();
                String Password = passwordfield.getText();

                if (Namefield.getText().equals("")
                        || ContactField2.getText().equals("")
                        || textField1.getText().equals("")
                        || passwordfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(pannel, " Please fill all fields!");
                }
                else {
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ISP_DB", "abc");
                        System.out.print("Connection Sucessful");
                        String sql = "INSERT INTO USER_SIGNUP(user_id,user_name,user_phone,user_address,user_password) VALUES(user_id_seq.nextVal,?,?,?,?)";
                        PreparedStatement pst = conn.prepareStatement(sql);

                        pst.setString(1, Name);
                        pst.setString(2, Contact);
                        pst.setString(3,Address);
                        pst.setString(4, Password);

                        pst.executeQuery();
                        System.out.println("Data saved successfully!");
                        Namefield.setText("");
                        ContactField2.setText("");
                        passwordfield.setText("");
                        textField1.setText("");

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pannel, ex);
                    }

                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new UserLoginGUI().setVisible(true);
                dispose();
            }
        });
    }
}
