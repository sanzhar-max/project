package com.company;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Admin {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static  Socket socket;
    public static AdminMainFrame frame;
    public static String accaunt=null;

    private static  ArrayList<AdminData> admins;

    public static void myLogin(String login){ accaunt=login; }

    public static void connectToServer(){
        try {
            socket=new Socket("127.0.0.1",1999);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void addRooms(Rooms rooms){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Room");
        pd.setRoom(rooms);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static ArrayList<Rooms> listRooms(){
        ArrayList<Rooms> rooms=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Rooms");
        pd.setRooms(rooms);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                rooms=pd.getRooms();
            }
        }catch (Exception e){e.printStackTrace();}
        return rooms;
    }
    public static void deleteWithId(Long id){
        PackageData pd=new PackageData();
        pd.setOperationType("Delete_Rooms");
        pd.setId(id);
        ArrayList<Rooms> rooms=pd.getRooms();
        try {
            outputStream.writeObject(pd);
        }catch(Exception e){e.printStackTrace();}
    }

    public static ArrayList<AdminData> listAdmin(){
        ArrayList<AdminData> admins=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Admins");
        pd.setAdmins(admins);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                admins=pd.getAdmins();
                for(AdminData ad : admins)
                    System.out.println(ad);
            }
        }catch (Exception e){e.printStackTrace();}
        return admins;
    }

    public static void addAdmin(AdminData admin){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Admin");
        pd.setAdmin(admin);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static void showAddPage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.listRooms.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.addRooms.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMainMenu() {
        Admin.frame.addAdmin.setVisible(false);
        Admin.frame.regitr.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showRegistrPage(){
        Admin.frame.addAdmin.setVisible(false);
        Admin.frame.regitr.setVisible(true);
        Admin.frame.menu.setVisible(false);
        Admin.frame.repaint();
    }

    public static void showListPage(){
        frame.menu.setVisible(false);
        frame.addRooms.setVisible(false);
        frame.deletePage.setVisible(false);
        frame.listRooms.setVisible(true);
        ArrayList<Rooms> list = listRooms();
        Admin.frame.listRooms.updateArea(list);
    }

    public static void showDeletePage(){
        Admin.frame.menu.setVisible(false);
        Admin.frame.addRooms.setVisible(false);
        Admin.frame.listRooms.setVisible(false);
        ArrayList<Rooms> list=listRooms();
        frame.deletePage.updateArea(list);
        Admin.frame.deletePage.setVisible(true);
        Admin.frame.repaint();
    }

    public static void showMenuPage(){
        Admin.frame.addRooms.setVisible(false);
        Admin.frame.listRooms.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(false);
        Admin.frame.regitr.setVisible(false);
        Admin.frame.addAdmin.setVisible(true);
        Admin.frame.repaint();
    }
    public static void MenuPage(){
        Admin.frame.addRooms.setVisible(false);
        Admin.frame.listRooms.setVisible(false);
        Admin.frame.deletePage.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.regitr.setVisible(false);
        Admin.frame.addAdmin.setVisible(false);
        Admin.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();

        frame = new AdminMainFrame();
        frame.setVisible(true);
    }
}
