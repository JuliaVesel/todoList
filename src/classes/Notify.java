package classes;

import interfaces.INotify;

public class Notify implements INotify {
    String title;
    String date;

    public Notify(String title_, String date_) {
       title = title_;
       date = date_;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title_) {
        title = title_;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date_) {
        date = date_;
    }
}
