package app;

import classes.Authorization;
import gui.AuthorizationForm;
import interfaces.IAuthorization;

public class Main {
    public static void main(String[] args) {

        /* init singleton authorization */
        IAuthorization auth = Authorization.getInstance();
        new AuthorizationForm();
    }
}
