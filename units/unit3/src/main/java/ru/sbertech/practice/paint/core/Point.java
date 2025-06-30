package ru.sbertech.practice.paint.core;

public class Point {

    // В теории мы можем менять позицию фигуры, но пока только рисуем
    private final int positionX;
    private final int positionY;


    public Point(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public double getPositionX() {
        return this.positionX;
    }


    public double getPositionY() {
        return this.positionY;
    }


    @Override
    public String toString() {
        return "(" + getPositionX() + ", " + getPositionY() + ")";
    }
}
