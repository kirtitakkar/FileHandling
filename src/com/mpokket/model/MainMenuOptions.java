package com.mpokket.model;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenuOptions {

    public static  void dispalymainMenu(){
        boolean flag = true;
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to get developer details");
        System.out.println("Press 2 to get file operations");
        System.out.println("Press 3 to get file operations");
        option = sc.nextInt();
        do{
            switch(option){
                case 1:
                    UserDetails userData = new UserDetails();
                    userData.getUserDetails();
                    break;
                case 2:
                    FileMenu fileMenu = new FileMenu();
                    fileMenu.getFileMenu();
                    break;
                case 3:
                    System.out.println("Program exited successfully.");
                    System.out.println("Good Bye!!.");
                    flag = false;
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected");
                    flag = false;
                    break;

            }
        }while(flag == true);



    }
}
