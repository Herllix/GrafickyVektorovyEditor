package cz.uhk.editor.graphics;
import java.awt.*;

public abstract class AbstractGraphObject {

    protected Point pozice;

    protected Color barva;

    public AbstractGraphObject(Point pozice, Color barva) {
        this.pozice = pozice;
        this.barva = barva;
    }

    public Point getPozice() {
        return pozice;
    }

    public void setPozice(Point pozice) {
        this.pozice = pozice;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }

    public abstract void draw(Graphics2D g);
    public abstract boolean obsahuje(int x, int y);
}
