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
 * @author eas7
 */
public interface Eas7Drawable {

    // Objekte für Canvas Zeichnung 
    public void draw(Graphics2D g2d);

    public void update();

    public void setPosition(Point point);
}
