import java.util.ArrayList;
import interfaces.IList;
import interfaces.ISetting;
import interfaces.IUser;
import interfaces.INotify;

public class User implements IUser {
    private ArrayList<IList> lists;
    private ArrayList<INotify> notifies;
    private ISetting setting_;

    public User(String name, String password) {
        setting_ = new Setting();
        setting_.setName(name);
        setting_.setPassword(password);
    }

    @Override
    public void addList(IList list) {
        lists.add(list);
    }

    @Override
    public void deleteList(IList list) {
        lists.remove(list);
    }

    @Override
    public void clearLists() {
        lists.clear();
    }

    @Override
    public void addNotify(INotify notify) {
        notifies.add(notify);
    }

    @Override
    public void deleteNotify(INotify notify) {
        notifies.remove(notify);
    }

    @Override
    public void clearNotifies() {
        notifies.clear();
    }
}
