/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.engine;


import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eas7.de-play
 */
public class Eas7Fonts {

    ArrayList<Font> fonts = new ArrayList<>();

    public Eas7Fonts(String name) {
        try {
            for (float i = 0f; i < 100f; i++) {
                fonts.add(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src\\eas7\\GameEngine2D\\fonts\\" + name)).deriveFont(i));
            }
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Font.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Font getFont(float ff) {
        return fonts.get((int) ff);
    }
}
