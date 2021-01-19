package com.javacore.chapter13.ex10;

import java.applet.Applet;
import java.awt.*;

public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Простейший апплет", 20, 20);
    }
}
