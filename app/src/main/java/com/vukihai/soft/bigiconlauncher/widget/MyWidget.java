package com.vukihai.soft.bigiconlauncher.widget;

public class MyWidget {
    private int height;
    private int width;
    public MyWidget(){
        height = 1;
        width = 1;
    }
    public MyWidget(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
