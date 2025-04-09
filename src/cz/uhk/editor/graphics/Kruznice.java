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
        g.fillOval(pozice.x , pozice.y , polomer*2, polomer*2);
    }

    @Override
    public boolean obsahuje(int x, int y) {
        int m = pozice.x + polomer;
        int n = pozice.y + polomer;

        int l =(x - m) * (x-m)+(y - n) * (y-n);
        int r = polomer * polomer;

        return l <=r;
    }
}
