package com.redcompany.red.logic.network.server;

import com.redcompany.red.entity.User;
import com.redcompany.red.repository.Repo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class SimpleServer {

    private Repo repo;

    public static void main(String[] args) {
        SimpleServer simpleServer = new SimpleServer();
        simpleServer.startServer();
    }

    private void startServer() {
        initStartData();
        byte[] data = new byte[1024];
        String showAll = initMessage_1();
        String addNewUser = initMessage_2();
        String serialize = initMessage_3();
        String deserialize = initMessage_4();
        try (ServerSocket serverSocket = new ServerSocket(9301)) {
            System.out.println("Server created and started:");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                InputStream bis = clientSocket.getInputStream();
                bis.read(data);
                String msg = new String(data);
                if (msg.equals(showAll)) {
                    repo.showDataUserList();
                }
                if (msg.equals(addNewUser)) {
                    repo.addDataToList(new User("NewUser" + (int) (Math.random() * 100), (int) (Math.random() * 100)));
                    System.out.println("New user successfully created!");
                }
                if (msg.equals(serialize)) {
                   serializeList();
                }
                if (msg.equals(deserialize)) {
                    deserializeList();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void serializeList() {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user"))) {
            os.writeObject(repo.getUserList());
            System.out.println("serialize comleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object deserializeList() {
        Object obj = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user"))) {
            obj = ois.readObject();
            repo.showDataUserList((ArrayList<User>) obj);
            System.out.println("deserialize comleted");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return obj;
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

    private String initMessage_1() {
        byte[] data = new byte[1024];
        data[0] = 115;
        data[1] = 104;
        data[2] = 111;
        data[3] = 119;
        data[4] = 65;
        data[5] = 108;
        data[6] = 108;
        String msg = new String(data);
        return msg;
    }

    private String initMessage_2() {
        byte[] data = new byte[1024];
        data[0] = 97;
        data[1] = 100;
        data[2] = 100;
        data[3] = 85;
        data[4] = 115;
        data[5] = 101;
        data[6] = 114;
        String msg = new String(data);
        return msg;
    }
    private String initMessage_3() {
        byte[] data = new byte[1024];
        data[0] = 115;
        data[1] = 101;
        data[2] = 114;
        String msg = new String(data);
        return msg;
    }
    private String initMessage_4() {
        byte[] data = new byte[1024];
        data[0] = 100;
        data[1] = 101;
        data[2] = 115;
        data[3] = 101;
        data[4] = 114;
        String msg = new String(data);
        return msg;
    }

}
