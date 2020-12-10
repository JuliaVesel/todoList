package gui;

import interfaces.IUser;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private JLabel notCreate;

    public SettingsPanel(IUser user) {
        setLayout(new FlowLayout());
        notCreate = new JLabel("Раздел в разаработке.");

        add(notCreate);
    }
}
