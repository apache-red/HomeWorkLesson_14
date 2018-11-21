package com.redcompany.red.logic.network.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

    public void showAllUser() {
        try (Socket clientSocket = new Socket("localhost", 9300)){
            OutputStream ous = clientSocket.getOutputStream();
            ous.write("showAll".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(){
          try (Socket clientSocket = new Socket("localhost", 9300)){
            OutputStream ous = clientSocket.getOutputStream();
            ous.write("addUser".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
