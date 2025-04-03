package cz.uhk.editor.graphics;

import java.awt.*;

public class Kruznice extends AbstractGraphObject{
    private int polomer;

    public Kruznice(Point pozice, Color barva, int polomer) {
        super(pozice, barva);
        this.polomer = polomer;
    }

    public int getPolomer() {
        return polomer;
    }

    public void setPolomer(int polomer) {
        this.polomer = polomer;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(barva);
        g.fillOval(pozice.x - polomer, pozice.y -polomer, polomer*2, polomer*2);
    }

    @Override
    public boolean obsahuje(int x, int y) {
        double vzdalenost = Math.sqrt(Math.pow(x - pozice.x, 2) + Math.pow(y - pozice.y, 2));
        return vzdalenost <= polomer;
    }
}
