package gui;

import classes.Authorization;
import classes.Setting;
import classes.User;
import interfaces.IAuthorization;
import interfaces.ISetting;
import interfaces.IUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame {

    private JPanel panel1;
    private JTextField nameTextField;
    private JTextField passwordTextField;
    private JButton saveButton;
    private JButton returnButton;
    private JTextField cityTextField;

    public RegisterForm() {
        setContentPane(panel1);
        setVisible(true);
        pack();
        setTitle("Регистрация");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        IAuthorization auth = Authorization.getInstance();
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AuthorizationForm af = new AuthorizationForm();
                af.setVisible(true);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String password = passwordTextField.getText();
                String city = cityTextField.getText();

                ISetting setting = new Setting();
                setting.setName(name);
                setting.setPassword(password);
                setting.setCity(city);

                IUser user = new User(setting);

                auth.addUser(user);

                JOptionPane.showMessageDialog(null,
                        "Пользователь успешно добавлен!");
            }
        });
    }
}
