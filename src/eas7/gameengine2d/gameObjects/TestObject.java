
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.objects.ImageDrawObject;
import eas7.gameengine2d.engine.Eas7DrawObject;
import eas7.gameengine2d.engine.Init;
import java.awt.Graphics2D;
import java.awt.Point;


/**
 *
 * @author eas7.de-play
 */
public class TestObject extends Eas7DrawObject {

//    private ImageDrawObject idoBack;

    public TestObject(Init init) {
        super(init);
        addStringToObject("TEASt", new Point(100,100), 10);
//        idoBack = new ImageDrawObject(init, "closer.png");

    }
    
//    @Override
//    public void draw(Graphics2D g2d){
//        idoBack.draw(g2d);
//    }

}
