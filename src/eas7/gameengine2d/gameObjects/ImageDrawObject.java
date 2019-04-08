/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.Eas7DrawObject;
import eas7.gameengine2d.engine.Eas7Images;
import eas7.gameengine2d.engine.Init;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author eas7.de-play
 */
public class ImageDrawObject extends Eas7DrawObject{

    private Init init;
    private Eas7Images eas7Images;
    private Image images;
    private int imageWidth, imageHeight, imageX, imageY;
    private Rectangle rectangle;

    public ImageDrawObject(Init init, String name) {
        super(init);
        this.init = init;
        this.rectangle = new Rectangle();
        setObjectShape(name);
    }

    @Override
    public void setObjectPosition(int x, int y) {
        this.imageX = x;
        this.imageY = y;
        this.rectangle.setLocation(x, y);
    }
    
    // setzt Image und rectangle Grösse
    @Override
    public void setObjectShape(String str) {
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
    }

}
