/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author eas7.de-play
 */
public class StringDrawObject implements Eas7Drawable {

    private final Init init;
    private int stringX, stringY, size;
    private String string;

    public StringDrawObject(Init init, String string, Point point, int size) {
        this.init = init;
        this.string = string;
        this.size = size;
        setPosition(point);
    }

    public void setPosition(Point pos) {
        this.stringX = pos.x;
        this.stringY = pos.y;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setFont(this.init.getFonts().getFont(this.size * init.getGameFactor()));
        g2d.drawString(string, stringX, stringY);
    }

    @Override
    public void update() {
    }

}
