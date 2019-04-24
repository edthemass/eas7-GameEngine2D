/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eas7.gameengine2d.gameObjects;

import eas7.gameengine2d.engine.Eas7DrawObject;
import eas7.gameengine2d.engine.Init;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author eas7.de-play
 */
public class InterfaceDate extends Eas7DrawObject {

    private Timer t;
    private int day = 1, month = 1, year = 2020;

    public InterfaceDate(Init init) {
        super(init);
        addStringToObject(getTime(), "kalendar", new Point(200, 200), 12);
        startTimer();
    }

    public void startTimer() {
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOnTic();
            }
        });
        t.start();
    }

    public void doOnTic() {
        time();
        setObjectString("kalendar", getTime());
    }
        // setString
    public String getTime() {
        String day = Integer.toString(this.day);
        String month = Integer.toString(this.month);
        String year = Integer.toString(this.year);
        if (this.day <= 9) {
            day = "0" + Integer.toString(this.day);
        }
        if (this.month <= 9) {
            month = "0" + Integer.toString(this.month);
        }
        return day + "." + month + "." + year;
    }

    public void time() {
        this.day++;
        if (this.day > 30) {
            this.day = 1;
            this.month++;
            if (this.month > 12) {
                this.month = 1;
                this.year++;
            }
        }
    }
}
