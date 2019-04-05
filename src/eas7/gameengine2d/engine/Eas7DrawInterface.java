/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author eas7.de-play
 */
public class Eas7DrawInterface implements Eas7Drawable, MouseListener, MouseMotionListener {

    private Init init;
    private Image images;
    private int imageWidth, imageHeight, imageX, imageY;
    private boolean useless = false;
    private boolean showBox = true;
    private Rectangle rectangle;
    private boolean mouseLeft, mouseRight, mouseMiddle, mouseContains;

    public Eas7DrawInterface(Init init) {
        this.init = init;
        this.setMouseListener(init);
        this.rectangle = new Rectangle();
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
        // Rectangele Unsichtbar schalten
        if (showBox) {
            g2d.setColor(new Color(0, 0, 0, 255));
        } else {
            g2d.setColor(new Color(0, 0, 0, 0));
        }
        drawMore(g2d);
    }

    public void drawMore(Graphics2D g2d) {

    }

    public int getGameFactor() {
        return init.getGameFactor();
    }
    
    public Font getFont(float f){
        return init.getFonts().getFont(f);
    }

    // setzt Image und rectangle Grösse
    public void setObjectShape(String str) {
        this.images = init.getImages().getImg(str);
        this.imageWidth = this.images.getWidth(null) * this.init.getGameFactor();
        this.imageHeight = this.images.getHeight(null) * this.init.getGameFactor();
        this.rectangle.setBounds(imageX, imageY, imageWidth, imageHeight);
    }

    @Override
    public void update() {
    }

    @Override
    public boolean isUseless() {
        return false;
    }

    @Override
    public void showBoundingBox(boolean b) {
    }

    @Override
    public boolean isObjectContainsMouse(MouseEvent e) {
        return false;
    }

    @Override
    public void setMouseListener(Init init) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
