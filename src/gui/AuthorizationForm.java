package gui;

import classes.Authorization;
import interfaces.IAuthorization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        IAuthorization auth = Authorization.getInstance();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                char[] password = passwordField1.getPassword();

                if (!auth.checkUser(name, String.valueOf(password))) {
                    System.out.print("Такого пользователя не существует!");
                }
            }
        });
    }
}
