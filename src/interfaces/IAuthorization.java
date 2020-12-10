package interfaces;

public interface IAuthorization {
    void addUser(IUser user);
    void deleteUser(IUser user);
    boolean checkUser(String name, String password);
    IUser getUserByName(String name);
}
