package classes;

import interfaces.IListItem;

public class ListItem implements IListItem {

    private String title;
    private String text;
    private Boolean isDone;

    public ListItem(String title_) {
        title = title_;
        text = "";
        isDone = false;
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
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text_) {
        text = text_;
    }

    @Override
    public Boolean getStatus() {
        return isDone;
    }

    @Override
    public void setStatus(Boolean status) {
        isDone = status;
    }
}
