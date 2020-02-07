package com.game;

import java.awt.*;

public class tileRect extends Rectangle {
    int id, loc;
    String label;

    public tileRect(int id, int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height =50;
        this.id = id;
        this.label = Integer.toString(this.id);
        this.loc = this.id;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(Color.WHITE);
        g.drawString(label, this.x + 20, this.y + 20);
    }
}
