package com.redcompany.red.console;

import com.redcompany.red.logic.consolelogic.MenuLogic;

public class Menu {

    private MenuLogic menuLogic;

    public Menu() {
        this.menuLogic = new MenuLogic();
    }

    public void startProgram() {
        showMainMenu();
        passLinkMenuToMenuLogic();
        menuLogic.choseActionMainMenu(menuLogic.writeAction());

    }

    private void showMainMenu() {
        System.out.println("------------------------------");
        System.out.println("Select an action. Enter the number 1...3");
        System.out.println("1. Choose if you want to get a list of users");
        System.out.println("2. Choose if you want to create new user");
        System.out.println("3. Choose if you want to exit from this program");
        System.out.println("------------------------------");
    }

    private void passLinkMenuToMenuLogic(){
      menuLogic.setMenu(Menu.this);
    }






}
