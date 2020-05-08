package com.company;

import java.io.Serializable;

public class Rooms implements Serializable {
    private Long id;
    private String roomNumber;
    private String time;
    private int price;

    public Rooms(){}

    public Rooms(Long id, String roomNumber, String time, int price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.time = time;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                '}';
    }
}
