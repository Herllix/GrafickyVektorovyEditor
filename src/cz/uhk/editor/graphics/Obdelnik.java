package cz.uhk.editor.graphics;

import java.awt.*;

public class Obdelnik extends AbstractGraphObject {
    private int vyska;
    private int sirka;

    public Obdelnik(Point pozice, Color barva, int vyska, int sirka) {
        super(pozice, barva);
        this.vyska = vyska;
        this.sirka = sirka;
    }

    public int getVyska() {
        return vyska;
    }

    public void setVyska(int vyska) {
        this.vyska = vyska;
    }

    public int getSirka() {
        return sirka;
    }

    public void setSirka(int sirka) {
        this.sirka = sirka;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(barva);
        g.fillRect(pozice.x, pozice.y, sirka, vyska);
    }

    @Override
    public boolean obsahuje(int x, int y) {
        return x >= pozice.x && x <= pozice.x + sirka && y >= pozice.y && y <= pozice.y + vyska;
    }
}
