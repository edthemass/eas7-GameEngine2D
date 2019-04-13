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
public class TestMapTile extends Eas7DrawObject {

    private int[] xpoints, ypoints;
    private int npoints;
    private String imagename = "emptyHouseSmal.png";

    public TestMapTile(Init init) {
        super(init);
        addPolygonToObject(new Point(100, 100), this.xpoints, this.ypoints, this.npoints, "emptyHouseSmal.png");
    }

}
