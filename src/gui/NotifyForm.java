package gui;

import classes.Notify;
import interfaces.IList;
import interfaces.INotify;
import interfaces.IUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class NotifyForm {
    private JList list1;
    private JPanel panel1;
    private JButton addButton;
    private JTextField textField1;
    private JButton deleteButton;
    private JTextField textField2;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    public NotifyForm(IUser user) {

        list1.setModel(dlm);

        ArrayList<INotify> notifies = user.getNotifies();
        for(INotify item : notifies) {
            String el = "Назвние: " + item.getTitle() + ", время: " + item.getDate();
            dlm.add(0, el);
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = textField1.getText();
                String date = textField2.getText();

                INotify notify = new Notify(title, date);
                user.addNotify(notify);

                dlm.clear();

                ArrayList<INotify> notifies = user.getNotifies();
                for(INotify item : notifies) {
                    String el = "Назвние: " + item.getTitle() + ", время: " + item.getDate();
                    dlm.add(0, el);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getSelectedValue() == null) return;
                String value = list1.getSelectedValue().toString();
                String[] words = value.split(" ");
                INotify notify = user.getNotify(words[1].substring(0, words[1].length() - 1));
                user.deleteNotify(notify);

                dlm.clear();
                ArrayList<INotify> notifies = user.getNotifies();
                for(INotify item : notifies) {
                    String el = "Назвние: " + item.getTitle() + ", время: " + item.getDate();
                    dlm.add(0, el);
                }
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
