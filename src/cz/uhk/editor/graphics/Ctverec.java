package cz.uhk.editor.graphics;

import java.awt.*;

public class Ctverec extends AbstractGraphObject {
    private int strana;

    public Ctverec(Point pozice, Color barva, int strana) {
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
        g.fillRect(pozice.x, pozice.y, strana, strana);
    }

    @Override
    public boolean obsahuje(int x, int y) {
        return x >= pozice.x && x <= pozice.x + strana && y >= pozice.y && y <= pozice.y + strana;
    }
}
