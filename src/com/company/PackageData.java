package com.company;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Reservs> reservs;
    ArrayList<Rooms> rooms;
    ArrayList<AdminData> admins;
    ArrayList<GuestData> guests;
    AdminData admin;
    GuestData user;
    Reservs reserv;
    Rooms room;
    Long id;

    public PackageData(){}

    public PackageData(String operationType, ArrayList<Reservs> reservs, ArrayList<Rooms> rooms, ArrayList<AdminData> admins, ArrayList<GuestData> guests, AdminData admin, GuestData user, Reservs reserv, Rooms room, Long id) {
        this.operationType = operationType;
        this.reservs = reservs;
        this.rooms = rooms;
        this.admins = admins;
        this.guests = guests;
        this.admin = admin;
        this.user = user;
        this.reserv = reserv;
        this.room = room;
        this.id = id;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setReservs(ArrayList<Reservs> reservs) {
        this.reservs = reservs;
    }

    public void setRooms(ArrayList<Rooms> rooms) {
        this.rooms = rooms;
    }

    public void setAdmins(ArrayList<AdminData> admins) {
        this.admins = admins;
    }

    public void setGuests(ArrayList<GuestData> guests) {
        this.guests = guests;
    }

    public void setAdmin(AdminData admin) {
        this.admin = admin;
    }

    public void setUser(GuestData user) {
        this.user = user;
    }

    public void setReserv(Reservs reserv) {
        this.reserv = reserv;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public ArrayList<Reservs> getReservs() {
        return reservs;
    }

    public ArrayList<Rooms> getRooms() {
        return rooms;
    }

    public ArrayList<AdminData> getAdmins() {
        return admins;
    }

    public ArrayList<GuestData> getGuests() {
        return guests;
    }

    public AdminData getAdmin() {
        return admin;
    }

    public GuestData getUser() {
        return user;
    }

    public Reservs getReserv() {
        return reserv;
    }

    public Rooms getRoom() {
        return room;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", reservs=" + reservs +
                ", rooms=" + rooms +
                ", admins=" + admins +
                ", guests=" + guests +
                ", admin=" + admin +
                ", user=" + user +
                ", reserv=" + reserv +
                ", room=" + room +
                ", id=" + id +
                '}';
    }
}
