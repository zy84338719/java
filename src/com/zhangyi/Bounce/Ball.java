package com.zhangyi.Bounce;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Ball {
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x;
    private double y;
    private double dx;
    private Color color;

    public Ball(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;

        this.dx = Math.random() * dx;
        this.dy = Math.random() * dy;
        Random rand = new Random();
        setColor(new Color(rand.nextInt(255)+1,rand.nextInt(255)+1,rand.nextInt(255)+1));
    }

    public Ball(){
        setColor(Color.BLACK);
    }

    private double dy = 1 ;

    public void move(Rectangle2D bounds){
        x += dx;
        y += dy;
        if(x < bounds.getMinX()){
            x = bounds.getMinX();
            dx = -dx;
        }
        if(x + XSIZE >= bounds.getMaxX()){
            x = bounds.getMaxX() - XSIZE;
            dx = -dx;
        }
        if(y < bounds.getMinY()){
            y = bounds.getMinY();
            dy = -dy;
        }
        if(y + YSIZE >= bounds.getMaxY()){
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape(){
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
