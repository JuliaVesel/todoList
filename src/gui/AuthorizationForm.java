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
        pack();
        setTitle("Авторизация");

        IAuthorization auth = Authorization.getInstance();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                char[] password = passwordField1.getPassword();

                if (!auth.checkUser(name, String.valueOf(password))) {
                    JOptionPane.showMessageDialog(null,
                            "Такого пользователя не существует!");
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "Успешно!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegisterForm rf = new RegisterForm();
                rf.setVisible(true);
            }
        });
    }
}
