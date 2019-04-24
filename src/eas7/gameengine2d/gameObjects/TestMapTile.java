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

    private int[] xpoints = new int[]{0, 15, 45, 60, 45, 15};
    private int[] ypoints = new int[]{30, 0, 0, 30, 60, 60};
    private int npoints = 6;
    private String imagename = "emptyHouseSmal.png";

    public TestMapTile(Init init, Point point) {
        super(init);
        addPolygonToObject(point, "testname", this.xpoints, this.ypoints, this.npoints, "emptyHouseSmal.png");
//        addPolygonToObject(new Point(60, 0), this.xpoints, this.ypoints, this.npoints, "emptyHouseSmal.png");
//        addPolygonToObject(new Point(120, 0), this.xpoints, this.ypoints, this.npoints, "emptyHouseSmal.png");
    }

}
