/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine.objects;

import eas7.gameengine2d.engine.Eas7Drawable;
import eas7.gameengine2d.engine.Init;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author eas7.de-play
 */
public class StringDrawObject implements Eas7Drawable {

    private final Init init;
    private int stringX, stringY, size, gameFactor;
    private String string;

    public StringDrawObject(Init init, String string, Point point, int size) {
        this.init = init;
        this.string = string;
        this.size = size;
        this.gameFactor = this.init.getGameFactor();
        setPosition(point);
    }

    @Override
    public void setPosition(Point pos) {
        this.stringX = pos.x * gameFactor;
        this.stringY = pos.y * gameFactor;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setFont(this.init.getFonts().getFont(this.size * gameFactor));
        g2d.drawString(string, stringX, stringY);
    }

    @Override
    public void update() {
    }

}
