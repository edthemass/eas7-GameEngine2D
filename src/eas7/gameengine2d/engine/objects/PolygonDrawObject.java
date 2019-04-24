/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine.objects;

import eas7.gameengine2d.engine.Eas7Drawable;
import eas7.gameengine2d.engine.Init;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author eas7.de-play
 */
public class PolygonDrawObject implements Eas7Drawable {

    private final Init init;
    private final Polygon polygon;
    private final Point position;
    private Image image;
    private int imageWidth, imageHeight, npoints, gameFactor;
    private int[] xpoints, ypoints;
    private String name;

    public PolygonDrawObject(Init init, String name, Point point, int[] xpoints, int[] ypoints, int npoints, String imagename) {
        this.init = init;
        this.position = new Point(point);
        this.polygon = new Polygon();
        this.xpoints = xpoints;
        this.ypoints = ypoints;
        this.npoints = npoints;
        this.gameFactor = this.init.getGameFactor();
        this.name = name;
        setPolygonShape(xpoints, ypoints, npoints);
        setPolygonImage(imagename);
        setPosition(point);
    }

    public void setPolygonShape(int[] xpoints, int[] ypoints, int npoints) {
        this.polygon.xpoints = xpoints;
        this.polygon.ypoints = ypoints;
        this.polygon.npoints = npoints;
        // verzerre Polygon nach Gamefactor
        for (int i = 0; i < this.polygon.xpoints.length; i++) {
            this.polygon.xpoints[i] *= this.gameFactor;
        }
        for (int i = 0; i < this.polygon.ypoints.length; i++) {
            this.polygon.ypoints[i] *= this.gameFactor;
        }

    }

    public void setPolygonImage(String str) {
        this.image = this.init.getImages().getImg(str);
        this.imageWidth = this.image.getWidth(null) * this.gameFactor;
        this.imageHeight = this.image.getHeight(null) * this.gameFactor;
    }

    @Override
    public void setPosition(Point point) {
        for (int i = 0; i < this.polygon.npoints; i++) {
            this.polygon.xpoints[i] = this.xpoints[i] + point.x * this.gameFactor;
            this.polygon.ypoints[i] = this.ypoints[i] + point.y * this.gameFactor;
        }
        // position = image pos
        this.position.x = point.x * this.gameFactor;
        this.position.y = point.y * this.gameFactor;
    }

    @Override
    public void draw(Graphics2D g2d) {
        //image clip polygon dispose
        g2d.setClip(polygon);
        g2d.drawImage(this.image,
                this.position.x,
                this.position.y,
                this.imageWidth,
                this.imageHeight,
                null
        );
        g2d.setClip(null);
        g2d.setColor(Color.red);
        g2d.draw(polygon);
//        g2d.dispose();

    }

    @Override
    public void update() {
    }

    public int getGameFactor() {
        return this.gameFactor;
    }

    public void setImageWidthPos(int x) {
        this.position.x = x;
    }

    public void setImageMove() {
        this.position.x += 1 * gameFactor;
    }

    public int getImageWidth() {
        return this.image.getWidth(null);
    }

    public int getImagePosX() {
        return position.x;
    }

    public int[] getXpoints() {
        return this.xpoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setString(String string) {}
}
