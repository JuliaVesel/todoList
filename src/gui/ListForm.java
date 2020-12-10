package gui;

import classes.List;
import classes.ListItem;
import interfaces.IList;
import interfaces.IListItem;
import interfaces.IUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListForm extends JPanel {
    private JPanel panel1;
    private JList list1;
    private JList list2;
    private JTextField addListTextField;
    private JButton addButton;
    private JButton deleteListButton;
    private JTextField addItemListTextField;
    private JButton addItemButton;
    private JButton deleteItemListButton;
    private JList list3;

    private DefaultListModel<String> dlm = new DefaultListModel<String>();
    private DefaultListModel<String> currentDlm = new DefaultListModel<String>();
    private DefaultListModel<String> currentDoneDlm = new DefaultListModel<String>();

    public ListForm(IUser user) {
        setVisible(true);

        list1.setModel(dlm);
        list2.setModel(currentDlm);
        list3.setModel(currentDoneDlm);

        for(IList item : user.getLists()) {
            dlm.add(0, item.getListTitle());
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlm.clear();
                IList list = new List(addListTextField.getText());

                user.addList(list);

                ArrayList<IList> lists = user.getLists();
                for(IList item : lists) {
                    dlm.add(0, item.getListTitle());
                }
            }
        });

        deleteListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getSelectedValue() == null) return;
                String title = list1.getSelectedValue().toString();
                IList list = user.getList(title);
                user.deleteList(list);

                dlm.clear();
                currentDlm.clear();
                ArrayList<IList> lists = user.getLists();
                for(IList item : lists) {
                    dlm.add(0, item.getListTitle());
                }
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String title = list1.getSelectedValue().toString();
                IList list = user.getList(title);

                currentDlm.clear();
                currentDoneDlm.clear();
                for(IListItem iteml : list.getListItems()) {
                    if (iteml.getStatus()) {
                        currentDoneDlm.add(0, iteml.getTitle());
                    }
                    else {
                        currentDlm.add(0, iteml.getTitle());
                    }
                }
            }
        });

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getSelectedValue() == null) return;

                String title = list1.getSelectedValue().toString();
                IList list = user.getList(title);

                list.addListItem(new ListItem(addItemListTextField.getText()));

                currentDlm.clear();
                for(IListItem item : list.getListItems()) {
                    currentDlm.add(0, item.getTitle());
                }

            }
        });

        deleteItemListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list1.getSelectedValue() == null || list3.getSelectedValue() == null) return;

                String title = list1.getSelectedValue().toString();
                IList list = user.getList(title);
                IListItem item = list.getListItem(list3.getSelectedValue().toString());
                list.deleteListItem(item);

                currentDlm.clear();
                currentDoneDlm.clear();
                for(IListItem iteml : list.getListItems()) {
                    if (iteml.getStatus()) {
                        currentDoneDlm.add(0, iteml.getTitle());
                    }
                    else {
                        currentDlm.add(0, iteml.getTitle());
                    }
                }
            }
        });

        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String title = list1.getSelectedValue().toString();
                IList list = user.getList(title);
                IListItem litem = list.getListItem(list2.getSelectedValue().toString());
                litem.setStatus(true);

                currentDlm.clear();
                currentDoneDlm.clear();
                for(IListItem item : list.getListItems()) {
                    if (item.getStatus()) {
                        currentDoneDlm.add(0, item.getTitle());
                    }
                    else {
                        currentDlm.add(0, item.getTitle());
                    }
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
