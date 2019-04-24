/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eas7.gameengine2d.engine;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author eas7.de-play
 */
public class Eas7Frame {
    
    private JFrame frame;
    private Dimension frameSize;
    
    public Eas7Frame() {
        // GAME ROOT PANEL SIZE
        // 1920 / 4 = 480
        // 1080 / 4 = 270
        
        // TODO Funktion die Bildschirmgrösse ermittelt
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setFrameSize();
                
        frame.setSize(frameSize);
        
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //Kein Rahmen (Vollbild)
        frame.setUndecorated(false);
        //frame.setLocation(200, 300);
        frame.setResizable(false);
        
        // nicht frameSize übereben sondern Factor
        frame.add(new Eas7Canvas(getGameFrameFactor(), frameSize));
        frame.setVisible(true);    
    }
    
    private double getGameFrameFactor(){
        return (frameSize.getWidth() / 480);
    }
    
    private void setFrameSize(){
        // Für Systemen mit mehrere Monitoren
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        
        // zum Testen von eigenen Auflösungen
        //TODO Kann man in Vorherigen Menü (nocht nicht Vorhande) umstellen
        int solution = 2;
        switch(solution){
            case 1: frameSize = new Dimension(480 , 270); break;
            case 2: frameSize = new Dimension(960 , 540); break;
            case 3: frameSize = new Dimension(1440 , 810); break;
            case 4: frameSize = new Dimension(1920 , 1080); break;
                default: break;
        }
        
        
        // richtet nach Monitor
//        frameSize = new Dimension(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
    }
    
}
