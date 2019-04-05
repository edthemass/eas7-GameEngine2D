/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Edgar Strauß
 */
public abstract class Eas7DrawObject implements Eas7Drawable, MouseListener, MouseMotionListener {

    private Init init;
    private Image images;
    private int imageWidth, imageHeight, imageX, imageY, anchorX, anchorY;
    private boolean useless = false;
    private boolean showBox = true;
    private Rectangle rectangle;
    private boolean mouseLeft, mouseRight, MouseMiddle;

    public Eas7DrawObject(Init init) {
        this.init = init;
        this.setMouseListener(init);
        this.rectangle = new Rectangle();
    }

    public void setObjectPosition(int x, int y) {
        this.imageX = x;
        this.imageY = y;
        this.rectangle.setLocation(x, y);
    }

    @Override
    public void setMouseListener(Init init) {
        init.getCanvas().addMouseListener(this);
        init.getCanvas().addMouseMotionListener(this);
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.drawImage(images,
                imageX,
                imageY,
                imageWidth,
                imageHeight,
                null
        );
        g2d.draw(rectangle);
        // Polygon-Hülle transparent
        if (showBox) {
            g2d.setColor(new Color(0, 0, 0, 255));
        } else {
            g2d.setColor(new Color(0, 0, 0, 0));
        }
    }

    @Override
    public void update() {
        moreUpdate();
    }

    public void moreUpdate() {

    }

    // setzt Image und rectangle Grösse
    public void setObjectShape(String str) {
        this.images = init.getImages().getImg(str);
        this.imageWidth = this.images.getWidth(null) * this.init.getGameFactor();
        this.imageHeight = this.images.getHeight(null) * this.init.getGameFactor();
        this.rectangle.setBounds(imageX, imageY, imageWidth, imageHeight);
    }

    @Override
    public boolean isUseless() {
        return useless;
    }

    public void setUseless(boolean useless) {
        this.useless = useless;
    }

    @Override
    public void showBoundingBox(boolean b) {
        this.showBox = b;
    }

    @Override
    public boolean isObjectContainsMouse(MouseEvent e) {
        return this.rectangle.contains(e.getPoint());
    }

    public void setMouseAnchor(MouseEvent e) {
        this.anchorX = e.getX() - this.imageX;
        this.anchorY = e.getY() - this.imageY;
    }

    public boolean isMouseRight() {
        return this.mouseRight;
    }

    public void setMouseRight(boolean mouseRight) {
        this.mouseRight = mouseRight;
    }

    public void moveObjectWithMouse(MouseEvent e) {
//        if (mouseRight) {
        setObjectPosition(e.getX() - anchorX, e.getY() - anchorY);
//        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.err.println("clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        System.err.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.err.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
