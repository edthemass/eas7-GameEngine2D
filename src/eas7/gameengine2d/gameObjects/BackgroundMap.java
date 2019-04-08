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
public class BackgroundMap extends Eas7DrawObject{
    
    public BackgroundMap(Init init) {
        super(init);
//        setObjectShape("map1.PNG");
        setBackgroundStatic(false);
        addImageToObject("closer.png", new Point(100,100));
        addStringToObject("test", new Point(100,100), 10);
    }   
}
