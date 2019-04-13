/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author eas7.de-play
 */
public final class PolygonDrawObject implements Eas7Drawable {

    private final Init init;
    private final Polygon polygon;
    private final Point position;
    private Image image;

    public PolygonDrawObject(Init init, Point point) {
        this.init = init;
        this.position = new Point(point);
        this.polygon = new Polygon();
//        setPolygonShape();
    }
    
    public void setPolygonShape(int[] xpoints, int[] ypoints, int npoints){
        this.polygon.xpoints = xpoints;
        this.polygon.ypoints = ypoints;
        this.polygon.npoints = npoints;
    }
    
    public void setPolygonImage(Image image){
        this.image = image;
    }

    @Override
    public void draw(Graphics2D g2d) {
        //image clip polygon dispose
        g2d.drawImage(this.image,
                0,
                0,
                0,
                0,
                null
        );
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPosition(Point point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
