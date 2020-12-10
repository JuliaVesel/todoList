package gui;

import interfaces.IUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingForm {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton updateButton;
    private JPanel panel1;

    public SettingForm(IUser user, JLabel label) {
        textField1.setText(user.getName());
        textField3.setText(user.getCity());

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String password = textField2.getText();
                String city = textField3.getText();

                if (!user.getName().equals(name) || !user.getCity().equals(city) || !password.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Данные пользователя успешно обновленны!");
                }

                user.updateName(name);
                user.updatePassword(password);
                user.updateCity(city);

                label.setText(name);

                textField2.setText("");

            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
