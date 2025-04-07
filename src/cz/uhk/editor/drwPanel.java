package cz.uhk.editor;
import cz.uhk.editor.graphics.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class drwPanel extends JPanel {
    private static List<AbstractGraphObject> objekty = new ArrayList<>();

    public static void initTestData(){
        objekty.add(new Trojuhelnik(new Point(206, 400), Color.GREEN, 80));
        objekty.add(new Kruznice(new Point(412, 400), Color.BLUE, 40));
        objekty.add(new Ctverec(new Point(618, 400), Color.PINK, 80));
        objekty.add(new Obdelnik(new Point (824, 400), Color.RED, 60,80));
    }

    public void addKruznice(Kruznice kruznice) {
        objekty.add(kruznice);
        repaint();
    }

    public void addCtverec(Ctverec ctverec) {
        objekty.add(ctverec);
        repaint();
    }

    public void addObdelnik(Obdelnik obdelnik) {
        objekty.add(obdelnik);
        repaint();
    }

    public void addTrojuhelnik(Trojuhelnik trojuhelnik) {
        objekty.add(trojuhelnik);
        repaint();
    }

    public AbstractGraphObject obsahuje(int x, int y){
        for (AbstractGraphObject objekt : objekty) {
            if (objekt.obsahuje(x, y)) {
                return objekt;
            }
        }
        return null;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (AbstractGraphObject objekty : objekty) {
            objekty.draw(g2d);
        }
    }
}


