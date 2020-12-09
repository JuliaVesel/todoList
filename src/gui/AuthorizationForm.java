package gui;

import javax.swing.*;

public class AuthorizationForm extends JFrame {
    private JPanel panel1;
    private JButton enterButton;
    private JButton registerButton;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public AuthorizationForm() {
        setContentPane(panel1);
        setVisible(true);
        setSize(400,400);
        setTitle("Авторизация");


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
