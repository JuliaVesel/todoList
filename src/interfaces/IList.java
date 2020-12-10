package interfaces;

import java.util.ArrayList;

public interface IList {
    ArrayList<IListItem> getListItems();
    void addListItem(IListItem listItem);
    void deleteListItem(IListItem listItem);
    IListItem getListItem(String title);
    IListItem getFirstListItem();
    IListItem getLastListItem();
    void setListTitle(String title);
    String getListTitle();
}
