/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import eas7.gameengine2d.gameObjects.BackgroundMap;
import eas7.gameengine2d.gameObjects.CitySpot;
import eas7.gameengine2d.gameObjects.GameProcessBar;
import eas7.gameengine2d.gameObjects.PlayerStats;
import eas7.gameengine2d.gameObjects.TestMapTile;
import eas7.gameengine2d.gameObjects.TestObject;
import eas7.gameengine2d.gameObjects.TopInterface;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 *
 * @author eas7
 */
public class Init {

    private final double gameFactor;
    private boolean showAllBoxes = false;
    private final Dimension frameSize;
    private final Eas7Fonts fonts;
    private final Eas7Canvas canvas;
    private final Eas7Images images;
    private final PlayerStats playerStats;

    private ArrayList<Eas7DrawableObjects> objects = new ArrayList<>();
    
    public Init(Eas7Canvas c, Eas7Images i, double gameFactor, Dimension frameSize) {
        // set Font
        this.fonts = new Eas7Fonts("OldGameFatty.ttf");
        // set Canvas
        this.canvas = c;
        // set Images
        this.images = i;
        // set GameFactor from Frame
        this.gameFactor = gameFactor;
        this.frameSize = frameSize;

        
        this.playerStats = new PlayerStats();
        
        // add alle Objekte
        /*
        objects.add(new Background(this));
        objects.add(new EnemyUnit(this));
        objects.add(new PlayerUnit(this));
        objects.add(magazin = new Magazin(this, 10));
        */
        objects.add(new BackgroundMap(this));
        objects.add(new CitySpot(this, new Point(100,100)));
//        objects.add(new TopInterface(this));
        objects.add(new TestObject(this));
        
        objects.add(new TestMapTile(this, new Point(0,0)));
        objects.add(new TestMapTile(this, new Point(60,0)));
        objects.add(new TestMapTile(this, new Point(120,0)));
        
        objects.add(new GameProcessBar(this));
        
//        objects.add(new PolygonDrawObject(this, new Point(0,0)));
        
        /*
        // baue Mauer Kaskadiert
        Point2D.Double posBaricade = new Point2D.Double(10, getFrameSize().height - (80 * getGameFactor()));
        for (int y = 0; y < 2; y++) {
            System.err.println(getGameFactor());
            posBaricade.x = 10 * getGameFactor();
            posBaricade.y += 16 * getGameFactor();
            for (int x = 0; x < 29; x++) {
                objects.add(new Barricade(this, posBaricade));
                posBaricade.x += 16 * getGameFactor();
            }
        }
        */
    }

    public PlayerStats getPlayerStats(){
        return this.playerStats;
    }
    
    public void draw(Graphics2D g2d) {
        for (Eas7DrawableObjects i : objects) {
            i.draw(g2d);
        }
    }

    public void update() {
        // Alle Objekte mit Status "useless" werden aus liste gelöscht
        try {
            for (Eas7DrawableObjects i : objects) {
                i.update();
//                if (i.isUseless()) {
//                    objects.remove(i);
//                    // Damit exception nicht auftritt.. einfach ein break machen!!!
//                    break;
//                }
//                // Zeige Bounding-Boxes
//                if (showAllBoxes) {
//                    i.showBoundingBox(true);
//                } else {
//                    i.showBoundingBox(false);
//                }
            }
        } catch (ConcurrentModificationException e) {
            System.err.println(e);
        }
    }

    public void showAllBoxes(boolean b) {
        showAllBoxes = b;
    }

    public Eas7Fonts getFonts() {
        return fonts;
    }

    public Eas7Canvas getCanvas() {
        return canvas;
    }

    public Eas7Images getImages() {
        return images;
    }

    public int getGameFactor() {
        return (int) gameFactor;
    }

    public Dimension getFrameSize() {
        return frameSize;
    }
    
//    public ArrayList<Eas7Drawable> getObjects() {
//        return objects;
//    }
}
