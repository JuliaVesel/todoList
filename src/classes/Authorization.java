package classes;

import interfaces.IAuthorization;
import interfaces.IUser;

import java.util.ArrayList;

public class Authorization implements IAuthorization {
    private static IAuthorization instance;
    private ArrayList<IUser> users = new ArrayList<IUser>();

    public static IAuthorization getInstance() {
        if (instance == null) {
            instance = new Authorization();
            instance.addUser(new User("user", "password", "spb"));
        }
        return instance;
    }

    private Authorization() {

    }

    @Override
    public void addUser(IUser user) {
        users.add(user);
    }

    @Override
    public void deleteUser(IUser user) {
        users.remove(user);
    }

    @Override
    public boolean checkUser(String name, String password) {
        for(IUser user : users) {
            if (user.getName().equals(name) && user.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public IUser getUserByName(String name) {
        for(IUser user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return new User("Default", "admin", "Moscow");
    }
}
