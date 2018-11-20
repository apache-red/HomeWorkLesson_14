package com.redcompany.red.console;

import com.redcompany.red.entity.User;
import com.redcompany.red.repository.Repo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Repo repo;

   public void startProgram(){
    startMainMenu();
    choseActionMainMenu(writeAction());
    }

    private void startMainMenu(){
        System.out.println("Select an action. Enter the number 1...2");
        System.out.println("1. Choose if you want to get a list of users");
        System.out.println("2. Choose if you want to create new user");
        System.out.println("3. Choose if you want to exit from this program");
        System.out.println("------------------------------");
    }


    private void choseActionMainMenu(int number) {
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
        startProgram();
    }


    private int writeAction() {
        System.out.print("Input field: ");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        if (scanner.hasNextInt()){
            number = scanner.nextInt();
        }else {
            System.out.println("!Exeption! Enter a number");
            writeAction();
        }
        return number;
    }

    private void initStartData(){
       this.repo = new Repo();
       repo.addDataToList(new User("Vasua"));
    }

}
