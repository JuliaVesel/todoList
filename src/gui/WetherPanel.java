package gui;

import interfaces.IUser;

import javax.swing.*;
import java.awt.*;

public class WetherPanel extends JPanel {
    private JLabel wetherLabel;

    public WetherPanel(IUser user) {
        setLayout(new FlowLayout());

        String city = user.getCity();

        if (!city.isEmpty())
            wetherLabel = new JLabel("В городе: \"" + user.getCity() + "\" +20 и солнечно, (всегда хорошая погода)");
        else
            wetherLabel = new JLabel("Укажите горд для отображения корректной погоды.");

        add(wetherLabel);
    }
}
