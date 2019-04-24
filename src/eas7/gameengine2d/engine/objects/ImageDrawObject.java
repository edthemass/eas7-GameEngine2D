/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine.objects;

import eas7.gameengine2d.engine.Eas7Drawable;
import eas7.gameengine2d.engine.Init;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author eas7.de-play
 */
public final class ImageDrawObject implements Eas7Drawable {

    private final Init init;
    private Image images;
    private int imageWidth, imageHeight, imageX, imageY;
    private final Rectangle rectangle;
    private String name;

    public ImageDrawObject(Init init, String imageName, String name, Point point) {
        this.init = init;
        this.rectangle = new Rectangle();
        this.name = name;
        setShape(imageName);
        setPosition(point);
    }

    public void setShape(String str) {
        this.images = init.getImages().getImg(str);
        this.imageWidth = this.images.getWidth(null) * this.init.getGameFactor();
        this.imageHeight = this.images.getHeight(null) * this.init.getGameFactor();
        this.rectangle.setBounds(imageX, imageY, imageWidth, imageHeight);
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
//        if (showBox) {
//            g2d.setColor(new Color(0, 0, 0, 255));
//        } else {
//            g2d.setColor(new Color(0, 0, 0, 0));
//        }
    }

    @Override
    public void update() {
    }

    @Override
    public void setPosition(Point pos) {
        this.imageX = pos.x;
        this.imageY = pos.y;
        this.rectangle.setLocation(pos.x, pos.y);
    }

    public Point getPosition() {
        return new Point(imageX, imageY);
    }

    public boolean isContainsMouse(MouseEvent e) {
        return this.rectangle.contains(e.getPoint());
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setString(String string) {}

}
