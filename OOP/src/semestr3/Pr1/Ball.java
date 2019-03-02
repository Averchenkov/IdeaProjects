package semestr3.Pr1;

import java.lang.*;

public class Ball {
    private int size;
    private String color;
    private int  pressure;
    public Ball(){
        size = 20;
        color = "white";
        pressure = 0;
    }
    public Ball(int size){
        this.size = size;
        color = "white";
        pressure = 0;
    }
    public Ball(int size, String color){
        this.size = size;
        this.color = color;
        pressure = 0;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getPressure() {
        return pressure;
    }

    public void inflate(int pressure){
        if(this.pressure + pressure > 1100)
        {
            this.pressure = 1100;
        }
        else this.pressure += pressure;
    }

    public void inflate()
    {
        if(this.pressure < 700){
            this.pressure = 700;
        }
    }

    public void deflate(int pressure){
        if (this.pressure < pressure){
            this.pressure = 0;
        }
        else this.pressure -= pressure;
    }

    public void deflate(){
        this.pressure = 0;
    }

    public String toString() {
        return "Pr1 size " + this.size + ", color " + this.color + " and pressure " + this.pressure;
    }
}
