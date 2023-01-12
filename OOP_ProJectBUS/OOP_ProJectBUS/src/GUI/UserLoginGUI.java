package GUI;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class UserLoginGUI extends JFrame
{
    private JTextField UserField1;
    private JTextField PasswordField2;
    private JButton loginButton;
    private JButton backButton;
    private JPanel pannel;
    private JButton registrationButton;

    public UserLoginGUI()
    {
        backButton.setFocusable(false);
        loginButton.setFocusable(false);

        add(pannel);
        setBounds(550,200,850,550);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WelcomeGUI().setVisible(true);
                dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String userName =UserField1.getText();
                String password = PasswordField2.getText();
                if (userName.equals("Saud") && password.equals("abc"))
                {
                    JOptionPane.showMessageDialog(pannel,"Success");
                    dispose();
                    new CustomerPannelGUI().setVisible(true);
                    UserField1.setText("");
                    PasswordField2.setText("");
                }
                else
                {
                try
                {
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ISP_DB","abc");
                    System.out.print("Connection Sucessful");
                    PreparedStatement pst=conn.prepareStatement("Select * from user_SignUp where username=? and user_password=?");
                    pst.setString(1,userName);
                    pst.setString(2,password);
                    ResultSet rs=pst.executeQuery();

                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(pannel,"Success");

                        dispose();
                        new CustomerPannelGUI().setVisible(true);
                        UserField1.setText("");
                        PasswordField2.setText("");
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(pannel,"Invalid Credientials");
                        UserField1.setText("");
                        PasswordField2.setText("");
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex);
                }
                }
            }
        });
        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new RegistrationGUI().setVisible(true);
                dispose();
            }
        });
    }
}
