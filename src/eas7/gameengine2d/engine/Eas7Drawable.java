/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eas7.gameengine2d.engine;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

/**
 *
 * @author eas7
 */
public interface Eas7Drawable{
    public void draw(Graphics2D g2d);
    public void update();
    public boolean isUseless();
    public void showBoundingBox(boolean b);
    public boolean isObjectContainsMouse(MouseEvent e);
//    public Point2D.Double getPosition();

    public void setMouseListener(Init init);
//    public void setObjectSetup();
    
}
