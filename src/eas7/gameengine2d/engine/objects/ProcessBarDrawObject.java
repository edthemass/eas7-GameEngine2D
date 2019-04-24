/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine.objects;

import eas7.gameengine2d.engine.Eas7Drawable;
import eas7.gameengine2d.engine.Init;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author eas7.de-play
 */
public class ProcessBarDrawObject extends PolygonDrawObject {

    public ProcessBarDrawObject(Init init, Point point, int[] xpoints, int[] ypoints, int npoints, String imagename) {
        super(init, point, xpoints, ypoints, npoints, imagename);
        setProcessImageNullPosition();
    }

    // TODO init anderen Konstruktor für einfache ProcessBar mit int height width;
//    public ProcessBarDrawObject(Init init, Point point, int width, int height, String imagename) {
//        super(init, point, null, null, 0, imagename);
//    }
    
    public int getProcessBarWidth() {
        int width = 0;
        for (int i = 0; i < getXpoints().length; i++) {
            if (getXpoints()[i++] > getXpoints()[i]) {
                width = getXpoints()[i++];
            }
        }
        return width;
    }

    public void setProcessBarLoad() {
        if (getImagePosX() < getImageMaxPostion()) {
            setImageMove();
        } else {
            setProcessImageNullPosition();
        }
    }

    public void setProcessImageNullPosition() {
        setImageWidthPos(-getImageWidth() / 2);
    }

    public int getImageMaxPostion() {
        return getImageWidth() / 2 - getProcessBarWidth();
    }

    @Override
    public void update() {
        setProcessBarLoad();
    }
}
