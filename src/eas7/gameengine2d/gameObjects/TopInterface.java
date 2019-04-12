/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.oldbutgold.Eas7DrawInterface;
import eas7.gameengine2d.engine.Init;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author eas7.de-play
 */
public class TopInterface extends Eas7DrawInterface{

    Init init;
    
    public TopInterface(Init init) {
        super(init);
        this.init = init;
        setObjectShape("topBar.png");
    }

    @Override
    public void drawMore(Graphics2D g2d){
        g2d.setFont(getFont(10 * getGameFactor()));
        g2d.drawString(init.getPlayerStats().getPlayerMoney() + " €"
                , 10 * getGameFactor()
                , 12 * getGameFactor());
        g2d.drawString(init.getPlayerStats().getTime()
                , 400 * getGameFactor()
                , 12 * getGameFactor());
    }

    @Override
    public void setPosition(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
