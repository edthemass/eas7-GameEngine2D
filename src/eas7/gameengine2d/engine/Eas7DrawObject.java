/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;

import eas7.gameengine2d.engine.objects.ImageDrawObject;
import eas7.gameengine2d.engine.objects.PolygonDrawObject;
import eas7.gameengine2d.engine.objects.ProcessBarDrawObject;
import eas7.gameengine2d.engine.objects.StringDrawObject;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 *
 * @author Edgar Strauß
 */
public abstract class Eas7DrawObject implements Eas7DrawableObjects, MouseListener, MouseMotionListener {

    // ZeichenObjekt wird hier definiert mit seinen Methoden
    
    private Init init;
    private ArrayList<Eas7Drawable> objects = new ArrayList<>();
//    private int anchorX, anchorY;
    private boolean useless = false;
    private boolean mouseRight;
    private Point relativPos, anchor;
    private String name;

    public Eas7DrawObject(Init init) {
        this.init = init;
        this.setMouseListener(init);
        this.relativPos = new Point();
        this.anchor = new Point();
        
    }

    public void setObjectPosition(Point point) {
        for (Eas7Drawable i : objects) {
            i.setPosition(point);
        }
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
//    public void setBackgroundStatic(boolean b) {
////        isBackgroundStatic = b;
//    }

    public void setMouseListener(Init init) {
        init.getCanvas().addMouseListener(this);
        init.getCanvas().addMouseMotionListener(this);
    }

    public void addImageToObject(String imageName, String name, Point point) {
        this.objects.add(new ImageDrawObject(this.init, imageName, name, point));
    }

    public void addStringToObject(String string, String name, Point point, int size) {
        this.objects.add(new StringDrawObject(this.init, string, name, point, size));
    }
    
    public void addPolygonToObject(Point point, String name, int[] xpoints, int[] ypoints, int npoints, String imagename){
        this.objects.add(new PolygonDrawObject(this.init, name, point, xpoints, ypoints, npoints, imagename));
    }
    
    public void addProcessBarToObject(Point point, String name, int[] xpoints, int[] ypoints, int npoints, String imagename){
        this.objects.add(new ProcessBarDrawObject(this.init, name, point, xpoints, ypoints, npoints, imagename));
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (Eas7Drawable i : objects) {
            i.draw(g2d);
        }
    }

    @Override
    public void update() {
        for (Eas7Drawable i : objects) {
            i.update();
        }
    }

    public boolean isUseless() {
        return useless;
    }

    public void setUseless(boolean useless) {
        this.useless = useless;
    }

//    public void showBoundingBox(boolean b) {
//        this.showBox = b;
//    }
//    public boolean isObjectContainsMouse(MouseEvent e) {
//        return this.rectangle.contains(e.getPoint());
//    }
    public void setMouseAnchor(MouseEvent e) {
//            this.anchorX = e.getX() - this.imageX;
//            this.anchorY = e.getY() - this.imageY;
    }

    public boolean isMouseRight() {
        return this.mouseRight;
    }

    public void setMouseRight(boolean mouseRight) {
        this.mouseRight = mouseRight;
    }

    public void moveObjectWithMouse(MouseEvent e) {
//        setObjectPosition(new Point(e.getX() - anchorX, e.getY() - anchorY));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 3) {
            mouseRight = true;
            setMouseAnchor(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Maus losgelassen
        mouseRight = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (mouseRight) {
            moveObjectWithMouse(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    public ArrayList<Eas7Drawable> getObject(){
        return this.objects;
    }
    
    public void setObjectString(String name, String string){
        for (int i = 0; i < getObject().size(); i++) {
            if (getObject().get(i).getName().equals(name)) {
                getObject().get(i).setString(string);
            }
        }
    }
}
