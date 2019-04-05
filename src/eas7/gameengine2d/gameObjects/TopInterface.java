/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.Eas7DrawInterface;
import eas7.gameengine2d.engine.Init;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author eas7.de-play
 */
public class TopInterface extends Eas7DrawInterface{

    Init init;
    
    public TopInterface(Init init) {
        super(init);
        setObjectShape("topBar.png");
    }

    @Override
    public void drawMore(Graphics2D g2d){
        g2d.setFont(getFont(10 * getGameFactor()));
        g2d.drawString("test", 10 * getGameFactor(), 12 * getGameFactor());
    }
}
