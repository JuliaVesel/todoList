package gui;

import interfaces.IUser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MianForm extends JFrame{
    private JButton showList;
    private JButton showNotify;
    private JButton showWether;
    private JButton showSettings;
    private JPanel jpanelMenu;
    private JPanel jpanelMain;
    private JPanel japnel1;
    private IUser user_;

    public MianForm(IUser user) {
        user_ = user;
        setContentPane(japnel1);
        setVisible(true);
        setSize(800, 600);
        setTitle("Списки");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jpanelMain.setLayout(new GridLayout(0, 1, 5, 5));
        jpanelMain.add(new ListForm(user).getPanel1());
        jpanelMain.setBorder(new EmptyBorder(10, 20, 10, 20));
        showList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpanelMain.removeAll();
                jpanelMain.add(new ListForm(user).getPanel1());
                japnel1.revalidate();
            }
        });

        showNotify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpanelMain.removeAll();
                jpanelMain.add(new NotifyPanel(user_));
                japnel1.revalidate();
            }
        });

        showWether.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpanelMain.removeAll();
                jpanelMain.add(new WetherPanel(user_));
                japnel1.revalidate();
            }
        });

        showSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jpanelMain.removeAll();
                jpanelMain.add(new SettingsPanel(user_));
                japnel1.revalidate();
            }
        });
    }
}
