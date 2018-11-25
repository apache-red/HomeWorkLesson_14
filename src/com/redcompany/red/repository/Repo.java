package com.redcompany.red.repository;

import com.redcompany.red.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Repo {

   private List<User> userList = new ArrayList<User>();


   public void addDataToList(User user){
       userList.add(user);
   }

    public void removeDataToList(int index){
        userList.remove(index);
    }

    public void showDataUserList(){
       if (userList.size() >0){
           for (User user: userList
           ) {
               System.out.println( user.toString());
           }
       }else {
           System.out.println("User list is empty! Add new User.");
       }
    }

    public void showDataUserList(ArrayList<User> userList){
        if (userList.size() >0){
            for (User user: userList
            ) {
                System.out.println( user.toString());
            }
        }else {
            System.out.println("User list is empty! Add new User.");
        }
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
