package com.zhangyi.multithread.Bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


class BounceFrame extends JFrame{
    private BallComponent comp;
    private static final int DELAY = 5;
    private static Boolean FLAG = false;
    ThreadPoolExecutor executor =
            new ThreadPoolExecutor(3, 20, 5,
                    TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    BounceFrame(){
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "开始", event -> start());
//        addButton(buttonPanel, "暂停", event -> stopBall());
        addButton(buttonPanel, "结束", event -> end());
        add(buttonPanel, BorderLayout.SOUTH);
        addMouseListener(new MouseHandler());

        pack();
    }

    private void addButton(Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    private void start(){
        FLAG = true;
    }

    private void end(){
        FLAG = false;
        System.exit(0);
    }

    private Ball addBall(Point point){
        double dx,dy;
        dx = 2;
        dy = -2;
        Ball ball = new Ball(point.getX(), point.getY(), dx, dy);
        return ball;
    }


    class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event){
            if(FLAG){
                Ball ball= addBall(event.getPoint());
                Runnable r = ()->{
                    try{
                        comp.add(ball);
                        while(true){
                            ball.move(comp.getBounds());
                            Thread.sleep(DELAY);
                        }
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                };
                executor.execute(r);
                System.out.println(executor.getTaskCount());
                if(executor.getTaskCount()>=20){
                    FLAG = false;
                }
            }
        }
    }

}
