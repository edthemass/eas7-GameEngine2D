/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Edgar Strauß
 */
public abstract class Eas7DrawObject implements Eas7Drawable, MouseListener, MouseMotionListener {

    private Init init;
    private ArrayList<Eas7Drawable> objects = new ArrayList<>();
    private int anchorX, anchorY;
    private boolean useless = false;
    private boolean mouseRight, isBackgroundStatic;

    public Eas7DrawObject(Init init) {
        this.init = init;
        this.setMouseListener(init);
    }

    public void setObjectPosition(int x, int y) {
//        this.imageX = x;
//        this.imageY = y;
//        this.rectangle.setLocation(x, y);
    }

    public void setBackgroundStatic(boolean b) {
        isBackgroundStatic = b;
    }

    public void setMouseListener(Init init) {
        init.getCanvas().addMouseListener(this);
        init.getCanvas().addMouseMotionListener(this);
    }

    public void addImageToObject(String name, Point point) {
        this.objects.add(new ImageDrawObject(this.init, name, point));
    }

    public void addStringToObject(String string, Point point, int size) {
        this.objects.add(new StringDrawObject(this.init, string, point, size));
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (Eas7Drawable i : objects) {
            i.draw(g2d);
        }
    }

    @Override
    public void update() {
        for (Eas7Drawable i : objects) {
            i.update();
        }
    }

    public boolean isUseless() {
        return useless;
    }

    public void setUseless(boolean useless) {
        this.useless = useless;
    }

//    public void showBoundingBox(boolean b) {
//        this.showBox = b;
//    }
//    public boolean isObjectContainsMouse(MouseEvent e) {
//        return this.rectangle.contains(e.getPoint());
//    }
    public void setMouseAnchor(MouseEvent e) {
//            this.anchorX = e.getX() - this.imageX;
//            this.anchorY = e.getY() - this.imageY;
    }

    public boolean isMouseRight() {
        return this.mouseRight;
    }

    public void setMouseRight(boolean mouseRight) {
        this.mouseRight = mouseRight;
    }

    public void moveObjectWithMouse(MouseEvent e) {
        setObjectPosition(e.getX() - anchorX, e.getY() - anchorY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            mouseRight = true;
            setMouseAnchor(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Maus losgelassen
        mouseRight = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if ((mouseRight) && (!isBackgroundStatic)) {
            moveObjectWithMouse(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
