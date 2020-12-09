package interfaces;

public interface IUser {
    void addList(IList list);
    void deleteList(IList list);
    void clearLists();
    void addNotify(INotify notify);
    void deleteNotify(INotify notify);
    void clearNotifies();
    String getName();
    boolean checkPassword(String password);
}
