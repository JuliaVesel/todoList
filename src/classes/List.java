package classes;

import interfaces.IList;
import interfaces.IListItem;
import interfaces.IUser;

import java.util.ArrayList;

public class List implements IList {
    private ArrayList<IListItem> items = new ArrayList<IListItem>();
    String title;
    public List(String title_) {
        title = title_;
    }

    @Override
    public ArrayList<IListItem> getListItems() { return items; }

    @Override
    public void addListItem(IListItem listItem) {
        items.add(listItem);
    }

    @Override
    public void deleteListItem(IListItem listItem) {
        items.remove(listItem);
    }

    @Override
    public IListItem getListItem(String title) {
        for(IListItem item : items) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return new ListItem("");
    }

    @Override
    public IListItem getFirstListItem() {
        return items.get(0);
    }

    @Override
    public IListItem getLastListItem() {
        return items.get(items.size() - 1);
    }

    @Override
    public void setListTitle(String title_) {
        title = title_;
    }

    @Override
    public String getListTitle() {
        return title;
    }
}
