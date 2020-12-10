package interfaces;

import java.util.ArrayList;

public interface IUser {
    ArrayList<IList> getLists();
    IList getList(String title);
    void addList(IList list);
    void deleteList(IList list);
    void clearLists();
    void addNotify(INotify notify);
    void deleteNotify(INotify notify);
    void clearNotifies();
    String getName();
    boolean checkPassword(String password);
    String getCity();
    void updateName(String name);
    void updatePassword(String password);
    void updateCity(String city);
}
