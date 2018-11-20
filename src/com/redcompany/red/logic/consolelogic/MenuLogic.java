package com.redcompany.red.logic.consolelogic;

import com.redcompany.red.console.Menu;
import com.redcompany.red.entity.User;
import com.redcompany.red.repository.Repo;

import java.util.Scanner;

public class MenuLogic {


    private Repo repo;
    private Menu menu;



    public void choseActionMainMenu(int number) {
        switch (number) {
            case 1:

                break;
            case 2:

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

    public void initStartData() {
        this.repo = new Repo();

        repo.addDataToList(new User("Vasya", 18));
        repo.addDataToList(new User("Petya", 12));
        repo.addDataToList(new User("Sasha", 19));
        repo.addDataToList(new User("Kate", 20));
        repo.addDataToList(new User("Lena", 29));
        repo.addDataToList(new User("Lena", 23));
        repo.addDataToList(new User("Ira", 32));
        repo.addDataToList(new User("Tanya", 23));
        repo.addDataToList(new User("Oleg", 14));
    }

    public void setMenu(Menu menu){
        this.menu = menu;
    }
}
