package com.mpokket.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


import static java.nio.file.Files.createDirectories;

public class FileMenu {

    public void getFileMenu(){
        int option;
        String fileName;
        Scanner sc = new Scanner(System.in);
        this.createFolderIfNotPresent("main");
        System.out.println("Press 1 get the list of files in ascending order");
        System.out.println("Press 2 to delete a specific file");
        System.out.println("Press 3 to search a specific file");
        System.out.println("Press 4 to create a new file and Enter file Name");
        System.out.println("Press 5 to go back to main menu");
        System.out.println("Press 6 to exit program");
        option = sc.nextInt();
        switch(option){
            case 1:
                this.getListOfFiles();
                break;

            case 2:
                System.out.println("Enter File Name");
                fileName = sc.next();
                this.deleteFileByName(fileName);
                break;
            case 3:
                System.out.println("Enter File Initials");
                fileName = sc.next();
                this.searchFileByInitials(fileName);
                break;
            case 4:
                System.out.println("Enter File Name");
                fileName = sc.next();
                this.createNewFile(fileName);
                break;
            case 5:
                MainMenuOptions.dispalymainMenu();
                break;
            case 6:
                System.out.println("Program exited successfully.");
                sc.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option selected");
                break;

        }

    }

    private void getListOfFiles(){
        File dir = new File("main");
        File[] files = dir.listFiles();
        List<File> listFiles = Arrays.asList(files);
        Collections.sort(listFiles);
        for(File file : files){
            System.out.println(file.getName());
        }

    }

    private void createFolderIfNotPresent(String folderName){
        File  file = new File(folderName);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    private void createNewFile(String fileName) {
        Path pathToFile = Paths.get("./main/" + fileName);
        try {
            Files.createDirectories(pathToFile.getParent());
            Files.createFile(pathToFile);
            System.out.println(fileName + " created successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    private void deleteFileByName(String fileName) {
        File file = new File("main/"+fileName);

        if(file.delete()) {
            System.out.println(file.getName() + " Deleted Successfully");
        }



    }

    private void searchFileByInitials(String fileName) {
        File file = new File("main");
        File[] files = file.listFiles();
        List<File> filesList = Arrays.asList(files);
        List<String> listOfFiles = new ArrayList<>();;
        if (files.length > 0) {
            for (File name : filesList) {

                if (name.getName().startsWith(fileName)) {
                    listOfFiles.add(name.getName());
                }
            }
        }
        System.out.println(listOfFiles);

    }
}
