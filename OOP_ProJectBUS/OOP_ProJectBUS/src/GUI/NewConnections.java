package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewConnections extends  JFrame implements ActionListener {

    JFrame frame = new JFrame("User Panel");

    JLabel label1 = new JLabel("Home Unlimited 10 Mbps");
    JLabel label2 = new JLabel("Home Unlimited 15 Mbps");
    JLabel label3 = new JLabel("Home Unlimited 50 Mbps");
    JLabel label4 = new JLabel("Home Unlimited 100 Mbps");

    JLabel label5 = new JLabel("Speed   : 10");
    JLabel label6 = new JLabel("Speed   : 15");
    JLabel label7 = new JLabel("Speed   : 50");
    JLabel label8 = new JLabel("Speed   : 100");

    JLabel label9 = new JLabel("Volume : Unlimited    Rs.1599/Month");
    JLabel label10 = new JLabel("Volume : Unlimited    Rs.1999/Month");
    JLabel label11 = new JLabel("Volume : Unlimited    Rs.4499/Month");
    JLabel label12 = new JLabel("Volume : Unlimited    Rs.9999/Month");

    JButton activate1 = new JButton("Activate Now");
    JButton activate2 = new JButton("Activate Now");
    JButton activate3 = new JButton("Activate Now");
    JButton activate4 = new JButton("Activate Now");
    JButton back = new JButton("Back");
    JPanel panel = new JPanel();

    NewConnections() {

        label1.setBounds(120,100,180,35);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Serif",Font.BOLD,16));
        label5.setBounds(120,130,180,35);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Serif",Font.BOLD,15));
        label9.setBounds(120,150,250,35);
        label9.setForeground(Color.WHITE);
        label9.setFont(new Font("Serif",Font.BOLD,14));

        activate1.setBounds(120, 200, 130, 40);
        activate1.setForeground(Color.RED);
        activate1.setFont(new Font("Serif", Font.BOLD, 16));
        activate1.setFocusable(false);
        activate1.addActionListener(this);

        label2.setBounds(120,280,180,35);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Serif",Font.BOLD,16));
        label6.setBounds(120,310,180,35);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Serif",Font.BOLD,15));
        label10.setBounds(120,330,250,35);
        label10.setForeground(Color.WHITE);
        label10.setFont(new Font("Serif",Font.BOLD,14));

        activate2.setBounds(120, 380, 130, 40);
        activate2.setForeground(Color.RED);
        activate2.setFont(new Font("Serif", Font.BOLD, 16));
        activate2.setFocusable(false);
        activate2.addActionListener(this);

        label3.setBounds(500,100,180,35);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Serif",Font.BOLD,16));
        label7.setBounds(500,130,180,35);
        label7.setForeground(Color.WHITE);
        label7.setFont(new Font("Serif",Font.BOLD,15));
        label11.setBounds(500,150,250,35);
        label11.setForeground(Color.WHITE);
        label11.setFont(new Font("Serif",Font.BOLD,14));

        activate3.setBounds(500, 200, 130, 40);
        activate3.setForeground(Color.RED);
        activate3.setFont(new Font("Serif", Font.BOLD, 16));
        activate3.setFocusable(false);
        activate3.addActionListener(this);

        label4.setBounds(500,280,180,35);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Serif",Font.BOLD,16));
        label8.setBounds(500,310,180,35);
        label8.setForeground(Color.WHITE);
        label8.setFont(new Font("Serif",Font.BOLD,15));
        label12.setBounds(500,330,250,35);
        label12.setForeground(Color.WHITE);
        label12.setFont(new Font("Serif",Font.BOLD,14));

        activate4.setBounds(500, 380, 130, 40);
        activate4.setForeground(Color.RED);
        activate4.setFont(new Font("Serif", Font.BOLD, 16));
        activate4.setFocusable(false);
        activate4.addActionListener(this);


        back.setBounds(670, 0, 120, 30);
        back.setForeground(Color.RED);
        back.setFont(new Font("Serif", Font.BOLD, 16));
        back.setFocusable(false);
        back.addActionListener(this);

        panel.setLayout(null);
        panel.setSize(800, 600);
        panel.setBackground(Color.BLUE);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);

        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);

        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);

        panel.add(activate1);
        panel.add(activate2);
        panel.add(activate3);
        panel.add(activate4);
        panel.add(back);


        frame.add(panel);

        frame.setSize(800, 600);
        frame.setLocation(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == activate1) {

            JOptionPane.showMessageDialog(null,"Your request has been submitted");

        } else if (actionEvent.getSource() == activate2) {

            JOptionPane.showMessageDialog(null,"Your request has been submitted");
        } else if (actionEvent.getSource() == activate3) {

            JOptionPane.showMessageDialog(null,"Your request has been submitted");
        } else if (actionEvent.getSource() == activate4) {

            JOptionPane.showMessageDialog(null,"Your request has been submitted");
        } else if (actionEvent.getSource() == back) {

            frame.dispose();
            new CustomerPannelGUI().setVisible(true);
        }
    }
}