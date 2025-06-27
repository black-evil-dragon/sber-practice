package ru.sbertech.practice.paint.core;

public class Point {

    // В теории мы можем менять позицию фигуры, но пока только рисуем
    private final double positionX;
    private final double positionY;


    public Point(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public double getPositionX() {
        return this.positionX;
    }


    public double getPositionY() {
        return this.positionY;
    }
}
