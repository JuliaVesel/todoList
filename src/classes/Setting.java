package classes;

import interfaces.ISetting;

public class Setting implements ISetting {
    private String name_;
    private String password_;
    private String city_;

    @Override
    public String getName() {
        return name_;
    }

    @Override
    public void setName(String name) {
        name_ = name;
    }

    @Override
    public String getPassword() {
        return password_;
    }

    @Override
    public void setPassword(String password) {
        password_ = password;
    }

    @Override
    public String getCity() {
        return city_;
    }

    @Override
    public void setCity(String city) {
        city_ = city;
    }
}
