package classes;

import java.util.ArrayList;
import interfaces.IList;
import interfaces.ISetting;
import interfaces.IUser;
import interfaces.INotify;

public class User implements IUser {
    private ArrayList<IList> lists = new ArrayList<IList>();
    private ArrayList<INotify> notifies = new ArrayList<INotify>();
    private ISetting setting_;

    public User(String name, String password, String city) {
        setting_ = new Setting();
        setting_.setName(name);
        setting_.setPassword(password);
        setting_.setCity(city);
    }

    public User(ISetting setting) {
        setting_ = new Setting();
        setting_.setName(setting.getName());
        setting_.setPassword(setting.getPassword());
        setting_.setCity(setting.getCity());
    }
    @Override
    public ArrayList<IList> getLists() {
        return lists;
    }

    @Override
    public IList getList(String title) {
        for(IList list : lists) {
            if (list.getListTitle().equals(title)) {
                return list;
            }
        }
        return new List("");
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

    @Override
    public String getName() {
        return setting_.getName();
    }

    @Override
    public boolean checkPassword(String password) {
        return setting_.getPassword().equals(password);
    }

    @Override
    public String getCity() {
        return setting_.getCity();
    }
}
