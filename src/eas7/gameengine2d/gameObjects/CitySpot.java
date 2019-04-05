/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.Eas7DrawObject;
import eas7.gameengine2d.engine.Init;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author eas7.de-play
 */
public class CitySpot extends Eas7DrawObject{
    
    private Image images;
    private int imageWidth, imageHeight, imageX, imageY;
    
    public CitySpot(Init init, Point point) {
        super(init);
        setObjectShape("workInProgressSmal.png");
        setObjectPosition(point.x, point.y);
        
        this.images = init.getImages().getImg("signToBuyGreenSmal15.png");
        this.imageWidth = this.images.getWidth(null) * getGameFactor();
        this.imageHeight = this.images.getHeight(null) * getGameFactor();
    }
    
    @Override
    public void drawMore(Graphics2D g2d){
        g2d.drawImage(images,
                getPosition().x + 20 * getGameFactor(),
                getPosition().y - 10 * getGameFactor(),
                this.imageWidth,
                this.imageHeight,
                null
        );
    }
    
}
