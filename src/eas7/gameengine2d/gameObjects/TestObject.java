
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.Eas7DrawObject;
import eas7.gameengine2d.engine.Init;
import java.awt.event.MouseEvent;


/**
 *
 * @author eas7.de-play
 */
public class TestObject extends Eas7DrawObject {

//    int xPoints[] = {0, 40, 40, 0};
//    int yPoints[] = {0, 0, 40, 40};
    public TestObject(Init init) {
        super(init);

        setObjectShape("closer.png");
//        setObjectPosition(100, 100);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            System.err.println("button3");
        }
        if(isObjectContainsMouse(e)){
            System.err.println("contains");
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

//            moveObjectWithMouse(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        setMouseRight(false);
//        System.err.println("released");
    }

}
