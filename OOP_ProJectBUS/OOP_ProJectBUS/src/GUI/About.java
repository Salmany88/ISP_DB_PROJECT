package GUI;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame {
    private JTextField SalmanAli;
    private JLabel Title;
    private JButton backButton;
    private JLabel Author;
    private JPanel panel;
    private JTextArea Description;



    public About() {
        add(panel);
        setBackground(Color.WHITE);
        setBounds(300,100,850,550);
        Title.setText("About");
        Description.setText("Internet Service Provider is a type of online booking portal which shows users requirements like internet issues, buy packages  and a new user request when he/she want to buy packages and a new internet service and admin can handle all these queries of users and give new connections to users and deletion and update their data . They may access a new internet connection by using this simple and user-friendly solution while they are at home.");
        SalmanAli.setText("Salman Ali");
        SalmanAli.setEditable(false);
        Description.setEditable(false);
        MongoDB();
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new WelcomeGUI().setVisible(true);
                dispose();
            }
        });
    }
    public static void MongoDB()
    {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ISP");

        // Get a collection
        MongoCollection<Document> collection = database.getCollection("About");

        // Create a document
        Document doc = new Document("Title", "About")
                .append("Description", "Internet Service Provider is a type of online booking portal which shows users requirements like internet issues, buy packages  and a new user request when he/she want to buy packages and a new internet service and admin can handle all these queries of users and give new connections to users and deletion and update their data . They may access a new internet connection by using this simple and user-friendly solution while they are at home.")
                .append("Author", "Salman Ali");

        // Insert the document
        collection.insertOne(doc);

        // Close the MongoClient
        mongoClient.close();

    }
}
