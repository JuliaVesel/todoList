package interfaces;

public interface IList {
    void addListItem(IListItem listItem);
    void deleteListItem(IListItem listItem);
    void getListItem(int index);
    IListItem getFirstListItem();
    IListItem getLastListItem();
    void setListTitle(String title);
    String getListTitle();
}
