package com.redcompany.red.logic.consolelogic;

import com.redcompany.red.console.Menu;
import com.redcompany.red.logic.network.client.SimpleClient;
import com.redcompany.red.repository.Repo;
import java.util.Scanner;

public class MenuLogic {

    private Repo repo;
    private Menu menu;
    private SimpleClient simpleClient;

    public MenuLogic() {
        this.simpleClient = new SimpleClient();
     }

    public void choseActionMainMenu(int number) {
        switch (number) {
            case 1:
                simpleClient.showAllUser();
                break;
            case 2:
                simpleClient.addNewUser();
                break;
            case 3:
                System.out.println("Program was stopped");
                System.exit(0);
                break;
        }
        menu.startProgram();
    }

    public int writeAction() {
        System.out.print("Input field: ");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        } else {
            System.out.println("!Exeption! Enter a number");
            writeAction();
        }
        return number;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}
