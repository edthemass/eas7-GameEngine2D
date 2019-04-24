/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    drawable objekt für init drawing
 */
package eas7.gameengine2d.engine;

import java.awt.Graphics2D;

/**
 *
 * @author eas7.de-play
 */
public interface Eas7DrawableObjects {

    // Object für DrawObject Zeichnung
    public void draw(Graphics2D g2d);

    public void update();
    
//    public String getName();

}
