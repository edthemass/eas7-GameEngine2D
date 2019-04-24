/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.Eas7DrawObject;
import eas7.gameengine2d.engine.Init;
import java.awt.Point;

/**
 *
 * @author eas7.de-play
 */
public class GameProcessBar extends Eas7DrawObject{
    
    private int[] xpoints = new int[]{0, 15, 100, 115, 100, 15};
    private int[] ypoints = new int[]{10, 0, 0, 10, 20, 20};
    private int npoints = 6;
    private String imagename = "processbar1.png";
    
    public GameProcessBar(Init init) {
        super(init);
        
        addProcessBarToObject(new Point(150,150), xpoints, ypoints, npoints, imagename);
        
    }
    
}
