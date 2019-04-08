/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author eas7.de-play
 */
public class ImageDrawObject {

    private Init init;
    private Eas7Images eas7Images;
    private Image images;
    private int imageWidth, imageHeight, imageX, imageY;
    private Rectangle rectangle;

    public ImageDrawObject(Init init, String name, Point point) {
        this.init = init;
        this.rectangle = new Rectangle();
        setShape(name);
        setPosition(point.x, point.y);
    }

    // setzte ObjectPosition
    public void setPosition(int x, int y) {
        this.imageX = x;
        this.imageY = y;
        this.rectangle.setLocation(x, y);
    }

    // setzte Image und rectangle Grösse
    public void setShape(String str) {
        this.images = init.getImages().getImg(str);
        this.imageWidth = this.images.getWidth(null) * this.init.getGameFactor();
        this.imageHeight = this.images.getHeight(null) * this.init.getGameFactor();
        this.rectangle.setBounds(imageX, imageY, imageWidth, imageHeight);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(images,
                imageX,
                imageY,
                imageWidth,
                imageHeight,
                null
        );
        g2d.draw(rectangle);
    }

    public Point getPosition() {
        return new Point(imageX, imageY);
    }
    
    public boolean isContainsMouse(MouseEvent e) {
        return this.rectangle.contains(e.getPoint());
    }
}
