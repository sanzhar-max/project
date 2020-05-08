package com.company;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Guest {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static GuestMainFrame frame;
    public static Socket  socket;
    public static String accaunt=null;

    private static  ArrayList<GuestData> guests;

    public static void addGuest(GuestData guest){
        PackageData pd=new PackageData();
        pd.setOperationType("Add_Guest");
        pd.setUser(guest);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){e.printStackTrace();}
    }

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",1999);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<GuestData> listGuest(){
        ArrayList<GuestData> guests=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Guests");
        pd.setGuests(guests);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                guests=pd.getGuests();
                for(GuestData gd : guests)
                    System.out.println(gd);
            }
        }catch (Exception e){e.printStackTrace();}
        return guests;
    }

    public static void addReservs(Reservs reservs){
        PackageData pd=new PackageData();
        ArrayList<Reservs> reservs1 = new ArrayList<>();
        reservs1.add(reservs);
        pd.setOperationType("Add_Reservs");
        pd.setReservs(reservs1);
        try {
            outputStream.writeObject(pd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Reservs> listReservs(){
        ArrayList<Reservs> reservs=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Reservs");
        pd.setReservs(reservs);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                reservs =pd.getReservs();
            }
        }catch (Exception e){e.printStackTrace();}
        return reservs;
    }

    public static ArrayList<Rooms> listRooms(){
        ArrayList<Rooms> rooms=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List_Rooms");
        try {
            outputStream.writeObject(pd);
            if((pd=(PackageData)inputStream.readObject())!=null){
                rooms=pd.getRooms();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rooms;
    }

    public static void showRegistrPage(){
        Guest.frame.addGuest.setVisible(false);
        Guest.frame.regitr.setVisible(true);
        Guest.frame.menu.setVisible(false);
        Guest.frame.repaint();
    }

    public static void myLogin(String login){
        accaunt=login;
    }


    public static void showListPage(){
        Guest.frame.menu.setVisible(false);
        Guest.frame.addReservs.setVisible(false);
        Guest.frame.listReservs.setVisible(true);
        ArrayList<Reservs>list=listReservs();
        frame.listReservs.updateArea(list);
        Guest.frame.repaint();
    }

    public static void showMainMenu() {
        Guest.frame.addGuest.setVisible(false);
        Guest.frame.regitr.setVisible(false);
        Guest.frame.menu.setVisible(true);
        Guest.frame.repaint();
    }


    public static void showMenuPage() {
        Guest.frame.addGuest.setVisible(true);
        Guest.frame.regitr.setVisible(false);
        Guest.frame.menu.setVisible(false);
        Guest.frame.repaint();
    }


    public static void main(String[] args){
        connectToServer();
        frame = new GuestMainFrame();
        frame.setVisible(true);
    }
}
