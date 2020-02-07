package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main extends JFrame implements MouseMotionListener {
    //Window size
    int WWIDTH = 1000;
    int WHEIGHT = 1000;

    //Buffer so it doesn't redraw
    private Image dbImage;
    private Graphics dbg;

    //Initializing variables
    int mX, mY;
    boolean mouseDragged;

    boolean winner = false;

    int[] TPX = {300, 400, 500,
                 300, 400, 500,
                 300, 400, 500};

    int[] TPY = {300, 300, 300,
                 400, 400, 400,
                 500, 500, 500};

    boolean[] empty = {false, false, false,
                       false, false, false,
                       false, false, true};

    tileRect r0 = new tileRect(0, TPX[0], TPY[0]);
    tileRect r1 = new tileRect(1, TPX[1], TPY[1]);
    tileRect r2 = new tileRect(2, TPX[2], TPY[2]);
    tileRect r3 = new tileRect(3, TPX[3], TPY[3]);
    tileRect r4 = new tileRect(4, TPX[4], TPY[4]);
    tileRect r5 = new tileRect(5, TPX[5], TPY[5]);
    tileRect r6 = new tileRect(6, TPX[6], TPY[6]);
    tileRect r7 = new tileRect(7, TPX[7], TPY[7]);
    Rectangle mouseRect = new Rectangle(0, 0, 10, 10);

    //Create window and set variable values
    public Main() {
        addMouseListener(new Mouse());
        addMouseMotionListener(this);
        setSize(WWIDTH, WHEIGHT);
        setTitle("Hentai Temple 2");
        setResizable(false);
        setBackground(Color.BLACK);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mX = e.getX();
        mY = e.getY();

        mouseRect.x = mX;
        mouseRect.y = mY;

        mouseDragged = true;

        e.consume();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mX = e.getX();
        mY = e.getY();

        mouseDragged = false;

        e.consume();
    }

    public class Mouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        r0.draw(g);
        if(r0.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r0.x = TPX[i];
                    r0.y = TPY[i];
                    empty[r0.loc] = true;
                    r0.loc = i;
                    break;
                }
            }
        }
        r1.draw(g);
        if(r1.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r1.x = TPX[i];
                    r1.y = TPY[i];
                    empty[r1.loc] = true;
                    r1.loc = i;
                    break;
                }
            }
        }
        r2.draw(g);
        if(r2.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r2.x = TPX[i];
                    r2.y = TPY[i];
                    empty[r0.loc] = true;
                    r2.loc = i;
                    break;
                }
            }
        }
        r3.draw(g);
        if(r3.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r3.x = TPX[i];
                    r3.y = TPY[i];
                    empty[r3.loc] = true;
                    r3.loc = i;
                    winner = true;
                    break;
                }
            }
        }
        r4.draw(g);
        if(r4.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r4.x = TPX[i];
                    r4.y = TPY[i];
                    empty[r4.loc] = true;
                    r4.loc = i;
                    break;
                }
            }
        }
        r5.draw(g);
        if(r5.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r5.x = TPX[i];
                    r5.y = TPY[i];
                    empty[r5.loc] = true;
                    r5.loc = i;
                    break;
                }
            }
        }
        r6.draw(g);
        if(r6.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r6.x = TPX[i];
                    r6.y = TPY[i];
                    empty[r6.loc] = true;
                    r6.loc = i;
                    break;
                }
            }
        }
        r7.draw(g);
        if(r7.intersects(mouseRect)){
            for(int i=0;i<9;i++) {
                if(empty[i] == true){
                    empty[i] = false;
                    r7.x = TPX[i];
                    r7.y = TPY[i];
                    empty[r7.loc] = true;
                    r7.loc = i;
                    break;
                }
            }
        }
        g.setColor(Color.WHITE);
        if(winner == true){
            g.setColor(Color.ORANGE);
            g.drawString("YOURE WINNER!!!!!!!!!!", 200, 200);
        }
        g.drawString("drag mouse over square to play", 600, 600);
        repaint();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
