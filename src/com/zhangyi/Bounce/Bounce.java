package com.zhangyi.Bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Deprecated
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            JFrame frame = new BounceFrameDefulat();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

@Deprecated
class BounceFrameDefulat extends JFrame{
    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 3;

    public BounceFrameDefulat(){
        setTitle("经典小球");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "开始", event -> addBall());
        addButton(buttonPanel, "结束", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall(){
        try{
            Ball ball = new Ball();
            comp.add(ball);
            for(int i = 1; i < STEPS; i++){
                ball.move(comp.getBounds());
                comp.paint(comp.getGraphics());
                Thread.sleep(DELAY);
            }
        }catch (InterruptedException e){
        }
    }
}
