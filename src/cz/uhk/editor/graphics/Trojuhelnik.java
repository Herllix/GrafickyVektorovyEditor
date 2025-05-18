package cz.uhk.editor.graphics;

import java.awt.*;

public class Trojuhelnik extends AbstractGraphObject {
    private int strana;

    public Trojuhelnik(Point pozice, Color barva, int strana) {
        super(pozice, barva);
        this.strana = strana;
    }

    public int getStrana() {
        return strana;
    }

    public void setStrana(int strana) {
        this.strana = strana;
    }

    @Override
    public void draw(Graphics2D g) {
        double vyskaDouble = (Math.sqrt(3.0) / 2.0) * strana;
        int vyska = (int) vyskaDouble;
        g.setColor(barva);
        int[] xPoints = {pozice.x - strana /2, pozice.x, pozice.x+strana /2};
        int[] yPoints = {pozice.y + vyska, pozice.y, pozice.y + vyska};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean obsahuje(int x, int y) {
        int vyska = (int) (Math.sqrt(3) / 2 * strana);
        return x >= pozice.x && x <= pozice.x + strana && y >= pozice.y + strana - vyska && y <= pozice.y + strana;
    }
}
