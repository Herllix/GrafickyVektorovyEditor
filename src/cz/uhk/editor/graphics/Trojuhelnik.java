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
        g.setColor(barva);
        int[] xPoints = {pozice.x, pozice.x+strana, pozice.x+strana / 2};
        int[] yPoints = {pozice.y + strana, pozice.y + strana, (int) (pozice.y + strana - (Math.sqrt(3) / 2) * strana)};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean obsahuje(int x, int y) {
        int vyska = (int) (Math.sqrt(3) / 2 * strana);
        return x >= pozice.x && x <= pozice.x + strana && y >= pozice.y + strana - vyska && y <= pozice.y + strana;
    }
}
