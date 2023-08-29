package main;

import service.LoginService;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginView loginView=new LoginView();
        loginView.menu();
    }
}
