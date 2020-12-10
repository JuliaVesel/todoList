package gui;

import interfaces.IUser;

import javax.swing.*;
import java.awt.*;

public class NotifyPanel extends JPanel {
    private JLabel notCreate;

    public NotifyPanel(IUser user) {
        setLayout(new FlowLayout());
        notCreate = new JLabel("Раздел в разаработке.");

        add(notCreate);
    }
}
